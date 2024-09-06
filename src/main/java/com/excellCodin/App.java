package com.excellCodin;

import com.excellCodin.model.AccountStatus;
import com.excellCodin.model.AccountType;
import com.excellCodin.model.BankAccount;
import com.excellCodin.model.BankDirector;
import com.excellCodin.repository.AccountRepositoryImpl;
import com.excellCodin.utils.JsonSerializer;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        JsonSerializer<BankAccount> bankAccountJsonSerializer=new JsonSerializer<>();
        AccountRepositoryImpl accountRepository= new AccountRepositoryImpl();
        accountRepository.populateData();
        List<BankAccount> bankAccounts = accountRepository.findAll();
        bankAccounts.stream()
                .map(bankAccountJsonSerializer::toJson)
                //.map(acc->bankAccountJsonSerializer.toJson(acc))
                .forEach(System.out::println);
        //bankAccounts.forEach(System.out::println);

        System.out.println("=================");
        BankAccount account = accountRepository.findById(1L).orElse(null);
        if (account!=null) {
            System.out.println(bankAccountJsonSerializer.toJson(account));
        }

        /*BankAccount account3=new BankAccount(3L,500,"EURO",AccountType.SAVING_ACCOUNT,AccountStatus.CREATED);
        System.out.println(account3);*/

        /*BankAccount account2=new BankAccount();
        account2.setAccountId(2L);
        account2.setBalance(600);
        account2.setCurrency("EURO");
        account2.setType(AccountType.SAVING_ACCOUNT);
        account2.setStatus(AccountStatus.CREATED);
        System.out.println(account2);*/

        /*BankAccount account1= BankDirector.accountBuilder()
                .accountId(1L)
                .currency("EURO")
                .status(AccountStatus.CREATED)
                .type(AccountType.SAVING_ACCOUNT)
                .balance(700.0)
                .build();
        System.out.println(account1.toString());*/

        /*BankAccount bankAccount= BankAccount.builder()
                .accountId(1L)
                .currency("EURO")
                .status(AccountStatus.CREATED)
                .type(AccountType.SAVING_ACCOUNT)
                .balance(700.0)
                .build();
        System.out.println(bankAccount.toString());*/
    }
}
