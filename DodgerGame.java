/**
 * DodgerGame
 */
public class DodgerGame {
    private Scene scene;
    private boolean isOver;
    private long startTime;
    private long startTimeGem;
    private long startTimePowerUp;
    private long startTimeLaser;
    private long oxygenTimer;
    private long tankTimer;
    private Controller controller;
    private int timer;
    private int score;
    private int oxygen = 12;


    public static void main(String[] args) {
        DodgerGame game = new DodgerGame();
        while (game.isOver==false){
            game.update();
            game.render();
        }
    }
    /*Create a new Dodger Game*/
    public  DodgerGame() {
        isOver = false;
        scene = new Scene();
        startTime = System.currentTimeMillis();
        Player player = new Player(250, 187.5);
        this.scene.setPlayer(player);
        controller = new Controller(player);
        this.timer = 0;
    }
    public void update(){
        controller.update();
        long now = System.currentTimeMillis();
        //while loop initiated here for timer<60 cutoff for boss fight
        if (now - this.startTime > 250) {
            scene.addMonster();
            this.startTime = now;
        }
        if (now - this.startTimeGem > 5000) {
            //Gem.isVisible = true;
            scene.addGem();
            this.startTimeGem = now;
        }
        //powerup generation on timer
        if (now - this.startTimePowerUp > 10000) {
            scene.addPowerUp();
            this.startTimePowerUp = now;
        }
        if (now - this.startTimeLaser > 300) {
            scene.addLaser();          
            this.startTimeLaser = now;
        }
        if (now - this.oxygenTimer > 1000) {
            oxygen--;
            this.timer++;
            this.oxygenTimer = now;
            if (oxygen == 0) {
                isOver = true;
            }
        }
        if (now - this.tankTimer > 8000) {
            scene.addTank();
            this.tankTimer = now;
        }
        //if (controller.isFiring == true) {
          //  scene.addLaser();
            //this.startTimeLaser = now;
        //}
        
        /*if (Controller.onSpacePress()){
            scene.addLaser();
        }*/
        scene.update();
        Player player = scene.getPlayer();
        //Laser laser = scene.getLasers();
        //Enemy monster = scene.getMonsters();
        
        for (Enemy monster : scene.getMonsters() ) {
            if (player.isTouching(monster) ){
                if (player.getPower() == 0){
                    isOver = true;
                }
                else{player.removePower();}
                
            }
            
            for (Laser laser : scene.getLasers() ) {
                if (laser.isTouching(monster) ){
                    //draw powerup dropped from monster x,y
                    /*double pUpX = monster.getX();
                    double pUpY = monster.getY();
                    scene.addPowerUp(pUpX, pUpY);*/
                    //laser.setX();
                    //laser.setY();
                    monster.setX();
                    monster.setY();
                }
            }
        }
        for (Gem gem : scene.getGems() ) {
            if (player.isTouching(gem) ){
                score++;
                gem.setX();
                gem.setY();                
            }
        }
        for (Power power : scene.getPowers() ) {
            if (player.isTouching(power) ){
                player.addPower();
                power.setX();
                power.setY(); 
            }
        }
        for (Tank tank : scene.getTanks() ) {
            if (player.isTouching(tank) ){
                oxygen = oxygen +5;
                tank.setX();
                tank.setY(); 
            }
        }
        
        

    }
    public int getScore(){
        return score;
    }
    public void render() {
        //game draw code
        scene.draw();
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(64,32, "Time: " + timer);
        StdDraw.text(320,32, "Score: " + score);
        //visual Shield representation
        StdDraw.text(320,54, "Shields: ");
        for (int i=0; i< Player.getPower(); i++){

            StdDraw.rectangle(320 +8*i, 70, 6, 6);
        }
        StdDraw.text(64,64, "Oxygen: " + oxygen);
        //oxygen bar
        /*for (int i= 0; i<oxygen; i--){

            StdDraw.filledRectangle(64 +8*oxygen, 64, 4, 4);
        }*/
        StdDraw.show(100);
    }
}