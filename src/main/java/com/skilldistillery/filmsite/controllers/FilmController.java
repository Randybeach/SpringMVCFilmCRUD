package com.skilldistillery.filmsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.entities.Film;
import com.skilldistillery.filmsite.database.DatabaseAccessorObject;

@Controller
public class FilmController {
	DatabaseAccessorObject db = new DatabaseAccessorObject();
	
	@RequestMapping(path="findFilm.do", params="id", method=RequestMethod.POST)
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
			method=RequestMethod.POST)
	public ModelAndView addFilm(@ModelAttribute("film") Film film) {
		ModelAndView mv = new ModelAndView();
	
		
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
	public ModelAndView deleteFilm(int id) {
		ModelAndView mv = new ModelAndView();
		Film deletedFilm = db.deleteFilm(id);
		
		if(deletedFilm == null) {
			mv.setViewName("/views/error.jsp");
		}else {
			mv.addObject("deleted", deletedFilm);
			mv.setViewName("/views/home.jsp");
		}
		
		return mv;
	}
	
	@RequestMapping(path="modify.do", method=RequestMethod.POST) 
	public ModelAndView changeViews() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/views/modify.jsp");
		return mv;
	}
	
	@RequestMapping(path="selectMod.do", method=RequestMethod.POST) 
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
			mv.addObject("film", new Film());
			mv.addObject("details", film);
			}
			
		}else if(value.equals("delete")) {
			mv.addObject("value",value);
		}else if(value.equals("add")) {
			mv.addObject("film", new Film());
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
	public ModelAndView updateFilm(@ModelAttribute("film") Film film) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("details",db.updateFilm(film));
		mv.setViewName("/views/result.jsp");
		return mv;
	}

}
