package com.markgravestock.bank;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.joda.money.Money;

import java.time.LocalDate;
import java.util.Date;

public class DepositTransaction {
    public final LocalDate date;
    public final Money amountToDeposit;

    public DepositTransaction(LocalDate date, Money amountToDeposit) {
        this.date = date;
        this.amountToDeposit = amountToDeposit;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, false);
    }

    public Money applyTo(Money balance) {
        return balance.plus(amountToDeposit);
    }
}
