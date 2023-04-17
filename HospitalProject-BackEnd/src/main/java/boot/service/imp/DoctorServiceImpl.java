package boot.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dto.AppointmentDTO;
import boot.dto.DoctorDTO;
import boot.entity.Doctor;
import boot.exception.ResourceNotFoundException;
import boot.repo.DoctorRepository;
import boot.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	ModelMapper mapper;
	
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<DoctorDTO> getAllDoctors() {
    	List<Doctor> findAll = doctorRepository.findAll();
    	List<DoctorDTO> collect = findAll.stream().map(doc->this.mapper.map(doc, DoctorDTO.class)).collect(Collectors.toList());
        return collect ;
    }

    @Override
    public DoctorDTO getDoctorById(Long id) {
    	if(doctorRepository.existsById(id))
    	{
    		Doctor doctor = doctorRepository.findById(id).get();
    		return this.mapper.map(doctor, DoctorDTO.class);
    	}
    	else
    		throw new ResourceNotFoundException("Doctor", "id", id);
    }

    @Override
    public DoctorDTO saveDoctor(Doctor doctor) {
    	Doctor save = doctorRepository.save(doctor);
        return this.mapper.map(save, DoctorDTO.class);
    }

    @Override
    public void deleteDoctor(Long id) {
    	if(doctorRepository.existsById(id))
		{
			doctorRepository.deleteById(id);
		}
		else
		{
			throw new ResourceNotFoundException("Doctor","DoctorId",id);
		}
    }

	@Override
	public DoctorDTO updateDoctor(Long id, Doctor doctor) {
	if(doctorRepository.existsById(id)) {
        Doctor doctor2 = doctorRepository.save(doctor);
        return this.mapper.map(doctor2,DoctorDTO.class);
    	}    
        else
        {
        	throw new ResourceNotFoundException("Doctor", "id", id);
        }
		
	}
}

