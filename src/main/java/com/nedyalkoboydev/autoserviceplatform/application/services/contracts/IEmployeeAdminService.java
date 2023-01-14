package com.nedyalkoboydev.autoserviceplatform.application.services.contracts;

import com.nedyalkoboydev.autoserviceplatform.domain.dtos.CarServiceDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.dtos.CreateCarServiceDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.dtos.EmployeeDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.entities.CarService;
import com.nedyalkoboydev.autoserviceplatform.domain.entities.Employee;

import java.util.List;

public interface IEmployeeAdminService {
    CarServiceDTO createCarService(CreateCarServiceDTO model);
}
