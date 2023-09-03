package by.test.testClever.utils;

import by.test.testClever.entities.Transaction;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PDFSaverForCheck {

    private static final int offsetX = 25;
    private static int offsetY = 725;

    public static boolean saveCheck(Transaction transaction) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            PDFont font = PDType0Font.load(document, new File("fonts/times.ttf"));
            contentStream.setFont(font, 12);
            addLine("----------------------------------------", contentStream);
            addLine("| Чек:             " + transaction.getId() + "            |", contentStream);
            addLine("|  " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE) + "         " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "            |", contentStream);
            addLine("|  Тип транзакции:       " + transaction.getType() + "            |", contentStream);
            addLine("|  Банк отправителя:   " + transaction.getFrom().getBank().getName() + "         |", contentStream);
            addLine("|  Банк получателя:       " + transaction.getTo().getBank().getName() + "     |", contentStream);
            addLine("|  Счет отправителя:         " + transaction.getFrom().getNumber() + "  |", contentStream);
            addLine("|  Счет получателя:            " + transaction.getTo().getNumber() + "                                       |", contentStream);
            addLine("|  Сумма:                       " + transaction.getCount() + "  " + transaction.getCurrencyType() + "                            |", contentStream);
            addLine("----------------------------------------", contentStream);
            contentStream.close();

            document.save("pdfBoxHelloWorld.pdf");
            document.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        offsetY = 725;


        return true;
    }

    private static void addLine(String text, PDPageContentStream stream) throws IOException {
        stream.beginText();
        stream.newLineAtOffset(offsetX, offsetY);
        offsetY -= 15;
        stream.showText(text);
        stream.endText();
    }

}
