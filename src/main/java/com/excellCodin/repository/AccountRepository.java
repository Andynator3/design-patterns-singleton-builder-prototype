package com.excellCodin.repository;

import com.excellCodin.model.BankAccount;


import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


public interface AccountRepository {
    BankAccount save(BankAccount bankAccount);
    List<BankAccount> findAll();
    Optional<BankAccount>findById(Long accountId);
    List<Object> searchAccounts(Predicate<BankAccount> predicate);
    BankAccount update(BankAccount account);
    void deleteById(Long accountId);
}
