package org.codeforall.iorns.debris;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Background background = new Background();
        background.raceTrack.draw();

        Start start = new Start();
        start.displayStartSign();
        start.waitForSpaceBar();

        Game game = new Game();
        game.init();

    }
}
