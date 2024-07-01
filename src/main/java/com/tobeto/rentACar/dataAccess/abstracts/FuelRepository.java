package com.tobeto.rentACar.dataAccess.abstracts;

import com.tobeto.rentACar.entities.concretes.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelRepository extends JpaRepository<Fuel,Integer> {
}
