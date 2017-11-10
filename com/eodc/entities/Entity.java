package com.eodc.entities;

import com.eodc.physics.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
/**
 * Write a description of class Entity here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Entity
{
    private Rectangle obj;
    private Vector velocity;

    /**
     * Constructor for objects of class Entity
     */
    public Entity(int width, int height) {
        obj = new Rectangle(width, height, Color.WHITE);
    }
    public Rectangle getObj() {
        return obj;
    }
    public double getX() {
        return obj.getX();
    }
    public double getY() {
        return obj.getX();
    }
    public double getVelocity() {
        return velocity.getMagnitude();
    }
    public double getXVelocity() {
        return velocity.getComponents()[0];
    }
    public double getYVelocity() {
        return velocity.getComponents()[1];
    }
}
