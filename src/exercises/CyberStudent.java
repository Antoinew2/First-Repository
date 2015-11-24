package exercises;

public class CyberStudent {
public String name;
public boolean Default_is_eating=false;
public boolean Default_is_working=false;
public boolean Default_is_awake=false;
public boolean Default_is_sleeping=true;
public boolean Default_is_dreaming=true;
public boolean Default_is_snoring=false;

public boolean isEating;
public boolean isWorking;
public boolean isAwake;
public boolean isSleeping;
public boolean isDreaming;
public boolean isSnoring;
public String stateone;
public String statetwo;
public CyberStudent( String Studentname )
{
	setName(Studentname);
	isEating = Default_is_eating;
	isWorking=Default_is_working;
	isAwake=Default_is_awake;
	isSleeping=Default_is_sleeping;
	isDreaming=Default_is_dreaming;
	isSnoring=Default_is_snoring;
}
public void setName(String Studentname)
{
	name = Studentname;
}

public void eating()
{
isEating=true;
isWorking=false;
isAwake=true;
isSleeping=false;
isDreaming=false;
isSnoring=false;
}
public void working()
{
	isEating=false;
	isWorking=true;
	isAwake=true;
	isSleeping=false;
	isDreaming=false;
	isSnoring=false;
}
public void awake()
{
	isAwake=true;
	isSleeping=false;
}
public void asleep()
{

	isAwake=false;
	isSleeping=true;
		
}
public void dreaming()
{
	isEating=false;
	isWorking=false;
	isAwake=false;
	isSleeping=true;
	isDreaming=true;
	isSnoring=false;
}
public void snoring()
{
	isEating=false;
	isWorking=false;
	isAwake=false;
	isSleeping=true;
	isDreaming=false;
	isSnoring=true;
}

public void getName()
{
	System.out.print("\n"+"The students name is: "+name );
}
public void getState()
{
	if (isAwake==true)
	{
		stateone= "awake";
		if(isEating==true)
		{
			statetwo="eating";
		}
		else if (isWorking==true )
		{
			statetwo="working";
		}
	}
	else if (isSleeping==true)
	{
	stateone="sleeping";	
		if(isDreaming==true)
		{
		statetwo="dreaming";
		}
		else if (isSnoring==true)
		{
		statetwo="snoring";
		}
	}
	System.out.println("\n"+name+" is "+ stateone+ " and "+statetwo);
}



public static void main(String args[])
{
String Antoine ="Antoine";
CyberStudent student1= new CyberStudent(Antoine);
student1.getName();
student1.getState();
student1.eating();
student1.getName();
student1.getState();
student1.working();
student1.getName();
student1.getState();
student1.snoring();
student1.getName();
student1.getState();
}
}

