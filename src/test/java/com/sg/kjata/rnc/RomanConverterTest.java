package com.sg.kjata.rnc;

import org.junit.Assert;
import org.junit.Test;

import com.sg.kata.rnc.RomanConverter;

import junit.framework.TestCase;

/**
 * Test class of RomanConverter 
 * @author dung
 *
 */
public class RomanConverterTest extends TestCase {
	
	RomanConverter romanConverter;
	
	@Override
	protected void setUp() throws Exception {
		romanConverter = new RomanConverter();
	}
		
	@Test
	public void testRoman() {
		
		try {
			romanConverter.roman(0);
			Assert.fail("The number should not be < 0");
		} catch (NumberFormatException numberFormatException) {
			Assert.assertTrue(true);
		}

		try {
			romanConverter.roman(4000);
			Assert.fail("The number should not be > 3999");
		} catch (NumberFormatException numberFormatException) {
			Assert.assertTrue(true);
		}
		
		Assert.assertEquals("Error", "I", romanConverter.roman(1));
		Assert.assertEquals("Error", "II", romanConverter.roman(2));
		Assert.assertEquals("Error", "III", romanConverter.roman(3));
		Assert.assertEquals("Error", "IV", romanConverter.roman(4));
		Assert.assertEquals("Error", "MCMLIV", romanConverter.roman(1954));
		Assert.assertEquals("Error", "MCMXC", romanConverter.roman(1990));
	}
}
