package com.paperscissorsstonegame;

/**
 * Created by yaoandy107 on 2018/4/12.
 */
public class GameSystem {
    private int myChoice;
    private int computerChoice;
    private int result;

    private int rule[][] = {{2, 0, 1}, {1, 2, 0}, {0, 1, 2}};

    private int random() {
        return (int)(Math.random() * 3 + 1);
    }

    public void setMyChoice(int myChoice) {
        this.myChoice = myChoice;
    }

    private void setComputerChoice(int comChoice) {
        computerChoice = comChoice;
    }

    public int getComputerChoice() {
        return computerChoice;
    }

    private void judge() {
        this.result = rule[this.myChoice - 1][computerChoice - 1];
    }

    public void playGame(int myChoice) {
        this.setMyChoice(myChoice);
        this.setComputerChoice(random());
        this.judge();
    }

    public int getResult() {
        return this.result;
    }

}
