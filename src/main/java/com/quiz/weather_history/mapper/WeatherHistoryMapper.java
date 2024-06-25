package com.quiz.weather_history.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.weather_history.domain.WeatherHistory;

@Mapper
public interface WeatherHistoryMapper {

	public List<WeatherHistory> selectWeatherList();
	
	public void insertWeather(Date date, String weather, String temperature, String precipitation,
			String microDust, String windSpeed);
}
