package Week1DPP.FactoryMethodPatternExample;

// DocumentFactoryTest.java
public class DocumentFactoryTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument("Word Document");
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument("PDF Document");
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument("Excel Document");
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
    }
}
