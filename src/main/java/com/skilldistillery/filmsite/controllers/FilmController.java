package com.skilldistillery.filmsite.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.entities.Film;
import com.skilldistillery.filmsite.database.DatabaseAccessorObject;

@Controller
public class FilmController {
	DatabaseAccessorObject db = new DatabaseAccessorObject();

	@RequestMapping(path = "findFilm.do", params = "id", method = RequestMethod.GET)
	public ModelAndView findFilmById(String id) {
		ModelAndView mv = new ModelAndView();
		Film film = null;
		try {
			int Id = Integer.parseInt(id);
			film = db.findFilmById(Id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (film == null) {
//			mv.addObject("details", film);
//			mv.setViewName("/views/result.jsp");
			mv.setViewName("/views/error.jsp");
		} else {
			mv.addObject("details", film);
			mv.setViewName("/views/result.jsp");
		}

		return mv;
	}

	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView addFilm(@ModelAttribute("film") @Valid Film film, Errors errors) {
		ModelAndView mv = new ModelAndView();
		String sf = film.getSpecial_features();
		sf = sf.replace(",none", "");
		sf = sf.replace("none", "");
		film.setSpecial_features(sf);


		if (errors.hasErrors()) {
			mv.addObject("value", "add");
			mv.setViewName("/views/modify.jsp");
			return mv;
		} else {
			Film createdFilm = db.createFilm(film);

			if (createdFilm == null) {
				mv.setViewName("/views/error.jsp");
			} else {
				mv.addObject("details", createdFilm);
				mv.setViewName("/views/result.jsp");
			}
		}

		return mv;
	}

	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST)
	public ModelAndView deleteFilm(int filmId) {
		ModelAndView mv = new ModelAndView();
		Film deletedFilm = db.deleteFilm(filmId);

		if (deletedFilm == null) {
			mv.setViewName("/views/error.jsp");
		} else {
			mv.addObject("deleted", deletedFilm);
			mv.setViewName("/views/home.jsp");
		}

		return mv;
	}

	@RequestMapping(path = "modify.do", method = RequestMethod.GET)
	public ModelAndView changeViews() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/views/modify.jsp");
		return mv;
	}

	@RequestMapping(path = "selectMod.do", method = RequestMethod.GET)
	public ModelAndView changeView(String value, String filmId) {
		ModelAndView mv = new ModelAndView();
		System.out.println("value: " + value + "/nId; " + filmId);
		if (value.equals("change")) {
			mv.addObject("value", value);
			Film film = null;
			try {
				int id = Integer.parseInt(filmId);
				film = db.findFilmById(id);

			} catch (Exception e) {
			}
			if (film == null) {
//				System.out.println("The film is null");
				mv.addObject("film", new Film());
				mv.setViewName("/views/error.jsp");
			} else {
				mv.addObject("film", new Film());
				mv.addObject("details", film);
				mv.setViewName("/views/modify.jsp");
			}

		} else if (value.equals("delete")) {
			mv.addObject("value", value);
			mv.setViewName("/views/modify.jsp");
		} else if (value.equals("add")) {
			mv.addObject("film", new Film());
			mv.addObject("value", value);
			mv.setViewName("/views/modify.jsp");
		}

		return mv;
	}

	@RequestMapping(path = "search.do", params = "keyword", method = RequestMethod.GET)
	public ModelAndView searchFilm(String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = db.findFilmByKeyword(keyword);
		if (films.size() == 0) {

			mv.setViewName("/views/error.jsp");
		} else {
			mv.addObject("details", films);
			mv.setViewName("/views/home.jsp");
		}
		return mv;
	}

	@RequestMapping(path = "changeFilm.do", method = RequestMethod.POST)
	public ModelAndView updateFilm(@ModelAttribute("film") @Valid Film film, Errors errors) {
		ModelAndView mv = new ModelAndView();

//		System.out.println("film id is :" + film.getId());
		if (errors.hasErrors()) {
			mv.addObject("value", "add");
			mv.setViewName("/views/modify.jsp");
			return mv;
		} else {
			Film film1 = db.updateFilm(film);

			mv.addObject("details", db.findFilmById(film1.getId()) );
			mv.setViewName("/views/result.jsp");
			return mv;
		}
	}

	@RequestMapping(path = "home.do", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/views/home.jsp");
		return mv;
	}
	@RequestMapping(path = "rick.do", method = RequestMethod.GET)
	public ModelAndView rick() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/views/rick.jsp");
		return mv;
	}

}
