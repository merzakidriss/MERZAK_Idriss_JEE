package ma.enset.hospital;

import ma.enset.hospital.entities.*;
import ma.enset.hospital.repositories.ConsultationRepository;
import ma.enset.hospital.repositories.MedecinRepository;
import ma.enset.hospital.repositories.PatientRepository;
import ma.enset.hospital.repositories.RendezVousRepository;
import ma.enset.hospital.service.IhospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {

        SpringApplication.run(HospitalApplication.class, args);
    }
    @Bean
    CommandLineRunner Start(IhospitalService hospitalService,PatientRepository patientRepository, MedecinRepository medecinRepository){

        return  args ->{
            Stream.of("ahmed","houssam","mourad")
                    .forEach(name ->{
            Patient patient=new Patient();
            patient.setDate(new Date());
            patient.setName(name);
            patient.setMalade(false);
            hospitalService.addPatient(patient);});



            Stream.of("ossama","anwar","ayoub")
                    .forEach(name ->{
                        Medecin medecin=new Medecin();
                        medecin.setNom(name);
                        medecin.setSpecialite(Math.random()>0.5?"cardio":"generaliste");
                        medecin.setEmail(name + "@gmail.com");
                        hospitalService.addMedecin(medecin);});

            Patient patient = patientRepository.findByName("ahmed");
            Medecin medecin =medecinRepository.findByNom("ossama");
            RendezVous rendezVous=new RendezVous();
            rendezVous.setId(UUID.randomUUID().toString());
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            hospitalService.addRendezVous(rendezVous);

            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRapport("it was good");
            consultation.setRendezvous(rendezVous);
            hospitalService.addConsultation(consultation);










        };



    }

}
