package com.project.anagram.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StringAnagramService1 {

	public static boolean  chkAnagram(String string1, String string2) 
    { 
        String str1[]=string1.split("");
        String str2[]=string2.split("");
		int length1 = str1.length; 
        int length2 = str2.length; 
  
       
        if (length1 != length2)
            return false; 
  
        Arrays.sort(str1); 
        Arrays.sort(str2); 
        for (int i = 0; i < length1; i++) {
            if (!(str1[i].equalsIgnoreCase(str2[i]))) 
                return false; 
        }
        return true; 
    } 
}
