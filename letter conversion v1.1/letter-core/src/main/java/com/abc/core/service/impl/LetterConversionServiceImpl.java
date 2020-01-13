package com.abc.core.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.core.domain.DigitMapping;
import com.abc.core.service.LetterConversionService;

@Service
public class LetterConversionServiceImpl implements LetterConversionService {
	

	public List<String> convert(int[] digits) {
		if (digits == null || digits.length == 0) {
			return null;
		}
		
		
		// convert input element start
		// convert input element which is bigger than 9, e.g. if input is {23,4}, then will be converted to {2,3,4}
		List<Integer> finalDigitList = new ArrayList<>();
		
		for(int i = 0; i<digits.length;i++) {
			
			if(digits[i] > 9) {
				String digitStr = String.valueOf(digits[i]);
				for(int j = 0; j < digitStr.length(); j++) {
					finalDigitList.add(Integer.valueOf(String.valueOf(digitStr.charAt(j))));
				}
				
			}else {
				finalDigitList.add(Integer.valueOf(digits[i]));
			}
		}
		// convert input element end
		
		List<String> finalLetterCombinations = new ArrayList<>();
		
		
		for(Integer digit : finalDigitList) {

			String Letter = DigitMapping.fromDigit(digit).getLetter();
			
			if(Letter == null) {
			    return null;	
			}

			
			List<String> LetterList= Arrays.asList(Letter.split(","));
			
			List<String> tempLetterCombinations = new ArrayList<>();
			
            if(finalLetterCombinations.size() == 0) {	
            	LetterList.forEach(eachLetter -> tempLetterCombinations.add(eachLetter));
				
			}else {
				
				for(String finalLetterCombination : finalLetterCombinations) {
					LetterList.forEach(eachLetter -> tempLetterCombinations.add(finalLetterCombination.concat(eachLetter)));
				}
			}
            
            finalLetterCombinations = tempLetterCombinations;
		}
		
		return finalLetterCombinations;
    }


}
