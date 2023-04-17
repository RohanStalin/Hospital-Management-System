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

import boot.dto.DoctorDTO;
import boot.entity.Doctor;
import boot.service.DoctorService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/getdoctors")
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        return new ResponseEntity<List<DoctorDTO>>(doctorService.getAllDoctors(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable("id") Long id) {
        return new ResponseEntity<DoctorDTO>(doctorService.getDoctorById(id),HttpStatus.OK) ;
    }

    @PostMapping("/save")
    public ResponseEntity<DoctorDTO> createDoctor(@RequestBody Doctor doctor) {
        return new ResponseEntity<DoctorDTO>(doctorService.saveDoctor(doctor), HttpStatus.ACCEPTED) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable("id") Long id,@RequestBody Doctor doctorDetails) {
       return new ResponseEntity<DoctorDTO>(doctorService.updateDoctor(id, doctorDetails), HttpStatus.OK) ;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteDoctor(@PathVariable("id") Long id) {
        doctorService.deleteDoctor(id);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", String.format("Data deleted Successfully with ID::%s",id));
        
        return ResponseEntity.ok(responseMap);
    }
}

