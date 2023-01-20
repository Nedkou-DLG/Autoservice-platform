package com.nedyalkoboydev.autoserviceplatform.persistence.repositories;

import com.nedyalkoboydev.autoserviceplatform.domain.entities.TypeOfServices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IServiceTypeRepository extends JpaRepository<TypeOfServices, Long> {
    List<TypeOfServices> findByNameContaining(String name);
}
