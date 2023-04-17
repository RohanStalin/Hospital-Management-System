package boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import boot.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long> {

}
