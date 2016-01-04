package letsBuildaGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
public class Player extends GameObject {
	Handler handler;
	public Player(float x, float y, ID id,Handler handler) 
	{
		super(x, y, id);
		this.handler= handler;
		
		
	}
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,32,32);
	}
	
	public void tick() 
	{
		x+=velX;
		y+=velY;
		x= Game.clamp((int)x,0,Game.WIDTH-37);
		y=Game.clamp((int)y,0,Game.HEIGHT-64);
		
		collision();
	}
	public void collision()
	{
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject TempObject = handler.object.get(i);
			if(TempObject.getId()==ID.BasicEnemy||TempObject.getId()==ID.FastEnemy||TempObject.getId()==ID.SmartEnemy)
			{
				
				if(getBounds().intersects(TempObject.getBounds()))
				{
					//collision code
					HUD.Health-=2;
				}
			}
			if(TempObject.getId()==ID.EnemyBoss1)
			{
				if(getBounds().intersects(TempObject.getBounds()))
				{
					HUD.Health-=100;
				}
			}
			if(TempObject.getId()==ID.Points)
				if(getBounds().intersects(TempObject.getBounds()))
				{
			{
				handler.removeObject(TempObject);
				HUD.score+=100;
			}
				}
			if(TempObject.getId()==ID.EnemyBoss2)
			{
				if(getBounds().intersects(TempObject.getBounds()))
				{
					HUD.Health-=100;
				}
			}
			if(TempObject.getId()==ID.HealthPickup)
			{
				if(getBounds().intersects(TempObject.getBounds()))
				{
					handler.removeObject(TempObject);
					HUD.Health+=4;
				}
			}
		}
	}
	
	public void render(Graphics e) 
	{
		if(id==ID.Player)
		{
		e.setColor(Color.white);
		}
		
		e.fillRect((int)x,(int)y,32,32);
		}
	
	

}
