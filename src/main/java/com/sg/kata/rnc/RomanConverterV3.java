package com.sg.kata.rnc;

/**
 * The principal class
 * 
 * @author dung
 *
 */
public class RomanConverterV3 {

	private int rangeReference = 10;

	public RomanConverterV3() {
		super();
	}

	private String getRomanCodeByRange(int number, int range) {

		if (!RomanCodeEnum.isRangeValid(range))
			return null;

		String code1 = RomanCodeEnum.getRomanCode(range, 1).name();
		String code5 = (range >= RomanCodeEnum.M.getRange()) ? "" : RomanCodeEnum.getRomanCode(range, 5).name();

		StringBuffer buffer = new StringBuffer();
		if (number == 1)
			return buffer.append(code1).toString();
		if (number == 2)
			return buffer.append(code1).append(code1).toString();
		if (number == 3)
			return buffer.append(code1).append(code1).append(code1).toString();
		if (number == 4)
			return buffer.append(code1).append(code5).toString();
		if (number == 5)
			return buffer.append(code5).toString();
		if (number == 6)
			return buffer.append(code5).append(code1).toString();
		if (number == 7)
			return buffer.append(code5).append(code1).append(code1).toString();
		if (number == 8)
			return buffer.append(code5).append(code1).append(code1).append(code1).toString();
		if (number == 9) {
			RomanCodeEnum next = RomanCodeEnum.getRomanCode((range * 10), 1);
			if (next != null) {
				String code1OfNextRange = next.name();
				return buffer.append(code1).append(code1OfNextRange).toString();
			}
		}
		return null;
	}

	/**
	 * Convert a number to a roman code
	 * 
	 * @param number
	 *            - the parameter should be between 1 and 3999
	 * @return
	 * @throws NumberFormatException
	 *             - it is thrown if the parameter is not in the range
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
