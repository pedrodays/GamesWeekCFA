package org.codeforall.iorns.debris;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Car car;
    private Scoreboard scoreboard;
    private Picture gameOver;
    private DebrisFactory debrisFactory;

    public Game (){
        this.car = new Car(this);
        this.scoreboard = new Scoreboard();
        this.debrisFactory = new DebrisFactory(this.car,scoreboard);

        this.gameOver = new Picture(0, 0, "resources/pngtree-game-over-png-transparent-background-in-gradient-png-image_6009300.png");
    }

    public void init() throws InterruptedException {
        while (!car.collided) {
            car.init();
            car.carMovement();
            scoreboard.init();
            debrisFactory.randomGeneratedDebris();
            debrisFactory.moveDebris();
            debrisFactory.checkCollision();
            Thread.sleep(17);
        }
    }
    /*public void fullReset() {
        // Reset car position
        car.carPicture.delete();
        car.carPicture = new Picture(430, 550, "resources/O NOSSO CAR.png");
        car.carPicture.grow(30, 30);
        car.carPicture.draw();

        // Remove the game over image
        gameOver.delete();

        // Reset the score
        Scoreboard.scoreCounter = 0;
        Scoreboard.updateScore();

        // Reset the collision state
        car.collided = false;

        // Start a new game loop
        try {
            init();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
}
