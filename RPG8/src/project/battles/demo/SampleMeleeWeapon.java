//Author: Pelham Van Cooten
package project.battles.demo;
import project.directors.Character;
import java.awt.Rectangle;

public class Melee {
	private int[] stats;
	int x;
	int y;
	int width;
	int height;
	boolean collided; 
	int uses = 15; 
	boolean pickedUp; 
	boolean drawImage; 
	
	//getBounds is the same for all collidables so it should be in an the collision abstract class
	public Rectangle getBounds(){
		return new Rectangle(x,y,width,height);
	}
	
	//My Collision method which I believe should be in an interface because it is different for projectiles and melee weapons	
	private boolean collision(){
		if(game.enemy.getBounds().intersects(getBounds()) ||
				game.character.getBounds().intersects(getBounds())) collided = true;
		
		if (collided) {
			delayTime(); 
			uses--;
		} 
	}
	
	private void lost(){
		if (uses == 0){
			drawImage = false; //the weapon "dies"
		}
	}

	private void delayTime() {
		// TODO Auto-generated method stub
		//Method to set delay time between uses of melee weapon 
		//E.g. swinging a sword 
	}
	
	private void beingUsed(){
		if (pickedUp){
			this.x = project.directors.Character.positionX;
			this.y = project.directors.Character.positionY;
		}
	}
	
	public Melee(int[] stats){
		this.stats=stats;
	}
}