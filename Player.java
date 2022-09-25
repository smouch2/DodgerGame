/**
 * Player
 */
public class Player {

    private String image;
    private int width;
    private int height;
    private double x;
    private double y;
    private int speed;
    public static int powerUp;

    public Player(double x, double y) {
        this.x = x;
        this.y = y;
        this.width = 32;
        this.height = 32;
        this.image = "assets/ship.png";
        this.speed = 10;
    }
    public void draw(){
        StdDraw.picture(x, y, image, width, height);
    }
    public void move(double x, double y) {
        this.y = y;
        this.x = x;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }

    public double getSpeed(){
        return this.speed;
    }
    public static int getPower(){
        return powerUp;
    }
    public int addPower(){
        return powerUp++;
    }
    public int removePower(){
        return powerUp--;
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
    public boolean isTouchingX( Gem gameObject ) {
        int hitzone = 24;
        return this.x <= gameObject.getX()+hitzone && gameObject.getX() <= this.x+hitzone;
    }
    public boolean isTouchingY ( Gem gameObject) {
        int hitzone = 24;
        return this.y <= gameObject.getY()+hitzone && gameObject.getY() <=this.y+hitzone;
    }
    public boolean isTouching( Gem gameObject) {
        return this.isTouchingX(gameObject) && this.isTouchingY(gameObject);
    }
    public boolean isTouchingX( Power gameObject ) {
        int hitzone = 24;
        return this.x <= gameObject.getX()+hitzone && gameObject.getX() <= this.x+hitzone;
    }
    public boolean isTouchingY ( Power gameObject) {
        int hitzone = 24;
        return this.y <= gameObject.getY()+hitzone && gameObject.getY() <=this.y+hitzone;
    }
    public boolean isTouching( Power gameObject) {
        return this.isTouchingX(gameObject) && this.isTouchingY(gameObject);
    }
    public boolean isTouchingX( Tank gameObject ) {
        int hitzone = 24;
        return this.x <= gameObject.getX()+hitzone && gameObject.getX() <= this.x+hitzone;
    }
    public boolean isTouchingY ( Tank gameObject) {
        int hitzone = 24;
        return this.y <= gameObject.getY()+hitzone && gameObject.getY() <=this.y+hitzone;
    }
    public boolean isTouching( Tank gameObject) {
        return this.isTouchingX(gameObject) && this.isTouchingY(gameObject);
    }

}