package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {
	
	@Autowired
	private RealEstateMapper realEstateMapper;

	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}
	
	public List<RealEstate> getRealEstateByRentPrice(int rentPrice) {
		return realEstateMapper.selectRealEstateByRentPrice(rentPrice);
	}
	
	public List<RealEstate> getRealEstateByAreaAndPrice(int area, int price){
		return realEstateMapper.selectRealEstateByAreaAndPrice(area, price);
	}
	
	// input: RealEstate
	// output: 성공한 행의 개수(int)
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
//	addRealEstatebyRealtorIDandAsField(
//			realtor_id, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
//	address
//	area
//	type
//	price
//	rentPrice
	
	public int addRealEstatebyRealtorIDandAsField(int realtor_id, String address, int area
			, String type, int price, Integer rentPrice) {
		return realEstateMapper.insertRealEstatebyRealtorIDandAsField(realtor_id, address, area, 
				type, price, rentPrice);
	}
}
