package com.tsi.service;



import com.tsi.beans.Movie;

public class MovieServiceImpl implements MovieService {

	

	@Override
	public void playMovie(Movie movie) throws Exception {
    System.out.println("Movie Details");
    System.out.println("-------------");
    System.out.println("Movie Name  : " + movie.getMovie_Name());
    System.out.println("Show  Time  : " + movie.getShow_time());
    System.out.println("Movie Price : " + movie.getPrice());
    throw new RuntimeException("Power Failure");  // when ever thorws expcetion advices will be excuted
 
	}

}
