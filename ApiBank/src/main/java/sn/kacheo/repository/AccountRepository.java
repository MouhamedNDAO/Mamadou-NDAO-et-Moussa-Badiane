package sn.kacheo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.kacheo.Modele.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
