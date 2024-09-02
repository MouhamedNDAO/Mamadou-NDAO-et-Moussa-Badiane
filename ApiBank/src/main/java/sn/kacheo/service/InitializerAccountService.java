package com.mamadou.banque.Service;

import java.util.List;

import com.mamadou.banque.Modele.InitializerAccountModele;

public interface InitializerAccountService {
 InitializerAccountModele creer(InitializerAccountModele account);

 List<InitializerAccountModele> lire();


 InitializerAccountModele modifier(long id, InitializerAccountModele account);

 void supprimer(long id);


    
}
