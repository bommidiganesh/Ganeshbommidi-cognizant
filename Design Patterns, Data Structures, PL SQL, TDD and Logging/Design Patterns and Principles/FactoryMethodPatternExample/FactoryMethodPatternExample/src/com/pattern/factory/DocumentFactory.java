package com.pattern.factory;

/**
 * Abstract creator class in the Factory Method pattern.
 */
public abstract class DocumentFactory {
    /**
     * Factory Method declared to create a Document.
     * Subclasses must override this to return their specific document type.
     */
    public abstract Document createDocument();

    /**
     * An optional helper method demonstrating that the creator class
     * can contain core logic relying on the product.
     */
    public void printDocumentDetails() {
        Document doc = createDocument();
        System.out.println("Processing: " + doc.getType());
        doc.open();
        doc.close();
    }
}
