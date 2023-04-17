package boot.dto;

import java.time.LocalDateTime;

import boot.entity.Appointment;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppointmentDTO {
    
    private Long id;
    private PatientDTO patient;
    private DoctorDTO doctor;
    private LocalDateTime appointmentDateTime;
    private String status;
    
  

	
}
