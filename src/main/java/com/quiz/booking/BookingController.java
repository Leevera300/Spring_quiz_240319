package com.quiz.booking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {

	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		// DB select
		List<Booking> BookingList = bookingBO.getBookingList();
		
		// Model
		model.addAttribute("BookingList", BookingList);
		
		// 화면
		return "booking/bookingList";
	}
	
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		// DB
		int rowCount = bookingBO.deleteBookingById(id);
		
		// JSON 응답
		// {"code":200, "delete":true}
		Map<String, Object> result = new HashMap<>();
			if (rowCount > 0) {
				result.put("code", 200);
				result.put("result", "성공");
			} else {
				result.put("code", 500);
				result.put("error_message", "삭제할 항목이 존재하지 않습니다.");
			}
				
		return result;
	}
	
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
}
