package com.mamadou.banque.Modele;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "Account")
@Getter
@Setter
@NoArgsConstructor
public class InitializerAccountModele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(name= "Nom", length = 50)
    private String nom ;
    
    @Column(name = "Prenom", length = 50)
    private String prenom;

    @Column(name = "NumeroCarte", length = 15)
    private long numeroCarte;

    @Column (name= "Solde", length = 15)
    private long solde;


}
