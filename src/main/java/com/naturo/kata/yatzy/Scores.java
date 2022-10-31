package com.naturo.kata.yatzy;

import java.util.List;

/**
 * 
 * @author NTH
 *
 */
public class Scores {

	private Scores() {
		
	}
	/**
	 * Get number of occurrence of dice with 1 spot
	 * @param dice dice rolled
	 * @return occurrences sum result
	 */
	public static int ones(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(1);
	}

	/**
	 * Get number of occurrence of dice with 2 spots
	 * @param dice dice rolled
	 * @return occurrences sum result
	 */
	public static int twos(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(2);
	}
	
	/**
	 * Get number of occurrence of dice with 3 spots
	 * @param dice dice rolled
	 * @return occurrences sum result
	 */
	public static int threes(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(3);
	}
	
	/**
	 * Get number of occurrence of dice with 4 spots
	 * @param dice dice rolled
	 * @return occurrences sum result
	 */
	public static int fours(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(4);
	}
	
	/**
	 * Get number of occurrence of dice with 5 spots
	 * @param dice dice rolled
	 * @return occurrences sum result
	 */
	public static int fives(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(5);
	}
	
	/**
	 * Get number of occurrence of dice with 6 spots
	 * @param dice dice rolled
	 * @return occurrences sum result
	 */
	public static int sixs(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(6);
	}
	
	/**
	 * Sum of all dices result
	 * @param dice dice rolled
	 * @return sum of all dices results
	 */
	public static int sumAllDicesRolledResult(DiceRoll dice)
	{
		return dice.sum();
	}
	
	/**
	 * Get Yatzy score. Yatzy: all five dice with the same number
	 * @param dice dice rolled
	 * @return score when all five dice with the same number
	 */
	public static int yatzyScore(DiceRoll dice)
	{
		return dice.isYatzy() ? 50 : 0;
	}
	
	/**
	 * Get sum of any dice having same spot number
	 * @param dice dice rolled
	 * @param occurrence number of occurrence rolling for one dice result
	 * @return sum of those dices
	 */
	public static int getDiceResultOfAkind(DiceRoll dice, int occurrence)
	{
		int index =  dice.getOccurenceOfKind(occurrence);
		
		return index != -1 ? (index) * occurrence : 0;
	}
	
	/**
	 * Get score of small straight. Small straight : any four dice in ascending order.
	 * @param dice dice rolled
	 * @return small straight score
	 */
	public static int scoreOfSmallStraight(DiceRoll dice)
	{
		return dice.isSmallStraight() ? 15 : 0;
	}
	
	/**
	 * Get score of large straight. Large straight: any five dice in ascending order.
	 * @param dice dice rolled
	 * @return large straight score
	 */
	public static int scoreOfLargeStraight(DiceRoll dice)
	{
		return dice.isLargeStraight() ? 20 : 0;
	}
	
	/**
	 * Get Two Pair i.e Two different pairs of dice
	 * @param dice dice rolled
	 * @return score of two different pairs of dice
	 */
	public static int twoPair(DiceRoll dice)
	{
		List<Integer>dicesResult = dice.findApair();
		return dicesResult.stream().count() == 2 ? dicesResult.get(0) * 2 + dicesResult.get(1) * 2 : 0;
	}
	
	/**
	 * Get One Pair i.e Two dice showing the same number.
	 * @param dice dice rolled
	 * @return score of those two dice
	 */
	public static int onePair(DiceRoll dice)
	{
		List<Integer>dicesResult = dice.findApair();
		return dicesResult.stream().count() >= 1 ? dicesResult.get(0) * 2 : 0;
	}
	
	/**
	 * Get Full House i.e Any set of three combined with a different pair.
	 * @param dice dice rolled
	 * @return sum of all dice
	 */
	public static int fullHouse(DiceRoll dice)
	{
		return dice.isFullHouse() ? dice.sum(): 0;
	}
}
