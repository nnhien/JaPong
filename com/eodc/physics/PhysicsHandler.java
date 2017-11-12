package com.eodc.physics;

import com.eodc.entities.*;
/**
 * Write a description of class PhysicsHandler here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PhysicsHandler
{
    public static boolean hitObject(Ball ball, Platform plat, int playerNum) {
        boolean result = false;
        if (playerNum == 1) {
            result = ball.getY() + ball.HEIGHT >= plat.getY()
            && ball.getY() <= plat.getY() + plat.HEIGHT
            && ball.getX() <= plat.getX()
            && ball.getX() != 0;
        } else {
            result = ball.getY() + ball.HEIGHT >= plat.getY()
            && ball.getY() <= plat.getY() + plat.HEIGHT
            && ball.getX() >= plat.getX()
            && ball.getX() != 800 - ball.WIDTH;
        }
        return result;
    }
    public static double[] calcDeflection(Ball ball, Platform plat) {
        double fXVelocity;
        if (ball.getX() < 400)
            fXVelocity = 770;
        else
            fXVelocity = -770;
        double pVelocity = Math.sqrt(fXVelocity * fXVelocity + ball.getYVelocity() * ball.getYVelocity());
        double fKinEnergy = 0.75 * (1/2.0 * ball.MASS * pVelocity * pVelocity);
        double fVelocity = Math.sqrt(2 * fKinEnergy / ball.MASS) + 110;
        double fYVelocity = Math.sqrt(fVelocity * fVelocity - fXVelocity * fXVelocity);
        if (ball.getY() < plat.getY() + plat.HEIGHT / 2)
            fYVelocity = -fYVelocity;
            
        double[] newVelocity = { fXVelocity, fYVelocity };
        return newVelocity;
    }
}
