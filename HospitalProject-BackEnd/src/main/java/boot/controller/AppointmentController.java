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

import boot.dto.AppointmentDTO;
import boot.entity.Appointment;
import boot.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {
    
    @Autowired
    private 
    AppointmentService service;
    
    @PostMapping("/save")
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody Appointment appointment) {
        return new ResponseEntity<AppointmentDTO>(service.saveAppointment(appointment), HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable("id") Long id, @RequestBody Appointment appointment) 
    {
    	return new ResponseEntity<AppointmentDTO>(service.updateAppointment(id, appointment),HttpStatus.OK );
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteAppointment(@PathVariable("id") Long id) {
       service.deleteAppointment(id);
       Map<String, String> responseMap = new HashMap<>();
       responseMap.put("message", String.format("Data deleted Successfully with ID::%s",id));
       
       return ResponseEntity.ok(responseMap);    }
    
    @GetMapping("/getappointments")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByPatientId() {
        return new ResponseEntity<List<AppointmentDTO>>(service.getAllAppointment(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentsByDoctorId(@PathVariable("id") Long Id) {
    	
    	AppointmentDTO appointmentDTO=service.getAppointmentById(Id);
        return new ResponseEntity<AppointmentDTO>(appointmentDTO,HttpStatus.OK);
    }    
}

