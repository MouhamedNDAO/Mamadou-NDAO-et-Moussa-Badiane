package sn.kacheo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.kacheo.Modele.InitializerAccountModele;
import sn.kacheo.service.InitializerAccountService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/Initializer/Account")
public class InitializerAccountController {
    
    private final InitializerAccountService accountService;

    @PostMapping("/create")
    public InitializerAccountModele creer(@RequestBody InitializerAccountModele account) {
        return accountService.creer(account);
    }

    @GetMapping("/lire")
    public List<InitializerAccountModele> lire() {
        return accountService.lire();
    }


    @PutMapping("/update")
    public InitializerAccountModele modifier(@PathVariable long id,@RequestBody InitializerAccountModele account) {
        return accountService.modifier(id, account);
    }

    @DeleteMapping("/delete")
    public void supprimer(@PathVariable long id){
        accountService.supprimer(id);
    }
}
