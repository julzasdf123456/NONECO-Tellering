/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

/**
 *
 * @author Julio Lopez
 */
public class TestR {
    
    public TestR() {
//        PrinterJob job = PrinterJob.getPrinterJob();
//        job.setPrintable(new HelloWorldPrinter());
//        try {
//            job.print();
//        } catch (PrinterException e) {
//            // The job did not successfully
//            // complete
//        }

        OutputStream file = null;
        try {
            
 
            System.out.println("Your PDF File is succesfully created");
           
        } catch (Exception e) {
            e.printStackTrace();
 
        } finally {
 
            // closing FileOutputStream
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException io) {/*Failed to close*/
 
            }
 
        }
    }
    
    public static void main(String[] args) {
        new TestR();
//            PDDocument document = Loader.loadPDF(new File(ConfigFileHelpers.REPORTS_FOLDER + "Test.pdf"));
//            
//            PrintService myPrintService = PrintServiceLookup.lookupDefaultPrintService();
//            
//            PrinterJob job = PrinterJob.getPrinterJob();
//            job.setPageable(new PDFPageable(document));
//            job.setPrintService(myPrintService);
//            job.print();
    }
    
    class HelloWorldPrinter implements Printable {

        public int print(Graphics g, PageFormat pf, int page)
                throws PrinterException {

              // We have only one page, and 'page'
              // is zero-based
            if (page > 0) {
                   return NO_SUCH_PAGE;
            }

              // User (0,0) is typically outside the
              // imageable area, so we must translate
              // by the X and Y values in the PageFormat
              // to avoid clipping.
                Graphics2D g2d = (Graphics2D)g;
                g2d.translate(pf.getImageableX(), pf.getImageableY());

                  // Now we perform our rendering
                g.drawString("Hello world!", 100, 100);
                
                  // tell the caller that this page is part
                  // of the printed document
                return PAGE_EXISTS;
        }
    }
}
