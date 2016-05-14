package com.softwareraftmanship.Board;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ColumnTest {

    private Column column;

    @Before
    public void setUp() throws Exception {
        column = new Column();
    }

    @Test
    public void when_a_token_is_placed_in_an_empty_column_it_occupies_the_lowest_row() {
        column.placeToken();
        assertThat(column.hasTokenAt(0), is(true));
    }

    @Test
    public void when_two_tokens_are_placed_in_column_the_third_row_is_free() {
        PlaceTokens(2);
        assertThat(column.hasTokenAt(2), is(false));
    }

    @Test
    public void when_the_seventh_token_is_placed_in_a_column_the_move_is_invalid() {
        PlaceTokens(6);
        assertThat(column.placeToken(), is(false));
    }

    private void PlaceTokens(int numberOfTokens) {
        for(int i = 0; i<numberOfTokens; i++){
            column.placeToken();
        }
    }

    @Test
    public void when_placing_a_token_in_an_empty_column_the_move_is_valid() {
        assertThat(column.placeToken(), is(true));
    }

    @Test
    public void when_three_tokens_are_token_are_placed_in_column_then_the_fourth_row_is_free() {
        PlaceTokens(3);
        assertThat(column.hasTokenAt(3), is(false));
    }

    @Test
    public void when_a_token_is_placed_in_the_second_column_then_first_column_is_empty_and_second_column_has_a_token(){
        Column first = new Column();
        Column second = new Column();
        List<Column> columns = Arrays.asList(new Column[]{first, second});

        PlaceTokenInColumn(2, columns);

        assertThat(first.hasTokenAt(0), is(false));
        assertThat(second.hasTokenAt(0), is(true));
    }

    @Test
    public void when_a_token_is_placed_in_the_third_column_then_first_and_second_are_empty(){
        Column first = new Column();
        Column second = new Column();
        Column third = new Column();
        List<Column> columns = Arrays.asList(new Column[]{first, second, third});

        PlaceTokenInColumn(3, columns);

        assertThat(first.hasTokenAt(0), is(false));
        assertThat(second.hasTokenAt(0), is(false));
        assertThat(third.hasTokenAt(0), is(true));

    }

    private void PlaceTokenInColumn(int index, List<Column> columns) {
        columns.get(index-1).placeToken();
    }



}
