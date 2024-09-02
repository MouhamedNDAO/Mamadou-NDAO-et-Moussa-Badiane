package sn.kacheo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import sn.kacheo.Modele.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	Page<Transaction> findByAccountId(Long accountId, Pageable pageable);

}
