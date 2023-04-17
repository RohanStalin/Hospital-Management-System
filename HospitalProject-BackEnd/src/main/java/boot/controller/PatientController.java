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

import boot.dto.PatientDTO;
import boot.entity.Patient;
import boot.service.PatientService;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "*")
public class PatientController {
	
	@Autowired
	private PatientService service;
	
	  @GetMapping("/getpatients")
	    public ResponseEntity<List<PatientDTO>> getAllDoctors() {
	        return new ResponseEntity<List<PatientDTO>>(service.getAllPatient(),HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<PatientDTO> getDoctorById(@PathVariable("id") Long id) {
	        return new ResponseEntity<PatientDTO>(service.getPatientById(id),HttpStatus.OK) ;
	    }

	    @PostMapping("/save")
	    public ResponseEntity<PatientDTO> createDoctor(@RequestBody Patient patient) {
	        return new ResponseEntity<PatientDTO>(service.savePatient(patient), HttpStatus.ACCEPTED) ;
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<PatientDTO> updateDoctor(@PathVariable("id") Long id,@RequestBody Patient doctorDetails) {
	       return new ResponseEntity<PatientDTO>(service.updatePatient(id, doctorDetails), HttpStatus.OK) ;
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Map<String, String>> deleteDoctor(@PathVariable("id") Long id) {
	    	service.deletePatient(id);
	    	 Map<String, String> responseMap = new HashMap<>();
	         responseMap.put("message", String.format("Data deleted Successfully with ID::%s",id));
	         
	         return ResponseEntity.ok(responseMap);	    }

}
