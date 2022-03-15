package com.bingo.controller;

import com.bingo.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

/**
 * Se crea el ValueCard Controller.
 *
 * @version 1.00.000 2022-03-14
 *
 * @author Santiago Ospina Osorio - santiago.m200@outlook.es
 *
 * @since 1.00.000 2022-03-14
 */
@Slf4j
@RestController
public class ValueCardController {

    private ArrayList columnB = new ArrayList();
    private ArrayList columnI = new ArrayList();
    private ArrayList columnN = new ArrayList();
    private ArrayList columnG = new ArrayList();
    private ArrayList columnO = new ArrayList();


    /**
     * Se crea el Create Value Card.
     *
     * @return the response entity
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 2022-03-14
     */
    public ResponseEntity<Response> createValueCard() {

        try {
            log.info("ValueCard a crear");

        } catch (Exception exc) {

        }
        createColumns();
        showCard();
        fillColumns();
        createBallotRandom();
        return null;
    }

    /**
     * Se crea el metodo createColumns con el objetivo de crear las columnas de la tarjeta del bingo.
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 2022-02-15
     */
    public void createColumns() {

        this.columnB.add("B");
        this.columnI.add("I");
        this.columnN.add("N");
        this.columnG.add("G");
        this.columnO.add("O");

    }

    /**
     * Se crea el metodo showCard con el objetivo de mostrar la tarjeta del bingo con un formato.
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 2022-02-15
     */
    public void showCard() {

        System.out.println("-----------------------------------------");
        for (int i = 0; i < this.columnB.size(); i++) {
            System.out.println("|\t" + this.columnB.get(i) + "\t|\t" + this.columnI.get(i) + "\t|\t" + this.columnN.get(i) + "\t|\t" + this.columnG.get(i) + "\t|\t" + this.columnO.get(i) + "\t|\t");
            System.out.println("-----------------------------------------");
        }

    }

    /**
     * Se crea el metodo fillColumns con el objetivo de crear una tarjeta aleatoria para cada usuario.
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 2022-02-15
     */
    public void fillColumns() {

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            columnB.add(random.nextInt(15));
            columnI.add(random.nextInt(15) + 15);
            columnN.add(random.nextInt(15) + 30);
            columnG.add(random.nextInt(15) + 45);
            columnO.add(random.nextInt(15) + 60);
        }

    }

    /**
     * Se crea el metodo createBallotRandom con el objetivo de crear balotas random.
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 2022-02-15
     */
    public void createBallotRandom() {

        String[] ballots = new String[5];
        ballots[0] = "B";
        ballots[1] = "I";
        ballots[2] = "N";
        ballots[3] = "G";
        ballots[4] = "O";

        Random random = new Random();
        String ballot = ballots[random.nextInt(5)];
        int number = random.nextInt(15);

        switch (ballot) {
            case "B":
                break;
            case "I":
                number += 15;
                break;
            case "N":
                number += 30;
                break;
            case "G":
                number += 45;
                break;
            case "O":
                number += 60;
                break;
        }
    }
}
