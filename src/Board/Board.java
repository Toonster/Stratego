package Board;

import army.unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int HEIGHT = 10;
    private final int WIDTH = 10;
    private Tile[][] gameField = new Tile[HEIGHT][WIDTH];
    private Unit unit;

    public Board() {
    }
    
    public void initializeBoard(){
        for (int i = 0; i < HEIGHT ; i++) {
            for (int j = 0; j < WIDTH; j++) {
                gameField[i][j] = new Tile(GrondSoorten.GROND);
            }
        }
        gameField[2][4] = new Tile(GrondSoorten.WATER);
        gameField[3][4] = new Tile(GrondSoorten.WATER);
        gameField[2][5] = new Tile(GrondSoorten.WATER);
        gameField[3][5] = new Tile(GrondSoorten.WATER);
        gameField[6][4] = new Tile(GrondSoorten.WATER);
        gameField[7][4] = new Tile(GrondSoorten.WATER);
        gameField[6][5] = new Tile(GrondSoorten.WATER);
        gameField[7][5] = new Tile(GrondSoorten.WATER);
    }

    public void draw(){
        System.out.print(" - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println();
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(" | ");
                gameField[x][y].draw();
            }
            System.out.print(" |");
            System.out.println();
            System.out.print(" - - - - - - - - - - - - - - - - - - - - - ");
            System.out.println();
        }
    }

    public void clear(){
       for (int i = 0; i < HEIGHT; i++) {
           for (int j = 0; j < WIDTH; j++) {
               gameField[i][j].removeChar();
           }
        }
       update();
    }

    public List<Unit> update(){
        List<Unit> unitsList = new ArrayList<>();
        for (int i = 0; i < gameField.length; i++) {
            unitsList.add(unit);
        }
        return unitsList;
    }

    public boolean isInBounds(){
       // if (positie is binnen gameField)
        return true;
    }




}
