package braga.leonam.services;

import java.time.Instant;

import braga.leonam.entities.Movie;
import braga.leonam.entities.Rent;
import braga.leonam.entities.User;
import braga.leonam.exceptions.OutOfStockException;
import braga.leonam.exceptions.RentException;

public class RentService {

	public Rent rentAMovie(User user, Movie movie) {
		
				
		if (user == null)
			throw new RentException("user can't be null");

		if (movie == null)
			throw new RentException("movie can't be null");
		
		if (movie.getStock() < 1)
			throw new OutOfStockException("this movie is out of stock");
		
		Rent rent = new Rent();
		rent.setMovie(movie);
		rent.setUser(user);
		rent.setRentDate(Instant.now());
		rent.setValue(movie.getRentPrice());
		rent.setReturnDate(rent.getRentDate().plusSeconds(86400));

		return rent;
	}

}
