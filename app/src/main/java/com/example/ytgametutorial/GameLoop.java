package com.example.ytgametutorial;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameLoop extends Thread {
    private boolean isRunning = false;
    private Game game;
    private SurfaceHolder holder;

    public GameLoop(Game game, SurfaceHolder holder) {
        this.game = game;
        this.holder = holder;
    }

    public double getAvarageUPS() {
        return 0;
    }

    public double getAvarageFPS() {
        return 0;
    }

    public void startLoop() {
        isRunning = true;
        start();
    }

    @Override
    public void run() {
        super.run();

        int updateCount = 0;
        int frameCount = 0;
        long startTime = 0;
        long elapsedTime = 0;
        long sleepTime = 0;

        Canvas canvas;
        startTime = System.currentTimeMillis();
        while (isRunning) {
            //try to update and render
            try {
                canvas = holder.lockCanvas();
                game.update();
                game.draw(canvas);
                holder.unlockCanvasAndPost(canvas);
            }catch (IllegalArgumentException iaex) {
                iaex.printStackTrace();
            }

            //pause, so that not too often, max UPS
            //skip frames to be on time
            //calc avg UPS and FPS
        }
    }
}
