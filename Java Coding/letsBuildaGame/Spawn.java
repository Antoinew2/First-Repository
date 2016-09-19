package letsBuildaGame;

import java.util.Random;

public class Spawn  {
	private Random PointSpawner= new Random();
	private int pointCounter=0;
	private static Handler handler;
	private HUD hud;
	private int scoreKeep=0;
	private static Random r= new Random();
	private int scoreHelper=0;
	public Spawn(Handler handler,HUD hud)
	{
		this.handler=handler;
		this.hud= hud;
	}

	public void tick()
	{
		
		scoreKeep=HUD.getScore();
		if(PointSpawner.nextInt(1000)==r.nextInt(1000))
		{OnePoint();}
		if(PointSpawner.nextInt(1000)==r.nextInt(1000))
		{HealthPickup();}
		
		if(scoreKeep>scoreHelper)
		{
			scoreHelper+=100;
			if(scoreKeep==scoreHelper)
			{
			hud.setLevel(hud.getLevel()+1);
			}
			
			
			if(hud.getLevel()==2)
			{
				LevelTwo();
				
			}
			else if(hud.getLevel()==3)
			{
				LevelThree();
				//OnePoint();
			}
			else if(hud.getLevel()==4)
			{
				LevelFour();
				//OnePoint();
			} 
			else if(hud.getLevel()==5)
			{
				LevelFive();
				//OnePoint();
			}
			else if(hud.getLevel()==6)
			{
				LevelSix();
				//OnePoint();
			}
		}
	}
	public static void LevelTwo()
	{
		handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.BasicEnemy,handler));
		handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.SmartEnemy,handler));	
	}
	public static void LevelThree()
	{
		handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.BasicEnemy,handler));
		handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.BasicEnemy,handler));
	}
	public static void LevelFour()
	{
		handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.FastEnemy,handler));	
	}
	public static void LevelFive()
	{
		handler.clearEnemies();
		handler.addObject(new EnemyBoss1(Game.WIDTH/2-48,-120,ID.EnemyBoss1,handler));
	}
	public static void LevelSix()
	{
		handler.clearEnemies();
		handler.addObject(new EnemyBoss2(Game.WIDTH/2-48,-120,ID.EnemyBoss2,handler));
	}
	public void LevelSeven()
	{
		
	}
	public void LevelEight()
	{
		
	}
	public void LevelNine()
	{
		
	}
	public void LevelTen()
	{
		
	}
	public void OnePoint()
	{
		handler.addObject(new Points(r.nextInt(Game.WIDTH-150),r.nextInt(Game.HEIGHT-150),ID.Points,handler));
		
	}
	public void TwoPoints()
	{
		handler.addObject(new Points(r.nextInt(Game.WIDTH-150),r.nextInt(Game.HEIGHT-150),ID.Points,handler));
		handler.addObject(new Points(r.nextInt(Game.WIDTH-150),r.nextInt(Game.HEIGHT-150),ID.Points,handler));
	}
	public void ThreePoints()
	{
		handler.addObject(new Points(r.nextInt(Game.WIDTH-150),r.nextInt(Game.HEIGHT-150),ID.Points,handler));
		handler.addObject(new Points(r.nextInt(Game.WIDTH-150),r.nextInt(Game.HEIGHT-150),ID.Points,handler));
		handler.addObject(new Points(r.nextInt(Game.WIDTH-150),r.nextInt(Game.HEIGHT-150),ID.Points,handler));
	}
	public void FourPoints()
	{
		handler.addObject(new Points(r.nextInt(Game.WIDTH-150),r.nextInt(Game.HEIGHT-150),ID.Points,handler));
		handler.addObject(new Points(r.nextInt(Game.WIDTH-150),r.nextInt(Game.HEIGHT-150),ID.Points,handler));
		handler.addObject(new Points(r.nextInt(Game.WIDTH-150),r.nextInt(Game.HEIGHT-150),ID.Points,handler));
		handler.addObject(new Points(r.nextInt(Game.WIDTH-150),r.nextInt(Game.HEIGHT-150),ID.Points,handler));
	}
	public void PointCenter()
	{
		handler.addObject(new Points(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Points,handler));
	}
	public void HealthPickup()
	{
		handler.addObject(new HealthPickup(r.nextInt(Game.WIDTH-150),r.nextInt(Game.HEIGHT-150),ID.HealthPickup,handler));
	}
}
