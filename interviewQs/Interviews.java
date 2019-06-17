package interviewQs;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
import java.util.Stack;

public class Interviews<E> {

	/**
	* Returns true if str1 and str2 are anagrams, false if not
	*
	* @str1 one of two strings to test if anagrams
	* @str2 two of two strings to test if anagrams
	* @return true if str1 and str2 are anagrams, false if not
	*/
	public boolean isAnagram(String str1, String str2) {
		if (str1 == null || str2 == null) {
			throw new NullPointerException();
	}

	if (str1.length() != str2.length() || str1.length() == 0 || str2.length() == 0) {
		return false;
	}
	Hashtable<Character, Integer> letterTable = new Hashtable<>();
	for (int i = 0; i < str1.length(); i++) {
		Character key = str1.charAt(i);
		if (letterTable.containsKey(key)) {
			int newCount = letterTable.get(key) + 1;
			letterTable.replace(key, newCount);
		} else {
			letterTable.put(key, 1);
		}
	}

	for (int j = 0; j < str2.length(); j++) {
		Character key2 = str2.charAt(j);
		if (letterTable.containsKey(key2)) {
			int newCount = letterTable.get(key2) + 1;
			letterTable.replace(key2, newCount);
		}
	}

	Collection<Integer> values = letterTable.values();
	for (Integer count : values) {
		if (count != 0) {
	return false;
	}
	}
	return true;
	}
	
	/**
	* Returns true if number is prime, false if not
	*
	* @param number - number to check if prime
	* @return true if number is prime, false if not
	*/
	public boolean isPrime(int number) {
		if (number % 2 == 0) {
		return false;
	}

	for (int i = 3; i < number / 2; i += 2) {
		if (number % i == 0) {
			return false;
		}
	}
	return true;
	}

	/**
	* Prints out duplicate letters in a string
	*
	*/
	public void printDuplicates(String str1) {
		// str1 is empty?
		if (str1 == null) {
			throw new NullPointerException();
		}
		
		Hashtable<Character, Integer> letterTable = new Hashtable<>();
		for (int i = 0; i < str1.length(); i++) {
			Character key = str1.charAt(i);
			if (letterTable.containsKey(key)) {
				int newValue = letterTable.get(key) + 1;
				letterTable.replace(key, newValue);
			} else {
				letterTable.put(key, 1);
			}
		}

		for (int i = 0; i < str1.length(); i++) {
	Character key = str1.charAt(i);
			if (letterTable.get(key) == 1) {
				letterTable.remove(key, 1);
			}
		}
		Set<Character> keys = letterTable.keySet();
		for (Character letter : keys) {
			System.out.println(letter);
		}
	}
	
	/**
	* Reverse the elements in the specified array
	*
	* @throws NullPointerException if array is null
	*/

	public static void reverse(int[] array) {
		if (array == null) {
			throw new NullPointerException();
		}

		for (int i = 0; i < array.length / 2; i++) {
		// array.length = 4 -> i would stop at index 1
		// array.length = 5 -> i would stop at index 1 (for loop does not swap middle element)
			int endPointer = array.length - 1 - i;
			swap(array, i, endPointer);
		}
	}



	/**
	* Swaps the specified elements at index1 and index2 of the specified array 
	*
	* @array - the array in which to swap the elements
	* @index1 - (one of two) the index of the element in the array to be swapped
	* @index2 - (two of two) the index of the element in the array to be swapped
	*/
	private static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	/**
	* Returns true if a string is closed correctly: {}, (), []
	*
	* @param string - the string to validate if closed correctly
	* @return true if the specified string is closed correctly, false if not
	*/
	public static boolean closedBrackets(String string) {
		if (string.length() == 0) {
			return false;
		}
		HashMap<Character, Character> brackets = new HashMap<>();
		brackets.put('(', ')');
		brackets.put('{', '}');
		brackets.put('[', ']');

		Stack<Character> bracketStack = new Stack<>();

		for (int i = 0; i < string.length(); i++) {
			Character seenBracket = string.charAt(i);
			if (brackets.containsKey(seenBracket)) {
				bracketStack.push(seenBracket);
			} else if (brackets.containsValue(seenBracket)) {
				if (bracketStack.empty()) {
					return false;
				} else {
					Character lastSeen = bracketStack.pop();
					if (brackets.get(lastSeen) != seenBracket) {
						return false;
					}
				}
			}

		}
		return bracketStack.empty();

	}

	
	/**
	* Finds the minimum and maximum bounds for the specified object in the given sorted array
	*
	* @param array - the sorted array in which to find the min and max bounds of the object
	* @param element - the object to find the min and max bounds for
	* @return a string declaring the min and max index bounds for the specified object, -1 if object 
	* not in array
	*/ 
	public static String findBounds(int[] array, int element) {
		int minBound = 0;
		int maxBound = array.length - 1;
		if (array[minBound] != element) {
			minBound = findMin(array, element, 0, array.length - 1);
		}

		if (array[maxBound] != element) {
			maxBound = findMax(array, element, 0, array.length - 1);
		}
		return "[" + minBound + ", " + maxBound + "]";
	}
		

	private static int findMin(int[] array, int element, int startIndex, int endIndex) {
		if (startIndex <= endIndex) {
			if (array[startIndex] == element && array[startIndex - 1] != element) {
				return startIndex;
			}
	
			int middleIndex = (startIndex + endIndex) / 2;
			if (element <= array[middleIndex]) {
				return findMin(array, element, startIndex, middleIndex - 1);
			} else if (element > array[middleIndex]) {
				return findMin(array, element, middleIndex + 1, endIndex);
			}
		}
		return -1;
	}

	private static int findMax(int[] array, int element, int startIndex, int endIndex) {
		if (startIndex <= endIndex) {
			if (array[startIndex] == element && array[startIndex + 1] != element) {
				return startIndex;
			}
	
			int middleIndex = (startIndex + endIndex) / 2;
			if (element >= array[middleIndex]) {
				return findMax(array, element, middleIndex + 1, endIndex);
			} else if (element < array[middleIndex]) {
				return findMax(array, element, startIndex, middleIndex - 1);
			}
		}
		return -1;
	}

	    public static int firstUniqChar(String s) {
	        // iterate through string, check if substring from i + 1 to end of string contains another char as the char at i
	        for (int i = 0; i < s.length(); i++) {
	            char curr = s.charAt(i);
	            if (s.lastIndexOf(curr) == i) {
	                return i;
	            }
	        }
	        return -1;
	    }
	
	public static void main(String[] args) {
	}
	
	



}
