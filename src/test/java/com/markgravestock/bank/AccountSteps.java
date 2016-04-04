package com.markgravestock.bank;

import org.jbehave.core.annotations.*;
import org.joda.money.Money;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AccountSteps {
    private Statement statement;
    private Account sut;

    @BeforeScenario
    public void scenarioSetup() {
        statement = new Statement();
        sut = new Account();
    }


    @Given("a customer deposits $money on $date")
    public void maekeDeposit(Money deposit, LocalDate date) {
        sut.deposit(deposit, date);
    }

    @When("they print their statement")
    public void printStatement() {
        sut.reportTo(statement);
    }

    @Then("they would see $statement")
    public void theirStatementShouldBe(String expectedStatement) {
        assertThat(statement.asString(), equalTo(expectedStatement));
    }

    @AsParameterConverter
    public Money createMoney(String moneyString) {
        return Money.parse(moneyString);
    }

    @AsParameterConverter
    public LocalDate createLocalDate(String localDate) {
        return LocalDate.parse(localDate, DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
    }

}
