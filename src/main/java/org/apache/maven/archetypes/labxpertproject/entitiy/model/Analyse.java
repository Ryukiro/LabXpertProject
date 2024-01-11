package org.apache.maven.archetypes.labxpertproject.entitiy.model;

import lombok.Data;
import org.apache.maven.archetypes.labxpertproject.entitiy.enums.StatutDanalyse;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "analyseData")
public class Analyse {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "your_sequence_name")
    @SequenceGenerator(name = "your_sequence_name", sequenceName = "your_sequence_name", allocationSize = 1)
    private Long analyseId;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @Column(name = "DateDebutAnalyse")
    private LocalDate dateDebutAnalyse;

    @Column(name = "DateFinAnalyse")
    private LocalDate dateFinAnalyse;

    @OneToMany(mappedBy = "analyse")
    private List<Resultat> resultats;

    @Enumerated(EnumType.STRING)
    @Column(name = "EtatAnalyse")
    private StatutDanalyse etatAnalyse;

    @Column(name = "Commentaire")
    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "planification_id")
    private Planification planification;

    @ManyToOne
    @JoinColumn(name = "echantillon_id")
    private Echantillon echantillon;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(mappedBy = "analyse")
    private List<Reactif> reactifs;
}
