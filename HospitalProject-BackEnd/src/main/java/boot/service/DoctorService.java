package boot.service;

import java.util.List;

import boot.dto.DoctorDTO;
import boot.entity.Doctor;

public interface DoctorService {
    List<DoctorDTO> getAllDoctors();
    DoctorDTO getDoctorById(Long id);
    DoctorDTO saveDoctor(Doctor doctor);
    DoctorDTO updateDoctor(Long id,Doctor doctor);
    void deleteDoctor(Long id);
}

