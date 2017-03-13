package com.track.courier.model;

import org.springframework.data.repository.CrudRepository;

public interface CourierRepository extends CrudRepository<Courier, String> {

	public Courier findByParcelId(String parcelId);
}
