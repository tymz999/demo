package com.abc.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterConversion {
	
	 private static volatile LetterConversion instance = null ;
	 
	 private static final String[] letterArray = new String[] {null,null,"a,b,c","d,e,f",
				"g,h,i","j,k,l","m,n,o","p,q,r,s","t,u,v","w,x,y,z"};
	
	
	private LetterConversion(){
		 
    }
	
	// apply singleton design pattern
   public static LetterConversion getInstance(){
        
        if(instance == null){
            synchronized (LetterConversion.class){
                if(instance == null){
                	instance = new LetterConversion();
                }
            }
        }
        return instance;
    }

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

			String Letter = letterArray[digit];
			
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
