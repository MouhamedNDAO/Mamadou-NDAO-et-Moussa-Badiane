package com.mamadou.banque.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mamadou.banque.Modele.InitializerAccountModele;

public interface InitializerAccountRepository extends JpaRepository<InitializerAccountModele, Long> {

    
}
