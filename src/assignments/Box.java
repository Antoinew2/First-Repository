package assignments;

public class Box{

	public static void main(String[] args){
		int L1=10;
		int W1=5;
		int H1=5;
		int Weight= 2600;
	Box BoxObject= new Box();
		BoxObject.SetValues(L1,W1,H1,Weight);
		System.out.println("The volume is: "+BoxObject.calculateVolume());
		if(Box.calculateDensity()==0)
		{
			System.out.println("Volume cannot be zero there will be a divide by zero error");
		}
		else
		{
			System.out.println("The density is: "+ BoxObject.calculateDensity());
		};
	}
	static int Length;
	static int Width;
	static int Height;
	static int Weight;
	static int Volume;
		public Box()
		{
			Length=0;
			Width=0;
			Height=0;
			Weight=0;
		}
		public void SetValues(int getLength,int getWidth,int getHeight,int getWeight)
		{
			Length=getLength;
			Width=getWidth;
			Height=getHeight;
			Weight=getWeight;
		}
	static int calculateVolume()
	{
		Volume=Length*Width*Height;
			return Volume;
	}
		static int calculateDensity()
		{
			if(Volume==0)
			{
				System.out.println("Volume will divide by zero. Volume must be a whole number");
			return 0;
			}
			else
			{
				return Weight/Volume;
			}
}
}