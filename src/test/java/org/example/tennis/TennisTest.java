package org.example.tennis;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

class TennisTest {

    private final Tennis tennis = new Tennis();

    @Test
    void newTennisObjectHasScoreLoveLove() {

        assertThat(tennis.readScore()).isEqualTo("love-love");
    }

    @Test
    void afterPlayer1WinsBallScoreShouldBe15Love() {

        tennis.incrementScore("player1");

        assertThat(tennis.readScore()).isEqualTo("15-love");
    }

    @Test
    void afterPlayersHasWonOneBallEachScoreShouldBe1515() {

        tennis.incrementScore("player1");
        tennis.incrementScore("player2");

        assertThat(tennis.readScore()).isEqualTo("15-15");
    }

    @Test
    void afterPlayer1HasWonTwoBallsScoreShouldBe30love() {

        tennis.incrementScore("player1");
        tennis.incrementScore("player1");

        assertThat(tennis.readScore()).isEqualTo("30-love");
    }

    @Test
    void afterPlayer1HasWonThreeBallsScoreShouldBe40love() {

        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");

        assertThat(tennis.readScore()).isEqualTo("40-love");
    }

    @Test
    void playerThatHasWon3BallsAndWinsAnotherShouldWinTheGame() {

        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");

        assertThat(tennis.isGameOver()).isTrue();
    }

    @Test
    void whenBothPlayerHasWon3BallsPlayer1ShouldNotWinAfterOneMoreBall() {

        play40_40();
        tennis.incrementScore("player1");

        assertThat(tennis.isGameOver()).isFalse();
    }

    @Test
    void whenOnePlayerHasWon2MoreBallsThanTheOtherGameIsOver() {

        play40_40();

        tennis.incrementScore("player1");
        tennis.incrementScore("player1");

        assertThat(tennis.isGameOver()).isTrue();
    }

    @Test
    void whenBothPlayersHasScoredAtLeast3BallsAndTheyHaveSameScoreShouldBeDeuce() {

        play40_40();

        assertThat(tennis.readScore()).isEqualTo("deuce");
        assertThat(tennis.isGameOver()).isFalse();
    }

    @Test
    void whenBothPlayersHasSameScoreAndMoreThan3BallsShouldBeDeuce() {

        play40_40();
        tennis.incrementScore("player1");
        tennis.incrementScore("player2");

        assertThat(tennis.readScore()).isEqualTo("deuce");
        assertThat(tennis.isGameOver()).isFalse();
    }

    @Test
    void whenBothPlayersHasMoreThan3BallsAndPlayer1HasAnAdvantageOfOneShouldBeAdvantagePlayerName() {

        play40_40();
        tennis.incrementScore("player1");
        tennis.incrementScore("player2");
        tennis.incrementScore("player1");

        assertThat(tennis.readScore()).isEqualTo("advantage player1");
        assertThat(tennis.isGameOver()).isFalse();
    }

    @Test
    void whenBothPlayersHasMoreThan3BallsAndPlayer2HasAnAdvantageOfOneShouldBeAdvantagePlayerName() {

        play40_40();
        tennis.incrementScore("player1");
        tennis.incrementScore("player2");
        tennis.incrementScore("player2");

        assertThat(tennis.readScore()).isEqualTo("advantage player2");
        assertThat(tennis.isGameOver()).isFalse();
    }

    @Test
    void playCompleteRound() {
        assertThat(tennis.readScore()).isEqualTo("love-love");
        tennis.incrementScore("player1");
        assertThat(tennis.readScore()).isEqualTo("15-love");
        tennis.incrementScore("player1");
        assertThat(tennis.readScore()).isEqualTo("30-love");
        tennis.incrementScore("player2");
        assertThat(tennis.readScore()).isEqualTo("30-15");
        tennis.incrementScore("player1");
        assertThat(tennis.readScore()).isEqualTo("40-15");
        tennis.incrementScore("player2");
        assertThat(tennis.readScore()).isEqualTo("40-30");
        tennis.incrementScore("player2");
        assertThat(tennis.readScore()).isEqualTo("deuce");
        tennis.incrementScore("player1");
        assertThat(tennis.readScore()).isEqualTo("advantage player1");
        assertThat(tennis.isGameOver()).isFalse();
        tennis.incrementScore("player2");
        assertThat(tennis.readScore()).isEqualTo("deuce");
        tennis.incrementScore("player2");
        assertThat(tennis.readScore()).isEqualTo("advantage player2");
        tennis.incrementScore("player2");
        assertThat(tennis.isGameOver()).isTrue();
        assertThat(tennis.readScore()).isEqualTo("winner player2");
    }

    @Test
    void callingIncrementScoreWhenGameIsOverThrowsException() {
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");

        assertThatThrownBy(()->tennis.incrementScore("player1"))
                .isInstanceOf(IllegalStateException.class);
    }



    private void play40_40() {
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player2");
        tennis.incrementScore("player2");
        tennis.incrementScore("player2");
    }




}
