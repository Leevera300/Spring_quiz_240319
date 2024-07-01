package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {

	@Autowired
	private BookingMapper bookingMapper;
	
	// input: X
	// output: List<Booking>
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	// input: id
	// output: int
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	// input: parameters
	// output: X
	public void addBooking(String name, LocalDate date, int day, 
			int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	// input: parameters
	// output: map
	public Booking getBookingByNameAndPhoneNumber(String name, String phoneNumber) {
		return bookingMapper.selectBookingByNameAndPhoneNumber(name, phoneNumber);
	}
}
