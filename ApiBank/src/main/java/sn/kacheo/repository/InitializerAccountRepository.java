package sn.kacheo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.kacheo.Modele.InitializerAccountModele;

public interface InitializerAccountRepository extends JpaRepository<InitializerAccountModele, Long> {

    
}
