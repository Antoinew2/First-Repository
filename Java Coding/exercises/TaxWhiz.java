package exercises;

public class TaxWhiz
{
	public static void main( String args[] ) {
	
	
	
	double TaxRateL=.0875;
	double TaxRateS=.0475;
	double purchase1=15;
	double purchase2=30;
	double purchase1F;
	double purchase2F;
	TaxWhiz TaxRateLarge = new TaxWhiz(.0875);
	TaxWhiz TaxRateSmall= new TaxWhiz(.0475);
	purchase1F= purchase1 + TaxRateLarge.calcTax(purchase1);
	purchase2F= purchase2 + TaxRateSmall.calcTax(purchase2);
	System.out.println("Thank you for shopping at Family Dollar");
	System.out.println("Subtotal: "+purchase1+"\nTax Rate: "+TaxRateL);
	System.out.println("Tax: "+ TaxRateLarge.calcTax(purchase1));
	System.out.println("Total: "+"$"+ purchase1F);
	System.out.println("\nThank you for shopping at Family Dollar");
	System.out.println("Subtotal: "+purchase2+"\nTax Rate: "+TaxRateS);
	System.out.println("Tax: "+ TaxRateSmall.calcTax(purchase2));
	System.out.println("Total: "+"$"+ purchase2F);
	
	}
		private double taxRate;

    /**
     * TaxWhiz() constructor creates an object with
     *  a given tax rate
     * @param t -- the given tax rate
     */
	
    public TaxWhiz(double t)
    {
        taxRate = t;
    }

    /**
     * calcTax() returns the tax for a given purchase
     * @param purchase -- the given purchase price
     */
    public double calcTax(double purchase)
    {
        return taxRate * purchase;
    }
	
    /**
     * changeTax() changes the current tax
     * @param t -- the change added to the current tax rate
     */
     public void changeTax(double t)
     {
     taxRate= taxRate + 1;
 	 }
	
} // TaxWhiz
