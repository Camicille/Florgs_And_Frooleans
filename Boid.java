
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**;
 * Write a description of class Trial here.
 * 
 * @author (Camille Otillio) 
 * @version (a version number or a date)
 */
public class Boid extends Actor
{
        private int speed = 3;
        private int direction = 3;
        private GreenfootImage image1, image2;
    public Boid()
    {
        image1 = new GreenfootImage("boid.png");
        image2 = new GreenfootImage("boid2.png");
        setImage(image1);
    }
        
        public void act() 
    {
        EatFlorg();
        turnAtEdge();
        playerMove();
        updateImage();
    }  
    public void EatFlorg()
    {
         if(isTouching(Florg.class))
        {
        removeTouching(Florg.class);
        speed = speed + 1;
        Greenfoot.playSound("manama.wav");
        
        CloudWorld cloudWorld = (CloudWorld)getWorld();
        cloudWorld.countScore(20);
    }
}
public void turnAtEdge() {
         if (isAtEdge()) {
               turn(3);
         }
    }
public void playerMove(){
    if (Greenfoot.isKeyDown("left")) {
       turn(-direction);
       move(-speed);
    }
    if (Greenfoot.isKeyDown("right")) {
       turn(speed);
       move(-direction);
    }
}
public void updateImage(){
    if (getImage() == image1){
       setImage(image2);
    }
    else if (getImage() == image2){
   setImage(image1);
}
}
}

