package com.util.number.converter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ConverterApplication {

	private static final  int arabicUpperLimit = 10000;

	private static final int arabicLowerLimit = 0;

	public static  Map<Integer, String> romanNumeralsMap = new HashMap<>();

	public static void setNewRomanNumber(int arabicNumber, String romanNumber) {
		romanNumeralsMap.put(arabicNumber,romanNumber);
	}

	static {
		romanNumeralsMap.put(1, "I");
		romanNumeralsMap.put(4, "IV");
		romanNumeralsMap.put(5, "V");
		romanNumeralsMap.put(9, "IX");
		romanNumeralsMap.put(10, "X");
		romanNumeralsMap.put(40, "XL");
		romanNumeralsMap.put(50, "L");
		romanNumeralsMap.put(90, "XC");
		romanNumeralsMap.put(100, "C");
		romanNumeralsMap.put(400, "CD");
		romanNumeralsMap.put(500, "D");
		romanNumeralsMap.put(900, "CM");
		romanNumeralsMap.put(1000, "M");
	}

	 public  static String arabicToRoman(int input){
    if(input <= Integer.valueOf(arabicLowerLimit) || input >= Integer.valueOf(arabicUpperLimit)){
    	throw new IllegalArgumentException(input + " is not in range (0, 10000)");
		}

		 List<Integer> romanNumerals = romanNumeralsMap.keySet().stream().collect(Collectors.toList());
     romanNumerals.sort(Collections.reverseOrder());
		 int i = 0;
		 StringBuilder sb = new StringBuilder();

		 while ((input > 0) && (i < romanNumerals.size())) {
			 Integer n = romanNumerals.get(i);
			 if (n <= input) {
				 sb.append(romanNumeralsMap.get(n));
				 input -= n;
			 } else {
				 i++;
			 }
		 }

		 return sb.toString();

	}

	public static int romanToArabic(String input){
		String romanNumeral = input.toUpperCase();
		int result = 0;

		List<Integer> romanNumerals = romanNumeralsMap.keySet().stream().collect(Collectors.toList());
		romanNumerals.sort(Collections.reverseOrder());

		int i = 0;

		while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
			  int n = romanNumerals.get(i);
			if (romanNumeral.startsWith(romanNumeralsMap.get(n))) {
				result += n;
				romanNumeral = romanNumeral.substring(romanNumeralsMap.get(n).length());
			} else {
				i++;
			}
		}

		if (romanNumeral.length() > 0) {
			throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
		}

		return result;
	}

}
