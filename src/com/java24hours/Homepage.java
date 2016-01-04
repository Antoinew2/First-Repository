package com.java24hours;

import java.net.*;

public class Homepage {
String owner;
URL address;
String category="none";

public Homepage(String inOwner,String inAddress)

	throws MalformedURLException
	{
		owner= inOwner;
		address= new URL(inAddress);
	
	
	
}
	public Homepage (String inOwner,String inAddress,String inCategory)
	throws MalformedURLException{
		
		this(inOwner,inAddress);
		category=inCategory;
		
	}
	
	
}
