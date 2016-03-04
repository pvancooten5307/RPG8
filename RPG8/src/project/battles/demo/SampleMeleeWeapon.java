//Author: Pelham Van Cooten
package project.battles.demo;
import project.directors.Character;
import java.awt.Rectangle;

public abstract class SampleMeleeWeapon {
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
	public void collision(){
		if(BattlesScreen.enemy1.getBounds().intersects(getBounds()) ||
				BattlesScreen.char1.getBounds().intersects(getBounds())) collided = true;
		
		if (collided) {
			delayTime(); 
			uses--;
		} 
	
	}
	
	public void lost(){
		if (uses == 0){
			drawImage = false; //the weapon "dies"
		}
	}
	
	public abstract void delayTime(); 
		//Method to set delay time between uses of melee weapon 
		//E.g. swinging a sword 
	
	
	public void beingUsed(){
		if (pickedUp){
			this.x = BattlesScreen.char1.getPositionX();
			this.y = BattlesScreen.char1.getPositionY();
		}
	}
	
	public SampleMeleeWeapon(int[] stats){
		this.stats=stats;
	}
}