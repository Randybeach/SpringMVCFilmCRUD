package com.skilldistillery.filmsite.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		String user = "student";
		String password = "student";
		String sql = "SELECT film.id, film.title, film.description, film.release_year, film.language_id, \n"
				+ "film.rental_duration, film.rental_rate, film.length, film.replacement_cost, film.rating, \n"
				+ "film.special_features, language.name, category.name\n"
				+ "FROM film JOIN language ON film.language_id = language.id \n"
				+ "JOIN film_category on film.id = film_category.film_id\n"
				+ "JOIN category ON film_category.category_id = category.id\n" + "WHERE film.id = ?;";
		try {
			Connection conn = DriverManager.getConnection(URL, user, password);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				film = new Film(rs.getInt("film.id"), rs.getString("film.title"), rs.getString("film.description"),
						rs.getInt("film.release_year"), rs.getInt("film.language_id"),
						rs.getInt("film.rental_duration"), rs.getDouble("film.rental_rate"), rs.getInt("film.length"),
						rs.getDouble("film.replacement_cost"), rs.getString("film.rating"),
						rs.getString("film.special_features"), rs.getString("language.name"),
						rs.getString("category.name"), findActorsByFilmId(rs.getInt("id")));
			}
			conn.close();
			if (film == null) {
				return film;
			}
			return film;

		} catch (SQLException e) {
			System.out.println(e);

			return new Film("");
		}

	}

	@Override
	public Actor findActorById(int actorId) {
		String user = "student";
		String password = "student";
		String sql = "SELECT * FROM actor WHERE id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, password);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, actorId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Actor actor = new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
				return actor;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return new Actor(-1, "None", "Found");
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		String user = "student";
		String password = "student";
//	String sql = "select * from actor join film_actor on actor.id = film_actor.actor_id join film on film_actor.film_id = film.id where film.id = ? ";
		String sql = "SELECT * FROM actor JOIN film_actor on actor.id = film_actor.actor_id JOIN film on film_actor.film_id = film.id WHERE film.id = ? ";
		try {
			Connection conn = DriverManager.getConnection(URL, user, password);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Actor actor = new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
				actors.add(actor);
			}
			conn.close();
			if (actors.size() > 0) {
				return actors;
			}
			actors.add(new Actor(-1, "", ""));
			return actors;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}

	}

	@Override
	public List<Film> findFilmByKeyword(String keyword) {
		List<Film> films = new ArrayList<Film>();
		String user = "student";
		String password = "student";
//		String sql = "SELECT * FROM film WHERE film.title like ? or film.description like ?";
		String sql = "SELECT film.id, film.title, film.description, film.release_year, film.language_id, film.rental_duration, \n" + 
				"film.rental_rate, film.length, film.replacement_cost, film.rating, film.special_features, language.name, category.name \n" + 
				"FROM film JOIN language \n" + 
				"ON film.language_id = language.id JOIN film_category on film.id = film_category.film_id\n" + 
				"JOIN category ON film_category.category_id = category.id\n" + 
				"WHERE (film.title like ?) or (film.description like ?);";
//		String sql = "SELECT film.id, title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features, language.name, actor.first_name, actor.last_name FROM film JOIN film_actor on actor.id = film_actor.actor_id JOIN film on film_actor.film_id = film.id JOIN language on film.language_id = language.id WHERE film.title like ? or film.description like ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, password);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ps.setString(2, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
//				System.out.println(rs.getString("description"));
				Film film = new Film(rs.getInt("film.id"), rs.getString("film.title"), rs.getString("film.description"),
						rs.getInt("film.release_year"), rs.getInt("film.language_id"),
						rs.getInt("film.rental_duration"), rs.getDouble("film.rental_rate"), rs.getInt("film.length"),
						rs.getDouble("film.replacement_cost"), rs.getString("film.rating"),
						rs.getString("film.special_features"), rs.getString("language.name"),
						rs.getString("category.name"), findActorsByFilmId(rs.getInt("id")));

				films.add(film);

			}
			conn.close();
			if (films.size() > 0) {
				return films;
			} else {

				return films;
			}

		} catch (SQLException e) {
			System.out.println(e);
			return films;
		}

	}

	@Override
	public Film createFilm(Film f) {
		Film film = f;
		String user = "student";
		String password = "student";
		String sql = "INSERT INTO film  (title, description, release_year, rental_duration, \n"
				+ "rental_rate, length, replacement_cost, rating, special_features, language_id)\n"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?);";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, film.getTitle());
			ps.setString(2, film.getDescription());
			ps.setInt(3, film.getRelease_year());
			ps.setInt(4, film.getRental_duration());
			ps.setDouble(5, film.getRental_rate());
			ps.setInt(6, film.getLength());
			ps.setDouble(7, film.getReplacement_cost());
			ps.setString(8, film.getRating());
			ps.setString(9, film.getSpecial_features());
			ps.setInt(10, film.getLanguage_id());
			int num = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				System.out.println("New film ID: " + rs.getInt(num));
				film.setId(rs.getInt(num));
				updateFilmCategory(film.getId(), film.getCategory());
			}
			conn.commit();
			return film;

		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle) {
					System.err.println("Error trying to rollback");
				}
			}
			System.out.println(e);
			return null;
		}

	}

	@Override
	public Film deleteFilm(int id) {
		Film film = findFilmById(id);
		if (film == null) {
			return film;
		}
		String user = "student";
		String password = "student";
		String sql = "DELETE FROM film WHERE id = ?";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, film.getId());
			ps.executeUpdate();
			System.out.println("Deleted " + film.getTitle());

			conn.commit();
			return film;
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle) {
					System.err.println("Error trying to rollback");
				}
			}
			System.out.println(e);
			return null;
		}

	}

	@Override
	public Film updateFilm(Film f) {
		Film film = f;
		System.out.println("from DBAO special features " + film.getSpecial_features());
		String user = "student";
		String password = "student";
		String sql = "UPDATE film SET title = ?, description = ?, release_year = ?, rental_duration = ?, \n"
				+ "rental_rate = ?, length = ?, replacement_cost = ?, rating = ?, special_features = ?, language_id = ?\n"
				+ "WHERE id = ?;";
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, user, password);
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, film.getTitle());
			ps.setString(2, film.getDescription());
			ps.setInt(3, film.getRelease_year());
			ps.setInt(4, film.getRental_duration());
			ps.setDouble(5, film.getRental_rate());
			ps.setInt(6, film.getLength());
			ps.setDouble(7, film.getReplacement_cost());
			ps.setString(8, film.getRating());
			ps.setString(9, film.getSpecial_features());
			ps.setInt(10, film.getLanguage_id());
			ps.setInt(11, film.getId());
			ps.executeUpdate();
			System.out.println("You have updated " + film.getTitle());
			System.out.println(film);

			conn.commit();
			return film;
		}

		catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle) {
					System.err.println("Error trying to rollback");
				}
			}
			System.out.println(e);
			return null;
		}
		

	}
	@Override
	public void updateFilmCategory(int filmId, int catId) {
		String user = "student";
		String password = "student";
		String sql ="insert into film_category (film_id, category_id) values (?,?); ";
		
				Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, filmId);
			ps.setInt(2, catId);
		int num = ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
	
		conn.commit();
		

	} catch (SQLException e) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException sqle) {
				System.err.println("Error trying to rollback");
			}
		}
		System.out.println(e);
	}

}


}
