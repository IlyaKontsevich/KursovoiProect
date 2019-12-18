package laba1.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class PdfWrite {
    public void write(String fileName, List<String> fullList) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(fileName + ".pdf")));

            document.open();

            for (String entity : fullList) {
                Paragraph p = new Paragraph();
                p.add(entity);
                p.setAlignment(Element.ALIGN_LEFT);
                document.add(p);
            }

            document.close();

            System.out.println("Done");

        } catch (Exception e) {
            System.out.println("something goes wrong");
        }

    }

}
