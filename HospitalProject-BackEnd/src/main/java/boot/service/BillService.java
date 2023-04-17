package boot.service;

import java.util.List;

import boot.dto.BillDTO;
import boot.entity.Bill;
import boot.service.imp.BillServiceImpl;

public interface BillService {

	 public BillDTO generateBill(Bill bill);
	 
	 public List<BillDTO> getBills();
	 public BillDTO getBillById(Long id);
	 public BillDTO updateBill(long id,Bill bill);
	 public void deleteBill(long id);
}
