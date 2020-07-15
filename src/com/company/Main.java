package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameField field = new GameField();
        System.out.println("Игра началась...");
        // напечатать номера клеток
        field.print();
        Symbol player = Symbol.krestik;
        while (!field.gameOver()) {
            String p = "";
            if (player == Symbol.krestik)
                p = "крестики";
            else
                p = "нолики";
            System.out.println("Ходят " + p);
            while (true) {
                int nomer = poluchieNomera();
                if (field.pustayaKletka(nomer)) {
                    field.sdelayHod(nomer, player);
                    break;
                } else {
                    System.out.println("клетка занята. Введите другую");
                }
            }
            field.print();
            if (player == Symbol.krestik)
                player = Symbol.nolik;
            else
                player = Symbol.krestik;
        }
        System.out.println(field.result());
        System.out.println("Спасибо за игру");
    }

    public static int poluchieNomera() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер клетки");
        int nomer;
        while (true) {
            nomer = scan.nextInt();
            if (nomer < 1 || nomer > 9)
                System.out.println("неверный номер. введит то 1 до 9");
            else
                break;
        }
        return nomer;
    }
}