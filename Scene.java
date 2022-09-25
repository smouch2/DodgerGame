/**
 * Scene
 */
import java.util.ArrayList;

public class Scene {
    //instance variables
    private String image;
    private int width;
    private int height;
    public ArrayList<Enemy> monsters;
    private ArrayList<Gem> gems;
    private ArrayList<Power> powers;
    private ArrayList<Laser> lasers;
    private ArrayList<Tank> tanks;
    private Player player;

    public Scene(){
        width = 500;
        height = 350;
        image = "assets/space-background.png";
        monsters = new ArrayList<Enemy>();
        gems = new ArrayList<Gem>();
        powers = new ArrayList<Power>();
        lasers = new ArrayList<Laser>();
        tanks = new ArrayList<Tank>();

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0.0, width);
        StdDraw.setYscale(height, 0.0);
    }
    //draw method
    public void draw(){
        StdDraw.picture(width/2, height/2, image);  //draw background image using center point
        for (Enemy monster : monsters){
            monster.draw();
        }
        for (Gem gem : gems){
            //if (gem.isVisible = true){
            gem.draw();
            //}
        }
        for (Power power : powers){
            power.draw();
        }
        for (Laser laser : lasers){
            //if (Controller.isFiring == true){
            laser.draw();
            //}
        }
        for (Tank tank : tanks){
            tank.draw();
        }
        player.draw();
    }
    public void addMonster(){
        double x = 32 +(Math.random() * (width - 64));
        double y = -32;
        Enemy star = new Enemy(x,y);
        monsters.add(star);
    }
    public void addGem(){
        double x = 32 +(Math.random() * (width - 64));
        double y = -32;
        Gem ruby = new Gem(x,y);
        gems.add(ruby);
    }
    public void addPowerUp(){
        //top of screen generation
        double x = 32 +(Math.random() * (width - 64));
        double y = -32;
        //at monster location generation
        //double x = monster.getX();
        //double y = monster.getY();
        Power power = new Power(x,y);
        powers.add(power);
        //System.out.println("after addPowerUp");
    }
    public void addLaser(){
        double x = player.getX();
        double y = player.getY();
        Laser laser = new Laser(x,y);
        lasers.add(laser);
    }
    public void addTank(){
        double x = 32 + (Math.random() * (width - 64));
        double y = -32;
        Tank tank = new Tank(x,y);
        tanks.add(tank);
    }
    //oxygen tank implementation

    public void update(){
        for (Enemy monster : monsters){
            monster.move();
        }
        for (Gem gem : gems){
            gem.move();
        }
        for (Power power : powers){
            power.move();
        }
        for (Laser laser : lasers){
            laser.move();
        }
        for (Tank tank : tanks){
            tank.move();
        }
    }
    public Player getPlayer(){
        return this.player;
    }
    public void setPlayer (Player player) {
        this.player = player;
    }
    public ArrayList<Enemy> getMonsters() {
        return this.monsters;
    }
    public ArrayList<Gem> getGems() {
        return this.gems;
    }
    public ArrayList<Power> getPowers(){
        //System.out.println("at getPowers");
        return this.powers;
    }
    public ArrayList<Laser> getLasers() {
        return this.lasers;
    }
    public ArrayList<Tank> getTanks() {
        return this.tanks;
    }


}