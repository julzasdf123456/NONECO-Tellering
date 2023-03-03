/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;


import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.draw.ILineDrawer;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.TabStop;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.layout.property.TabAlignment;
import com.itextpdf.layout.property.TextAlignment;
import static helpers.PowerBillPrint.SAXFONT;
import java.awt.print.PrinterJob;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import pojos.DCRSummaryTransactions;
import pojos.PaidBills;
import pojos.TransactionDetails;


/**
 *
 * @author Julio Lopez
 */
public class DCRPrinter {
    
    private static int FONT_SIZE = 8;
    private static String COMPANY = "NORTHEN NEGROS ELECTRIC COOPERATIVE, INC.";
    private static String COMPANY_ABREV = "NONECO";
    private static String COMPANY_ADDRESS = "Bo. Tortosa, Manapla, Negros Occidental";
    private static String DCRSUMMARYTITLE = "DAILY COLLECTION REPORT PER ACCOUNT CODE";
    private static int MARGINTOP = 10;   
    private static PageSize defPageSize;
    
    public static void printDcr(pojos.Login l, String date, List<DCRSummaryTransactions> list,
            List<PaidBills> powerBills, List<TransactionDetails> nonPowerBills, List<TransactionDetails> checkPayments, List<TransactionDetails> cancelledOrs,
            List<PaidBills> checkSummary, double dcrTotalCorrected) {
        try {
            String filename = ConfigFileHelpers.REPORTS_FOLDER + "DCR-" + ObjectHelpers.getSqlDate() + "-" + l.getUsername() + ".pdf";
            
            PdfWriter writer = new PdfWriter(filename); 
   
            // Creating a PdfDocument       
            PdfDocument pdfDoc = new PdfDocument(writer);  
            pdfDoc.setDefaultPageSize(PageSize.LETTER);

            // Adding a new page 
            PdfPage dcrPage = pdfDoc.addNewPage();
           
            // REGISTER FONT
            PdfFontFactory.register(SAXFONT, "saxmono");

            // Creating a Document        
            defPageSize = new PageSize(new Rectangle(612, 792));
            Document document = new Document(pdfDoc); 
            document.setMargins(15, 25, 15, 25);
            
            // GET PAPER WIDTH FOR CENTERING
            Rectangle pageSize = pdfDoc.getDefaultPageSize();
            float width = pageSize.getWidth() - document.getLeftMargin() - document.getRightMargin();
            
            PdfFont font = PdfFontFactory.createRegisteredFont("saxmono");
            
            /**
             * START DCR SUMMARY
             */
            addCenteredParagraph(document, null, width, COMPANY, font);  
            addCenteredParagraph(document, null, width, COMPANY_ADDRESS, font);  
            addCenteredParagraph(document, null, width, DCRSUMMARYTITLE, font);  
            
            addLeftParagraph(document, "TELLER:             " + l.getName(), font);
            addLeftParagraph(document, "COLLECTION CENTER:  " + ConfigFileHelpers.getOffice(), font);
            addLeftParagraph(document, "COLLECTION DATE:    " + date + "\n", font);
            
            populateDcrTable(dcrPage, font, document, list, dcrTotalCorrected);
            
            addLeftParagraph(document, "\nPrepared By:\n\n", font);
            addCenteredParagraphSignatory(document, null, width, l.getName(), font);
            
            /**
             * START POWER BILL
             */
            document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
                        
            populatePowerBillsTable(font, document, powerBills, l, date, width);
            
            addLeftParagraph(document, "\nPrepared By:\n\n", font);
            addCenteredParagraphSignatory(document, null, width, l.getName(), font);
            
            /**
             * START NON-POWER BILLS
             */
            document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
            
            populateNonPowerBillsTable(font, document, nonPowerBills, l, date, width);
            
            addLeftParagraph(document, "\nPrepared By:\n\n", font);
            addCenteredParagraphSignatory(document, null, width, l.getName(), font);
            
            /**
             * START CHECK PAYMENTS
             */
            document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
            
            populateCheckPaymentsTable(font, document, checkPayments, l, date, width);
            
            addLeftParagraph(document, "\nPrepared By:\n\n", font);
            addCenteredParagraphSignatory(document, null, width, l.getName(), font);
            
            /**
             * START CANCELLED ORS
             */
            document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
            
            populateCancelledOrsTable(font, document, cancelledOrs, l, date, width);
            
            addLeftParagraph(document, "\nPrepared By:\n\n", font);
            addCenteredParagraphSignatory(document, null, width, l.getName(), font);
            
            /**
             * START CHECK SUMMARY
             */
            document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
            
            populateCheckSummaryTable(font, document, checkSummary, l, date, width);
            
            addLeftParagraph(document, "\nPrepared By:\n\n", font);
            addCenteredParagraphSignatory(document, null, width, l.getName(), font);

            // Closing the document    
            document.close();              
            
            /**
             * PRINT THE PDF
             */
//            Desktop.getDesktop().open(new File(filename));
            PDDocument printDoc = PDDocument.load(new File(filename));
            
            PrintService myPrintService = PrintServiceLookup.lookupDefaultPrintService();
            
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPageable(new PDFPageable(printDoc));
            job.setPrintService(myPrintService);
            job.print();
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error printing DCR", e.getMessage());
        }
    }
    
    public static void addCenteredParagraph(Document doc, ILineDrawer line, float width, String text, PdfFont font) {
        List<TabStop> tabStops = new ArrayList<>();

        // Create a TabStop at the middle of the page
        tabStops.add(new TabStop(width / 2, TabAlignment.CENTER, line));

        // Create a TabStop at the end of the page
        tabStops.add(new TabStop(width, TabAlignment.LEFT, line));

        Paragraph p = new Paragraph().addTabStops(tabStops);
        p
                .add(new Tab())
                .add(text)
                .add(new Tab());
        p.setMarginTop(-2).setMarginBottom(-2);
        p.setFont(font).setFontSize(FONT_SIZE);
        doc.add(p);
    }
    
    public static void addCenteredParagraphSignatory(Document doc, ILineDrawer line, float width, String text, PdfFont font) {     
        Paragraph p = new Paragraph(text);
        p.setWidth(100);
        p.setTextAlignment(TextAlignment.CENTER);
        p.setBorderTop(new SolidBorder(1));
        p.setFont(font).setFontSize(FONT_SIZE);
        doc.add(p);
    }
    
    public static void addLeftParagraph(Document doc, String text, PdfFont font) {
        Paragraph p = new Paragraph(text);
        p.setMarginTop(-2).setMarginBottom(-2);
        p.setFont(font).setFontSize(FONT_SIZE);
        doc.add(p);
    }
    
    public static void addTableCellHeader(Table table, TextAlignment alignment, String text, boolean isbold) {
        Cell c1 = new Cell();                        // Creating cell 1 
        c1.add(text);            
        if (isbold) {
            c1.setBold();
        }
        c1.setBorder(Border.NO_BORDER);              // Setting border
        c1.setTextAlignment(alignment);   // Setting text alignment   
        table.addCell(c1);
    }
    
    public static void addTableCellHeaderBordered(Table table, TextAlignment alignment, String text, boolean isbold) {
        Cell c1 = new Cell();                         // Creating cell 1 
        c1.add(text);            
        if (isbold) {
            c1.setBold();
        }             // Setting border
        c1.setTextAlignment(alignment);   // Setting text alignment   
        table.addCell(c1);
    }
    
    public static void addTableCellLeftText(Table table, String text, boolean isbold) {
        Cell c1 = new Cell();                        // Creating cell 1 
        c1.add(text != null ? text : " ");
        if (isbold) {
            c1.setBold();
        }
        c1.setBorder(Border.NO_BORDER);    
        c1.setHeight(13f);          
        c1.setMargin(-2);
        c1.setTextAlignment(TextAlignment.LEFT);   // Setting text alignment   
        table.addCell(c1);
    }
    
    public static void addTableCellRightText(Table table, String text, boolean isbold) {
        Cell c1 = new Cell();                        // Creating cell 1 
        c1.add(text);     
        if (isbold) {
            c1.setBold();
        }
        c1.setBorder(Border.NO_BORDER);    
        c1.setHeight(13f);          
        c1.setMargin(-2);
        c1.setTextAlignment(TextAlignment.RIGHT);   // Setting text alignment   
        table.addCell(c1);
    }
    
    public static void addTableCellCenterText(Table table, String text, boolean isbold) {
        Cell c1 = new Cell();                        // Creating cell 1 
        c1.add(text);     
        if (isbold) {
            c1.setBold();
        }
        c1.setBorder(Border.NO_BORDER);    
        c1.setHeight(13f);          
        c1.setMargin(-2);
        c1.setTextAlignment(TextAlignment.CENTER);   // Setting text alignment   
        table.addCell(c1);
    }
    
    public static void populateDcrTable(PdfPage page, PdfFont font, Document doc, List<DCRSummaryTransactions> list, Double dcrCorrected) {
        float [] pointColumnWidths = {80F, 210F, 80F};   
        Table table = new Table(pointColumnWidths);   
        table.setFont(font).setFontSize(FONT_SIZE);

        // Adding cells to the table       
        addTableCellHeader(table, TextAlignment.CENTER, "GL Code", true);
        addTableCellHeader(table, TextAlignment.CENTER, "Description", true);
        addTableCellHeader(table, TextAlignment.RIGHT, "Amount", true);

        // add sepratator line for header of table
        PdfCanvas canvas = new PdfCanvas(page);       
        canvas.moveTo(20, 763);    
        canvas.lineTo(410, 763);       
        canvas.closePathStroke(); 

        double dcrSummaryTotal = 0;
        int dcrSize = list.size();
        for (int i=0; i<dcrSize; i++) {
            if (list.get(i).getAmount() != null && Double.valueOf(list.get(i).getAmount()) != 0) {
                addTableCellLeftText(table, list.get(i).getGLCode(), false);
                addTableCellLeftText(table, list.get(i).getDescription(), false);
                addTableCellRightText(table, ObjectHelpers.roundTwo(list.get(i).getAmount()), false);
                dcrSummaryTotal += Double.valueOf(list.get(i).getAmount());
            } 
        }
        
        Cell ttl = new Cell(0, 2);
        ttl.add("Total");
        ttl.setBold();
        ttl.setHeight(13f);          
        ttl.setMargin(-2);        
        table.addCell(ttl);
        
        ttl = new Cell();
        ttl.add(ObjectHelpers.roundTwo(dcrCorrected + ""));
        ttl.setBold();
        ttl.setHeight(13f);          
        ttl.setMargin(-2);
        ttl.setTextAlignment(TextAlignment.RIGHT);
        table.addCell(ttl);
        
        doc.add(table);
    }
    
    public static void populatePowerBillsTable(PdfFont font, Document doc, List<PaidBills> powerBills, pojos.Login l, String date, float width) {
        float [] pointColumnWidths = {50F, 60F, 200F, 60F, 60F, 50F, 70F};   
        
        int size = powerBills.size();
        int numberOfLinestoBreak = 50;
        int pageNo = (size < numberOfLinestoBreak) ? 1 : size/numberOfLinestoBreak;
        if ((size % numberOfLinestoBreak) > 0 && size > numberOfLinestoBreak) {
            pageNo += 1;
        }
        
        int tableItemIndex = 0;
        double overAllAmountTotal = 0;
        for (int pg=0; pg<pageNo; pg++) {
            addLeftParagraph(doc, "Page " + (pg+1) + " of " + pageNo , font);
            
            Table table = new Table(pointColumnWidths);   
            table.setFont(font).setFontSize(FONT_SIZE);
            addCenteredParagraph(doc, null, width, COMPANY, font);  
            addCenteredParagraph(doc, null, width, COMPANY_ADDRESS, font);  
            addCenteredParagraph(doc, null, width, "POWER BILLS DAILY COLLECTION REPORT", font);  

            addLeftParagraph(doc, "TELLER:             " + l.getName(), font);
            addLeftParagraph(doc, "COLLECTION DATE:    " + date + "\n", font);

            // Adding cells to the table       
            addTableCellHeaderBordered(table, TextAlignment.CENTER, "OR Number", false);
            addTableCellHeaderBordered(table, TextAlignment.CENTER, "Account No", false);
            addTableCellHeaderBordered(table, TextAlignment.CENTER, "Consumer Name", false);
            addTableCellHeaderBordered(table, TextAlignment.CENTER, "Billing Month", false);
            addTableCellHeaderBordered(table, TextAlignment.RIGHT, "Bill #", false);
            addTableCellHeaderBordered(table, TextAlignment.RIGHT, "Kwh Used", false);
            addTableCellHeaderBordered(table, TextAlignment.RIGHT, "Amount Paid", false);

            double pbTotal = 0, kwhTotal = 0;
            int localCounter = 0;
            for (int i=tableItemIndex; i<size; i++) {
                PaidBills pb = powerBills.get(i);
                addTableCellLeftText(table, pb.getORNumber(), false);
                addTableCellLeftText(table, pb.getAccountNumber(), false);
                addTableCellLeftText(table, pb.getId(), false);
                addTableCellCenterText(table, pb.getServicePeriod(), false);
                addTableCellRightText(table, pb.getBillNumber(), false);
                addTableCellRightText(table, pb.getKwhUsed()!=null ? pb.getKwhUsed() : "0", false);
                addTableCellRightText(table, ObjectHelpers.roundTwo(pb.getNetAmount()), false);
                pbTotal += pb.getNetAmount() != null ? Double.valueOf(pb.getNetAmount()) : 0;
                kwhTotal += pb.getKwhUsed() != null ? Double.valueOf(pb.getKwhUsed()) : 0;
                if (localCounter == numberOfLinestoBreak-1) {
                    break;
                }
                localCounter++;
            }
            
            overAllAmountTotal += pbTotal;

            Cell ttl = new Cell(0, 5);
            ttl.add("Total");
            ttl.setHeight(13f);          
            ttl.setMargin(-2);        
            table.addCell(ttl);

            ttl = new Cell();
            ttl.add(kwhTotal + "");
            ttl.setHeight(13f);          
            ttl.setMargin(-2);
            ttl.setTextAlignment(TextAlignment.RIGHT);
            table.addCell(ttl);

            ttl = new Cell();
            ttl.add(ObjectHelpers.roundTwo(overAllAmountTotal + ""));
            ttl.setHeight(13f);          
            ttl.setMargin(-2);
            ttl.setTextAlignment(TextAlignment.RIGHT);
            table.addCell(ttl);
            
            doc.add(table);
        
            if (pg < pageNo-1) {
                doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE)); 
            }                       
            
            tableItemIndex += numberOfLinestoBreak;
        }
        
    }
    
    public static void populateNonPowerBillsTable(PdfFont font, Document doc, List<TransactionDetails> details, pojos.Login l, String date, float width) {
        float [] pointColumnWidths = {50F, 160F, 260F, 70F};   
        
        int size = details.size();
        int numberOfLinestoBreak = 50;
        int pageNo = (size < numberOfLinestoBreak) ? 1 : size/numberOfLinestoBreak;
        if ((size % numberOfLinestoBreak) > 0 && size > numberOfLinestoBreak) {
            pageNo += 1;
        }
        
        int tableItemIndex = 0;
        double overAllAmountTotal = 0;
        for (int pg=0; pg<pageNo; pg++) {
            addLeftParagraph(doc, "Page " + (pg+1) + " of " + pageNo , font);
            
            Table table = new Table(pointColumnWidths);   
            table.setFont(font).setFontSize(FONT_SIZE);
            addCenteredParagraph(doc, null, width, COMPANY, font);  
            addCenteredParagraph(doc, null, width, COMPANY_ADDRESS, font);  
            addCenteredParagraph(doc, null, width, "NON POWER BILLS/MISCELLANEOUS DAILY COLLECTION REPORT", font);  

            addLeftParagraph(doc, "TELLER:             " + l.getName(), font);
            addLeftParagraph(doc, "COLLECTION DATE:    " + date + "\n", font);

            // Adding cells to the table       
            addTableCellHeaderBordered(table, TextAlignment.CENTER, "OR Number", false);
            addTableCellHeaderBordered(table, TextAlignment.CENTER, "Payee Name", false);
            addTableCellHeaderBordered(table, TextAlignment.CENTER, "Particulars", false);
            addTableCellHeaderBordered(table, TextAlignment.RIGHT, "Amount Paid", false);

            double pbTotal = 0;
            String prevHolder = "", prev = "";
            int localCounter = 0;
            for (int i=tableItemIndex; i<size; i++) {
                TransactionDetails td = details.get(i);
                prevHolder = td.getId();
                addTableCellLeftText(table, prevHolder.equals(prev) ? "" : td.getId(), false);
                addTableCellLeftText(table, prevHolder.equals(prev) ? "" : td.getVAT(), false);
                addTableCellLeftText(table, td.getParticular(), false);
                addTableCellRightText(table, ObjectHelpers.roundTwo(td.getTotal()), false);
                pbTotal += td.getTotal()!= null ? Double.valueOf(td.getTotal()) : 0;
                prev = prevHolder;    
                if (localCounter == numberOfLinestoBreak-1) {
                    break;
                }
                localCounter++;
            }
            
            overAllAmountTotal += pbTotal;

            Cell ttl = new Cell(0, 3);
            ttl.add("Total");
            ttl.setHeight(13f);          
            ttl.setMargin(-2);        
            table.addCell(ttl);

            ttl = new Cell();
            ttl.add(ObjectHelpers.roundTwo(overAllAmountTotal + ""));
            ttl.setHeight(13f);          
            ttl.setMargin(-2);
            ttl.setTextAlignment(TextAlignment.RIGHT);
            table.addCell(ttl);
            
            doc.add(table);
        
            if (pg < pageNo-1) {
                doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE)); 
            }                       
            
            tableItemIndex += numberOfLinestoBreak;
        }
        
    }
    
    public static void populateCheckPaymentsTable(PdfFont font, Document doc, List<TransactionDetails> checks, pojos.Login l, String date, float width) {
        float [] pointColumnWidths = {50F, 60F, 200F, 80F, 70F, 50F, 70F};   
        
        int size = checks.size();
        int numberOfLinestoBreak = 50;
        int pageNo = (size < numberOfLinestoBreak) ? 1 : size/numberOfLinestoBreak;
        if ((size % numberOfLinestoBreak) > 0 && size > numberOfLinestoBreak) {
            pageNo += 1;
        }
        
        int tableItemIndex = 0;
        double overAllAmountTotal = 0;
        for (int pg=0; pg<pageNo; pg++) {
            addLeftParagraph(doc, "Page " + (pg+1) + " of " + pageNo , font);
            
            Table table = new Table(pointColumnWidths);   
            table.setFont(font).setFontSize(FONT_SIZE);
            addCenteredParagraph(doc, null, width, COMPANY, font);  
            addCenteredParagraph(doc, null, width, COMPANY_ADDRESS, font);  
            addCenteredParagraph(doc, null, width, "SUMMARY OF CHECK PAYMENTS", font);  

            addLeftParagraph(doc, "TELLER:             " + l.getName(), font);
            addLeftParagraph(doc, "COLLECTION DATE:    " + date + "\n", font);

            // Adding cells to the table       
            addTableCellHeaderBordered(table, TextAlignment.CENTER, "OR Number", false);
            addTableCellHeaderBordered(table, TextAlignment.CENTER, "Account No", false);
            addTableCellHeaderBordered(table, TextAlignment.CENTER, "Payee Name", false);
            addTableCellHeaderBordered(table, TextAlignment.LEFT, "Source", false);
            addTableCellHeaderBordered(table, TextAlignment.LEFT, "Check No", false);
            addTableCellHeaderBordered(table, TextAlignment.CENTER, "Bank", false);
            addTableCellHeaderBordered(table, TextAlignment.RIGHT, "Amount Paid", false);

            double pbTotal = 0;
            int localCounter = 0;
            for (int i=tableItemIndex; i<size; i++) {
                TransactionDetails td = checks.get(i);
                addTableCellLeftText(table, td.getId(), false);
                addTableCellLeftText(table, td.getTransactionIndexId(), false);
                addTableCellLeftText(table, td.getParticular(), false);
                addTableCellLeftText(table, td.getAmount(), false);
                addTableCellLeftText(table, td.getVAT(), false);
                addTableCellLeftText(table, td.getAccountCode(), false);
                addTableCellRightText(table, ObjectHelpers.roundTwo(td.getTotal()), false);
                pbTotal += td.getTotal()!= null ? Double.valueOf(td.getTotal()) : 0;
                  
                if (localCounter == numberOfLinestoBreak-1) {
                    break;
                }
                localCounter++;
            }
            
            overAllAmountTotal += pbTotal;

            Cell ttl = new Cell(0, 6);
            ttl.add("Total");
            ttl.setHeight(13f);          
            ttl.setMargin(-2);        
            table.addCell(ttl);

            ttl = new Cell();
            ttl.add(ObjectHelpers.roundTwo(overAllAmountTotal + ""));
            ttl.setHeight(13f);          
            ttl.setMargin(-2);
            ttl.setTextAlignment(TextAlignment.RIGHT);
            table.addCell(ttl);
            
            doc.add(table);
        
            if (pg < pageNo-1) {
                doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE)); 
            }                       
            
            tableItemIndex += numberOfLinestoBreak;
        }
        
    }
    
    public static void populateCancelledOrsTable(PdfFont font, Document doc, List<TransactionDetails> cancelled, pojos.Login l, String date, float width) {
        float [] pointColumnWidths = {50F, 60F, 200F, 80F, 70F};   
        
        int size = cancelled.size();
        int numberOfLinestoBreak = 50;
        int pageNo = (size < numberOfLinestoBreak) ? 1 : size/numberOfLinestoBreak;
        if ((size % numberOfLinestoBreak) > 0 && size > numberOfLinestoBreak) {
            pageNo += 1;
        }
        
        int tableItemIndex = 0;
        double overAllAmountTotal = 0;
        for (int pg=0; pg<pageNo; pg++) {
            addLeftParagraph(doc, "Page " + (pg+1) + " of " + pageNo , font);
            
            Table table = new Table(pointColumnWidths);   
            table.setFont(font).setFontSize(FONT_SIZE);
            addCenteredParagraph(doc, null, width, COMPANY, font);  
            addCenteredParagraph(doc, null, width, COMPANY_ADDRESS, font);  
            addCenteredParagraph(doc, null, width, "SUMMARY OF CANCELLED ORS", font);  

            addLeftParagraph(doc, "TELLER:             " + l.getName(), font);
            addLeftParagraph(doc, "COLLECTION DATE:    " + date + "\n", font);

            // Adding cells to the table       
            addTableCellHeaderBordered(table, TextAlignment.CENTER, "OR Number", false);
            addTableCellHeaderBordered(table, TextAlignment.CENTER, "Account No", false);
            addTableCellHeaderBordered(table, TextAlignment.CENTER, "Payee Name", false);
            addTableCellHeaderBordered(table, TextAlignment.CENTER, "Source", false);
            addTableCellHeaderBordered(table, TextAlignment.RIGHT, "Amount Paid", false);

            double pbTotal = 0;
            int localCounter = 0;
            for (int i=tableItemIndex; i<size; i++) {
                TransactionDetails td = cancelled.get(i);
                addTableCellLeftText(table, td.getId(), false);
                addTableCellLeftText(table, td.getTransactionIndexId(), false);
                addTableCellLeftText(table, td.getParticular(), false);
                addTableCellLeftText(table, td.getAmount(), false);
                addTableCellRightText(table, ObjectHelpers.roundTwo(td.getTotal()), false);
                pbTotal += td.getTotal()!= null ? Double.valueOf(td.getTotal()) : 0;
                  
                if (localCounter == numberOfLinestoBreak-1) {
                    break;
                }
                localCounter++;
            }
            
            overAllAmountTotal += pbTotal;

            Cell ttl = new Cell(0, 4);
            ttl.add("Total");
            ttl.setHeight(13f);          
            ttl.setMargin(-2);        
            table.addCell(ttl);

            ttl = new Cell();
            ttl.add(ObjectHelpers.roundTwo(overAllAmountTotal + ""));
            ttl.setHeight(13f);          
            ttl.setMargin(-2);
            ttl.setTextAlignment(TextAlignment.RIGHT);
            table.addCell(ttl);
            
            doc.add(table);
        
            if (pg < pageNo-1) {
                doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE)); 
            }                       
            
            tableItemIndex += numberOfLinestoBreak;
        }
        
    }
    
    public static void populateCheckSummaryTable(PdfFont font, Document doc, List<PaidBills> checks, pojos.Login l, String date, float width) {
        float [] pointColumnWidths = {145F, 145F, 130F};   
        
        int size = checks.size();
        int numberOfLinestoBreak = 50;
        int pageNo = (size < numberOfLinestoBreak) ? 1 : size/numberOfLinestoBreak;
        if ((size % numberOfLinestoBreak) > 0 && size > numberOfLinestoBreak) {
            pageNo += 1;
        }
        
        int tableItemIndex = 0;
        double overAllAmountTotal = 0;
        for (int pg=0; pg<pageNo; pg++) {
            addLeftParagraph(doc, "Page " + (pg+1) + " of " + pageNo , font);
            
            Table table = new Table(pointColumnWidths);   
            table.setFont(font).setFontSize(FONT_SIZE);
            addCenteredParagraph(doc, null, width, COMPANY, font);  
            addCenteredParagraph(doc, null, width, COMPANY_ADDRESS, font);  
            addCenteredParagraph(doc, null, width, "SUMMARY OF CHECKS", font);  

            addLeftParagraph(doc, "TELLER:             " + l.getName(), font);
            addLeftParagraph(doc, "COLLECTION DATE:    " + date + "\n", font);

            // Adding cells to the table       
            addTableCellHeaderBordered(table, TextAlignment.CENTER, "Bank", false);
            addTableCellHeaderBordered(table, TextAlignment.LEFT, "Check No", false);
            addTableCellHeaderBordered(table, TextAlignment.RIGHT, "Amount", false);

            double pbTotal = 0;
            int localCounter = 0;
            for (int i=tableItemIndex; i<size; i++) {
                PaidBills td = checks.get(i);
                addTableCellLeftText(table, td.getBank(), false);
                addTableCellLeftText(table, td.getCheckNo(), false);
                addTableCellRightText(table, ObjectHelpers.roundTwo(td.getNetAmount()), false);
                pbTotal += td.getNetAmount()!= null ? Double.valueOf(td.getNetAmount()) : 0;
                  
                if (localCounter == numberOfLinestoBreak-1) {
                    break;
                }
                localCounter++;
            }
            
            overAllAmountTotal += pbTotal;

            Cell ttl = new Cell(0, 2);
            ttl.add("Total");
            ttl.setHeight(13f);          
            ttl.setMargin(-2);        
            table.addCell(ttl);

            ttl = new Cell();
            ttl.add(ObjectHelpers.roundTwo(overAllAmountTotal + ""));
            ttl.setHeight(13f);          
            ttl.setMargin(-2);
            ttl.setTextAlignment(TextAlignment.RIGHT);
            table.addCell(ttl);
            
            doc.add(table);
        
            if (pg < pageNo-1) {
                doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE)); 
            }                       
            
            tableItemIndex += numberOfLinestoBreak;
        }
    }
}
