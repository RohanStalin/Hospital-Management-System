package boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.dto.RepDTO;
import boot.entity.Patient;
import boot.entity.Rep;
import boot.service.PatientService;
import boot.service.RepService;

@RestController
@RequestMapping("/reps")
@CrossOrigin(origins = "*")
public class RepController {

	@Autowired
	private RepService service;
	
	  @GetMapping("/getreps")
	    public ResponseEntity<List<RepDTO>> getAllDoctors() {
	        return new ResponseEntity<List<RepDTO>>(service.getAllRep(),HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<RepDTO> getDoctorById(@PathVariable("id") Long id) {
	        return new ResponseEntity<RepDTO>(service.getRepById(id),HttpStatus.OK) ;
	    }

	    @PostMapping("/save")
	    public ResponseEntity<RepDTO> createDoctor(@RequestBody Rep rep) {
	        return new ResponseEntity<RepDTO>(service.saveRep(rep), HttpStatus.ACCEPTED) ;
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<RepDTO> updateDoctor(@PathVariable("id") Long id,@RequestBody Rep doctorDetails) {
	       return new ResponseEntity<RepDTO>(service.updateRep(id, doctorDetails), HttpStatus.OK) ;
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Map<String, String>> deleteDoctor(@PathVariable("id") Long id) {
	    	service.deleteRep(id);
	    	Map<String, String> responseMap = new HashMap<>();
	         responseMap.put("message", String.format("Data deleted Successfully with ID::%s",id));
	         
	         return ResponseEntity.ok(responseMap);	
	         }
}
