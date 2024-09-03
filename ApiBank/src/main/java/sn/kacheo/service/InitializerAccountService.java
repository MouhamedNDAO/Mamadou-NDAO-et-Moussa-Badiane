package sn.kacheo.service;

import java.util.List;

import sn.kacheo.Modele.InitializerAccountModele;

public interface InitializerAccountService {
 InitializerAccountModele creer(InitializerAccountModele account);

 List<InitializerAccountModele> lire();


 InitializerAccountModele modifier(long id, InitializerAccountModele account);

 void supprimer(long id);


    
}
