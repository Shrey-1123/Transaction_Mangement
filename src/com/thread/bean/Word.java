package com.thread.bean;


import java.util.LinkedList;
import java.util.Queue;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.thread.util.Dictionary;

public class Word 
{
	static volatile boolean isTimeCompleted=true;
	static int word_count;
	static int hit_count;

	private static Queue<String> list=new LinkedList<>();
	private int capacity;
	
	private static int score;
	
	public static int getScore() {
		return score;
	}
	
	public Word()
	{
		capacity=1;
		;
	}
	   public boolean full()
	    {
	    	if(list.size()==capacity)
	    	{
	    		return true;
	    	}
	    	else
	    		return false;
	    }
	    
	    public boolean empty()
	    {
	    	if(list.size()==0)
	    	{
	    		return true;
	    	}
	    	else
	    		return false;
	    }
		public synchronized void  working() throws InterruptedException
		{
			
			while(true)
			{

				if(full())
				{
					try 
					{
						wait();
					}
					catch (InterruptedException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				list.add(Dictionary.getRandomWord().toString());
				word_count++;
				System.out.println(list.peek()+" "+word_count);

				Timer timer=new Timer();
				TimerTask task=new TimerTask()
				{

					

					@Override
					public void run() 
					{
						if(isTimeCompleted)
						{
							System.out.println("Time over");
							System.exit(0);
						}
						
						
					}
					
				};
				timer.schedule(task, 5000);

				System.out.println("Type your word within 5 seconds..");
				
				Scanner sc=new Scanner(System.in);
				String text=sc.nextLine();
				isTimeCompleted=false;
				String temp=list.peek();
				if(empty())
				{
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				
				if(text.equals(temp))
				{
					
					hit_count++;
					list.remove();
					score++;
				}
				if(text.equals("*"))
				{
					System.out.println("your final score is:"+score);
					sc.close();
					System.exit(0);
				}

			}
			
		}
		
	
}
