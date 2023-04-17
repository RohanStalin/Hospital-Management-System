package boot.service.imp;

import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dto.BillDTO;
import boot.entity.Bill;
import boot.entity.Patient;
import boot.exception.ResourceNotFoundException;
import boot.repo.BillRepo;
import boot.repo.PatientRepo;
import boot.service.BillService;
@Service
public class BillServiceImpl implements BillService{
	@Autowired
	BillRepo repo;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public BillDTO generateBill(Bill bill) {
		// TODO Auto-generated method stub
//		if(repo2.existsById(patientId))
//		{
//		Patient patient=repo2.findById(patientId).get();
//		}
//		else 
//			throw new ResourceNotFoundException("Patient", "PatientId",patientId) ;
		bill.setBillDate(LocalDateTime.now());
		Bill save = repo.save(bill);
		BillDTO billDTO=this.mapper.map(save, BillDTO.class);
		return billDTO;
	}

	@Override
	public List<BillDTO> getBills() {
		// TODO Auto-generated method stub
		List<Bill> findAll = repo.findAll();
		List<BillDTO> collect = findAll.stream().map(bill->this.mapper.map(bill, BillDTO.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public BillDTO getBillById(Long id) {
		// TODO Auto-generated method stub
		if(repo.existsById(id))
		{
		Bill bill = repo.findById(id).get();
		return this.mapper.map(bill, BillDTO.class);
		}
		else
			throw new ResourceNotFoundException("Bill", "BillId", id); 
	}

	@Override
	public BillDTO updateBill(long id, Bill bill) {
		// TODO Auto-generated method stub
		if(repo.existsById(id))
		{
			Bill save = repo.save(bill);
			return this.mapper.map(save, BillDTO.class);
		}
		else
			throw new ResourceNotFoundException("Bill", "BillId", id); 
	}
	

	@Override
	public void deleteBill(long id) {
		// TODO Auto-generated method stub
		if(repo.existsById(id))
		{
			repo.deleteById(id);
		}
		else
			throw new ResourceNotFoundException("Bill", "BillId", id); 
		
	}

}
