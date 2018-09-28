
import greenfoot.*;

public class MyWorld extends greenfoot.World
{
    private int score = 0;
    private int points;
    
    public MyWorld(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(new Boid(),getRandomW(),getRandomH());
        addObject(new Florg(), getRandomW(), getRandomH());
        addObject(new Froolean(), getRandomW(), getRandomH());
        
    }
    public void act()
    {
        countScore(points);
        showScore();
        endMessage();
        //adds Florgs at random (times and locations)
        if (Greenfoot.getRandomNumber(100)<1){
             addObject(new Florg(), getRandomW(), getRandomH());
            }
    }
    public int getRandomW(){
        int randomW = Greenfoot.getRandomNumber(600);
        return(randomW);
    }
    public int getRandomH(){
    int randomH = Greenfoot.getRandomNumber(400);
        return(randomH);
    }
    public void countScore(int points){
       score = score + points;
    }
    public void showScore(){
    showText("Score: " + score, 65, 25);
    }
    public void endMessage(){
    
        if (score <= - 150){
        showText("Sorry Loser Final Score:" + score, 200,300);
        Greenfoot.stop();
        }
        if (score >= 150){
        showText("Wow You Won Final Score:" + score, 200, 300);
        Greenfoot.stop();
        }
    }
}