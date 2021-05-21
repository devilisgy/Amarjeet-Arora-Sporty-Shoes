package com.example.sporty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.sporty.domain.Shoes;
import com.example.sporty.service.ShoesService;

@Controller
public class ShoesController {
	
	 @Autowired
	    private ShoesService service;

	    @GetMapping("/new")
	    public String add(Model model) {
	        model.addAttribute("shoes", new Shoes());
	        return "new";
	    }

	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveProduct(@ModelAttribute("shoes") Shoes shoe,Model model) {
	        List<Shoes> listproducts = service.listAll();
	        model.addAttribute("listproducts", listproducts);
	        service.save(shoe);
	        return "index";
	    }

	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("new");
	        Shoes product = service.get(id);
	        mav.addObject("product", product);
	        return mav;
	        
	    }
	    @RequestMapping("/delete/{id}")
	    public String deleteProduct(@PathVariable(name = "id") int id,Model model) {

	        service.delete(id);

	        return "index";
	    }
}