package com.cg.sprint.dto;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="bookingdetails")
public class Booking 
{
     @Id
     @Column(name="booking_id")
     int BookingId;
     @OneToOne
     @JoinColumn(name="show_id")
     Show show;
     @OneToOne
     @JoinColumn(name="user_id")
     User user;
     @Column(name="booking_date")
     LocalDate bookingDate;
     @Column(name="show_date")
     LocalDate showDate;
     @OneToOne
     @JoinColumn(name="movie_id")
     Movie movie;
     @OneToMany
     @JoinColumn(name="booking_id")
     List<ReservedSeats> reservedSeats;
	public Booking() {
		super();
	}
	public Booking(int bookingId, Show show, User user, LocalDate bookingDate, LocalDate showDate, Movie movie,
			List<ReservedSeats> reservedSeats) {
		super();
		BookingId = bookingId;
		this.show = show;
		this.user = user;
		this.bookingDate = bookingDate;
		this.showDate = showDate;
		this.movie = movie;
		this.reservedSeats = reservedSeats;
	}
	public int getBookingId() {
		return BookingId;
	}
	public void setBookingId(int bookingId) {
		BookingId = bookingId;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalDate getShowDate() {
		return showDate;
	}
	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public List<ReservedSeats> getReservedSeats() {
		return reservedSeats;
	}
	public void setReservedSeats(List<ReservedSeats> reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	}