package Modelos;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.Pfm2afm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class PdfGenerator {

    private ProcesoCivil proceso;

    private static String FILE;

    private static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font subtitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    private static Font contentFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL);
    private static Font columnFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    private static Font rowFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL);

    public PdfGenerator(ProcesoCivil proceso) throws IOException {
        this.proceso = proceso;
        this.FILE = FILE = new java.io.File(".").getCanonicalPath() + "/InformeProcesoCivilTSS-" + new Date().getTime() + ".pdf";
    }

    public static void main(String[] args) throws IOException {
        PdfGenerator pdf = new PdfGenerator(new ProcesoCivil(1));
        pdf.generarPdf();
    }

    public void generarPdf() {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            anadirTitulo(document);
            anadirDescripcion(document);
            anadirContenido(document);
            document.close();
        } catch (DocumentException | IOException e) {
            e.getMessage();
        }
    }

    private void anadirTitulo(Document document)
            throws DocumentException {
        Paragraph paragraph1 = new Paragraph("REPORTE SIMULACION DE PROCESO CIVIL", titleFont);
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        Paragraph paragraph2 = new Paragraph("En fecha: " + new Date(), titleFont);
        paragraph2.setAlignment(Element.ALIGN_CENTER);
        addEmptyLine(paragraph2, 3);
        document.add(paragraph1);
        document.add(paragraph2);
    }

    private void anadirDescripcion(Document document) throws DocumentException {
        Paragraph p1 = new Paragraph("Durante un proceso civil se puede pasar por las siguientes etapas:", subtitleFont);
        List list1 = new List();
        list1.add("Conciliacion Previa. - Medio por el cual dos o más personas solucionan sus conflictos voluntariamente,"
                + " asistidas por una persona imparcial y ajena al conflicto, quienes se denominan conciliadora o conciliador,"
                + " persona que tiene la tarea de apoyar a ambas partes para que logren una comunicación constructiva,"
                + " permitiéndoles identificar con claridad el problema que les afecta, dentro de los límites de "
                + "legalidad preservando el valor justicia, en busca de un acuerdo satisfactorio. La conciliación puede ser total o parcial y tiene el efecto de una sentencia judicial. ");
        list1.add("Demanda. - Da inicio a un procedimiento judicial por el cual el demandante pide una tutela jurisdiccional frente al demandado"
                + " en forma de sentencia que le sea favorable a sus intereses.\n Va a constituirse como la petición de una persona (demandante) para que la"
                + " justicia actúe en contra de los intereses de otra persona (demandado) solicitando el inicio de un proceso judicial.");
        list1.add("Citación y Emplazamiento. - La citación es el acto de poner en conocimiento de alguna persona un mandato del Juez o tribunal para que concurra"
                + " a la práctica de alguna diligencia procesal y el emplazamiento es el llamado judicial que se hace para que dentro del plazo señalado la parte demandada comparezca en juicio.");
        list1.add("Contestación. - Es el acto procesal mediante el cual el demandado alega todas sus excepciones y defensas respecto de una demanda. La contestación de la demanda tiene la misma"
                + " importancia para el demandado que la demanda para el demandante. Puede ser escrita u oral, dependiendo del tipo de procedimiento (escrito u oral).");
        list1.add("Pruebas. - La finalidad de la prueba es convencer al juzgador sobre la certeza de los hechos que fundamentan las pretensiones de cada parte."
                + "Se las va diligenciando desde la etapa de demanda hasta la audiencia preliminar.");
        list1.add("Audiencia Preliminar. - Se presentan las pruebas y se dicta sentencia dictada por un juez o tribunal que pone fin a la litis"
                + " o caso sometido a su conocimiento y cierra definitivamente su actuación en el mismo. ");
        list1.add("Audiencia Complementaria. - Si en la audiencia preliminar no se hubiera producido o diligenciado todas las pruebas, principalmente por falta de tiempo del juez,"
                + " en el plazo de 15 días se señalará recién la audiencia complementaria para ese objeto.");
        Paragraph p2 = new Paragraph("La simulacion del proceso civil obtuvo los siguientes resultados: ", subtitleFont);
        List list2 = new List();
        list2.add("Se llevaron a cabo " + this.proceso.getEtapasProcesoCivil().size() + " de 6 etapas.");
        list2.add("El proceso civil termino en " + this.proceso.getDiasTotalesTranscurridos() + " dias.");
        document.add(p1);
        document.add(list1);
        document.newPage();
        document.add(p2);
        document.add(list2);
    }

    private void anadirContenido(Document document) throws DocumentException {
        Paragraph p1 = new Paragraph("Descripcion de cada etapa realizada en la simulacion de proceso civil:", subtitleFont);
        this.addEmptyLine(p1, 2);
        document.add(p1);
        ArrayList<Etapa> etapas = this.proceso.getEtapasProcesoCivil();
        for (Etapa e : etapas) {
            PdfPTable table = new PdfPTable(1);
            PdfPCell c1 = new PdfPCell(new Phrase(e.getNombreEtapa() + " - Dias transcurridos: " + e.getDiasTranscurridosEtapa(), titleFont));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            table.setHeaderRows(1);
            e.getMensages().forEach((s) -> {
                table.addCell(s);
            });
            document.add(table);
        }

    }

    private void createTable(Section subCatPart)
            throws BadElementException {
        PdfPTable table = new PdfPTable(3);

        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);
        PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Table Header 2"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Table Header 3"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        table.addCell("1.0");
        table.addCell("1.1");
        table.addCell("1.2");
        table.addCell("2.1");
        table.addCell("2.2");
        table.addCell("2.3");

        subCatPart.add(table);

    }

    private void createList(Section subCatPart) {
        List list = new List(true, false, 10);
        list.add(new ListItem("First point"));
        list.add(new ListItem("Second point"));
        list.add(new ListItem("Third point"));
        subCatPart.add(list);
    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

}
