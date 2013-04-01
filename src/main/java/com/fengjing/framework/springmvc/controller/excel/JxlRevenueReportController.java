package com.fengjing.framework.springmvc.controller.excel;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class JxlRevenueReportController extends AbstractController {

	@Override
	@RequestMapping(value="/jxl")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String output = ServletRequestUtils.getStringParameter(request,
				"output");

		// dummy data
		Map<String, String> revenueData = new HashMap<String, String>();
		revenueData.put("Jan-2010", "$100,000,000");
		revenueData.put("Feb-2010", "$110,000,000");
		revenueData.put("Mar-2010", "$130,000,000");
		revenueData.put("Apr-2010", "$140,000,000");
		revenueData.put("May-2010", "$200,000,000");

		if (output == null || "".equals(output)) {
			// return normal view
			return new ModelAndView("RevenueSummary", "revenueData",
					revenueData);

		} else if ("EXCEL".equals(output.toUpperCase())) {
			// return excel view
			return new ModelAndView("JxlExcelRevenueSummary", "revenueData",
					revenueData);

		} else {
			// return normal view
			return new ModelAndView("RevenueSummary", "revenueData",
					revenueData);

		}
	}

}
