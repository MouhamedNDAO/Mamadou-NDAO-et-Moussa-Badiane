package com.mamadou.banque.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mamadou.banque.Modele.InitializerAccountModele;
import com.mamadou.banque.Repository.InitializerAccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InitializerAccountServiceImpl implements InitializerAccountService{

    private final InitializerAccountRepository accountRepository;

    @Override
    public InitializerAccountModele creer(InitializerAccountModele account) {  
      return accountRepository.save(account);
    }

    @Override
    public List<InitializerAccountModele> lire() {
        return accountRepository.findAll();
    }

    @Override
    public InitializerAccountModele modifier(long id, InitializerAccountModele account) {
        return accountRepository.findById(id).map(p->{
            p.setId(account.getId());
            p.setNom(account.getNom());
            p.setNumeroCarte(account.getNumeroCarte());
            p.setPrenom(account.getPrenom());
            p.setSolde(account.getSolde());
            return accountRepository.save(p);
        }).orElseThrow(()-> new RuntimeException("Compte non trouve"));
    }

    @Override
    public void supprimer(long id) {
         accountRepository.deleteById(id);
    }

}
