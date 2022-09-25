/**
 * Laser
 */
public class Laser {

    private String image;
    private int width;
    private int height;
    private double x;
    private double y;
    private int speed;

    public Laser(double x, double y) {
        this.x = x;
        this.y = y;
        this.width = 16;
        this.height = 16;
        this.image = "assets/beam.png";
        this.speed = (int) (3 + Math.random() * 10);
        //isVisible = false;
    }

    public void draw(){
            StdDraw.picture(x, y, image, width, height);
    }
    public void move(){
        this.y -= this.speed;
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
    public boolean isTouchingX( Enemy gameObject ) {
        int hitzone = 24;
        return this.x <= gameObject.getX()+hitzone && gameObject.getX() <= this.x+hitzone;
    }
    public boolean isTouchingY ( Enemy gameObject) {
        int hitzone = 24;
        return this.y <= gameObject.getY()+hitzone && gameObject.getY() <=this.y+hitzone;
    }
    public boolean isTouching( Enemy gameObject) {
        return this.isTouchingX(gameObject) && this.isTouchingY(gameObject);
    }
}