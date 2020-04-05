package com.project.anagram.Bean;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Anagram {
ArrayList<String> anagram;

public ArrayList<String> getAnagram() {
	return anagram;
}

public void setAnagram(ArrayList<String> anagram) {
	this.anagram = anagram;
}


}
