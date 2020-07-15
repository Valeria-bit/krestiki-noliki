package com.company;

public class GameField {
    Symbol values[][] = new Symbol[3][3];
    String result="";

    public GameField() {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                values[i][j] = Symbol.empty;
            }
        }
    }

    public void print() {
        System.out.println("-------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print('|');
                if (values[i][j] == Symbol.empty)
                    System.out.print(' ');
                if (values[i][j] == Symbol.krestik)
                    System.out.print('X');
                if (values[i][j] == Symbol.nolik)
                    System.out.print('O');
            }
            System.out.print('|');
            System.out.println();
            System.out.println("-------");
        }
    }

    public boolean pustayaKletka(int n){
        int i, j;
        int[] buf = rasschetIndex(n);
        i = buf[0];
        j = buf[1];
        return this.values[i][j] == Symbol.empty;
    }

    public void sdelayHod(int nomer, Symbol player){
        int i, j;
        int[] buf = rasschetIndex(nomer);
        i = buf[0];
        j = buf[1];
        this.values[i][j] = player;
    }
    private int[] rasschetIndex(int n){
        int c = (n-1) % 3;
        int r = (n-1) / 3 ;
        int[] buf = {r,c};
        return buf;
    }

    public boolean gameOver(){
        if(fieldIsFill()) {
            this.result = "ничья";
            return true;
        }
        if (row_fill(0,Symbol.krestik) || row_fill(1,Symbol.krestik) || row_fill(2,Symbol.krestik)
            || col_fill(0, Symbol.krestik) || col_fill(1, Symbol.krestik) || col_fill(2, Symbol.krestik)
            || diagonal_fill(Symbol.krestik) || diagonal2_fill(Symbol.krestik)){
            this.result = "победили крестики";
            return true;
        }
        if (row_fill(0,Symbol.nolik) || row_fill(1,Symbol.nolik) || row_fill(2,Symbol.nolik)
                || col_fill(0, Symbol.nolik) || col_fill(1, Symbol.nolik) || col_fill(2, Symbol.nolik)
                || diagonal_fill(Symbol.nolik) || diagonal2_fill(Symbol.nolik)){
            this.result = "победили нолики";
            return true;
        }
        return false;
    }

    private boolean row_fill(int n, Symbol s){
        return  (this.values[n][0] == this.values[n][1] && this.values[n][1] == this.values[n][2] && this.values[n][2] == s);
    }

    private boolean col_fill(int n, Symbol s){
        return  (this.values[0][n] == this.values[1][n] && this.values[1][n] == this.values[2][n] && this.values[2][n] == s);
    }

    private boolean diagonal_fill(Symbol s) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j && this.values[i][j] != s) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean diagonal2_fill(Symbol s) {
        return  (this.values[2][0] == this.values[1][1] && this.values[1][1] == this.values[0][2] && this.values[0][2] == s);
    }

    private boolean fieldIsFill(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(this.values[i][j] == Symbol.empty)
                    return false;
            }
        }
        return true;
    }

    public String result(){
        return this.result;
    }

}
