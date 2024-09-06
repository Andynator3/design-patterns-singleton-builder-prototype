package com.excellCodin.repository;

import com.excellCodin.model.AccountStatus;
import com.excellCodin.model.AccountType;
import com.excellCodin.model.BankAccount;
import com.excellCodin.model.BankDirector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


public class AccountRepositoryImpl implements AccountRepository {
    private Map<Long, BankAccount> bankAccountMap=new HashMap<>();
    private long accountsCount=0;
    @Override
    public BankAccount save(BankAccount bankAccount) {
        Long accountId=++accountsCount;
        bankAccount.setAccountId(accountId);
        bankAccountMap.put(accountId, bankAccount);
        return bankAccount;
    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccountMap.values().stream().collect(toList());
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        BankAccount account=bankAccountMap.get(id);
        if (account==null)
            return Optional.empty();
        else
            return Optional.of(account);
    }

    @Override
    public List<Object> searchAccounts(Predicate<BankAccount> predicate) {
        return bankAccountMap.values().stream().filter(predicate).collect(toList());
    }

    @Override
    public BankAccount update(BankAccount account) {
        bankAccountMap.put(account.getAccountId(), account);
        return account;
    }

    @Override
    public void deleteById(Long id) {
        bankAccountMap.remove(id);
    }
    public void populateData(){
        for (int i = 0; i <10; i++) {
            BankAccount account= BankDirector.accountBuilder()
                    .balance(5000.0+Math.random()*90000)
                    .type(Math.random()>0.5 ? AccountType.SAVING_ACCOUNT : AccountType.CURRENT_ACCOUNT)
                    .status(Math.random()>0.5 ? AccountStatus.CREATED : AccountStatus.ACTIVATED)
                    .currency(Math.random()>0.5 ? "EURO" : "USD")
                    .build();
            save(account);

        }
    }

}
