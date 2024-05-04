package ma.enset.patientmvc;

import ma.enset.patientmvc.entities.Patient;
import ma.enset.patientmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.util.Date;
//@Import(SecurityConfig.class)

@SpringBootApplication
public class PatientMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientMvcApplication.class, args);
	}

//	@Bean
       CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
		return args -> {
			patientRepository.save(new Patient(null, "Khalid", new Date(), false, 4));
			patientRepository.save(new Patient(null, "Omar", new Date(), false, 5));
			patientRepository.save(new Patient(null, "Salma", new Date(), false, 3));
			patientRepository.save(new Patient(null, "Younes", new Date(), false, 12));


		};


	}




}
