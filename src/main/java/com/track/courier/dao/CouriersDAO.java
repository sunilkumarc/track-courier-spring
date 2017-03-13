package com.track.courier.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.track.courier.model.Courier;
import com.track.courier.model.CourierRepository;

@Component
public class CouriersDAO {

	@Autowired
	CourierRepository courierRepository;

	public Courier addCourier(Courier courier) {
		return courierRepository.save(courier);
	}

	public List<Courier> findAll() {
		List<Courier> couriers = new ArrayList<>();
		for (Courier courier : courierRepository.findAll()) {
			couriers.add(courier);
		}
		return couriers;
	}
	
	public Courier getSingleCourier(String courierId) {
		return courierRepository.findByParcelId(courierId);
	}
}
