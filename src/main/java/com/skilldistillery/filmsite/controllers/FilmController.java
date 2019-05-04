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
	public ModelAndView findFilmById(String id) {
		ModelAndView mv = new ModelAndView();
		Film film = null;
		try {
			int Id = Integer.parseInt(id);
			film = db.findFilmById(Id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(film == null) {
			mv.setViewName("/views/error.jsp");
		}else {
		mv.addObject("details", film);
		mv.setViewName("/views/result.jsp");
		}
		
		return mv;
	}
	
	@RequestMapping(path="addFilm.do", 
			params= {"title", "description", "release_year","rental_duration", "rental_rate", "length", "replacement_cost", "rating", "special_features", "language_id"},
			method=RequestMethod.POST)
	public ModelAndView addFilm(String title, String description, String release_year, String rental_duration, String rental_rate, String length, String replacement_cost, String rating, String special_features, String language_id) {
		ModelAndView mv = new ModelAndView();
		if(release_year.equals("")) {
			release_year = "0";
		}
		if(rental_rate.equals("")) {
			rental_rate = "0";
		}
		if(length.equals("")) {
			length = "0";
		}
		if(replacement_cost.equals("")) {
			replacement_cost = "0";
		}
		if(rental_duration.equals("")) {
			rental_duration = "0";
		}
		int release_yearInt = Integer.parseInt(release_year);
		double rental_rateDouble = Double.parseDouble(rental_rate);
		int lengthInt = Integer.parseInt(length);
		double replacement_costDouble = Double.parseDouble(replacement_cost);
		int rental_durationInt = Integer.parseInt(replacement_cost);
		int language_idInt = Integer.parseInt(language_id);
		Film film = new Film(title, description, rental_durationInt, release_yearInt, rental_rateDouble, lengthInt, replacement_costDouble, rating, special_features, language_idInt);
		
		Film createdFilm = db.createFilm(film);
		
		if(createdFilm == null) {
			mv.setViewName("/views/error.jsp");
		}else {
			mv.addObject("details", createdFilm);
			mv.setViewName("/views/result.jsp");
		}
		
		
		return mv;
	}
	
	@RequestMapping(path="deleteFilm.do", method=RequestMethod.POST)
	public ModelAndView deleteFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		Film deletedFilm = db.deleteFilm(film);
		
		if(deletedFilm == null) {
			mv.setViewName("/views/error.jsp");
		}else {
			mv.addObject("details", deletedFilm);
			mv.setViewName("/views/home.jsp");
		}
		
		return mv;
	}
	
	@RequestMapping(path="modify.do", method=RequestMethod.GET) 
	public ModelAndView changeViews() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/views/modify.jsp");
		return mv;
	}
	
	@RequestMapping(path="selectMod.do", method=RequestMethod.GET) 
	public ModelAndView changeView(String value, String filmId) {
		ModelAndView mv = new ModelAndView();
		if(value.equals("change")) {
			mv.addObject("value",value);
			Film film = null;
			try {
				int id = Integer.parseInt(filmId);
				film = db.findFilmById(id);
				
			}catch(Exception e) {}
			if(film == null) {
				mv.setViewName("/views/error.jsp");
			}else {
			mv.addObject("details", film);
			}
			
		}else if(value.equals("delete")) {
			mv.addObject("value",value);
		}else if(value.equals("add")) {
			mv.addObject("value",value);
		}
			
		mv.setViewName("/views/modify.jsp");
		return mv;
	}
	
	@RequestMapping(path="search.do", params="keyword", method=RequestMethod.GET) 
	public ModelAndView searchFilm(String keyword) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("details",db.findFilmByKeyword(keyword));
		mv.setViewName("/views/home.jsp");
		return mv;
	}
	
	@RequestMapping(path="changeFilm.do", method=RequestMethod.POST) 
	public ModelAndView updateFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("details",db.updateFilm(film));
		mv.setViewName("/views/result.jsp");
		return mv;
	}

}
