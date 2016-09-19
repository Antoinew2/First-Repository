package letsBuildaGame;
/* Java Programming Lets build a game
*
* user Real Tuts GML youtube
*/
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable 
{

	public static final int WIDTH=640,HEIGHT=WIDTH/12*9;
	private Thread thread;
	private boolean running = false;
	public static boolean pause = false;
	private static final long serialVersionUID = -1275349743963390807L;
	private Random r;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	public enum STATE
	{
		Menu,Help,Game,End
	}
	
	public static STATE gameState = STATE.Game;//where game state is set when set to Game game starts
	public Game()
	{
		hud= new HUD();
		handler= new Handler();
		menu=new Menu(this,handler,hud);
		
		
		this.addKeyListener(new KeyInput(handler,this));
		this.addMouseListener(menu);
		spawner= new Spawn(handler,hud);
		Player Person= new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player,handler);
		new Window(WIDTH,HEIGHT,"Lets make a Game!",this);
		r= new Random();
		if(gameState==STATE.Game)
		{
			
			handler.addObject(Person);
			//handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player,handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.BasicEnemy,handler));
			handler.addObject(new Points(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.Points,handler));
		}else if(gameState==STATE.End)
		{
			handler.removeObject(Person);
		}
		else
		{
			for(int i =0; i <10;i++)
			{
				handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.MenuParticle,handler));
			}
			
		}
	
		
		
	}
		
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running=true;
	}
	public synchronized void stop()
	{
		try
		{
		thread.join();
		running=false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void run() 
	{
		this.requestFocus();
		long lastTime=System.nanoTime();
		double amountOfTicks =60;
		double ns =1000000000/amountOfTicks;//9 zeros 
		double delta=0;
		long timer=System.currentTimeMillis();
		int frames=0;
		while(running)
		{
			long now = System.nanoTime();
			delta+= (now-lastTime)/ns;
			lastTime = now;
			while(delta>=1)
			{
				tick();
				delta--;
			}
			if(running)
				render();
				frames++;
				
				if(System.currentTimeMillis() - timer>1000)
				{
					timer += 1000;
					System.out.println("FPS: "+frames);
					frames=0;
				}
		}
		stop();
	}
	private void tick()
	{
		
		if(gameState==STATE.Game)
		{
		if(!pause)
		{	
			hud.tick();
			spawner.tick();
			handler.tick();
			if(HUD.Health<=0)
			{
				gameState=STATE.End;
				HUD.Health=100;
				hud.setLevel(1);
				
				handler.clearEnemies();
				//handler.removeObject(Person);
				for(int i =0; i <10;i++)
				{
					handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.MenuParticle,handler));
				}
			}
				
		}
		}
		else if(gameState==STATE.Menu )
		{
			menu.tick();
			handler.tick();
		}
		else if (gameState==STATE.End)
		{
			handler.tick();
		}
		
	}
	private void render()
	{
		BufferStrategy bs= this.getBufferStrategy();
		if(bs==null)
		{
			this.createBufferStrategy(3);
		return;
		}
		Graphics g= bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0,WIDTH,HEIGHT);
		handler.render(g);
		if(pause)
		{
			g.drawString("Paused", 100, 100);
		}
		
		if(gameState==STATE.Game)
		{
			hud.render(g);
		}
		else if(gameState==STATE.Menu|| gameState==STATE.Help|| gameState==STATE.End)
		{
			menu.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	public static int clamp(int var,int min, int max)
	{
		if(var >= max)
		{
			return var=max;
		}
		else if(var<=min)
		{
			return var=min;
		}
		else
		{
			return var;
		}
	}
	public static void main(String args[])
	{
		new Game();
		
	}

	
	
	
}
