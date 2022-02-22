package braga.leonam.services;

import java.time.Instant;

import org.junit.Assert;
import org.junit.Test;

import braga.leonam.entities.Movie;
import braga.leonam.entities.Rent;
import braga.leonam.entities.User;

public class RentServiceTest {

	@Test
	public void testValue() {

		RentService service = new RentService();
		User user = new User("Leonam Braga");
		Movie movie = new Movie("Homem aranha", 3, 2.75);

		Rent rent = service.rentAMovie(user, movie);

		Assert.assertEquals(2.75, rent.getValue(), .01);

	}

	@Test
	public void testRentDate() {

		RentService service = new RentService();
		User user = new User("Leonam Braga");
		Movie movie = new Movie("Homem aranha", 3, 2.75);

		Rent rent = service.rentAMovie(user, movie);

		Assert.assertTrue(rent.getRentDate().equals(Instant.now()));

	}

	@Test
	public void testReturnDate() {

		RentService service = new RentService();
		User user = new User("Leonam Braga");
		Movie movie = new Movie("Homem aranha", 3, 2.75);

		Rent rent = service.rentAMovie(user, movie);
		Assert.assertTrue(rent.getReturnDate().equals(Instant.now().plusSeconds(86400)));

	}

}
