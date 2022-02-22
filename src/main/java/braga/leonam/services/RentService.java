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

	public static void main(String[] args) {

		RentService service = new RentService();
		User user = new User("Leonam Braga");
		Movie movie = new Movie("Homem aranha", 3, 2.75);
				
		Rent rent = service.rentAMovie(user, movie);
		
		System.out.println(rent.getValue() == 2.75);
		System.out.println(rent.getRentDate().equals(Instant.now()));
		System.out.println(rent.getReturnDate().equals(Instant.now().plusSeconds(86400)));

	}

}
