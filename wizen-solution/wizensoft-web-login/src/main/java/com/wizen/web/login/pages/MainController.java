package com.wizen.web.login.pages;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wizen.core.Test;

//import com.wizen.core.Test;

@Controller
public class MainController {

	@RequestMapping("/main/home.do")
	public String home() {
		return "main/home";
	}
	@RequestMapping("/main/home2.do")
	public ModelAndView home2() {
ModelAndView mav = new ModelAndView("main/home2");
        
        mav.addObject("key", "fruits");
        
        List<String> fruitList = new ArrayList<String>();
        
        fruitList.add("apple");
        fruitList.add("orange");
        fruitList.add("banana");
        
       com.wizen.core.Test test =new Test();
        fruitList.add(test.getInfo());
      
        mav.addObject("value", fruitList);
		return mav;
	}	
}
