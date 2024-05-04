package ma.enset.hospital.service;

import jakarta.transaction.Transactional;
import ma.enset.hospital.entities.Consultation;
import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;
import ma.enset.hospital.repositories.ConsultationRepository;
import ma.enset.hospital.repositories.MedecinRepository;
import ma.enset.hospital.repositories.PatientRepository;
import ma.enset.hospital.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service @Transactional
public class hospitalServiceImpl implements IhospitalService {

    @Autowired
     PatientRepository patientRepository;
    @Autowired
    MedecinRepository   medecinRepository;
    @Autowired
    RendezVousRepository renderVousRepository;
    @Autowired
    ConsultationRepository consultationRepository;



    public hospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository renderVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.renderVousRepository = renderVousRepository;
        this.consultationRepository = consultationRepository;
    }





    @Override
    public Patient addPatient(Patient p) {
        return patientRepository.save(p);
    }

    @Override
    public Medecin addMedecin(Medecin m) {

        return medecinRepository.save(m);
    }

    @Override
    public RendezVous addRendezVous(RendezVous r) {

        return renderVousRepository.save(r);
    }

    @Override
    public Consultation addConsultation(Consultation c) {

        return consultationRepository.save(c);
    }
}
