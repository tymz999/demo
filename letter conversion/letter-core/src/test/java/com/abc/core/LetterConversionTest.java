package com.abc.core;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.abc.core.service.LetterConversionService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:applicationContext.xml" }) 
public class LetterConversionTest {
	
	@Autowired
	LetterConversionService letterConversionService;
	

	@Test
	public void test() {
		

		// scenario 1: input is 0
	    assertEquals(letterConversionService.convert(new int[] {0}), null);
	    
	    // scenario 2: input is 1
	    assertEquals(letterConversionService.convert(new int[] {1}), null);
	    
	    // scenario 3 : input elements contains 0
	    assertEquals(letterConversionService.convert(new int[] {2,0}), null);
	    
	    // scenario 4 : input elements contains 1
	    assertEquals(letterConversionService.convert(new int[] {2,1}), null);
	    
	    
	    // scenario 5: input one normal element
	    List<String> expectedResult5 = Arrays.asList(new String[] {"a","b","c"});
	    assertEquals(letterConversionService.convert(new int[] {2}), expectedResult5);
	    
	    // scenario 6: input more than one normal elements: two elements
	    List<String> expectedResult6 = Arrays.asList(new String[] {"ad","ae","af","bd","be","bf","cd","ce","cf"});
	    assertEquals(letterConversionService.convert(new int[] {2,3}), expectedResult6);
	    
	    // scenario 7: input more than one normal elements: three elements
	    List<String> expectedResult7 = Arrays.asList(new String[] {"adg", "adh", "adi", "aeg", "aeh", "aei", "afg", "afh", "afi", "bdg", 
	    "bdh", "bdi", "beg", "beh", "bei", "bfg", "bfh", "bfi", "cdg", "cdh", "cdi", "ceg", "ceh", "cei", "cfg", "cfh", "cfi"});
	    assertEquals(letterConversionService.convert(new int[] {2,3,4}), expectedResult7);
	    
	    
	    // scenario 8 : input element which is bigger than 9
	    List<String> expectedResult8 = Arrays.asList(new String[] {"ad","ae","af","bd","be","bf","cd","ce","cf"});
	    assertEquals(letterConversionService.convert(new int[] {23}), expectedResult8);
		
	    
	    // scenario 9 : input elements some bigger than 9, some smaller than 9
	    List<String> expectedResult9 = Arrays.asList(new String[] {"adg", "adh", "adi", "aeg", "aeh", "aei", "afg", "afh", "afi", "bdg", 
	    	    "bdh", "bdi", "beg", "beh", "bei", "bfg", "bfh", "bfi", "cdg", "cdh", "cdi", "ceg", "ceh", "cei", "cfg", "cfh", "cfi"});
	    assertEquals(letterConversionService.convert(new int[] {23,4}), expectedResult9);
	    
	 // scenario 10: input is empty
	    assertEquals(letterConversionService.convert(new int[] {}), null);
	}

}
