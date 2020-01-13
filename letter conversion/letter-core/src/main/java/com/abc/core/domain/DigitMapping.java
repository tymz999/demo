package com.abc.core.domain;

public enum DigitMapping {
	
	 //final String[] letterArray = new String[] {null,null,"a,b,c","d,e,f",
				//"g,h,i","j,k,l","m,n,o","p,q,r,s","t,u,v","w,x,y,z"};
	
	
	ZERO(0, null), 
	ONE(1, null), 
	TWO(2, "a,b,c"), 
	THREE(3, "d,e,f"), 
	FOUR(4, "g,h,i"), 
	FIVE(5, "j,k,l"), 
	SIX(6, "m,n,o"), 
	SEVEN(7, "p,q,r,s"), 
	EIGHT(8, "t,u,v"), 
	NIGHT(9, "w,x,y,z");
	
	 
	 private int digit;
	 
	 private String letter;
	 
	 private DigitMapping(int digit, String letter) {  
	        this.digit = digit;  
	        this.letter = letter;  
	    }  
	 
	  public static DigitMapping fromDigit(int digit) {  
          for (DigitMapping digitMapping : DigitMapping.values()) {  
              if (digitMapping.getDigit()== digit) {  
                  return digitMapping;  
              }  
          }  
          return null;  
      }  
	  
	  

	public int getDigit() {
		return digit;
	}

	public String getLetter() {
		return letter;
	}
	 
	 
	 
	 

}
