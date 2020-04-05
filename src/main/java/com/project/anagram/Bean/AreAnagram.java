package com.project.anagram.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AreAnagram {

boolean areAnagram;

public boolean isAreAnagram() {
	return areAnagram;
}

public void setAreAnagram(boolean areAnagram) {
	this.areAnagram = areAnagram;
}




}
