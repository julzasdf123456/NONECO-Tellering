/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import db.ServiceAccountsDao;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.geom.AffineTransform;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.PaidBills;
import pojos.ServiceAccounts;

/**
 *
 * @author Julio Lopez
 */
public class PowerBillPrint implements Printable {
    
    public List<PaidBills> bill;
    public ServiceAccounts account;
    public String orNumber;
    public String username;
    
    private static String SEPARATOR = File.separator;
    public static String SAXFONT = System.getProperty("user.dir") + SEPARATOR + "res" + SEPARATOR + "saxmono.ttf";
    
    public PowerBillPrint(List<PaidBills> bill, ServiceAccounts account, String orNumber, String username) {
        this.bill = bill;
        this.account = account;
        this.orNumber = orNumber;
        this.username = username;
    }

    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(SAXFONT)));
        } catch (FontFormatException ex) {
            Logger.getLogger(PowerBillPrint.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PowerBillPrint.class.getName()).log(Level.SEVERE, null, ex);
        }

        Font font = new Font("saxmono", Font.PLAIN, 9).deriveFont(
            AffineTransform.getScaleInstance(.87, 1d));
        g.setFont(font);
        // LEFT, TOP
        g.drawString("Meter #: " + account.getMeterDetailsId(), 58, 39);        
        g.drawString(orNumber, 308, 42);
        
        g.drawString(account.getOldAccountNo(), 58, 49);
        g.drawString(account.getServiceAccountName(), 138, 49);
        
        g.drawString(ServiceAccountsDao.getAddress(account), 58, 59);
        
        g.drawString(ObjectHelpers.formatORPrintDate(ObjectHelpers.getCurrentTimestamp()), 242, 79);
        
        /**
         * LOOP PAID BILLS
         */
        int startPosY = 118;
        int incrementPosY = 10;
        double totalPayments = 0;
        for (int i=0; i<bill.size(); i++) {
            g.drawString(bill.get(i).getBillNumber(), 13, startPosY);
            g.drawString(ObjectHelpers.formatReadableDate(bill.get(i).getServicePeriod()), 68, startPosY);
            g.drawString(ObjectHelpers.formatSlashedDate(bill.get(i).getBank()), 115, startPosY);
            g.drawString(ObjectHelpers.roundTwo("" + (Double.valueOf(bill.get(i).getNetAmount()) - Double.valueOf(bill.get(i).getSurcharge()))), 168, startPosY);
            g.drawString(ObjectHelpers.roundTwo(bill.get(i).getSurcharge()), 222, startPosY);
//            if (account.getOrganization() != null && account.getOrganization()=="BAPA") {
//                
//            } else {
//                g.drawString(ObjectHelpers.roundTwo(bill.get(i).getNetAmount()), 290, startPosY);
//                System.out.println("AMT: " + ObjectHelpers.roundTwo("" + (Double.valueOf(bill.get(i).getNetAmount()) - Double.valueOf(bill.get(i).getSurcharge()))));
//            }
            g.drawString(ObjectHelpers.roundTwo(getBapaGross(bill.get(i).getNetAmount(), bill.get(i).getDeductions()) + ""), 290, startPosY);
            System.out.println("AMT: " + ObjectHelpers.roundTwo(getBapaGross(bill.get(i).getNetAmount(), bill.get(i).getDeductions()) + ""));
            
            startPosY += incrementPosY;
            totalPayments += Double.valueOf(bill.get(i).getNetAmount());
        }
           
        g.drawString(username, 24, 230);
        g.drawString(ObjectHelpers.roundTwo(totalPayments + ""), 290, 230);
        
        return PAGE_EXISTS;
    }
    
    public double getBapaGross(String netAmount, String discount) {
        try {
            double amnt = 0;
            if (netAmount != null) {
                amnt = Double.valueOf(netAmount);
            }
            
            double dsc = 0;
            
            if (discount != null) {
                dsc = Double.valueOf(discount);
            }
            
            return amnt + dsc;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
