package com.project.anagram.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.project.anagram.Bean.Anagram;
import com.project.anagram.Bean.AreAnagram;
import com.project.anagram.service.*;



@RestController
public class AnagramController {
	@Autowired
	AreAnagram areAnagram;
	@Autowired
	Anagram anagram;
	
	@GetMapping(value="/anagrams/{string1}/{string2}",produces="application/json")
	public ResponseEntity<AreAnagram> checkAnagram1(@PathVariable("string1") String string1,@PathVariable("string2") String string2)
	{
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
	     Matcher m1 = p.matcher(string1);
	     Matcher m2=p.matcher(string2);
	     boolean boolean1 = m1.find();
	     boolean boolean2=m2.find();
	     if(boolean1||boolean2) {
	    	 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	     }
	     
	     boolean b=StringAnagramService1.chkAnagram(string1, string2);
	     areAnagram.setAreAnagram(b);
	    return new ResponseEntity<AreAnagram>(areAnagram, HttpStatus.OK);
		
		
	}
	@GetMapping(value="/anagrams/{string1}",produces="application/json")
	public ResponseEntity<Anagram> checkAnagram2(@PathVariable("string1") String string1)
	{
		
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
	     Matcher m1 = p.matcher(string1);
	     boolean boolean1 = m1.find();
	     if(boolean1) {
	    	 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	     }
		anagram.setAnagram(StringAnagramService2.getallAnagrams(string1));
	     return new ResponseEntity<Anagram>(anagram, HttpStatus.OK);
		
		
	}
}

