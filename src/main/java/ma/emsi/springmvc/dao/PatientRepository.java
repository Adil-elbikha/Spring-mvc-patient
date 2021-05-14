package ma.emsi.springmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.springmvc.entities.Patient;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;


public interface PatientRepository extends JpaRepository<Patient, Long> {

	public Page<Patient> findByNameContains(String mc,Pageable pageable);
}
