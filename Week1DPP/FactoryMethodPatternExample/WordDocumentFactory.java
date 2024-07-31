package Week1DPP.FactoryMethodPatternExample;


public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String name) {
        return new WordDocument(name);
    }
}


class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String name) {
        return new PdfDocument(name);
    }
}


class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String name) {
        return new ExcelDocument(name);
    }
}
