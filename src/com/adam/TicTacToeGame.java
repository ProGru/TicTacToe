package com.adam;

import java.util.Scanner;

public class TicTacToeGame {

    public TicTacToeMap ticTacToeMap = new TicTacToeMap();
    Scanner odczyt = new Scanner(System.in);
    int playerRound = 1;


    public void play(){
        boolean isPlay = true;

        showMap();

        while (isPlay){
            imputFromPlayers();
            showMap();
            playerRound = -playerRound;
            if (isSomeoneWin()){
                isPlay = false;
            }
        }

    }

    public void showMap(){

        char[] map = ticTacToeMap.getMap();

        System.out.println("  "+1+" "+2+" "+3);
        char[] letters = {'A','B','C'};

        for (int i = 0;i<map.length;i+=3){
            System.out.println(letters[i/3]+" "+map[i]+"|"+map[i+1]+"|"+map[i+2]);
        }
    }

    public void imputFromPlayers(){
        String userImput;
        if (playerRound==1) {
            System.out.print("Prosze podać pozycje [X] A-C,1-3:");
            userImput = odczyt.nextLine();
            if (!isUserInputCorrect(userImput)){
                showMap();
                System.out.println("Wpisz dokładnie!");
                imputFromPlayers();
            }else{

                int[] parseInput = new int[0];

                try {
                    parseInput = userInputParser(userImput);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (ticTacToeMap.getItemInPosition(parseInput[0],parseInput[1])=='.') {

                    ticTacToeMap.placeCross(parseInput[0],parseInput[1]);
                }else{
                    showMap();
                    System.out.println("Zajete miejsce wybierz inne!");
                    imputFromPlayers();
                }
            }
        }else {
            System.out.print("Prosze podać pozycje [O] A-C,1-3:");
            userImput = odczyt.nextLine();
            if (!isUserInputCorrect(userImput)){
                showMap();
                System.out.println("Wpisz dokładnie!");
                imputFromPlayers();
            }else{

                int[] parseInput = new int[0];

                try {
                    parseInput = userInputParser(userImput);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (ticTacToeMap.getItemInPosition(parseInput[0],parseInput[1])=='.') {

                    ticTacToeMap.placeCircle(parseInput[0], parseInput[1]);
                }else{
                    showMap();
                    System.out.println("Zajete miejsce wybierz inne!");
                    imputFromPlayers();
                }
            }
        }
    }

    public boolean isUserInputCorrect(String userInput){
        String[] tekst = userInput.split(",");
        if (tekst.length!=2) {
            tekst = userInput.split("");
        }
        if (tekst.length!=2) {
            tekst = userInput.split(" ");
        }


        if (tekst.length==2) {
            if (tekst[0].equalsIgnoreCase("A")
                    || tekst[0].equalsIgnoreCase("B")
                    || tekst[0].equalsIgnoreCase("C")) {
                if (Integer.parseInt(tekst[1]) <= 3 || Integer.parseInt(tekst[0]) <= 3) {
                    return true;
                } else {
                    return false;
                }
            } else if (tekst[1].equalsIgnoreCase("A")
                    || tekst[1].equalsIgnoreCase("B")
                    || tekst[1].equalsIgnoreCase("C")) {
                if ( Integer.parseInt(tekst[0]) <= 3) {
                    return true;
                } else {
                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }

    }

    public int[] userInputParser(String userInput) throws Exception {
        String[] tekst = userInput.split(",");
        if (tekst.length!=2) {
            tekst = userInput.split("");
        }
        if (tekst.length!=2) {
            tekst = userInput.split(" ");
        }

        int textValue;
        int notText;

        if (tekst[0].equalsIgnoreCase("A")) {
            textValue = 0;
            notText = 1;
        } else if (tekst[0].equalsIgnoreCase("B")) {
            textValue = 1;
            notText = 1;
        } else if (tekst[0].equalsIgnoreCase("C")) {
            textValue = 2;
            notText = 1;
        }else if (tekst[1].equalsIgnoreCase("A")) {
            textValue = 0;
            notText = 0;
        } else if (tekst[1].equalsIgnoreCase("B")) {
            textValue = 1;
            notText = 0;
        } else if (tekst[1].equalsIgnoreCase("C")){
            textValue = 2;
            notText = 0;
        }else{
            throw new Exception("Bad user input");
        }

        return new int[] { textValue, Integer.parseInt(tekst[notText])-1};
    }

    public boolean isSomeoneWin(){
        char winer = ticTacToeMap.checkForWiner();
        if (winer=='.') {
            return false;
        }else if (winer=='R'){
            System.out.println("No One Win - Draw");
            return true;
        } else {
            System.out.println("Win player with ["+winer+"]");
            return true;
        }

    }
}