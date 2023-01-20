package com.nedyalkoboydev.autoserviceplatform.application.services.contracts;

import com.nedyalkoboydev.autoserviceplatform.domain.dtos.AppointmentCalendarDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.dtos.CompleteAppoinmentDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.models.CompleteAppointmentViewModel;

import java.util.List;

public interface IEmployeeService {
    List<AppointmentCalendarDTO> getSchedule();

    void completeAppointment(CompleteAppoinmentDTO model);
}
