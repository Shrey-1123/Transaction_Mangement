package com.thread.util;



import com.thread.bean.Word;

public class WordDropper extends Thread
{
	
	
	Word word=new Word();
	
    public WordDropper(Word word) 
    {
	
		this.word=word;
		
	}

	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				
				word.working();
			}
		}
		catch(Exception e)
		{
			
		}
		 
	}

}
