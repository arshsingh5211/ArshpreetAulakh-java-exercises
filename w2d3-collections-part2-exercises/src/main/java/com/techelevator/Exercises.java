package com.techelevator;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercises {

	/*
	 * Dictionary/Map Exercises
	 */
	
	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").  
	 * 
	 * The animal name should be case insensitive so "elephant", "Elephant", and 
	 * "ELEPHANT" should all return "herd". 
	 * 
	 * If the name of the animal is not found, null, or empty, return "unknown". 
	 * 
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * 
	 */
	public String animalGroupName(String animalName) {
		Map<String, String> animalToGroup = new HashMap<>();
		animalToGroup.put("rhino", "Rash");
		animalToGroup.put("giraffe", "Tower");
		animalToGroup.put("elephant", "Herd");
		animalToGroup.put("lion", "Pride");
		animalToGroup.put("crow", "Murder");
		animalToGroup.put("pigeon", "Kit");
		animalToGroup.put("flamingo", "Pat");
		animalToGroup.put("deer", "Herd");
		animalToGroup.put("dog", "Pack");
		animalToGroup.put("crocodile", "Float");
		
		return animalToGroup.getOrDefault(animalName.toLowerCase(),"unknown");
	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 * 
	 * If the item number is empty or null, return 0.00.
	 * 
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 * 
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *  
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00 
	 * 
	 */
	public Double isItOnSale(String itemNumber) {
        HashMap<String, Double> itemDiscount = new HashMap <String, Double>();
        itemDiscount.put("kitchen4001", 0.20);
        itemDiscount.put("garage1070", 0.15);
        itemDiscount.put("livingroom", 0.10);
        itemDiscount.put("kitchen6073", 0.40);
        itemDiscount.put("bedroom3434", 0.60);
        itemDiscount.put("bath0073", 0.15);
        
        return itemDiscount.getOrDefault(itemNumber.toLowerCase(), 0.00);
	}
	
	/*
	 * Modify and return the given map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 * 
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 * 
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 * 
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
		Integer valPeter = peterPaul.get("Peter");
		Integer valPaul = peterPaul.get("Paul");
		int total = valPeter + valPaul;
		if (valPeter > 0 && valPaul < 1000) {
			valPaul = valPaul + valPeter/2;
			valPeter = total - valPaul;
		}
		peterPaul.put("Peter", valPeter);
		peterPaul.put("Paul", valPaul);
		return peterPaul;
	}
	
    /*
	 * Modify and return the given map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 * 
	 * peterPaulPartnership({"Peter": 5000, "Paul": 10000}) → {"Peter": 3750, "Paul": 7500, "PeterPaulPartnership": 3750}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 * 
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
		int valPeter = peterPaul.get("Peter");
		int valPaul = peterPaul.get("Paul");

		if (valPeter >= 5000 && valPaul >= 10000) {
			peterPaul.put("Peter", (int)(valPeter * 0.75));
			peterPaul.put("Paul", (int) (valPaul * 0.75));
			peterPaul.put("PeterPaulPartnership", (int)((valPeter * 0.25) + (valPaul * 0.25)));
		}

		return peterPaul;
	}
	
	/*
	 * Given an array of non-empty strings, return a Map<String, String> where for every different string in the array, 
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
        Map<String, String> wordCharMap = new HashMap<>();
        for (String word : words) {
            wordCharMap.put(word.substring(0,1), word.substring(word.length()-1));
        }
        return wordCharMap;
	}
	
	/*
	 * Given an array of strings, return a Map<String, Integer> with a key for each different string, with the value the 
	 * number of times that string appears in the array.
	 * 
	 * ** A CLASSIC **
	 * 
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 * 
	 */
	public Map<String, Integer> wordCount(String[] words) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			if (!map.containsKey(word)) map.put(word, 1);
			else map.put(word, map.get(word) + 1);
		}
			return map;
	}
	
	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the 
	 * number of times that int appears in the array.
	 * 
	 * ** The lesser known cousin of the the classic wordCount **
	 * 
	 * integerCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 1, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * integerCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * integerCount([]) → {}
	 * 
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num: ints) {
			if (!map.containsKey(num)) map.put(num, 1);
			else map.put(num, map.get(num) + 1);
		}
			return map;
	}
	
	/*
	 * Given an array of strings, return a Map<String, Boolean> where each different string is a key and value
	 * is true only if that string appears 2 or more times in the array.
	 * 
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 * 
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
        Map<String, Boolean> wordTwice = new HashMap<>();
        for (String word : words) {
            if (wordTwice.containsKey(word)) wordTwice.put(word, true);
            else wordTwice.put(word, false);
        }
        return wordTwice;
	}
	
	/*
	 * Given two maps, Map<String, Integer>, merge the two into a new map, Map<String, Integer> where keys in Map2, 
	 * and their Integer values, are added to the Integer values of matching keys in Map1. Return the new map.
	 * 
	 * Unmatched keys and their Integer values in Map2 are simply added to Map1.
	 *  
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 * 
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse, Map<String, Integer> remoteWarehouse) {
		for (String item: remoteWarehouse.keySet()) {
			if (mainWarehouse.containsKey(item)) mainWarehouse.put(item, mainWarehouse.get(item) + remoteWarehouse.get(item));
			else mainWarehouse.put(item, remoteWarehouse.get(item));
		}
			return mainWarehouse;
	}
	
	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 * 
	 * Given an array of strings, for each string, the count of the number of times that a substring length 2 appears 
	 * in the string and also as the last 2 chars of the string, so "hixxxhi" yields 1. 
	 * 
	 * We don't count the end substring, but the substring may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end substring, which we don't count.  
	 * 
	 * Return Map<String, Integer>, where the key is string from the array, and its last2 count.
	 *  
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 * 
	 */
	public Map<String, Integer> last2Revisted(String[] words) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			int count = 0;
			String end = word.substring(word.length()-2);
			for (int i = 0; i < word.length()-2; i++) {
				if (word.substring(i, i+2).equals(end)) count++;
			}
			map.put(word, count);
		}
		return map;
	}
	
	// is there a way to do this with linear complexity
	// bad form to declare variables inside a loop? or is it best to limit scope of variables
}
