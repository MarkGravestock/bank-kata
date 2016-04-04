package com.markgravestock.bank;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StatementTest {

    private Statement sut;

    @Before
    public void setUp() throws Exception {
        sut = new Statement();
    }

    @Test
    public void a_statement_has_a_line_for_each_reported_transaction() throws Exception {
        sut.report(new DepositTransaction(LocalDate.of(2012, Month.DECEMBER, 12), Money.of(CurrencyUnit.GBP, BigDecimal.valueOf(200L))), Money.of(CurrencyUnit.GBP, BigDecimal.valueOf(200L)));

        assertThat(sut.asString(), containsString("| 12/12/12 | GBP 200.00 CR | GBP 200.00 CR |"));

    }
}