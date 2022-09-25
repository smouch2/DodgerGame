/**
 * Tank
 */
public class Tank {

    private String image;
    private int width;
    private int height;
    private double x;
    private double y;
    private int speed;
    
    public Tank (double x, double y) {
        this.x = x;
        this.y = y;
        this.width = 32;
        this.height = 32;
        this.image = "assets/tank.png";
        this.speed = (int) (3 + Math.random() * 10);
        //isVisible = false;
    }
    
    public void draw(){
        //if (Gem.isVisible = true){
            StdDraw.picture(x, y, image, width, height);
        //}
    }
    public void move(){
        this.y += this.speed;
    }

    public double getX(){
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public double setX(){
        return this.x = 700;
    }
    public double setY() {
        return this.y = 700;
    }
    
}
