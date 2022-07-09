/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import db.ServiceAccountsDao;
import static helpers.PowerBillPrint.SAXFONT;
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
import pojos.ServiceAccounts;
import pojos.TransactionDetails;
import pojos.TransactionIndex;

/**
 *
 * @author Julio Lopez
 */
public class TransactionsPrint implements Printable{
    
    public TransactionIndex index;
    public List<TransactionDetails> details;
    public ServiceAccounts account;
    public String username;

    public TransactionsPrint(TransactionIndex index, List<TransactionDetails> details, String username, ServiceAccounts account) {
        this.index = index;
        this.details = details;
        this.username = username;
        this.account = account;
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
        g.drawString(account != null ? ("Meter #: " + account.getMeterDetailsId()) : ("Trans. #: " + index.getId()), 58, 39);        
        g.drawString(index.getORNumber(), 308, 42);
        
        String accountDisplay = "";
        if (account != null) {
            accountDisplay = account.getOldAccountNo();
        } else {
            if (index.getServiceConnectionId() != null) {
                accountDisplay = index.getServiceConnectionId();
            } else {
                accountDisplay = index.getObjectId();
            }
        }
        g.drawString(accountDisplay, 58, 49);
        g.drawString(index.getPayeeName(), 138, 49);
        
        g.drawString(account != null ? ServiceAccountsDao.getAddress(account) : index.getSource(), 58, 59);
        
        g.drawString(ObjectHelpers.formatORPrintDate(ObjectHelpers.getCurrentTimestamp()), 242, 79);
        
        /**
         * LOOP PAID BILLS
         */
        int startPosY = 118;
        int incrementPosY = 10;
        double othersTotal = 0;
        double othersVatTotal = 0;
        boolean isMoreThan5 = false;
        for (int i=0; i<details.size(); i++) {
            if (i < 5) {
                g.drawString(details.get(i).getAccountCode() != null ? details.get(i).getAccountCode() : "", 13, startPosY);
                g.drawString(details.get(i).getParticular() != null ? details.get(i).getParticular() : "", 68, startPosY);
    //            g.drawString(ObjectHelpers.formatSlashedDate(details.get(i).getBank()), 115, startPosY);
                g.drawString(details.get(i).getAmount() != null ? ObjectHelpers.roundTwo(details.get(i).getAmount()) : "", 168, startPosY);
                g.drawString(details.get(i).getVAT() != null ? ("VAT: " + ObjectHelpers.roundTwo(details.get(i).getVAT())) : "", 222, startPosY);
                g.drawString(details.get(i).getTotal() != null ? ObjectHelpers.roundTwo(details.get(i).getTotal()) : "", 290, startPosY);

                startPosY += incrementPosY;
            } else {
                isMoreThan5 = true;
                othersTotal += Double.valueOf(details.get(i).getTotal());
                othersVatTotal += (details.get(i).getTotal() != null ? Double.valueOf(details.get(i).getTotal()) : 0);
            }            
        }
        
        if (isMoreThan5) {
            g.drawString("Others..........", 13, startPosY);
//            g.drawString(details.get(i).getParticular() != null ? details.get(i).getParticular() : "", 68, startPosY);
//            g.drawString(ObjectHelpers.formatSlashedDate(details.get(i).getBank()), 115, startPosY);
//            g.drawString(details.get(i).getAmount() != null ? ObjectHelpers.roundTwo(details.get(i).getAmount()) : "", 168, startPosY);
            g.drawString("VAT: " + ObjectHelpers.roundTwo(othersVatTotal + ""), 222, startPosY);
            g.drawString(ObjectHelpers.roundTwo(othersTotal + ""), 290, startPosY);
        }
           
        g.drawString(username, 24, 230);
        g.drawString(ObjectHelpers.roundTwo(index.getTotal()), 290, 230);
        
        return PAGE_EXISTS;
    }
    
}
