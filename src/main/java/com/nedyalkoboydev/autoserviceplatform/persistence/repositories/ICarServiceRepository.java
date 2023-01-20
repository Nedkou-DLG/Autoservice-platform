package com.nedyalkoboydev.autoserviceplatform.persistence.repositories;

import com.nedyalkoboydev.autoserviceplatform.domain.entities.CarService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarServiceRepository extends JpaRepository<CarService, Long> {
    List<CarService> findTop10ByOrderByNameAsc();
    List<CarService> findByNameContaining(String name);
}
