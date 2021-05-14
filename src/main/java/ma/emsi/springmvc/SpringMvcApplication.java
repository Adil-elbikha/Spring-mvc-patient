package ma.emsi.springmvc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.emsi.springmvc.dao.PatientRepository;
import ma.emsi.springmvc.entities.Patient;

@SpringBootApplication
public class SpringMvcApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null, "ahmed", new Date(), false));
		patientRepository.save(new Patient(null, "ali", new Date(), false));
		patientRepository.save(new Patient(null, "adil", new Date(), false));
		patientRepository.save(new Patient(null, "youssef", new Date(), false));
		patientRepository.save(new Patient(null, "ahmed", new Date(), false));
		patientRepository.save(new Patient(null, "ahmed", new Date(), false));
		patientRepository.save(new Patient(null, "ali", new Date(), false));
		patientRepository.save(new Patient(null, "adil", new Date(), false));
		patientRepository.save(new Patient(null, "youssef", new Date(), false));
		patientRepository.save(new Patient(null, "ahmed", new Date(), false));
	
		
		patientRepository.findAll().forEach(p->{
			System.out.println(p.getName());
		});
		
	}

}
