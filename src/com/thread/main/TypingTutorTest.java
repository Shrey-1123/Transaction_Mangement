package com.thread.main;



import com.thread.bean.Word;
import com.thread.util.WordDropper;


public class TypingTutorTest
{

	public static void main(String[] args) throws InterruptedException
	{
		
		Word word=new Word();
		Thread t1=new Thread(new WordDropper(word));
		
		
		t1.start();
		

	}

}
