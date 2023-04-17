package boot.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dto.PatientDTO;
import boot.dto.RepDTO;
import boot.entity.Patient;
import boot.entity.Rep;
import boot.exception.ResourceNotFoundException;
import boot.repo.RepRepo;
import boot.service.RepService;

@Service
public class RepServiceImpl implements RepService{
	
	@Autowired
	RepRepo repo;
	
	@Autowired
	ModelMapper mapper;


	@Override
	public List<RepDTO> getAllRep() {
		// TODO Auto-generated method stub
		List<Rep> findAll = repo.findAll();
		List<RepDTO> collect=findAll.stream().map(rep->this.mapper.map(rep, RepDTO.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public RepDTO getRepById(Long id) {
		// TODO Auto-generated method stub
		
		if(repo.existsById(id))
		{
			Rep rep = repo.findById(id).get();
			return this.mapper.map(rep, RepDTO.class);
		}
		else
			throw new ResourceNotFoundException("Receptionist", "ReceptionistId", id);
	}

	@Override
	public RepDTO saveRep(Rep rep) {
		// TODO Auto-generated method stub
		Rep save = repo.save(rep);
		return this.mapper.map(save, RepDTO.class);
	}

	@Override
	public RepDTO updateRep(Long id, Rep rep) {
		// TODO Auto-generated method stub
		if(repo.existsById(id))
		{
			Rep save = repo.save(rep);
		    return this.mapper.map(save, RepDTO.class);
		}
		else
			throw new ResourceNotFoundException("Receptionist", "ReceptionistId", id);
	}

	@Override
	public void deleteRep(Long id) {
		// TODO Auto-generated method stub
		if(repo.existsById(id))
		{
			repo.deleteById(id);
		}
		else
			throw new ResourceNotFoundException("Receptionist", "ReceptionistId", id);
		
	}

}
