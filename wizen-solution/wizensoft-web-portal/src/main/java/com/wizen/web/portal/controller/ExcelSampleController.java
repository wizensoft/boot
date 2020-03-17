package com.wizen.web.portal.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wizen.web.portal.model.StatRow;

@Controller
@RequestMapping("/excelsample")
public class ExcelSampleController {
	private void populateModel(Model model) {
        List<StatRow> rows = Arrays.asList(
                new StatRow("고객1", 1000, 1500),
                new StatRow("고객2", 2000, 2500),
                new StatRow("고객3", 3000, 3500)
        );

        model.addAttribute("rows", rows);

    }
	@GetMapping("/stat")
    public String get(Model model) {
        populateModel(model);
        return "excelsample/stat";
    }
	
	@GetMapping("/stat.xls")
    public String getExcelByExt(Model model) {
        populateModel(model);
        return "downloadXlsView";
    }

    @GetMapping(path = "/stat", params = "format=xls")
    public String getExcelByParam(Model model) {
        populateModel(model);
        return "downloadXlsView";
        //return new ModelAndView("downloadXlsView", "model", model);
    }
}
