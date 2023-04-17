package boot.service;

import java.util.List;

import boot.dto.RepDTO;
import boot.entity.Patient;
import boot.entity.Rep;

public interface RepService {

	List<RepDTO> getAllRep();
	RepDTO getRepById(Long id);
	RepDTO saveRep(Rep rep);
	RepDTO updateRep(Long id,Rep rep);
	 void deleteRep(Long id);
}
