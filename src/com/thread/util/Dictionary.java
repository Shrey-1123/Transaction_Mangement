package com.thread.util;

import java.util.Random;

public enum Dictionary
{
	APPLE,BANANA,MANGO,DIRT,APPRENTICE,POLO,ANKLE,DENMARK;
	
	public static Dictionary getRandomWord()
	{
		Random random=new Random();
		return values()[random.nextInt(values().length)];
	}
	
}
