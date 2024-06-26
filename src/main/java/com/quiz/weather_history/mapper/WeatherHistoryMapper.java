package com.quiz.weather_history.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.weather_history.domain.WeatherHistory;

@Mapper
public interface WeatherHistoryMapper {

	public List<WeatherHistory> selectWeatherList();
	
	public void insertWeather(
			@Param("date") LocalDate date, 
			@Param("weather") String weather, 
			@Param("temperature") String temperature, 
			@Param("precipitation") String precipitation,
			@Param("microDust") String microDust, 
			@Param("windSpeed") String windSpeed);
}
