package braga.leonam.services;

import java.time.Instant;

import org.junit.Assert;
import org.junit.Test;

import braga.leonam.entities.Movie;
import braga.leonam.entities.Rent;
import braga.leonam.entities.User;
import braga.leonam.exceptions.OutOfStockException;
import braga.leonam.exceptions.RentException;

public class RentServiceTest {

	@Test
	public void testValue() {

		RentService service = new RentService();
		User user = new User("Leonam Braga");
		Movie movie = new Movie("Homem aranha", 3, 2.75);

		if (movie.getStock() < 1)
			throw new OutOfStockException("this movie is out of stock");

		Rent rent = service.rentAMovie(user, movie);

		Assert.assertEquals(2.75, rent.getValue(), .01);

	}

	@Test
	public void testRentDate() {

		RentService service = new RentService();
		User user = new User("Leonam Braga");
		Movie movie = new Movie("Homem aranha", 3, 2.75);

		if (movie.getStock() < 1)
			throw new OutOfStockException("this movie is out of stock");

		Rent rent = service.rentAMovie(user, movie);

		Assert.assertTrue(rent.getRentDate().equals(Instant.now()));

	}

	@Test
	public void testReturnDate() {

		RentService service = new RentService();
		User user = new User("Leonam Braga");
		Movie movie = new Movie("Homem aranha", 3, 2.75);

		if (movie.getStock() < 1)
			throw new OutOfStockException("this movie is out of stock");

		Rent rent = service.rentAMovie(user, movie);
		Assert.assertTrue(rent.getReturnDate().equals(Instant.now().plusSeconds(86400)));

	}
	
	@Test
	public void testUser() {
		
		RentService service = new RentService();
		User user = null;
		Movie movie = new Movie("Homem aranha", 3, 2.75);
		
		try {
			service.rentAMovie(user, movie);
			Assert.fail();
		} catch (RentException e) {
			Assert.assertEquals(e.getMessage(), "user can't be null");
		}
		
	}
	
	@Test
	public void testMovie() {
		
		RentService service = new RentService();
		User user = new User("Leonam Braga");
		Movie movie = null;
		
		try {
			service.rentAMovie(user, movie);
			Assert.fail();
		} catch (RentException e) {
			Assert.assertEquals(e.getMessage(), "movie can't be null");
		}
		
	}

}
