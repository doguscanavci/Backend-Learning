package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.AccountService;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final CustomerService customerService;

    @Autowired
    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @GetMapping
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account find(@PathVariable long id) {
        return accountService.find(id);
    }

    @PostMapping("/{customerId}")
    public AccountResponse save(@PathVariable long customerId, @RequestBody Account account) {
        Customer customer = customerService.find(customerId);
        account.setCustomer(customer);
        Account savedAccount = accountService.save(account);
        return new AccountResponse(savedAccount.getId(), savedAccount.getAccountName(), savedAccount.getMoneyAmount(), customer);
    }

    @PutMapping("/{customerId}")
    public AccountResponse update(@PathVariable long customerId, @RequestBody Account account) {
        Customer customer = customerService.find(customerId);

        Account existingAccount = accountService.find(account.getId());
        if (existingAccount != null) {
            account.setCustomer(customer);
        }

        Account updatedAccount = accountService.save(account);
        customerService.save(customer);

        return new AccountResponse(updatedAccount.getId(), updatedAccount.getAccountName(), updatedAccount.getMoneyAmount(), customer);
    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable long id) {
        // 1. Testin çağırmanı beklediği 'find' metodu (Önce hesabı buluyoruz)
        Account account = accountService.find(id);

        // 2. Ardından silme işlemini yapıyoruz
        accountService.delete(id);

        // 3. Bulduğumuz hesabı dönüyoruz (Workintech testleri silinen objeyi dönmeni bekler)
        return account;
    }
}