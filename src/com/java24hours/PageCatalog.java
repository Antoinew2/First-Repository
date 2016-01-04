package com.java24hours;

import java.net.*;

public class PageCatalog {
public static void main(String[] arguments)
{
	Homepage[] catalog= new Homepage[5];
	try{
		catalog[0] = new Homepage("Mark Evanier",
				"http://www.newsfromme.com","comic books");
		catalog[1] = new Homepage("Jeff Rients",
				"http://jrients.blogspot.com","gaming");
		catalog[2]= new Homepage("Rogers Cadenhead",
				"http://workbench.cadenhead.org","programming");
		catalog[3]= new Homepage("Juan Cole",
				"http://www.juancole.com","politics");
		catalog[4]= new Homepage("Rafe Coburn",
				"http://www.rc3.org");
		for(int i= 0; i<catalog.length;i++)
		{
			System.out.println(catalog[i].owner+ ": "+
		catalog[i].address+"--"+ catalog[i].category);
		}
	}catch (MalformedURLException e)
	{
		System.out.println("Error: "+ e.getMessage());
	}
}
}
