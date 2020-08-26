package com.tsi.service;

import com.tsi.bean.Show;

public class ShowServiceImpl implements ShowService {

	@Override
	public String runShow(Show show) throws RuntimeException {

		System.out.println("Show " + show.getName() + "Start ");
		System.out.println("Show " + show.getName() + "Running Sucessfully");
		if (!show.getName().equalsIgnoreCase("Mimicry")) {
			throw new RuntimeException();
		}
		System.out.println("Show " + show.getName() + "Ends..");
		return "Success";
	}

}
