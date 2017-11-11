package com.eodc.entities;

import com.eodc.physics.*;
import java.util.Random;

/**
 * Write a description of class Ball here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ball extends Entity
{
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    public final int MIN_POS = 0;
    public final int MAX_X_POS = 800;
    public final int MAX_Y_POS = 600;
    public final int MASS = 2;

    private double deltaX;
    private double deltaY;
    public Ball() {
        super(WIDTH, HEIGHT);
        this.setX(400);
    }

    public void start() {
        this.setXVelocity(-400);
        double yVelocity;
        if (this.getY() < 300) {
            yVelocity = -400 * Math.tan(Math.toRadians(165));
            this.setYVelocity(yVelocity);
        }
        else if (this.getY() >= 300) {
            yVelocity = -400 * Math.tan(Math.toRadians(-165));
            this.setYVelocity(yVelocity);
        }
        setDeltas();
    }

    public boolean checkCollision(Platform plat) {
        return PhysicsHandler.hitObject(this, plat);
    }

    public void handleCollision(Platform player) {
        double[] newVelocity = PhysicsHandler.calcDeflection(this, player);
        setXVelocity(newVelocity[0]);
        setYVelocity(newVelocity[1]);
        setDeltas();
    }

    public void setDeltas() {
        deltaX = 1/80.0 * this.getXVelocity();
        deltaY = 1/80.0 * this.getYVelocity();
    }

    public void move() {
        setX(getX() + deltaX);
        setXVelocity(getXVelocity() - deltaX);
        setY(getY() + deltaY);
        setYVelocity(getYVelocity() - deltaY);
    }

    public void stop() {
        resetVelocity();
        setDeltas();
    }
}
