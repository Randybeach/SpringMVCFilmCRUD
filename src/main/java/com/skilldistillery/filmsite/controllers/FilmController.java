package com.skilldistillery.filmsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.entities.Film;
import com.skilldistillery.filmsite.database.DatabaseAccessorObject;

@Controller
public class FilmController {
	DatabaseAccessorObject db = new DatabaseAccessorObject();
	
	@RequestMapping(path="findFilm.do", params="id", method=RequestMethod.GET)
	public ModelAndView findFilmById(String ID) {
		ModelAndView mv = new ModelAndView();
		Film film = null;
		try {
			int id = Integer.parseInt(ID);
			film = db.findFilmById(id);
			
		}catch(Exception e) {}
		if(film == null) {
			mv.setViewName("WEB-INF/error.jsp");
		}else {
		mv.addObject("details", film);
		mv.setViewName("WEB-INF/result.jsp");
		}
		
		return mv;
	}
	
	@RequestMapping(path="createFilm.do", 
//			params= {"id", "title", "description", "release_year", "language_id", "rental_rate", "length", "replacement_cost", "rating", "special_features"},
			method=RequestMethod.POST)
	public ModelAndView addFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		Film createdFilm = db.createFilm(film);
		
		if(createdFilm == null) {
//			mv.addAllObjects("details", )
		}
		
		
		return mv;
	}
	
	@RequestMapping(path="modify.do", method=RequestMethod.GET) 
	public ModelAndView changeViews() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/views/modify.jsp");
		return mv;
	}

}
