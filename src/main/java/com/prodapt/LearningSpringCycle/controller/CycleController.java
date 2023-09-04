package com.prodapt.LearningSpringCycle.controller;

import java.util.ArrayList;
import java.util.List;

import org.h2.schema.Sequence.Cycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.prodapt.LearningSpringCycle.Entity.CycleTable;
import com.prodapt.LearningSpringCycle.Repository.CycleRepository;
import com.prodapt.LearningSpringCycle.Service.cycleservice;

@Controller
public class CycleController {
   

    @Autowired
    public CycleRepository cyclerepository;

    
    @Autowired
    public cycleservice Cycleservice;
    @RequestMapping("/cycle")
    public String listAllCycles(Model model) {
        //count of the cycles
    	model.addAttribute("Cycles" , cyclerepository.findAll());
        return "Cycle";
    }
    
   @GetMapping("/addCycle")
   public String addCycle(Model model) {
	   CycleTable cycle = new CycleTable();
   	model.addAttribute("cycle",cycle);
   	return "NewCycle";
   }
   
   
    @PostMapping("/save")
    public String saveCycle(@ModelAttribute("cycle") CycleTable cycle) {
    	cyclerepository.save(cycle);
    	return "redirect:/cycle";
    }

   @GetMapping("/borrowCycle/{id}")
   public String borrowcycle(@PathVariable("id") int id) {
	   Cycleservice.borrowmethod(id);
	   return "redirect:/cycle";
   }
 
   @GetMapping("/returnCycle/{id}")
   public String returncycle(@PathVariable("id") int id) {
	   	Cycleservice.returnmethod(id);
	   	return "redirect:/cycle";
   }

   @GetMapping("/restock/{id}")
   public String restockCycle(@PathVariable("id") int id, Model model) {
	   CycleTable cycle = new CycleTable();
	  
	   model.addAttribute("cycle" , cycle);
	   return "Restock";
   }
   
}