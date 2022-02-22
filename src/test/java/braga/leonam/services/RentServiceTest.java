package braga.leonam.services;

import java.time.Instant;

import org.junit.Assert;
import org.junit.Test;

import braga.leonam.entities.Movie;
import braga.leonam.entities.Rent;
import braga.leonam.entities.User;
import braga.leonam.services.RentService;

public class RentServiceTest {
	
	@Test
	public void test() {

		RentService service = new RentService();
		User user = new User("Leonam Braga");
		Movie movie = new Movie("Homem aranha", 3, 2.75);
				
		Rent rent = service.rentAMovie(user, movie);
		
		Assert.assertEquals(2.75, rent.getValue(), .01);
		Assert.assertTrue(rent.getRentDate().equals(Instant.now()));
		Assert.assertTrue(rent.getReturnDate().equals(Instant.now().plusSeconds(86400)));

	}

}
