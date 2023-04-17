package boot.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dto.AppointmentDTO;
import boot.entity.Appointment;
import boot.exception.ResourceNotFoundException;
import boot.repo.AppointmentRepo;
import boot.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<AppointmentDTO> getAllAppointment() {
		// TODO Auto-generated method stub
		List<Appointment> findAll = repo.findAll();
		List<AppointmentDTO> collect = findAll.stream().map(app->this.mapper.map(app, AppointmentDTO.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public AppointmentDTO getAppointmentById(Long id) {
		// TODO Auto-generated method stub

		if(repo.existsById(id))
		{
			Appointment appointment = repo.findById(id).get();
			return this.mapper.map(appointment, AppointmentDTO.class);
		}
		else
			throw new ResourceNotFoundException("Appointment", "AppointmentId", id); 
	}

	@Override
	public AppointmentDTO saveAppointment(Appointment app) {
		// TODO Auto-generated method stub
		Appointment save = repo.save(app);
		return this.mapper.map(save, AppointmentDTO.class);
	}

	@Override
	public AppointmentDTO updateAppointment(Long id, Appointment app) {
		// TODO Auto-generated method stub
		if(repo.existsById(id))
		{
			Appointment save = repo.save(app);
			return this.mapper.map(save, AppointmentDTO.class);
		}
		else
			throw new ResourceNotFoundException("Appointment", "AppointmentId", id); 
	}

	@Override
	public void deleteAppointment(Long id) {
		if(repo.existsById(id))
		{
			repo.deleteById(id);
		}
		else
			throw new ResourceNotFoundException("Appointment", "AppointmentId", id); 
		
	}

}
