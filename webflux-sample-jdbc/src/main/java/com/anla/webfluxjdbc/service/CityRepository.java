package com.anla.webfluxjdbc.service;

import com.anla.webfluxjdbc.domain.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
	City findByNameAndCountryAllIgnoringCase(String name, String country);
}
