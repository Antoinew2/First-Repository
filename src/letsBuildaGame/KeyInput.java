package letsBuildaGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import letsBuildaGame.Game.STATE;

/*
** Feel free to copy and paste this into your own project :)
** //Dribo
*/
public class KeyInput extends KeyAdapter {
		
        private Handler handler;
        private int xp, xm, yp, ym; //xm stands for x minus and xp stands for x plus etc.
        Game game;
        public KeyInput(Handler handler,Game game) {
                this.handler = handler;
                this.game= game;
        }
 
        public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
 
                for (int i = 0; i < handler.object.size(); i++) {
                        GameObject tempObject = handler.object.get(i);
 
                        if (tempObject.getId() == ID.Player) {
                               
                                //I collect the numbers before actually set the velocity.
                                //In addition, you can use arrow keys
                                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) ym = 10;
                                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) xm = 10;
                                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) yp = 10;
                                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) xp = 10;
                               
                                //And here I set the velocity
                                tempObject.setVelX(xp - xm);
                                tempObject.setVelY(yp - ym);
                        }
                        
                }
                if(key==KeyEvent.VK_P)
                {
                	if(game.gameState==STATE.Game)
                	{
                	if(Game.pause) Game.pause=false;
                	else Game.pause=true;
                	
                	}
                }
        }
 
        public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
 
                for (int i = 0; i < handler.object.size(); i++) {
                        GameObject tempObject = handler.object.get(i);
 
                        if (tempObject.getId() == ID.Player) {
 
                                //Same story. I collect numbers before I change velocity
                                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) ym = 0;
                                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) xm = 0;
                                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) yp = 0;
                                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) xp = 0;
                               
                                tempObject.setVelX(xp - xm);
                                tempObject.setVelY(yp - ym);
                        }
                }
 
        }
 
}