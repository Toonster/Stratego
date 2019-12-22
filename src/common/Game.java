package common;

import Board.Board;
import Player.Player;
import army.Army;
import army.unit.Bomb;
import army.unit.Unit;

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

    public void start(){
        update();
        swapTurns();
        loadArmyConfig();
        update();

    }

    public void placeArmy(){
       placeUnit();
    }

    public void placeUnit(){
        //currentArmy.placeUnit();
    }
    public void play(){
        processturn();

    }

    public void processturn(){
        swapTurns();
    }

    public void update(){
        board.update();
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
