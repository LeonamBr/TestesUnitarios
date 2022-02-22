package braga.leonam.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Rent {
	
	private User user;
	
	private List<Movie> movie = new ArrayList<>();;
	
	private Instant rentDate;
	
	private Instant returnDate;
	
	private List<Double> value = new ArrayList<>();
	
	
	public Rent() {
	}

	public Rent(User user, Movie movie, Instant rentDate, Instant returnDate, Double value) {
		this.user = user;
		this.movie.add(movie);
		this.rentDate = rentDate;
		this.returnDate = returnDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Movie> getMovie() {
		return movie;
	}
	
	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}

	public Instant getRentDate() {
		return rentDate;
	}

	public void setRentDate(Instant rentDate) {
		this.rentDate = rentDate;
	}

	public Instant getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Instant returnDate) {
		this.returnDate = returnDate;
	}

	public List<Double> getValue() {
		return value;
	}

	public void setValue(Movie movie) {
		this.value.add(movie.getRentPrice());
	}
	
	public double sumValue() {
		double sum = 0.0;
		for (Double value : this.value)
			sum += value;
		return sum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rentDate == null) ? 0 : rentDate.hashCode());
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rent other = (Rent) obj;
		if (rentDate == null) {
			if (other.rentDate != null)
				return false;
		} else if (!rentDate.equals(other.rentDate))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		return true;
	}

}
