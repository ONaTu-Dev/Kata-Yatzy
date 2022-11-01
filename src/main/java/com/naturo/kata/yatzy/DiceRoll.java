package com.naturo.kata.yatzy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/** Realize combinations of dice roll results, based on Yatzy Rule from https://en.wikipedia.org/wiki/Yatzy
 * 
 * @author HOANG Nha Thu
 *
 */
public class DiceRoll {

	/**
	 * List of five number of spot for five dice rolling 
	 */
	private List<Integer> dicesRolledResult;
	
	/**
	 * List of dice rolled numbers as key and its occurrences as value
	 */
	private Map<Integer,Long> dicesResOccur;
	
	private static final List<Integer> SMALL_STRAIGHT = Arrays.asList(1,2,3,4,5);
	private static final List<Integer> LARGE_STRAIGHT = Arrays.asList(2,3,4,5,6);

	/**
	 * DiceRoll constructor
	 * initiate two work lists
	 * @param dice1 number of first dice roll
	 * @param dice2 number of second dice roll
	 * @param dice3 number of third dice roll
	 * @param dice4 number of fourth dice roll
	 * @param dice5 number of fifth dice roll
	 */
	public DiceRoll(int dice1, int dice2, int dice3, int dice4, int dice5)
	{
		this.dicesRolledResult = Arrays.asList(dice1,dice2,dice3,dice4,dice5);
		this.dicesResOccur = this.getListOfDiceResultAndOccurence();
		
	}
	
	/**
	 * The sum of all dice showing the number in parameter
	 * @param faceDice dice number 
	 * @return number occur * dice number 
	 */
	
	public int sumOneFaceDiceOccurence(int faceDice)
	{
		return dicesResOccur.get(faceDice) !=null ? Long.valueOf(dicesResOccur.get(faceDice)).intValue() * faceDice : 0;
	}
	
	/**
	 * Sum of all dice rolled result
	 * @return sum of dice result
	 */
	
	public int sum()
	{
		return  dicesRolledResult.stream()
				  .reduce(0, Integer::sum);
	}
	
	/**
	 * Get list of dice rolled numbers and its occurrence
	 * @return Map with dice rolled numbers as Key and its occurrence as Value
	 */
	
	private Map<Integer,Long> getListOfDiceResultAndOccurence()
	{
		return dicesRolledResult.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));			
	}
	
	/**
	 * Get list of dice rolled numbers when their occurrence superior or equal than parameter
	 * @param occurrence number of occurrence
	 * @return list of dice rolled numbers
	 */
	private List<Integer> getDiceNumListWhenOccurNumSupOrEqual(long occurrence)
	{
		return this.dicesResOccur.entrySet().stream()
				.filter(e -> e.getValue() >= Long.valueOf(occurrence))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}
	
	/**
	 * Find dice number associate to the occurrence in parameter
	 * @param occurrence number rolling with same face dice
	 * @return dice number associated this occurrence, -1 if not found
	 */
	public int getOccurenceOfKind(int occurrence)
	{
		return this.getDiceNumListWhenOccurNumSupOrEqual(occurrence).stream()
					.findFirst()
					.orElse(-1);
		
	}
	
	/**
	 * Check if all five dice rolls show the same number
	 * @return true when found 5 from list of numbers occurrence
	 */
	
	public boolean isYatzy()
	{
		return this.getOccurenceOfKind(5) !=-1 ? true : false;
	}
	
	/**
	 * Check Small straight : The combination 1-2-3-4-5
	 * @return true for smallStraight else false
	 */
	
	public boolean isSmallStraight()
	{
		return this.dicesResOccur.entrySet().stream().
				map(Map.Entry :: getKey).collect(Collectors.toList()).containsAll(SMALL_STRAIGHT);
	}
	
	/**
	 * Check Large straight: The combination 2-3-4-5-6
	 * @return true for largeStraight else false
	 */
	public boolean isLargeStraight()
	{
		return this.dicesResOccur.entrySet().stream().
				map(Map.Entry :: getKey).collect(Collectors.toList()).containsAll(LARGE_STRAIGHT);
	}
	
	/**
	 * Find the pair of dice with the same number of pips.
	 * @return list of dice
	 */
	public List<Integer> findApair()
	{
		return this.getDiceNumListWhenOccurNumSupOrEqual(2).stream()
					.sorted(Comparator.reverseOrder())
					.collect(Collectors.toList());
	}
	
	/**
	 * Check fullHouse  : Any set of three combined with a different pair
	 * if any pair with any other three-of-a-kind
	 * @return true for FullHouse else false
	 */
	
	public boolean isFullHouse()
	{
		int threeOfKindValue = this.getOccurenceOfKind(3);
		int onePairCountValue = (int)this.findApair().stream().findFirst().orElse(-1);
		return threeOfKindValue != 0 && onePairCountValue !=-1 && threeOfKindValue != onePairCountValue? true : false;
	}
}
