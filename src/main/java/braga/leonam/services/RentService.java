package braga.leonam.services;

import java.time.Instant;
import java.util.List;

import braga.leonam.entities.Movie;
import braga.leonam.entities.Rent;
import braga.leonam.entities.User;
import braga.leonam.exceptions.OutOfStockException;
import braga.leonam.exceptions.RentException;

public class RentService {

	public Rent rentAMovie(User user, List<Movie> movie) {

		if (user == null)
			throw new RentException("user can't be null");

		for (Movie mv : movie)
			if (mv == null)
				throw new RentException("movie can't be null");

		if (movie.isEmpty())
			throw new RentException("movie can't be null");

		for (Movie mv : movie)
			if (mv.getStock() < 1)
				throw new OutOfStockException("this movie is out of stock");

		Rent rent = new Rent();
		rent.setMovie(movie);
		rent.setUser(user);
		rent.setRentDate(Instant.now());
		for (Movie mv : movie)
			rent.setValue(mv);
		rent.setReturnDate(rent.getRentDate().plusSeconds(86400));

		return rent;
	}

}
