package com.sg.kata.rnc;

import java.util.HashMap;
import java.util.Map;

/**
 * The principal class
 * @author dung
 *
 */
public class RomanConverter {

	private Map<Integer, Map<Integer, String>> map = new HashMap<Integer, Map<Integer, String>>();

	public RomanConverter() {
		super();
		map.put(1, new HashMap<Integer, String>());
		map.get(1).put(1, "I");
		map.get(1).put(2, "II");
		map.get(1).put(3, "III");
		map.get(1).put(4, "IV");
		map.get(1).put(5, "V");
		map.get(1).put(6, "VI");
		map.get(1).put(7, "VII");
		map.get(1).put(8, "VIII");
		map.get(1).put(9, "IX");

		map.put(10, new HashMap<Integer, String>());
		map.get(10).put(1, "X");
		map.get(10).put(2, "XX");
		map.get(10).put(3, "XXX");
		map.get(10).put(4, "XL");
		map.get(10).put(5, "L");
		map.get(10).put(6, "LX");
		map.get(10).put(7, "LXX");
		map.get(10).put(8, "LXXX");
		map.get(10).put(9, "XC");

		map.put(100, new HashMap<Integer, String>());
		map.get(100).put(1, "C");
		map.get(100).put(2, "CC");
		map.get(100).put(3, "CCC");
		map.get(100).put(4, "CD");
		map.get(100).put(5, "D");
		map.get(100).put(6, "DC");
		map.get(100).put(7, "DCC");
		map.get(100).put(8, "DCCC");
		map.get(100).put(9, "CM");

		map.put(1000, new HashMap<Integer, String>());
		map.get(1000).put(1, "M");
		map.get(1000).put(2, "MM");
		map.get(1000).put(3, "MMM");
	}

	/**
	 * Convert a number to a roman code
	 * @param number - the parameter should be between 1 and 3999
	 * @return
	 * @throws NumberFormatException - it is thrown if the parameter is not in the range
	 */
	public String roman(int number) throws NumberFormatException {
		if (number <= 0 || number > 3999) {
			throw new NumberFormatException("Not implemented for this sample.");
		}
		
		int multiple = 1;
		String result = "";
		StringBuffer buffer = new StringBuffer();
		while (number != 0) {
			int currentDigit = number % 10;
			number = Math.abs(number / 10);
			String romanLetter = map.get(multiple).get(currentDigit);
			if (romanLetter != null) {
				result = buffer.append(romanLetter).append(result).toString();
				buffer.setLength(0);
			}
			multiple = multiple * 10;
		}
		return result;
	}

}
