package boot.service;

import java.util.List;

import boot.dto.AppointmentDTO;
import boot.entity.Appointment;
import boot.entity.Rep;

public interface AppointmentService {
	List<AppointmentDTO> getAllAppointment();
	AppointmentDTO getAppointmentById(Long id);
	AppointmentDTO saveAppointment(Appointment app);
	AppointmentDTO updateAppointment(Long id,Appointment app);
	void deleteAppointment(Long id);

}
