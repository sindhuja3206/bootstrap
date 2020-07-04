package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@Controller
public class AlienController {

	
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
	}
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) 
	{
		repo.save(alien);
		return "home.jsp";
	}
	@RequestMapping("/getAlien")
	@ResponseBody
	public String getAliens() 
	{
		
		return repo.findAll().toString();
	}
	
	@RequestMapping("/getAlien/{aid}")
	@ResponseBody
	public String getAlien(@PathVariable("aid") int aid) 
	{
		
		return repo.findById(aid).toString();
	}
}
