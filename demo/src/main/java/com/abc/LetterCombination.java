package com.abc;
import java.util.ArrayList;
import java.util.List;
 
public class LetterCombination {
	
	
	private String[] letterArr = new String[] {"","","abc","def",
			"ghi","jkl","mno","pqrs","tuv","wxyz"};
			

	public void convert(int[] digitArr) {
		if (digitArr == null || digitArr.length == 0) {
			return;
		}
		
		StringBuffer combinationStr = new StringBuffer();
		
		List<String> resultList = new ArrayList<String>();
		
		combinate(digitArr , 0 , resultList,combinationStr);
		System.out.println(resultList);
    }
 
	private void combinate(int[] digitArr , int positionOfDigit, List<String> resultList, StringBuffer combinationStr) {
		if (positionOfDigit == digitArr.length) {
			resultList.add(combinationStr.toString());
			return;
		}
		for (int i = 0; i < letterArr[digitArr[positionOfDigit]].length(); i++) {
			combinationStr.append(letterArr[digitArr[positionOfDigit]].charAt(i));
			combinate(digitArr, positionOfDigit + 1, resultList,combinationStr);
			combinationStr.deleteCharAt(combinationStr.length() - 1);
		}
	}
	}