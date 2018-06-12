package com.adam;

public class TicTacToeMap {
    private char[] map = {'.','.','.','.','.','.','.','.','.'};

    private char firstPlayerChar = 'X';

    private char secondPlayerChar ='O';

    public TicTacToeMap(){}

    public TicTacToeMap(char firstPlayerChar, char secondPlayerChar){
        this.firstPlayerChar = firstPlayerChar;
        this.secondPlayerChar = secondPlayerChar;
    }

    public void placeCircle(int x,int y){
        int index = x*3+y;
        if (index<map.length) {
            if (map[index] == '.') {
                map[index] = secondPlayerChar;
            }
        }
    }

    public void placeCross(int x,int y){
        int index = x*3+y;
        if (index<map.length) {
            if (map[index] == '.') {
                map[index] = firstPlayerChar;
            }
        }
    }

    public char getItemInPosition(int x,int y){
        int index = x*3+y;
        if (index<map.length) {
            return map[index];
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    public char checkForWiner(){

        for (int i =0;i<map.length/3;i++){
            if (map[i*3]==map[i*3+1] && map[i*3+2]==map[i*3]){
                return map[i*3];
            }
            if (map[i]==map[3+i] && map[i]==map[6+i]){
                return map[i];
            }
        }

        if (map[0]==map[4] && map[0]==map[8]){
            return map[0];
        }

        if (map[2]==map[4] && map[2]==map[6]){
            return map[2];
        }

        for (int i = 0; i<map.length;i++ ){
            if(map[i]=='.'){
                return '.';

            }
        }

        return 'R';
    }

    public char[] getMap(){
        return map;
    }
}
