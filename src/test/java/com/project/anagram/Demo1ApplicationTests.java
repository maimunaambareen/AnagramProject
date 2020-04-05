package com.project.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.anagram.Bean.Anagram;
import com.project.anagram.Bean.AreAnagram;
import com.project.anagram.controller.AnagramController;
import com.project.anagram.service.StringAnagramService1;
import com.project.anagram.service.StringAnagramService2;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class Demo1ApplicationTests {

StringAnagramService1 s1=new StringAnagramService1();
StringAnagramService2 s2=new StringAnagramService2();
@Mock
AnagramController controller=new AnagramController();


	@Test
	public void stringAnagaram1Test() {
	String string1="listen";
	String string2="silent";
	boolean b=true;
		assertEquals(b, s1.chkAnagram(string1, string2));
	}
	
	@Test
	public void testController1()
	{
		AreAnagram areAnagram=new AreAnagram();
		String string1="listen";
		String string2="silent";
		areAnagram.setAreAnagram(s1.chkAnagram(string1, string2));
		Mockito
        .when(controller.checkAnagram1(string1, string2))
        .thenReturn(new ResponseEntity(areAnagram, HttpStatus.OK));
	Anagram anagram=new Anagram();
	anagram.setAnagram(s2.getallAnagrams(string1));
	Mockito
    .when(controller.checkAnagram2(string1))
    .thenReturn(new ResponseEntity(anagram, HttpStatus.OK));
	}

	@Test
	public void testController2()
	{
		String string1="listen*";
		String string2="*silent";
		Mockito
        .when(controller.checkAnagram1(string1, string2))
        .thenReturn(new ResponseEntity(HttpStatus.BAD_REQUEST));
	Mockito
    .when(controller.checkAnagram2(string1))
    .thenReturn(new ResponseEntity(HttpStatus.BAD_REQUEST));
	}
}
