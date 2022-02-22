package braga.leonam.services;

import java.time.Instant;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import braga.leonam.entities.Movie;
import braga.leonam.entities.Rent;
import braga.leonam.entities.User;
import braga.leonam.exceptions.OutOfStockException;
import braga.leonam.exceptions.RentException;

public class RentServiceTest {

	private RentService service;

	private User user;

	private Movie mv;

	private Movie mv2;

	@Before
	public void testSetup() {
		service = new RentService();
		user = new User("Leonam Braga");
		mv = new Movie("Homem aranha", 3, 2.75);
		mv2 = new Movie("Doutor Stranho", 2, 3.00);

	}

	@Test
	public void testValue() {

		for (Movie mov : Arrays.asList(mv, mv2))
			if (mov.getStock() < 1)
				throw new OutOfStockException("this movie is out of stock");

		Rent rent = service.rentAMovie(user, Arrays.asList(mv, mv2));

		Assert.assertEquals(5.75, rent.sumValue(), .01);

	}

	@Test
	public void testRentDate() {

		for (Movie mov : Arrays.asList(mv, mv2))
			if (mov.getStock() < 1)
				throw new OutOfStockException("this movie is out of stock");
		
		Rent rent = service.rentAMovie(user, Arrays.asList(mv, mv2));

		Assert.assertTrue(rent.getRentDate().equals(Instant.now()));

	}

	@Test
	public void testReturnDate() {

		for (Movie mov : Arrays.asList(mv, mv2))
			if (mov.getStock() < 1)
				throw new OutOfStockException("this movie is out of stock");

		Rent rent = service.rentAMovie(user, Arrays.asList(mv, mv2));
		Assert.assertTrue(rent.getReturnDate().equals(Instant.now().plusSeconds(86400)));

	}

	@Test
	public void testUser() {

		user = null;

		try {
			service.rentAMovie(user, Arrays.asList(mv, mv2));
			Assert.fail();
		} catch (RentException e) {
			Assert.assertEquals(e.getMessage(), "user can't be null");
		}

	}

	@Test
	public void testMovie() {

		mv = null;
		mv2 = null;

		try {
			service.rentAMovie(user, Arrays.asList(mv, mv2));
			Assert.fail();
		} catch (RentException e) {
			Assert.assertEquals(e.getMessage(), "movie can't be null");
		}

	}

}
