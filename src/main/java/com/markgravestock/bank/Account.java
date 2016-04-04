package com.markgravestock.bank;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private Money balance = Money.of(CurrencyUnit.GBP, BigDecimal.ZERO);
    private List<DepositTransaction> transactions = new ArrayList<>();

    public void deposit(Money amountToDeposit, LocalDate date) {
        transactions.add(new DepositTransaction(date, amountToDeposit));
    }

    public void reportTo(Statement statement) {
        transactions.forEach(transaction -> {
            balance = transaction.applyTo(balance);
            statement.report(transaction, balance);
        });
    }
}
