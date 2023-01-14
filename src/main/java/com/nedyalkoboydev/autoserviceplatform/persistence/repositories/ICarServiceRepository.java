package com.nedyalkoboydev.autoserviceplatform.persistence.repositories;

import com.nedyalkoboydev.autoserviceplatform.domain.entities.CarService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarServiceRepository extends JpaRepository<CarService, Long> {
}
