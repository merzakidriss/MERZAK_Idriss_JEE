package ma.enset.hospital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.Date;



@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {

    @Id
    private String id ;
    private Date date ;
    @Enumerated(EnumType.STRING)
    private  StatusRDV status ;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private  Patient patient ;
    @ManyToOne
    private Medecin medecin ;
    @OneToOne(mappedBy = "rendezvous")
    private Consultation consultation;






}
