package business.entities;

import business.GameManager;

import java.awt.*;

public class Base extends Defensive{

    public Base(String name,int posx, int posy, GameManager gameManager, boolean isUser,boolean stop,Color color) {
        super(name,posx,posy,gameManager, isUser,stop,color);
        this.setRange(4);//cuadrados a la redonda posible 5
        this.setLife(30);
        this.setCost(0);
        this.setDamage(6);
        this.setAttackVelocity(1000);
        this.setType("Structure");
        this.setTimeLife(10000);//seg
        this.setColor(Color.BLUE);
    }


    @Override
    public synchronized void run() {


        while (getLife() > 0) {
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (enemyNear() != null && enemyNear().getLife() >= 0.0) {
                atack(enemyNear());
            }

        }
        dieTroop(this);
        stopGame();

    }

}
