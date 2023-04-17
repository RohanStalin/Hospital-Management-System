package boot.dto;

import java.util.List;

import boot.entity.Appointment;
import lombok.Data;

@Data
public class DoctorDTO {
	    private Long id;
	    
	
	    private String name;
	    private String email;
	    
	    
	    private String password;
	    
	    
	    private String specialization;
	    
//	    private List<Appointment> appointments;
	    

}
