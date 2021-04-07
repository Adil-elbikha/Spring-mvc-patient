package ma.emsi.springmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.springmvc.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
