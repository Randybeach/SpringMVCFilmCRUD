package com.skilldistillery.filmsite.database;

import java.util.List;

import com.skilldistillery.film.entities.*;

public interface DatabaseAccessor {
	  public Film findFilmById(int filmId);
	  public Actor findActorById(int actorId);
	  public List<Actor> findActorsByFilmId(int filmId);
	  public List<Film> findFilmByKeyword(String keyword);
	  public Film createFilm(Film film);
	  public Film deleteFilm(Film film);
	  public Film updateFilm(Film film);
}
