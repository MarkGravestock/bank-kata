package com.markgravestock.bank;

import org.joda.money.Money;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Statement {

    private static final String REPORT_HEADER = "| Date | Transaction | Balance |";

    private StringBuilder builder;

    public Statement() {
        builder = new StringBuilder(REPORT_HEADER);
    }

    public String asString() {
        return builder.toString();
    }

    public void report(DepositTransaction transaction, Money balance) {
        builder.append(System.lineSeparator());
        builder.append("| " + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(transaction.date) + " | " + transaction.amountToDeposit + " CR | " + balance + " CR |");
    }
}
