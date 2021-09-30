package com.techelevator.dao;

import com.techelevator.model.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAllAccount();

    Account getAccountById(long accountId);

    Account createAccount(Account account);

    Account getAccountByUserId(int id);
}
