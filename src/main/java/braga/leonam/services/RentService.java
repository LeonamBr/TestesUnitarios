package braga.leonam.services;

import java.time.Instant;

import braga.leonam.entities.Movie;
import braga.leonam.entities.Rent;
import braga.leonam.entities.User;

public class RentService {

	public Rent rentAMovie(User user, Movie movie) {
		Rent rent = new Rent();
		rent.setMovie(movie);
		rent.setUser(user);
		rent.setRentDate(Instant.now());
		rent.setValue(movie.getRentPrice());
		rent.setReturnDate(rent.getRentDate().plusSeconds(86400));

		return rent;
	}

}
