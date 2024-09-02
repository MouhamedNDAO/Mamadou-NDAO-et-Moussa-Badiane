package sn.kacheo.controleur;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import sn.kacheo.model.Transaction;
import sn.kacheo.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountId}/balance")
    public BigDecimal getBalance(@PathVariable Long accountId) {
        return accountService.getBalance(accountId);
    }

    @GetMapping("/{accountId}/transactions")
    public Page<Transaction> getTransactions(@PathVariable Long accountId, Pageable pageable) {
        return accountService.getTransactions(accountId, pageable);
    }

    @PostMapping("/transfer")
    public void transfer(@RequestParam Long fromAccountId,
                         @RequestParam Long toAccountId,
                         @RequestParam BigDecimal amount) {
        accountService.transfer(fromAccountId, toAccountId, amount);
    }
}