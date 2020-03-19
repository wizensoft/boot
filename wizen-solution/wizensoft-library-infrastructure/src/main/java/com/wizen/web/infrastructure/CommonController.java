package com.wizen.web.infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CommonController {

	private Log logger = LogFactory.getLog(getClass());;
	
	@RequestMapping("/common/sharedtiles_header.do")
	public ModelAndView sharedtiles_header() {
		logger.info("infrastructure url call ====/common/header.do #########");
		ModelAndView mav = new ModelAndView("common/sharedtiles_header");
        
        mav.addObject("key", "fruits");
        
        List<String> fruitList = new ArrayList<String>();
        
        fruitList.add("apple");
        fruitList.add("orange");
        fruitList.add("banana");
        
       com.wizen.core.Test test =new com.wizen.core.Test();
        fruitList.add(test.getInfo());
      
        mav.addObject("value", fruitList);
		return mav;
	}
	
	@RequestMapping("/common/sample_user_list.do")
	public ModelAndView commonSampleUserList() {
		logger.info("infrastructure url call ====/common/sample_user_list.do #########");
		ModelAndView mav = new ModelAndView("common/sample_user_list");
        
        mav.addObject("key", "fruits");
        
        List<String> fruitList = new ArrayList<String>();
        
        fruitList.add("apple");
        fruitList.add("orange");
        fruitList.add("banana");
        
       com.wizen.core.Test test =new com.wizen.core.Test();
        fruitList.add(test.getInfo());
      
        mav.addObject("value", fruitList);
		return mav;
	}
}
