package Modelos;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class PdfGenerator {

    private ProcesoCivil proceso;

    private String fileProcesoCivil;
    private String fileSalaCivil;

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
        this.fileProcesoCivil = new java.io.File(".").getCanonicalPath() + "/InformeProcesoCivilTSS-" + new Date().getTime() + ".pdf";
        this.fileSalaCivil = new java.io.File(".").getCanonicalPath() + "/InformeSalasCivilesTSS-" + new Date().getTime() + ".pdf";
    }

    public void generarPdfProcesoCivil() {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileProcesoCivil));
            document.open();
            anadirTitulo(document);
            anadirDescripcion(document);
            anadirContenido(document);
            document.close();
        } catch (DocumentException | IOException e) {
            e.getMessage();
        }
    }

    public void generarPdfSalaCivil(ArrayList<SalaCivil> salas) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileSalaCivil));
            document.open();
            anadirContenidoSalaCivil(document, salas);
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

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    public String pathPdfProcesoCivil() {
        return this.fileProcesoCivil;
    }

    public String pathPdfSalaCivil() {
        return this.fileSalaCivil;
    }

    private void anadirContenidoSalaCivil(Document document, ArrayList<SalaCivil> salas) throws DocumentException {
        Paragraph paragraph1 = new Paragraph("REPORTE SIMULACION DE SALAS CIVILES", titleFont);
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        Paragraph paragraph2 = new Paragraph("En fecha: " + new Date(), titleFont);
        paragraph2.setAlignment(Element.ALIGN_CENTER);
        addEmptyLine(paragraph2, 3);
        Paragraph paragraph3 = new Paragraph("Se realizo la simulacion de " + salas.size() + " salas civiles, "
                + "a su vez cada sala civil atendio " + salas.get(0).getProcesos().size() + " procesos civiles.", contentFont);
        paragraph3.setAlignment(Element.ALIGN_JUSTIFIED);
        Paragraph paragraph4 = new Paragraph("Se obtuvieron los siguientes resultados", subtitleFont);
        addEmptyLine(paragraph3, 1);
        document.add(paragraph1);
        document.add(paragraph2);
        document.add(paragraph3);
        document.add(paragraph4);

    }
}
