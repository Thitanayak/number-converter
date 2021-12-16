package com.util.number.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterApplicationTests {

	@Test
	void arabicToRomanTest() {
		assertEquals("DLXXXIV",ConverterApplication.arabicToRoman(584));
	}

	@Test
	void arabicToRomanExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> ConverterApplication.arabicToRoman(555555555));
	}

	@Test
	void romanToArabicTest() {
		assertEquals(584,ConverterApplication.romanToArabic( "DLXXXIV"));
	}

	@Test
	void romanToArabicExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> ConverterApplication.romanToArabic("ghggoou"));
	}

	@Test
	void updateRomanList(){
		ConverterApplication.setNewRomanNumber(10000,"K");
		assertEquals(14,ConverterApplication.romanNumeralsMap.size());
	}

}
