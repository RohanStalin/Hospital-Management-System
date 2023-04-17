package boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.entity.Login;
import boot.dto.ResponseMessage;
import boot.entity.Doctor;
import boot.entity.Rep;
import java.util.Optional;
import boot.repo.DoctorRepository;
import boot.repo.RepRepo;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class AuthController {

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private RepRepo receptionistRepository;

	@PostMapping("/authenticate")
	public ResponseEntity<ResponseMessage> authenticate(@RequestBody Login login) {
		String email = login.getEMail();
		String password = login.getPassword();
		String userType = login.getUserType();

		if ("doctor".equals(userType)) {
			Optional<Doctor> doctorOptional = doctorRepository.findByEmailAndPassword(email, password);
			if (doctorOptional.isPresent()) {
				return ResponseEntity.ok(new ResponseMessage("Authentication successful","doctor"));
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseMessage("Invalid email or password","doctor"));
			}
		} else if ("receptionist".equals(userType)) {
			Optional<Rep> receptionistOptional = receptionistRepository.findByEmailAndPassword(email, password);
			if (receptionistOptional.isPresent()) {
				return ResponseEntity.ok(new ResponseMessage("Authentication successful","receptionist"));
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseMessage("Invalid email or password","receptionist"));
			}
		} else if ("admin".equals(userType)) {
			if ((email.equals("RohanStalin"))&&(password.equals("Rohan@123"))) {
				return ResponseEntity.ok(new ResponseMessage("Authentication successful","admin"));
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseMessage("Invalid email or password","admin"));
			}
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid UserType","Invalid role"));
		}
	}
}
