package com.quiz.weather_history.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather_history.domain.WeatherHistory;
import com.quiz.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistroyBO {

	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	// input: X
	// output: List<WeatherHistory>
	public List<WeatherHistory> getWeatherList() {
		return weatherHistoryMapper.selectWeatherList();
	}
	
	// input: parameters
	// output: X
	public void addWeather(LocalDate date, String weather, String temperature, String precipitation,
			String microDust, String windSpeed) {
		weatherHistoryMapper.insertWeather(date, weather, temperature, precipitation,
				microDust, windSpeed);
	}
}
