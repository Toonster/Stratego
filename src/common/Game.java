package common;

import Board.Board;
import Player.Player;
import army.Army;

public class Game {
    private Player currentPlayer;
    private Player enemyPlayer;
    private Army currentArmy;
    private Army enemyArmy;
    private Board board;

    public Game(Player currentPlayer, Player enemyPlayer, Army currentArmy, Army enemyArmy) {
        this.currentPlayer = currentPlayer;
        this.enemyPlayer = enemyPlayer;
        this.currentArmy = currentArmy;
        this.enemyArmy = enemyArmy;
    }

    public Game() {
    }


    public void swapTurns(){
        this.currentPlayer = enemyPlayer;
    }

    public void loadArmyConfig(){
        currentArmy.initializeArmy();
        enemyArmy.initializeArmy();

    }


    public void loadGameState(GameState gamestate){
        gamestate.getCurrentArmy();
        gamestate.getEnemyArmy();
        gamestate.getCurrentPlayer();
        gamestate.getEnemyPlayer();
    }

}
