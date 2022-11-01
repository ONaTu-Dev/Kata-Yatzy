package com.naturo.kata.yatzy;
import org.junit.*;

import static org.junit.Assert.*;

public class ScoresTest {

	    @Test
	    public void testSumOfAllDice() {
	        assertEquals(15, Scores.chance(new DiceRoll(2,3,4,5,1)));
	        assertEquals(16, Scores.chance(new DiceRoll(3,3,4,5,1)));
	    }

	    @Test public void testOnes() {
	        assertTrue(Scores.ones(new DiceRoll(1,2,3,4,5)) == 1);
	        assertEquals(2, Scores.ones(new DiceRoll(1,2,1,4,5)));
	        assertEquals(0, Scores.ones(new DiceRoll(6,2,2,4,5)));
	        assertEquals(4, Scores.ones(new DiceRoll(1,2,1,1,1)));
	    }

	    @Test
	    public void testTwos() {
	        assertEquals(4, Scores.twos(new DiceRoll(1,2,3,2,6)));
	        assertEquals(10, Scores.twos(new DiceRoll(2,2,2,2,2)));
	    }

	    @Test
	    public void testThrees() {
	        assertEquals(6, Scores.threes(new DiceRoll(1,2,3,2,3)));
	        assertEquals(12, Scores.threes(new DiceRoll(2,3,3,3,3)));
	    }

	    @Test
	    public void testFours() 
	    {
	        assertEquals(12, Scores.fours(new DiceRoll(4,4,4,5,5)));
	        assertEquals(8, Scores.fours(new DiceRoll(4,4,5,5,5)));
	        assertEquals(4, Scores.fours(new DiceRoll(4,5,5,5,5)));
	    }

	    @Test
	    public void testFives() {
	        assertEquals(10, Scores.fives(new DiceRoll(4,4,4,5,5)));
	        assertEquals(15, Scores.fives(new DiceRoll(4,4,5,5,5)));
	        assertEquals(20, Scores.fives(new DiceRoll(4,5,5,5,5)));
	    }

	    @Test
	    public void testSixs() {
	        assertEquals(0, Scores.sixs(new DiceRoll(4,4,4,5,5)));
	        assertEquals(6, Scores.sixs(new DiceRoll(4,4,6,5,5)));
	        assertEquals(18, Scores.sixs(new DiceRoll(6,5,6,6,5)));
	    }

	    @Test public void testYatzyScores50() {
	        assertEquals(50, Scores.yatzyScore(new DiceRoll(4,4,4,4,4)));
	        assertEquals(50, Scores.yatzyScore(new DiceRoll(6,6,6,6,6)));
	        assertEquals(0, Scores.yatzyScore(new DiceRoll(6,6,3,5,6)));
	    }

	    @Test
	    public void testFourOfKind() {
	        assertEquals(12, Scores.getFourOfAKind(new DiceRoll(3,3,3,3,5)));
	        assertEquals(20, Scores.getFourOfAKind(new DiceRoll(5,5,5,4,5)));
	        assertEquals(12, Scores.getFourOfAKind(new DiceRoll(3,3,3,3,3)));
	    }
	    
	    @Test
	    public void testThreeOfKind() {
	        assertEquals(9, Scores.getThreeOfAKind(new DiceRoll(3,3,3,4,5)));
	        assertEquals(15, Scores.getThreeOfAKind(new DiceRoll(5,3,5,4,5)));
	        assertEquals(9, Scores.getThreeOfAKind(new DiceRoll(3,3,3,3,5)));
	    }
	    
	    @Test
	    public void testOnePair() {
	        assertEquals(6, Scores.onePair(new DiceRoll(3,4,3,5,6)));
	        assertEquals(10, Scores.onePair(new DiceRoll(5,3,3,3,5)));
	        assertEquals(12, Scores.onePair(new DiceRoll(5,3,6,6,5)));
	    }

	    @Test
	    public void testTwoPair() {
	        assertEquals(16, Scores.twoPair(new DiceRoll(3,3,5,4,5)));
	        assertEquals(16, Scores.twoPair(new DiceRoll(3,3,5,5,5)));
	        assertEquals(12, Scores.twoPair(new DiceRoll(1,2,2,4,4)));
	        assertEquals(0, Scores.twoPair(new DiceRoll(1,2,2,4,5)));
	    }

	    @Test
	    public void testSmallStraight() {
	    	assertEquals(15, Scores.scoreOfSmallStraight(new DiceRoll(1,2,3,4,5)));
	        assertEquals(15, Scores.scoreOfSmallStraight(new DiceRoll(2,3,4,5,1)));
	        assertEquals(0, Scores.scoreOfSmallStraight(new DiceRoll(1,2,2,4,5)));
	        assertEquals(0, Scores.scoreOfSmallStraight(new DiceRoll(1,1,3,4,5)));
	    }

	    @Test
	    public void testLargeStraight() {
	        assertEquals(20, Scores.scoreOfLargeStraight(new DiceRoll(6,2,3,4,5)));
	        assertEquals(20, Scores.scoreOfLargeStraight(new DiceRoll(2,3,4,5,6)));
	        assertEquals(0, Scores.scoreOfLargeStraight(new DiceRoll(1,2,2,4,5)));
	        assertEquals(0, Scores.scoreOfLargeStraight(new DiceRoll(1,3,6,4,5)));
	        assertEquals(0, Scores.scoreOfLargeStraight(new DiceRoll(1,3,6,2,5)));
	        assertEquals(0, Scores.scoreOfLargeStraight(new DiceRoll(1,2,4,6,5)));
	    }

	    @Test
	    public void testFullHouse() {
	        assertEquals(18, Scores.fullHouse(new DiceRoll(6,2,2,2,6)));
	        assertEquals(0, Scores.fullHouse(new DiceRoll(2,3,4,5,6)));
	    }
	
}
