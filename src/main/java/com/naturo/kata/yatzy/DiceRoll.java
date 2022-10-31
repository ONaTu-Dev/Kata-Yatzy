package com.naturo.kata.yatzy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DiceRoll {

	private List<Integer> dicesRolledResult;
	private Map<Integer,Long> dicesResOccur;
	
	
	private final static List<Integer> SMALL_STRAIGHT_ONE = Arrays.asList(1,2,3,4);
	private final static List<Integer> SMALL_STRAIGHT_TWO = Arrays.asList(2,3,4,5);
	private final static List<Integer> SMALL_STRAIGHT_THREE = Arrays.asList(3,4,5,6);

	public DiceRoll(int dice1, int dice2, int dice3, int dice4, int dice5)
	{
		this.dicesRolledResult = Arrays.asList(dice1,dice2,dice3,dice4,dice5);
		this.dicesResOccur = this.getListOfDiceResultAndOccurence();
		
	}
	
	/**
	 * count all occurrence outcome of one face dice
	 * @param faceDice
	 * @return
	 */
	
	public int sumOneFaceDiceOccurence(int faceDice)
	{
		return dicesResOccur.get(faceDice) !=null ? Long.valueOf(dicesResOccur.get(faceDice)).intValue() * faceDice : 0;
	}
	
	/**
	 * sum of all dice rolled result
	 * @return sum of dice result
	 */
	
	public int sum()
	{
		return  dicesRolledResult.stream()
				  .reduce(0, Integer::sum);
	}
	
	public int countOccu(int oc)
	{
		return  (int)dicesRolledResult.stream().filter(e -> e.equals(oc)).count();
	}
	
	/**
	 * get list of dice rolled result and its occurrence
	 * @return Map with dice rolled result as Key and its occurrence as Value
	 */
	 
	
	private Map<Integer,Long> getListOfDiceResultAndOccurence()
	{
		//dicesRolledResult.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().forEach(e -> System.out.println("K " + e.getKey() + "V: " + e.getValue()));			
	
		return dicesRolledResult.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));			
	}
	
	/**
	 * 
	 * @param diceResult
	 * @return list of face dice when their occurrence outcome greater than param
	 */
	private List<Integer> getDiceResultListWhenOccurencesGreaterThan(long diceResult)
	{
		return this.dicesResOccur.entrySet().stream()
				.filter(e -> e.getValue() >= Long.valueOf(diceResult))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}
	
	/**
	 * Get occurrence of any dice with the same number of pips.
	 * @param diceResult
	 * @return
	 */
	public int getOccurenceOfKind(int pipsNumber)
	{
		return this.getDiceResultListWhenOccurencesGreaterThan(pipsNumber).stream()
					.findFirst()
					.orElse(-1);
		
	}
	
	/** Verify if all five dice with the same number
	 *  return true when found 5 in list 
	 *  */
	
	public boolean isYatzy()
	{
		return this.getOccurenceOfKind(5) !=-1 ? true : false;
	}
	
	/**
	 * Verify if any four dice in ascending order  
	 * @return boolean
	 */
	
	public boolean isSmallStraight()
	{
		List<Integer> list =  this.dicesResOccur.entrySet()
				.stream()
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		return list.containsAll(SMALL_STRAIGHT_ONE) || list.containsAll(SMALL_STRAIGHT_TWO) || list.containsAll(SMALL_STRAIGHT_THREE);
	}
	
	/**
	 * Verify if any five dice in ascending order
	 * and the result of each rolled dice occurrence is 1 
	 * @return
	 */
	public boolean isLargeStraight()
	{
		
		boolean b= this.dicesResOccur.entrySet().stream()
						.filter(e -> e.getValue() == 1).count()==5 ? true : false;
		return b && (this.sum() == 20 || this.sum() ==  15);
	}
	
	/**
	 * Find the pair of dice with the same number of pips.
	 * @return list of rolled dice result
	 */
	public List<Integer> findApair()
	{
		return this.getDiceResultListWhenOccurencesGreaterThan(2).stream()
					.sorted(Comparator.reverseOrder())
					.collect(Collectors.toList());
	}
	
	/**
	 * Vérify if any pair with any other three-of-a-kind for five dice
	 * @return boolean
	 */
	
	public boolean isFullHouse()
	{
		int threeOfKindValue = this.getOccurenceOfKind(3);
		int onePairCountValue = (int)this.findApair().stream().findFirst().orElse(-1);
		return threeOfKindValue != 0 && onePairCountValue !=-1 && threeOfKindValue != onePairCountValue? true : false;
	}
}