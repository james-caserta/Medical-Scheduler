package com.techelevator.dao;

import com.techelevator.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAccountDao implements AccountDao{
    private JdbcTemplate jdbcTemplate;
    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account createAccount(Account account) {
        String sql = "INSERT INTO account (account_id, first_name, last_name, email, user_id ) " +
                "VALUES (?, ?, ?, ?) RETURNING account_id;";
        Long newId = jdbcTemplate.queryForObject(sql, Long.class, account.getAccountId(),
                account.getFirstName(), account.getLastName(), account.getEmail(), account.getUserId());


        return getAccountById(newId);
    }


    @Override
    public List<Account> findAllAccount() {
        List<Account> account = new ArrayList<>();
        String sql = "SELECT account_id, first_name, last_name, email, user_id " +
                "FROM account ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Account accounts = mapRowToAccount(results);
            account.add(accounts);
        }
        return account;
    }

    @Override
    public Account getAccountById(long accountId) {
        String sql = "SELECT account_id, first_name, last_name, email, user_id " +
                " FROM account " +
                "WHERE account_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
        if(results.next()) {
            return mapRowToAccount(results);
        } else {
            throw new RuntimeException("Account: "+accountId+" was not found.");
        }
    }



// *** Account Map ***
    private Account mapRowToAccount(SqlRowSet results){
        Account account = new Account();
        account.setAccountId(results.getLong("account_id"));
        account.setFirstName(results.getString("first_name"));
        account.setLastName(results.getString("last_name"));
        account.setEmail(results.getString("email"));
        account.setUserId(results.getLong("user_id"));

        return account;
    }
}
