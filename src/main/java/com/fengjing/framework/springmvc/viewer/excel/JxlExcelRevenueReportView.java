package com.fengjing.framework.springmvc.viewer.excel;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.document.AbstractJExcelView;

@Service(value="JxlExcelRevenueSummary")//该名称与JxlRevenueReportController中的名称保持一致
public class JxlExcelRevenueReportView extends AbstractJExcelView {

	@Override
	protected void buildExcelDocument(@SuppressWarnings("rawtypes") Map model,
			WritableWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		Map<String, String> revenueData = (Map<String, String>) model
				.get("revenueData");
		WritableSheet sheet = workbook.createSheet("Revenue Report", 0);

		sheet.addCell(new Label(0, 0, "Month"));
		sheet.addCell(new Label(1, 0, "Revenue"));

		int rowNum = 1;
		for (Map.Entry<String, String> entry : revenueData.entrySet()) {
			// create the row data
			sheet.addCell(new Label(0, rowNum, entry.getKey()));
			sheet.addCell(new Label(1, rowNum, entry.getValue()));
			rowNum++;
		}
	}

}
