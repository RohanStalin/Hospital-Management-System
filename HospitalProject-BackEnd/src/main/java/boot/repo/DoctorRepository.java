package boot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import boot.entity.Doctor;
import jakarta.transaction.Transactional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	Optional<Doctor> findByEmailAndPassword(String email, String password);
}
