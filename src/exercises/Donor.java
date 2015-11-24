package exercises;
	/*
	 * File: Donor.java
	 *
	 * Description: This class represents a donor to an
	 *              organization. It stores the donor's name and rating.
	 *              The main() method tests the class's methods.
	 *
	 * Assignment:
	 *            1) Add a new level "low" to this class (in addition to 
	 *                "high", "medium", "none")
	 *             2) Add a new method:
	 *                public void updateRating(double amt){ } which 
	 *                recalculates a donor's rating according to the following 
	 *                schedule:
	 *                a) amt = 0 - none
	 *                b) amt < $100 - low level
	 *                c) amt >= $100 and amt < $1000 - medium level
	 *                d) amt >= $1000 - high level
	 *                updateRating() should change the instance variable: 
	 *                rating to the new value
	 *             3) Modify this template to include an address variable and 
	 *                change the constructor to accept this new variable 
	 *                (along with the parameters). Basically, the object
	 *                stores the donor's name, address and rating
	 *             4) Create a new donor (donor4) with an initial "low" rating,
	 *                a) then let donor4 contribute $150,
	 *                b) print this donor's new rating to the CRT
	 *             5) Modify the rest of the program (as needed) so that it compiles and runs correctly
	 *
	 */

	public class Donor
	{
	    private String name = "no name";
	    private String rating = "none";
	    private int amt = 0;
	    /**
	     * Donor() constructor sets the object's name and rating
	     * @param str -- a String giving the donor's name
	     * @param str2 -- a String giving the donor's rating
	     */
	  public void updateRating(int amount)
	  {
		  if (amount == 0)
		  {
			  rating = "none";
		  }
		  else if(amount < 100)
		  {
			  rating = "low";
		  }
		  else if(amount >= 100 && amount <1000)	  
		  {
		  rating ="medium";
		  }  
		  else if (amount >= 1000)
		  {
		  rating ="high";
		  }
		  
	  }
	  
	  
	  
	    public Donor(String str, String str2,int amount)
	    {
	        name = str;
	        rating = str2;
	        amount=amt;
	    }

	    /**
	     * getName() returns the donor's name
	     * @return a String giving the person's name
	     */
	    public String getName()
	    {
	        return name;
	    }

	    /**
	     * getRating() returns the donor's rating
	     * @return a String giving the person's rating
	     */
	    public String getRating()
	    {
	        if (rating.equals ("high"))
	            return "high";
	        if (rating.equals ("medium"))
	            return "medium";
	        if (rating.equals("low"))
	        	return "low";
	        return "none";
	    }

	    /**
	     * main() creates three Donor instances and tests this
	     *  classes methods.
	     */
	    public static void main (String argv[])
	    {
	        Donor donor1 = new Donor("NewDonor", "high",1001);
	        System.out.println("Donor's name is " + donor1.getName());
	        System.out.println(donor1.getName() + "'s rating is " + donor1.getRating());

	        Donor donor2 = new Donor("NewDonor2", "medium",950);
	        System.out.println("Donor's name is " + donor2.getName());
	        System.out.println(donor2.getName() + "'s rating is " + donor2.getRating());

	        Donor donor3 = new Donor("NewDonor3", "none",0);
	        System.out.println("Donor's name is " + donor3.getName());
	        System.out.println(donor3.getName() + "'s rating is " + donor3.getRating());
	        Donor donor4 = new Donor("NewDonor4","low",150);
	        donor4.updateRating(150);
	        System.out.println("Donor's name is "+ donor4.getName());
	        System.out.println(donor4.getName()+"'s rating is " + donor4.getRating());
	    } // main()
	} // Donor


