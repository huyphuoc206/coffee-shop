package utils;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import constant.ShopInfo;
import model.Bill;
import model.BillDetails;
import model.LoginInfo;

public class PDFUtils {

	public static void printBill(Bill bill) throws IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		String fileName = "BillNo" + bill.getId() + ".pdf";
		fileChooser.setDialogTitle("Specify a file to save");
		fileChooser.setSelectedFile(new File(fileName));
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		File fileToSave = null;
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			fileToSave = fileChooser.getSelectedFile();
		} else {
			return;
		}
		PdfWriter pdfWriter = new PdfWriter(fileToSave);
		PdfFont f = PdfFontFactory.createFont("/font/arial.ttf", PdfEncodings.IDENTITY_H);
		PdfDocument pdfDocument = new PdfDocument(pdfWriter);
		Document document = new Document(pdfDocument);
		pdfDocument.setDefaultPageSize(PageSize.A4);
		float col = 530;
		float columnWidth[] = { col };
		Table hedaerTable = new Table(columnWidth);
		hedaerTable.addCell(new Cell()
				.add(new Paragraph(ShopInfo.SHOP_NAME).setTextAlignment(TextAlignment.CENTER)
						.setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(25).setBold().setItalic())
				.setBorder(Border.NO_BORDER));
		hedaerTable.addCell(new Cell()
				.add(new Paragraph(ShopInfo.SHOP_ADDRESS).setTextAlignment(TextAlignment.CENTER)
						.setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(12).setItalic())
				.setBorder(Border.NO_BORDER));
		hedaerTable.addCell(new Cell().add(new Paragraph("\n")).setBorder(Border.NO_BORDER));
		hedaerTable.addCell(new Cell()
				.add(new Paragraph("H??A ????N THANH TO??N").setTextAlignment(TextAlignment.CENTER)
						.setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(20).setBold().setItalic())
				.setBorder(Border.NO_BORDER));
		hedaerTable.setHorizontalAlignment(HorizontalAlignment.CENTER).setBorder(Border.NO_BORDER);

		float colWidth[] = { 80, 250, 80, 120 };
		Table billInfoTable = new Table(colWidth);
		billInfoTable.addCell(new Cell().add(new Paragraph("M?? h??a ????n:")).setBorder(Border.NO_BORDER));
		billInfoTable.addCell(new Cell(0, 3).add(new Paragraph(bill.getId() + "")).setBorder(Border.NO_BORDER));

		billInfoTable.addCell(new Cell().add(new Paragraph("Gi??? v??o:")).setBorder(Border.NO_BORDER));
		billInfoTable.addCell(
				new Cell().add(new Paragraph(bill.getCreatedDate().format(formatter))).setBorder(Border.NO_BORDER));
		billInfoTable.addCell(new Cell().add(new Paragraph("Thu ng??n:")).setBorder(Border.NO_BORDER));
		billInfoTable.addCell(new Cell().add(new Paragraph(LoginInfo.FULLNAME).setTextAlignment(TextAlignment.RIGHT))
				.setBorder(Border.NO_BORDER));

		float billDetailsColWidth[] = { 30, 160, 50, 100, 50, 130 };
		Table billDetailsTable = new Table(billDetailsColWidth);

		billDetailsTable.addCell(new Cell().add(new Paragraph("STT").setTextAlignment(TextAlignment.CENTER).setBold()));
		billDetailsTable.addCell(new Cell().add(new Paragraph("T??n").setTextAlignment(TextAlignment.CENTER).setBold()));
		billDetailsTable
				.addCell(new Cell().add(new Paragraph("Size").setTextAlignment(TextAlignment.CENTER).setBold()));
		billDetailsTable.addCell(new Cell().add(new Paragraph("Gi??").setTextAlignment(TextAlignment.CENTER).setBold()));
		billDetailsTable.addCell(new Cell().add(new Paragraph("SL").setTextAlignment(TextAlignment.CENTER).setBold()));
		billDetailsTable
				.addCell(new Cell().add(new Paragraph("T???ng").setTextAlignment(TextAlignment.CENTER).setBold()));

		for (int i = 0; i < bill.getBillDetails().size(); i++) {
			BillDetails item = bill.getBillDetails().get(i);
			billDetailsTable
					.addCell(new Cell().add(new Paragraph((i + 1) + "").setTextAlignment(TextAlignment.CENTER)));
			billDetailsTable.addCell(new Cell().add(
					new Paragraph(item.getDrinkDetails().getDrink().getName()).setTextAlignment(TextAlignment.LEFT)));
			billDetailsTable.addCell(new Cell().add(
					new Paragraph(item.getDrinkDetails().getSize().getName()).setTextAlignment(TextAlignment.CENTER)));
			billDetailsTable
					.addCell(new Cell().add(new Paragraph(CurrencyFormat.format(item.getDrinkDetails().getPrice()))
							.setTextAlignment(TextAlignment.CENTER)));
			billDetailsTable.addCell(
					new Cell().add(new Paragraph(item.getQuantity() + "").setTextAlignment(TextAlignment.CENTER)));
			billDetailsTable.addCell(new Cell()
					.add(new Paragraph(CurrencyFormat.format((item.getQuantity() * item.getDrinkDetails().getPrice())))
							.setTextAlignment(TextAlignment.RIGHT)));
		}

		float totalColWidth[] = { 400, 130 };
		Table totalTable = new Table(totalColWidth);

		totalTable
				.addCell(new Cell().add(new Paragraph("Ph????ng th???c thanh to??n:").setTextAlignment(TextAlignment.RIGHT))
						.setBorder(Border.NO_BORDER));
		totalTable.addCell(
				new Cell().add(new Paragraph(bill.getPayment().getName()).setTextAlignment(TextAlignment.RIGHT))
						.setBorder(Border.NO_BORDER));
		totalTable.addCell(new Cell().add(new Paragraph("T???NG:").setTextAlignment(TextAlignment.RIGHT).setBold())
				.setBorder(Border.NO_BORDER));
		totalTable.addCell(new Cell().add(new Paragraph(CurrencyFormat.format(bill.getTotalPrice()))
				.setTextAlignment(TextAlignment.RIGHT).setBold()).setBorder(Border.NO_BORDER));

		document.setFont(f);
		document.add(hedaerTable);
		document.add(new Paragraph("\n"));
		document.add(billInfoTable);
		document.add(new Paragraph("\n"));
		document.add(billDetailsTable);
		document.add(new Paragraph("\n"));
		document.add(totalTable);
		document.add(new Paragraph("\n"));
		document.add(
				new Paragraph("Xin c???m ??n Qu?? kh??ch").setItalic().setBold().setTextAlignment(TextAlignment.CENTER));
		document.add(new Paragraph("H???n g???p l???i qu?? kh??ch l???n sau!").setItalic().setBold()
				.setTextAlignment(TextAlignment.CENTER));
		document.close();
	}
}