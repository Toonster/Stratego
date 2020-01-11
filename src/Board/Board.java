package Board;

import army.unit.Unit;
import common.Position;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int HEIGHT = 10;
    private final int WIDTH = 10;
    private Tile[][] gameField = new Tile[HEIGHT][WIDTH];
    private Unit unit;

    public Board() {
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                gameField[j][i] = new Tile(new Grond());
            }
        }
        Tile water = new Tile(new Water());
        water.update(water.getSurfaceChar());
        gameField[2][4] = water;
        gameField[3][4] = water;
        gameField[2][5] = water;
        gameField[3][5] = water;
        gameField[6][4] = water;
        gameField[7][4] = water;
        gameField[6][5] = water;
        gameField[7][5] = water;

    }

    public void draw() {
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

    public void clear() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                gameField[i][j].removeChar();
            }
        }
    }

    public void update(List<Unit> units, boolean visible) {
        for (Unit unit : units) {
            char unitchar = unit.isVisibleToEnemy() ? unit.getCharacter() : visible ? unit.getCharacter(): 'X';
            gameField[unit.getX()][unit.getY()].update(unitchar);
        }
    }

    public boolean isInBounds(Position position) {
        if (position.getX() <= 0 && position.getX() < WIDTH && position.getY() <= 0 && position.getY() < HEIGHT) {
            return true;
        }
        return false;
    }

    public boolean freePosition(List<Position> tilePositions){
        if  (tilePositions.isEmpty()){
            return true;
        }boolean available = true;
        for (Position tilePosition: tilePositions) {
            if (!tileIsFree(tilePosition) || !isAccessable(tilePosition)){
                available = false;
            }
        }
        return available;
    }

    public boolean tileIsFree(Position tilePosition) {
        return this.gameField[tilePosition.getX()][tilePosition.getY()].isFree();
    }

    public boolean isAccessable(Position tilePosition){
        return this.gameField[tilePosition.getY()][tilePosition.getY()].isFree();
    }

    public Tile[][] getGameField() {
        return gameField;
    }
}
