package com.tsi.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tsi.beans.Movie;
import com.tsi.service.MovieService;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/tsi/resource/applicationContext.xml");
		Movie movie = (Movie) context.getBean("movieBean");
		MovieService movie_service = (MovieService) context.getBean("proxy");
		
		try {
		movie_service.playMovie(movie);
		} catch (Exception e) {
			
		}

	}

}
