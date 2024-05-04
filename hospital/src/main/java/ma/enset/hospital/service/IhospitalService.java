package ma.enset.hospital.service;

import ma.enset.hospital.entities.Consultation;
import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;

public interface IhospitalService {

    Patient addPatient(Patient p);
    Medecin addMedecin(Medecin m);

    RendezVous addRendezVous(RendezVous r);

    Consultation addConsultation(Consultation c);



}
