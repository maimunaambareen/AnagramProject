package com.project.anagram.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class StringAnagramService2 {
	static ArrayList<String> list=new ArrayList<String>();
	public static ArrayList<String> getallAnagrams(String arg1) {

		anagrams("",arg1);
		return list;

		}

		public static void anagrams(String perm, String arg1) {

		if(!arg1.isEmpty())
		{
		for(int i=0;i<arg1.length();i++)
		{
		anagrams(perm+arg1.substring(i, i+1),arg1.substring(0,i)+arg1.substring(i+1,arg1.length()));
		}
		}

		else
		{
		list.add(perm+arg1);
			//System.out.println(perm+arg1);
		}
		}
    
}
