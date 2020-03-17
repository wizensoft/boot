package com.wizen.web.api.pages;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.annotations.Api;

@RestController
//@EnableWebMvc
@RequestMapping("/rest")
//@Api("Set of endpoints for Creating, Retrieving, Updating and Deleting of Persons.")
//@Api(value = "HelloController", description = "헬로 에이피아이")
@Api(value = "HelloController")
public class SampleRestController {
   @RequestMapping(value = "/products", method = RequestMethod.GET)
   public List<String> getProducts() {
      List<String> productsList = new ArrayList<>();
      productsList.add("Honey");
      productsList.add("Almond");
      return productsList;
   }
   @RequestMapping(value = "/products", method = RequestMethod.POST)
   public String createProduct() {
      return "Product is saved successfully";
   }
   
}