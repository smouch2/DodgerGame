/**
 * Controller
 */
public class Controller {

    public static boolean isFiring;
    //public static boolean pressingSpacebar = false;
    private Player player;
    //private double rSpeed = player.getSpeed();

    public Controller(Player player){
        this.player = player;
    }
    public void onMousePress(){
        if (StdDraw.mousePressed() ){
            double mouseX = StdDraw.mouseX();
            double mouseY = StdDraw.mouseY();
            double playerX = player.getX();
            double playerY = player.getY();
            
            //moves player towards the cursor
            //likely the secret for 'smart' enemies is in here
            /*Hint: find the slope between current position and destination position.
If the slope distance is greater than the player speed, then use speed / distance to find
the ratio and multiply by the destination x and destination y coordinate*/
            /*if ( ((mouseX-playerX)/(mouseY-playerY)) > player.getSpeed()) {
                getRatio();
            }*/


            if (mouseY < playerY ) playerY -= player.getSpeed();
            if (mouseY > playerY ) playerY += player.getSpeed();
            if (mouseX < playerX ) playerX -= player.getSpeed();
            if (mouseX > playerX ) playerX += player.getSpeed();
            player.move(playerX, playerY);
        }
    }

    /*public static boolean isKeyPressed(int VK_SPACE){
        return pressingSpacebar = isKeyPressed(VK_SPACEl);
    }*/
    
        
        
    
    /*public double getRatio(double mouseX, double mouseY){
        double rSpeed = player.getSpeed();
        double ratio = rSpeed/getDistance();
        return (ratio*mouseX, ratio*mouseY);
    }
    public double getDistance(){
        return Math.sqrt( (mouseX-playerX)*(mouseX-playerX) + (mouseY-playerY)*(mouseY-playerY) );
    }
    */
    public void update(){
        onMousePress();
        //isKeyPressed(VK_SPACE);
        /*if ( StdDraw.hasNextKeyTyped() == true ) {
            char key = StdDraw.nextKeyTyped();
            if ( key == ' ') {
                isFiring = true;
                
            }
            //else {
              //  isFiring = false;
            //}
            //second player controls implementation
            /*if ( key == 'w' && Scene.canMove(x,y-1) ) {
                y--;
            }
            else if ( key == 's' && Scene.canMove(x, y+1)) {
                y++;
            }
            else if ( key == 'a' && Scene.canMove(x-1, y)) {
                x--;
            }
            else if ( key == 'd' && Scene.canMove(x+1, y)) {
                x++;
            }
        }*/
    }
    /*public void stopFiring(){
        isFiring = false;
    }*/
}