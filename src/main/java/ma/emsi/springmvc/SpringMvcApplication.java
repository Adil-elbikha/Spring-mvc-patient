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
		
		//patientRepository.save(new Patient(null, "adil", new Date(), true, 3));
	//	patientRepository.save(new Patient(null, "youssef", new Date(), false, 6));
		//patientRepository.save(new Patient(null, "mahmoud", new Date(), true, 8));
		//patientRepository.save(new Patient(null, "ayoub", new Date(), false, 12));
		
		patientRepository.findAll().forEach(p->{
			System.out.println(p.getName());
		});
		
	}

}
