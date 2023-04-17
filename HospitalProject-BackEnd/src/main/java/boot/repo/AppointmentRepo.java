package boot.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import boot.entity.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Long>{

	    List<Appointment> findByPatientId(Long patientId);
	    
	    List<Appointment> findByDoctorId(Long doctorId);
	    
}
