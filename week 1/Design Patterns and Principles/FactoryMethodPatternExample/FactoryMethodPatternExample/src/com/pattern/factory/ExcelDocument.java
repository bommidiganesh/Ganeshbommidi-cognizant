package com.pattern.factory;

public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel Spreadsheet (.xlsx) and loading cells...");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel Spreadsheet...");
    }

    @Override
    public String getType() {
        return "Excel Spreadsheet";
    }
}
