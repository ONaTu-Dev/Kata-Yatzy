package com.naturo.kata.yatzy;

import java.util.List;

public class Scores {

	private Scores() {
		
	}
	/**
	 * Get number of occurrence of dice with 1 spot
	 * @param DiceRoll
	 * @return occurrences sum result
	 */
	public static int ones(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(1);
	}

	/**
	 * Get number of occurrence of dice with 2 spots
	 * @param DiceRoll
	 * @return occurrences sum result
	 */
	public static int twos(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(2);
	}
	
	/**
	 * Get number of occurrence of dice with 3 spots
	 * @param DiceRoll
	 * @return occurrences sum result
	 */
	public static int threes(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(3);
	}
	
	/**
	 * Get number of occurrence of dice with 4 spots
	 * @param DiceRoll
	 * @return occurrences sum result
	 */
	public static int fours(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(4);
	}
	
	/**
	 * Get number of occurrence of dice with 5 spots
	 * @param DiceRoll
	 * @return occurrences sum result
	 */
	public static int fives(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(5);
	}
	
	/**
	 * Get number of occurrence of dice with 6 spots
	 * @param DiceRoll
	 * @return occurrences sum result
	 */
	public static int sixs(DiceRoll dice)
	{
		return dice.sumOneFaceDiceOccurence(6);
	}
	
	/**
	 * Sum of all dices result
	 * @param DiceRoll
	 * @return
	 */
	public static int sumAllDicesRolledResult(DiceRoll dice)
	{
		return dice.sum();
	}
	
	/**
	 * Get Yatzy score
	 * @param DiceRoll
	 * @return
	 */
	public static int yatzyScore(DiceRoll dice)
	{
		return dice.isYatzy() ? 50 : 0;
	}
	
	/**
	 * Get dice rolled result of a kind
	 * @param DiceRoll
	 * @param number of pips
	 * @return
	 */
	public static int getDiceResultOfAkind(DiceRoll dice, int pipsNumber)
	{
		int index =  dice.getOccurenceOfKind(pipsNumber);
		
		return index != -1 ? (index) * pipsNumber : 0;
	}
	
	/**
	 * Get score of small straight
	 * @param dice
	 * @return
	 */
	public static int scoreOfSmallStraight(DiceRoll dice)
	{
		return dice.isSmallStraight() ? 15 : 0;
	}
	
	/**
	 * Get score of large straight
	 * @param DiceRoll
	 * @return
	 */
	public static int scoreOfLargeStraight(DiceRoll dice)
	{
		return dice.isLargeStraight() ? 20 : 0;
	}
	
	/**
	 * Get Two Pair
	 * @param DiceRoll
	 * @return
	 */
	public static int twoPair(DiceRoll dice)
	{
		List<Integer>dicesResult = dice.findApair();
		return dicesResult.stream().count() == 2 ? dicesResult.get(0) * 2 + dicesResult.get(1) * 2 : 0;
	}
	
	/**
	 * Get One Pair
	 * @param DiceRoll
	 * @return
	 */
	public static int onePair(DiceRoll dice)
	{
		List<Integer>dicesResult = dice.findApair();
		return dicesResult.stream().count() >= 1 ? dicesResult.get(0) * 2 : 0;
	}
	
	/**
	 * Get Full House
	 * @param DiceRoll
	 * @return
	 */
	public static int fullHouse(DiceRoll dice)
	{
		return dice.isFullHouse() ? dice.sum(): 0;
	}
}
