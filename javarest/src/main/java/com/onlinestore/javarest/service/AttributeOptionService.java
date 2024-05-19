package com.onlinestore.javarest.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.aws.PutObject;
import com.onlinestore.javarest.aws.S3BucketService;
import com.onlinestore.javarest.entities.AttributeOption;
import com.onlinestore.javarest.report.ExcelReportGenerator;
import com.onlinestore.javarest.report.PDFReportGenerator;
import com.onlinestore.javarest.repository.AttributeOptionRepository;

import jakarta.transaction.Transactional;

@Service
public class AttributeOptionService {

	@Autowired
	private AttributeOptionRepository attributeOptionRepository;

	@Autowired
	private ExcelReportGenerator excelReportGenerator;
	
	@Autowired
	private PDFReportGenerator pdfReportGenerator;

	@Autowired
	private S3BucketService s3BucketService;

	@Autowired
	private PutObject putObject;

	public List<AttributeOption> getAllAttributeOptions() {
		return (List<AttributeOption>) attributeOptionRepository.findAll();
	}

	public Optional<AttributeOption> getAttributeOptionById(Long attributeOptionId) {
		return attributeOptionRepository.findById(attributeOptionId.intValue());
	}

	public AttributeOption addAttributeOption(AttributeOption attributeOptionEntity) {
		return attributeOptionRepository.save(attributeOptionEntity);
	}

	public AttributeOption updateAttributeOption(AttributeOption attributeOptionEntity) {
		return attributeOptionRepository.save(attributeOptionEntity);
	}

	@Transactional
	public void deleteAttributeOptionById(Long attributeOptionId) {
		attributeOptionRepository.deleteById(attributeOptionId.intValue());
	}

	/**
	 * Reports
	 * 
	 * @throws IOException
	 */

	public ResponseEntity<byte[]> getAttributeOptionsExcel() throws IOException {
		List<AttributeOption> attributeOptions = (List<AttributeOption>) attributeOptionRepository.findAll();

		try (Workbook workbook = createExcel(attributeOptions)) {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			workbook.write(outputStream);
			byte[] excelBytes = outputStream.toByteArray();

			return ResponseEntity.ok().body(excelBytes);
		}
	}

	private Workbook createExcel(List<AttributeOption> attributeOptions) {
		Workbook workbook = new XSSFWorkbook();
		return workbook;
	}

	public byte[] getAttributeOptionsPdf() throws IOException {
		List<AttributeOption> attributeOptions = (List<AttributeOption>) attributeOptionRepository.findAll();

		try (PDDocument document = new PDDocument()) {
			PDPage page = new PDPage();
			document.addPage(page);

			try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

				for (AttributeOption element : attributeOptions) {
					contentStream.beginText();
					contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
					contentStream.newLineAtOffset(100, 700);
					contentStream.showText(element.getAttributeOptionName());
					contentStream.endText();
				}
			}

			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			document.save(byteArrayOutputStream);
			return byteArrayOutputStream.toByteArray();
		}
	}

}