package boot.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dto.DoctorDTO;
import boot.dto.PatientDTO;
import boot.entity.Patient;
import boot.exception.ResourceNotFoundException;
import boot.repo.PatientRepo;
import boot.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	PatientRepo repo;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public List<PatientDTO> getAllPatient() {
		// TODO Auto-generated method stub
		List<Patient> findAll = repo.findAll();
		List<PatientDTO> collect=findAll.stream().map(pat->this.mapper.map(pat, PatientDTO.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public PatientDTO getPatientById(Long id) {
		// TODO Auto-generated method stub
		if(repo.existsById(id))
		{
			Patient patient = repo.findById(id).get();
			return this.mapper.map(patient, PatientDTO.class);
		}
		else
		{
			throw new ResourceNotFoundException("Patient", "PatientId", id);
		}
	}

	@Override
	public PatientDTO savePatient(Patient patient) {
		// TODO Auto-generated method stub
		Patient save = repo.save(patient);
		return  this.mapper.map(save, PatientDTO.class);
	}

	@Override
	public PatientDTO updatePatient(Long id, Patient patient) {
		// TODO Auto-generated method stub
		
		if(repo.existsById(id))
		{
			Patient save = repo.save(patient);
			return  this.mapper.map(save, PatientDTO.class);
		}
		else {
			throw  new ResourceNotFoundException("Patient", "PatientId", id);
		} 

		
	}

	@Override
	public void deletePatient(Long id) {
		if(repo.existsById(id))
		{
			repo.deleteById(id);
		}
		else
			throw  new ResourceNotFoundException("Patient", "PatientId", id);
		
		
	}

}
