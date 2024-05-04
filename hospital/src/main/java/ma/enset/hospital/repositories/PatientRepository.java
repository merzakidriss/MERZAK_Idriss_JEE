package ma.enset.hospital.repositories;

import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {

 Patient findByName(String name) ;
}
