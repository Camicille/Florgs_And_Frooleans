import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Froolean here.
 * Frooleans Kill Boids
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Froolean extends Actor{
    private int timer = 5;
    private int boidsKilled = 0;
    
    public void act(){
        int speed = Greenfoot.getRandomNumber(10);
        int direction = Greenfoot.getRandomNumber(10);
        
        move(speed);
        turn(direction);
        KillBoid();
        timer = timer + 1;
        
        if (timer%5 == 0)
        {
            move(speed);
            turn(direction);
            timer = 0;
        }
    }    
    public void KillBoid() {
            if(isTouching(Boid.class)) {
            boidsKilled = boidsKilled + 1;
            removeTouching(Boid.class);
            Greenfoot.playSound("bubbles_sfx.wav");
            
            getWorld().addObject(new Froolean(), Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
            getWorld().addObject(new Boid(),Greenfoot.getRandomNumber(599), Greenfoot.getRandomNumber(399));
            
            MyWorld myWorld = (MyWorld)getWorld();
            myWorld.countScore(-50);
        }
    }
}

