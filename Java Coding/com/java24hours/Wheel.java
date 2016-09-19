package com.java24hours;

public class Wheel {
public static void main (String[] arguments)
{
	String phrase[]= {
			"A STITCH IN TIME SAVES NINE",
			"DON'T EAT THE YELLOW SNOW",
			"JUST DO IT",
			"EVERY GOOD BOY DOES FINE",
			"I WANT MY MTV",
			"I LIKE IKE",
			"PLAY IT AGAIN,SAM",
			"FROSTY THE SNOWMAN",
			"ONE MORE FOR THE ROAD",
			"HOME FIELD ADVANTAGE",
			"VALENTINES DAY MASSACRE",
			"GROVER CLEVELAND OHIO",
			"SPAGHETTI WESTERN",
			"AQAUA TEEN HUNGER FORCE",
			"IT'S A WONDERFUL LIFE"
			};
	int[] letterCount  = new int[26];
	for (int count= 0; count <phrase.length; count++){
		String current = phrase[count];
		char[] letters = current.toCharArray();
		for(int count2 =0; count2 <letters.length;count2++)
		{
			char lett = letters[count2];
			if ( (lett >= 'A')& (lett<= 'Z'))
			{
				letterCount[lett -'A']++;
			}
		}
	}
	for(char count ='A'; count <='Z'; count++)
	{
		System.out.print(count + ": "+
	letterCount[count-'A']+ " ");
		if (count=='M')
		{
			System.out.println();
		}
	}
	System.out.println();
}
}
