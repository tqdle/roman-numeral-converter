package com.sg.kata.rnc;

import java.util.HashMap;
import java.util.Map;

/**
 * The principal class
 * @author dung
 *
 */
public class RomanConverterV2 {

	private Map<Integer, Map<Integer, String>> map = new HashMap<Integer, Map<Integer, String>>();

	private int rangeReference = 10;
	
	public RomanConverterV2() {
		super();
		map.put(1, new HashMap<Integer, String>());
		map.get(1).put(1, "I");
		map.get(1).put(5, "V");
		map.put(10, new HashMap<Integer, String>());
		map.get(10).put(1, "X");
		map.get(10).put(5, "L");

		map.put(100, new HashMap<Integer, String>());
		map.get(100).put(1, "C");
		map.get(100).put(5, "D");

		map.put(1000, new HashMap<Integer, String>());
		map.get(1000).put(1, "M");
	}

	private String getRomanCodeByRange(int number, int range) {
		
		if (!map.containsKey(range))
			return null;
		
		String code1 = map.get(range).get(1);
		String code5 = map.get(range).get(5);
		
		StringBuffer buffer = new StringBuffer();
		if (number == 1) return buffer.append(code1).toString();
		if (number == 2) return buffer.append(code1).append(code1).toString();
		if (number == 3) return buffer.append(code1).append(code1).append(code1).toString();
		if (number == 4) return buffer.append(code1).append(code5).toString();
		if (number == 5) return buffer.append(code5).toString();
		if (number == 6) return buffer.append(code5).append(code1).toString();
		if (number == 7) return buffer.append(code5).append(code1).append(code1).toString();
		if (number == 8) return buffer.append(code5).append(code1).append(code1).append(code1).toString();		
		if (number == 9) {
			if (map.containsKey(range * 10)) {
				String code1OfNextRange = map.get(range * 10).get(1);
				return buffer.append(code1).append(code1OfNextRange).toString();
			}
		}		
		return null;
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
			int currentDigit = number % rangeReference;
			number = Math.abs(number / rangeReference);
			String romanLetter = getRomanCodeByRange(currentDigit, multiple);
			if (romanLetter != null) {
				result = buffer.append(romanLetter).append(result).toString();
				buffer.setLength(0);
			}
			multiple = multiple * rangeReference;
		}
		return result;
	}

}
