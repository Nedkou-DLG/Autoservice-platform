package com.nedyalkoboydev.autoserviceplatform.persistence.repositories;

import com.nedyalkoboydev.autoserviceplatform.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT employee FROM Employee employee WHERE (employee.firstName LIKE CONCAT('%',UPPER(:name),'%') or employee.lastName LIKE CONCAT('%',UPPER(:name),'%')) AND employee.carService.id = :carServiceId")
    List<Employee> findEmployeesInCarService(@Param("name") String name, @Param("carServiceId")  long carServiceId);
}
