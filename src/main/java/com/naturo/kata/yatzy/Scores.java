package com.naturo.kata.yatzy;

import java.util.List;

/** Develop the scoring methods from combinations of dice roll results
 * 
 * @author HOANG Nha Thu
 * 
 *
 */
public class Scores {

	private Scores() {
		
	}
	/**
	 * The sum of all dice showing the number 1
	 * @param dice dice rolled
	 * @return occurrences sum result
	 */
	public static int ones(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(1);
	}

	/**
	 * The sum of all dice showing the number 2
	 * @param dice dice rolled
	 * @return occurrences sum result
	 */
	public static int twos(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(2);
	}
	
	/**
	 * The sum of all dice showing the number 3
	 * @param dice dice rolled
	 * @return occurrences sum result
	 */
	public static int threes(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(3);
	}
	
	/**
	 * The sum of all dice showing the number 4
	 * @param dice dice rolled
	 * @return occurrences sum result
	 */
	public static int fours(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(4);
	}
	
	/**
	 * The sum of all dice showing the number 5
	 * @param dice dice rolled
	 * @return occurrences sum result
	 */
	public static int fives(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(5);
	}
	
	/**
	 * The sum of all dice showing the number 6
	 * @param dice dice rolled
	 * @return occurrences sum result
	 */
	public static int sixs(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(6);
	}
	
	/**
	 * Any combination of dice
	 * @param dice dice rolled
	 * @return sum of all dice
	 */
	public static int chance(DiceRoll dice)
	{
		return dice.sum();
	}
	
	/**
	 * Get Yatzy score. Yatzy combination: All five dice with the same number
	 * @param dice dice rolled
	 * @return 50 points
	 */
	public static int yatzyScore(DiceRoll dice)
	{
		return dice.isYatzy() ? 50 : 0;
	}
	
	/**
	 * Three dice showing the same number
	 * @param dice dice rolled
	 * @return sum of those three dices
	 */
	public static int getThreeOfAKind(DiceRoll dice)
	{
		int index =  dice.getOccurenceOfKind(3);
		
		return index != -1 ? (index) * 3 : 0;
	}
	
	/**
	 * Four dice with the same number
	 * @param dice dice rolled
	 * @return sum of those four dice
	 */
	public static int getFourOfAKind(DiceRoll dice)
	{
		int index =  dice.getOccurenceOfKind(4);
		
		return index != -1 ? (index) * 4 : 0;
	}
	
	/**
	 * Small straight : The combination 1-2-3-4-5
	 * @param dice dice rolled
	 * @return 15 points
	 */
	public static int scoreOfSmallStraight(DiceRoll dice)
	{
		return dice.isSmallStraight() ? 15 : 0;
	}
	
	/**
	 * Large straight: The combination 2-3-4-5-6
	 * @param dice dice rolled
	 * @return 20 points
	 */
	public static int scoreOfLargeStraight(DiceRoll dice)
	{
		return dice.isLargeStraight() ? 20 : 0;
	}
	
	/**
	 * Two different pairs of dice
	 * @param dice dice rolled
	 * @return Sum of dice in those two pairs
	 */
	public static int twoPair(DiceRoll dice)
	{
		List<Integer>dicesResult = dice.findApair();
		return dicesResult.stream().count() == 2 ? dicesResult.get(0) * 2 + dicesResult.get(1) * 2 : 0;
	}
	
	/**
	 * Two dice showing the same number.
	 * @param dice dice rolled
	 * @return Sum of those two dice
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
