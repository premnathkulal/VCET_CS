package com.example.vcet_cs;

public class pro_data {


    private int id;
    private String sem;
    private String PdfURL;
    private String PdfName;

    public pro_data(int id, String sem, String PdfURL, String PdfName) {
        this.id = id;
        this.sem = sem;
        this.PdfURL = PdfURL;
        this.PdfName = PdfName;
    }

    public int getId() {
        return id;
    }

    public String getSem() {
        return sem;
    }

    public String getPdfURL() {
        return PdfURL;
    }

    public String getPdfName() {
        return PdfName;
    }


}
