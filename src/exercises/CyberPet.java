package exercises;

public class CyberPet
{
	 
	/*** Defaults/Constants ***/
   public static final String DEFAULT_SIZE         = "small";
   public static final boolean DEFAULT_IS_EATING   = false;
   public static final boolean DEFAULT_IS_SLEEPING = false;
   public static final boolean DEFAULT_IS_THINKING = true;
   /*** Instance variables ***/
   private String  name;
   private String  size;
   private boolean isEating;
   private boolean isSleeping;
   private boolean isThinking;
   /*** Constructor Methods ***/
   public CyberPet( String petName )
   {
      setName( petName );
      size       = DEFAULT_SIZE;
      isEating   = DEFAULT_IS_EATING;
      isSleeping = DEFAULT_IS_SLEEPING;
      isThinking = DEFAULT_IS_THINKING;
   }
   public CyberPet( String petName, String activity )
   {
      setName( petName );
      size       = DEFAULT_SIZE;
      currentActivity( activity );
   }
   public CyberPet( String petName, String size, String activity )
   {
      setName( petName );
      size       = size;
      currentActivity( activity );
   }
   /*** Transformer or Mutator Methods ***/
   public void setName( String petName )
   {
   	  name = petName;
   }
   public void eat()
   {
      isEating   = true;
      isSleeping = false;
      isThinking = false;
   }
   public void sleep()
   {
      isEating   = false;
      isSleeping = true;
      isThinking = false;
   }
   public void think()
   {
      isEating   = false;
      isSleeping = false;
      isThinking = true;
   }
   /*** Observor or Accessor Methods ***/
   public String getState()
   {
      String state = "Error in state";
      if ( isEating )
         state = "Eating";
      if ( isSleeping )
         state = "Sleeping";
      if ( isThinking )
      	 state = "Thinking";
      return state;
   }
   public String getName()
   {
   	  return name;
   }
   public String getSize()
   {
   	  return size;
   }
   /*** Helper methods ***/
   public void currentActivity( String activity )
   {
   	  if ( activity == "eating" )
   	  {
   	     eat();
   	  }
   	  else if ( activity == "sleeping" )
   	  {
   	  	 sleep();
   	  }
   	  else
   	  {
   	  	 think();
   	  }
   }
   public String encounter( CyberPet otherPet )
   {
	      String phrase;
	      if ( getSize() == "small" )
	      {
	      	 if ( otherPet.getSize() == "big" )
	      	 	phrase = "See yah!";
	      	 else if ( otherPet.getSize() == "small" )
	      	 	phrase = "Let's go to McDonalds!";
	      	 else
	      	 	phrase = "*** unable to determine size of other pet ***";
	      }
	      else if ( getSize() == "big" )
	      {
	      	 if ( otherPet.getSize() == "small" )
	      	 	phrase = "I'm going to eat you!";
	      	 else if ( otherPet.getSize() == "big" )
	      	 	phrase = "Let's go to McDonalds!";
	      	 else
	      	 	phrase = "*** unable to determine size of other pet ***";
	      }
	      else
	      	 phrase = "*** unable to determine size of " + getName();
	      return phrase;
	   }


}