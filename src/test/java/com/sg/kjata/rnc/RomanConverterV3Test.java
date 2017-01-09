package com.sg.kjata.rnc;

import org.junit.Assert;

import com.sg.kata.rnc.RomanConverterV3;

import junit.framework.TestCase;

/**
 * Test class of RomanConverterV3
 * 
 * @author dung
 *
 */
public class RomanConverterV3Test extends TestCase {

	RomanConverterV3 romanConverter;

	@Override
	protected void setUp() throws Exception {
		romanConverter = new RomanConverterV3();
	}

//	@Test
	public void testRoman() {

		try {
			romanConverter.roman(-1);
			Assert.fail("The parameter must not be negative");

			romanConverter.roman(0);
			Assert.fail("The parameter must not be 0");
			
			romanConverter.roman(4000);
			Assert.fail("The parameter must not be upper than 3999");
		} catch (NumberFormatException numberFormatException) {
			// OK
			Assert.assertTrue(true);
		}

		// Samples valid test cases, but they keep mind they don't prove the algorithm is correct
		Assert.assertEquals("Error", "I", romanConverter.roman(1));
		Assert.assertEquals("Error", "II", romanConverter.roman(2));
		Assert.assertEquals("Error", "III", romanConverter.roman(3));
		Assert.assertEquals("Error", "IV", romanConverter.roman(4));
		Assert.assertEquals("Error", "MCMLIV", romanConverter.roman(1954));
		Assert.assertEquals("Error", "MCMXC", romanConverter.roman(1990));

		// Just for fun..
		int[] params = { 1, 4, 1954, 1990, 5, 45, 3256, 955, 1000, 142, 3999, 3000};
		for (int i : params) {
			System.out.println(i + " - " + romanConverter.roman(i));
		}
	}
}
