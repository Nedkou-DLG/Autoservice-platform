package com.nedyalkoboydev.autoserviceplatform.persistence.repositories;

import com.nedyalkoboydev.autoserviceplatform.domain.entities.AppointmentCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentCalendarRepository extends JpaRepository<AppointmentCalendar, Long> {
}
