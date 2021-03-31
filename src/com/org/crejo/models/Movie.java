/**
 * 
 */
package com.org.crejo.models;

/**
 * @author Mridul
 *
 */
public class Movie {
	
	private String movieName;
	private Integer releaseYear;
	private MovieGenre genre;
	
	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}
	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	/**
	 * @return the releaseYear
	 */
	public Integer getReleaseYear() {
		return releaseYear;
	}
	/**
	 * @param releaseYear the releaseYear to set
	 */
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
	/**
	 * @return the genre
	 */
	public MovieGenre getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(MovieGenre genre) {
		this.genre = genre;
	}

}
