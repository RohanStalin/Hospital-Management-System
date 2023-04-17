package boot.service;

import java.util.List;

import boot.dto.PatientDTO;
import boot.entity.Doctor;
import boot.entity.Patient;

public interface PatientService {
	
	 List<PatientDTO> getAllPatient();
	 PatientDTO getPatientById(Long id);
	 PatientDTO savePatient(Patient patient);
	 PatientDTO updatePatient(Long id,Patient patient);
	 void deletePatient(Long id);
}
