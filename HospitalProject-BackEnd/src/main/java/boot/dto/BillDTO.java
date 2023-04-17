package boot.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import boot.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDTO {

    private Long id; 
    
    private PatientDTO patient;
    private LocalDateTime billDate;
    private double totalAmount;
    private String paymentStatus;
    
    
}
