package com.sg.kata.rnc;

public enum RomanCodeEnum {
	I(1, 1), V(1, 5), X(10, 1), L(10, 5), C(100, 1), D(100, 5), M(1000, 1);
	private int range;
	private int number;
	
	private RomanCodeEnum(int range, int number) {
		this.range = range;
		this.number = number;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public static boolean isRangeValid(int range) {
		RomanCodeEnum[] table = RomanCodeEnum.values();
		for (RomanCodeEnum romanCode : table) {
			if (range==romanCode.getRange()) {
				return true;
			}
		}
		return false;
	}
	
	public static RomanCodeEnum getRomanCode(int range, int number) {
		RomanCodeEnum[] table = RomanCodeEnum.values();
		for (RomanCodeEnum romanCode : table) {
			if (range==romanCode.getRange() && number==romanCode.getNumber()) {
				return romanCode;
			}
		}
		return null;
	}
	

}
