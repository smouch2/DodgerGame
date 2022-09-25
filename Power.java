/**
 * Power
 */
public class Power {

    private String image;
    private int width;
    private int height;
    private double x;
    private double y;
    private int speed;

    public Power(double x, double y) {
        this.x = x;
        this.y = y;
        this.width = 32;
        this.height = 32;
        this.image = "assets/power.png";
        this.speed = (int) (3 + Math.random() * 8);
    }
    public void draw(){
        StdDraw.picture(x, y, image, width, height);
        
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
