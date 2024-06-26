package com.quiz.weather_history;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherHistroyBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {

	@Autowired
	private WeatherHistroyBO weatherHistoryBO;
	
	// http://localhost:8080/weather-history/weather-list-view
	@GetMapping("/weather-list-view")
	public String weatherList(Model model) {
		// select DB
		List<WeatherHistory> List = weatherHistoryBO.getWeatherList();
		// Model
		model.addAttribute("List", List);
		// 화면
		return "weather_history/weatherList";
	}
	
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	// 날씨 추가 기능 /weather-history/add-weather
	@PostMapping("/add-weather")
	public String addWeather(
			// RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam("date") LocalDate date, // String 이나 LocalDate 둘다 됨
			@RequestParam("weather") String weather,
			@RequestParam("temperature") String temperature,
			@RequestParam("precipitation") String precipitation,
			@RequestParam("microDust") String microDust,
			@RequestParam("windSpeed") String windSpeed) {
		// insert
		weatherHistoryBO.addWeather(date, weather, temperature, precipitation,
				microDust, windSpeed);
		// redirect => 날씨 목록
		return "redirect:/weather-history/weather-list-view";
	}
}
