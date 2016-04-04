package com.markgravestock.bank;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountTest {

    private Account sut;
    private Statement statement;

    @Before
    public void setUp() throws Exception {
        sut = new Account();
        statement = mock(Statement.class);

        sut.deposit(Money.of(CurrencyUnit.GBP, BigDecimal.TEN), null);
    }

    @Test
    public void when_there_is_deposit_in_a_new_account_it_is_added_to_the_transactions_reported() {

        sut.reportTo(statement);

        verify(statement).report(eq(new DepositTransaction(null, Money.of(CurrencyUnit.GBP, BigDecimal.TEN))), any(Money.class));
    }

    @Test
    public void when_there_is_deposit_in_a_new_account_the_balance_is_reported() {

        sut.reportTo(statement);

        verify(statement).report(any(DepositTransaction.class), eq(Money.of(CurrencyUnit.GBP, BigDecimal.TEN)));
    }

    @Test
    public void when_there_is_another_deposit_in_a_new_account_the_running_balance_is_reported() {

        sut.deposit(Money.of(CurrencyUnit.GBP, BigDecimal.ONE), null);

        sut.reportTo(statement);

        verify(statement).report(any(DepositTransaction.class), eq(Money.of(CurrencyUnit.GBP, BigDecimal.TEN)));
        verify(statement).report(any(DepositTransaction.class), eq(Money.of(CurrencyUnit.GBP, BigDecimal.valueOf(11L))));
    }

}