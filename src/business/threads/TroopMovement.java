package business.threads;


import business.entities.*;

import java.util.concurrent.ThreadLocalRandom;

public class TroopMovement {

    private Troop troop;
    private String[][] mapa;

    public TroopMovement(Troop troop, String[][] mapa) {
        this.troop = troop;
        this.mapa = mapa;
    }

    /*@Override
    public synchronized void run() {
        while (true) {
            try {
                Thread.sleep(((Archer)troop).getMovementVelocity());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //drawMap();
            moveTroop();
        }
    }*/



    public void cellIsEmpty() {

    }


    public synchronized void moveTroop(String name) {

        int auxI = -1;
        int auxJ = -1;

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa.length; j++) {
                if (mapa[i][j].equals(name)) {
                    auxI = i;
                    auxJ = j;
                }
            }
        }
        if (auxI != -1) {
            mapa[auxI][auxJ] = "|";
            if (auxJ > 10 && auxJ <= 20 && mapa[auxI + 1][auxJ - 1].equals("|")) {
                auxJ--;
                auxI++;
            } else if (auxJ < 10 && auxJ >= 0 && mapa[auxI + 1][auxJ + 1].equals("|")) {
                auxJ++;
                auxI++;
            } else if (mapa[auxI + 1][auxJ].equals("|")) {
                auxI++;
            } else if (mapa[auxI + 1][auxJ--].equals("|")) {
                auxI++;
                auxJ--;
            } else if (mapa[auxI + 1][auxJ++].equals("|")) {
                auxI++;
                auxJ--;
            }
            mapa[auxI][auxJ] = name;
        }
    }
}
