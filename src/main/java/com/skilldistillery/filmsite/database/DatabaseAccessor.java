package com.skilldistillery.filmsite.database;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface DatabaseAccessor {
	  public Film findFilmById(int filmId);
	  public Actor findActorById(int actorId);
	  public List<Actor> findActorsByFilmId(int filmId);
	  public List<Film> findFilmByKeyword(String keyword);
	  public Film createFilm(Film film);
	  public Film deleteFilm(int id);
	  public Film updateFilm(Film film);
	  public void addFilmCategory(int filmId, int catId);
	  public void updateFilmCategory(int filmId, int catId);
}
