package boot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.dto.BillDTO;
import boot.entity.Bill;


import boot.service.BillService;

@RestController
@RequestMapping("/bill")
@CrossOrigin(origins = "*")
public class BillController {

  @Autowired
  BillService service;

    @PostMapping("/save")
    public ResponseEntity<BillDTO> generateBill(@RequestBody Bill bill) {
    	BillDTO generateBill = service.generateBill(bill);
    	return new ResponseEntity<BillDTO>(generateBill,HttpStatus.OK);
       
    }
    @GetMapping("/all")
    public ResponseEntity<List<BillDTO>> bills()
    {
    	List<BillDTO> bills = service.getBills();
    	return new ResponseEntity<List<BillDTO>>(bills,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BillDTO> getBill(@PathVariable("id") Long id)
    {
    	BillDTO billById = service.getBillById(id);
    	return new ResponseEntity<BillDTO>(billById,HttpStatus.OK);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<BillDTO> updateBill(@PathVariable("id") Long id, @RequestBody Bill bill) 
    {
    	return new ResponseEntity<BillDTO>(service.updateBill(id, bill),HttpStatus.OK );
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteBill(@PathVariable("id") Long id) {
        service.deleteBill(id);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", String.format("Data deleted Successfully with ID::%s",id));
        
        return ResponseEntity.ok(responseMap);
    }

//    @GetMapping("/{id}")
//    public Bill getBillById(@PathVariable Long id) {
//        return billRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Bill not found with id " + id));
//    }

    // Other methods such as updateBill() and deleteBill() can also be implemented
}

