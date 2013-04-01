package com.fengjing.framework.springmvc.viewer.excel;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.document.AbstractExcelView;

/**
 * 创建Excel视图
 * @author scott
 *
 */
@Service(value="PoiExcelRevenueSummary")//该名称与RevenueReportController中的名称保持一致
public class PoiExcelRevenueReportView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, String> revenueData = (Map<String, String>) model.get("revenueData");
		// create a wordsheet
		HSSFSheet sheet = workbook.createSheet("Revenue Report");

		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("Month");
		header.createCell(1).setCellValue("Revenue");

		int rowNum = 1;
		for (Map.Entry<String, String> entry : revenueData.entrySet()) {
			// create the row data
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(entry.getKey());
			row.createCell(1).setCellValue(entry.getValue());
		}
	}

}
