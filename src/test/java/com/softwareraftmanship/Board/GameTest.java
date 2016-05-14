package com.softwareraftmanship.Board;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameTest {
    @Test
    public void when_there_are_four_tokens_of_the_same_column_that_colour_wins() {
        Game game = new Game();
        game.playTokenInColumn(0, Colour.Red);
        game.playTokenInColumn(0, Colour.Red);
        game.playTokenInColumn(0, Colour.Red);
        game.playTokenInColumn(0, Colour.Red);
        assertThat(game.hasWinner(Colour.Red), is(true));
    }

    @Test
    public void when_there_are_three_tokens_of_the_same_colour_in_th_same_column_that_colour_has_not_won() {
        Game game = new Game();
        game.playTokenInColumn(0, Colour.Red);
        game.playTokenInColumn(0, Colour.Red);
        game.playTokenInColumn(0, Colour.Red);

        assertThat(game.hasWinner(Colour.Red), is(false));
    }
}
