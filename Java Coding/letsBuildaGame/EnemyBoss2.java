package letsBuildaGame;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss2 extends GameObject {
	private Handler handler;
	Random r= new Random();
	private int timer1=50;
	private int timer2=50;
	public EnemyBoss2(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		
	this.handler=handler;
	velX=0;
	velY=2;
	
	}
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,96,96);
	}
	public void tick()
	{
		x+=velX;
		y+=velY;
		if(timer1<=0)
			{
			velY=0; 
			timer2--;
			}
		else timer1--;
		if(timer2<=0)
		{
			if(velX==0)velX=2;
			if(velX>0)
			{
				velX+=10f;
			}
			else if(velX<0)
			{
				velX-=10f;
			}
			velX= Game.clamp((int)velX,-100, 100);
			int spawn = r.nextInt(10);
			if (spawn==0)
			{
				handler.addObject(new EnemyBossBullet((int) x+48,(int) y+48,ID.BasicEnemy,handler));
			}
		}
		//if(y<= 0|| y>=Game.HEIGHT-32) velY *= -1;
		if(x<=0|| x>=Game.WIDTH-96) velX*=-1;	
		
		//handler.addObject(new Trail((int)x,(int)y,ID.Trail,Color.red,96,96,0.01f,handler));
	}
	
	public void render(Graphics g)
	{
		
		g.setColor(Color.red);
		g.fillRect((int)x,(int)y,96,96);
		
	}
}