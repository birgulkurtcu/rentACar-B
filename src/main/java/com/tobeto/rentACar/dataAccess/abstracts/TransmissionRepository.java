package com.tobeto.rentACar.dataAccess.abstracts;

import com.tobeto.rentACar.entities.concretes.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmissionRepository extends JpaRepository<Transmission,Integer> {
}
