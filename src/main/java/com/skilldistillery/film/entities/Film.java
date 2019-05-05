package com.skilldistillery.film.entities;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Film {

	private List<Actor> actors;
	private int id;
	private String title;
	private String description;
	@Min(1901)
	@Max(2099)
	private int release_year;
	private int language_id;
	private int rental_duration;
	private double rental_rate;
	private int length;
	private double replacement_cost;
	private String rating;
	private String special_features;
	private String language;
	
	public Film() {
		
	}
	public Film(String title2, String description2, int rental_duration2, int release_year2, double rental_rate2, int length2, double replacement_cost2, String rating2, String special_features2, int language_id2) {
		title = title2;
		description = description2;
		rental_duration = rental_duration2;
		release_year = release_year2;
		rental_rate = rental_rate2;
		length = length2;
		replacement_cost = replacement_cost2;
		rating = rating2;
		special_features = special_features2;
		language_id = language_id2;
	}
	public Film(int id, String title, String description, int release_year, int language_id, int rental_duration,
			double rental_rate, int length, double replacement_cost, String rating, String special_features, String language, List<Actor> actors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.release_year = release_year;
		this.language_id = language_id;
		this.rental_duration = rental_duration;
		this.rental_rate = rental_rate;
		this.length = length;
		this.replacement_cost = replacement_cost;
		this.rating = rating;
		this.special_features = special_features;
		this.language = language;
		this.actors = actors;
		
	}
	
	
	
	public Film(String title) {
		super();
		this.title = title;
	}



	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Film(int id) {
		super();
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRelease_year() {
		return release_year;
	}
	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}
	public int getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}
	public int getRental_duration() {
		return rental_duration;
	}
	public void setRental_duration(int rental_duration) {
		this.rental_duration = rental_duration;
	}
	public double getRental_rate() {
		return rental_rate;
	}
	public void setRental_rate(double rental_rate) {
		this.rental_rate = rental_rate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public double getReplacement_cost() {
		return replacement_cost;
	}
	public void setReplacement_cost(double replacement_cost) {
		this.replacement_cost = replacement_cost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSpecial_features() {
		return special_features;
	}
	public void setSpecial_features(List<String> featuresList) {
		String features = "";
		if(featuresList == null) {
			this.special_features = "";
		}
			for (int i = 0; i < featuresList.size(); i++) {
				if(i == 0) {
					features = featuresList.get(i)+ ",";
				}else {
					features += featuresList.get(i) + ",";
				}
			}
			features = features.substring(0, features.length()-1);
			System.out.println(features);
		this.special_features = features;
	}
	
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	@Override
	public String toString() {
		String details = "Title: " + title  +"\nReleased "+ release_year + " in " + language  + " : Rated "+ rating +"\n"+ description + "\n";
		StringBuilder b = new StringBuilder(details);
//		if(title == "") {
//		
//			return "";
//		}
//		b.append("Cast:");
//		if(actors.size()>0) {
//		for (Actor actor : actors) {
//			if(actor.getFirst_name().equals("")) {
//				continue;
//			}
//			b.append(" " + actor+ ",");
//		}
//		}
//		b.setLength(b.length()-1);
		return b.toString()+"\n\n"; 
			
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + language_id;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + release_year;
		result = prime * result + rental_duration;
		long temp;
		temp = Double.doubleToLongBits(rental_rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replacement_cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((special_features == null) ? 0 : special_features.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (language_id != other.language_id)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (release_year != other.release_year)
			return false;
		if (rental_duration != other.rental_duration)
			return false;
		if (Double.doubleToLongBits(rental_rate) != Double.doubleToLongBits(other.rental_rate))
			return false;
		if (Double.doubleToLongBits(replacement_cost) != Double.doubleToLongBits(other.replacement_cost))
			return false;
		if (special_features == null) {
			if (other.special_features != null)
				return false;
		} else if (!special_features.equals(other.special_features))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}