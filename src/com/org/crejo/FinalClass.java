/**
 * 
 */
package com.org.crejo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

import com.org.crejo.models.*;

/**
 * @author Mridul
 *
 */
public class FinalClass {
	
	static ArrayList<User> users;
	static HashSet<Movie> movies;
	static ArrayList<Review> reviwes = new ArrayList<Review>();
	
	static void addUsers()
	{
		try
		{
		users = new ArrayList<User>();
		User user = new User();
		user.setUserName("SRK");
		user.setEmailID("SRK@email.com");
		user.setUserType(UserType.VIEWER);
		users.add(user);
		
		User user1 = new User();
		user1.setUserName("Salman");
		user1.setEmailID("Salman@email.com");
		user1.setUserType(UserType.VIEWER);
		users.add(user1);
		
		User user2 = new User();
		user2.setUserName("Deepika");
		user2.setEmailID("Deepika@email.com");
		user2.setUserType(UserType.VIEWER);
		users.add(user2);
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
	}
	
	static void addMovies()
	{
		try {
		movies = new HashSet<Movie>();
		
		Movie movie = new Movie();
		movie.setMovieName("Don");
		movie.setReleaseYear(2006);
		movie.setGenre(MovieGenre.Action);
		
		Movie movie1 = new Movie();
		movie1.setMovieName("Tiger");
		movie1.setReleaseYear(2008);
		movie1.setGenre(MovieGenre.Drama);
		
		Movie movie2 = new Movie();
		movie2.setMovieName("Padmaavat");
		movie2.setReleaseYear(2006);
		movie2.setGenre(MovieGenre.Comedy);
		
		Movie movie3 = new Movie();
		movie3.setMovieName("Lunchbox");
		movie3.setReleaseYear(2022);
		movie3.setGenre(MovieGenre.Drama);
		
		Movie movie4 = new Movie();
		movie4.setMovieName("Guru");
		movie4.setReleaseYear(2006);
		movie4.setGenre(MovieGenre.Drama);
		
		Movie movie5 = new Movie();
		movie5.setMovieName("Metro");
		movie5.setReleaseYear(2006);
		movie5.setGenre(MovieGenre.Romance);
		
		movies.add(movie);
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);
		movies.add(movie5);
	}
	catch(Exception ex)
		{
		throw ex;
		}
	}	

	static String addReview(String userName,String movieName,Integer rating){
		String result = "";
		User user = new User();
		Movie movie = new Movie();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		try
		{
			// Check for User
			for(User obj :users)
			{
				if(obj.getUserName() == userName)
				{
					user = obj;
					break;
				}
			}
			
			// Check for Movie
			for(Movie obj : movies)
			{
				if(obj.getMovieName() == movieName)
				{
					movie = obj;
					break;
				}
			}
			
			if(user.getUserName() !=null && movie.getMovieName() != null)
			{
				// Check for review Count;
				if(reviwes.size()>0)
				{
					//Check for duplicate review
					for(Review obj : reviwes)
					{
						if(obj.getUser().getUserName() == userName && obj.getMovie().getMovieName() == movieName)
						{
							return result = "Exception multiple reviews not allowed --- for input " + userName + " , "+movieName;
							
						}
						if(movie.getReleaseYear() > year)
						{
							return result = "Exception movie yet to be released --- for input " + userName + " , "+movieName;
						}
						else
						{
							Review review = new Review();
							user.setReviewCount(user.getReviewCount() + 1);
							if(user.getReviewCount() ==3)
							{
								user.setUserType(UserType.CRITIC);
								result = " User has been Promoted to critic";
							}
							review.setUser(user);
							review.setMovie(movie);
							review.setRating(rating);
							reviwes.add(review);
							
							return result = "Review Has Been Saved -- User "+user.getUserName() + " given "+rating+" to a movie "+movie.getMovieName() + result;
							
						}
					}
				}
				else
				{
					Review review = new Review();
					user.setReviewCount(user.getReviewCount() + 1);
					review.setUser(user);
					review.setMovie(movie);
					review.setRating(rating);
					reviwes.add(review);
					return result = "Review Has Been Saved -- User "+user.getUserName() + " given "+rating+" to a movie "+movie.getMovieName() ;
				}
			}
			else
			{
				return result = "Exception either User or Movie Not Found --- for input " + userName + " , "+movieName;
			}
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
		return result;
	}
	
	static void avgReviewScoreByYear(int year)
	{
		int sum = 0;
		int count = 0;
		for(Review obj:reviwes)
		{
			if(obj.getMovie().getReleaseYear() == year)
			{
				sum = sum + obj.getRating();
				count = count+1;
			}
		}
		if(count == 0)
		{
			System.out.println("No Reviews has been Found in given year");
		}
		else
		{
			System.out.println("Average review score of "+ year+" is "+ sum/count);
		}
	}
	
	static void avgReviewScoreByMovie(String movieName)
	{
		int sum = 0;
		int count = 0;
		for(Review obj:reviwes)
		{
			if(obj.getMovie().getMovieName() == movieName)
			{
				sum = sum + obj.getRating();
				count = count+1;
			}
		}
		if(count == 0)
		{
			System.out.println("No Reviews has been Found for a given movie");
		}
		else
		{
			System.out.println("Average review score of "+movieName+" is "+ sum/count);
		}
	}
	
	static void topNMovies()
	{
		ArrayList<Review> filter = new ArrayList<Review>();
		for(Review obj:reviwes)
		{
			if(obj.getUser().getUserType().toString() == "CRITIC")
			{
				filter.add(obj);
			}
		}
		for(Review obj:filter)
		{
			System.out.println(obj.getMovie().getMovieName() + "=="+ obj.getRating());
		}
	}
	public static void main(String args[]) {
	   addUsers();
	   addMovies();
	   System.out.println(addReview("SRK","Don",2));
	   System.out.println(addReview("SRK","Padmaavat",8));
	   System.out.println(addReview("Salman","Don",5));
	   System.out.println(addReview("Deepika","Don",9));
	   System.out.println(addReview("Deepika","Guru",6));
	   System.out.println(addReview("SRK","Don",10));
	   System.out.println(addReview("Deepika","Lunchbox",5));
	   System.out.println(addReview("SRK","Tiger",5));
	   System.out.println(addReview("SRK","Metro",7)); 
	   avgReviewScoreByYear(2006);
	   avgReviewScoreByMovie("Don");
	   topNMovies();
	}
}

