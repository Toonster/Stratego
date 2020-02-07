import Board.Tile;
import army.ArmyColor;
import army.unit.Unit;
import common.Game;
import common.Position;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        showMessage("Welcome to Stratego");
        Game game = new Game();


    }

    enum CoordinateAxis {
        X, Y
    }

    static Scanner input = new Scanner(System.in);
    static Random random = new Random();

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static Game startInitializing() {
        Game game = null;
        showMessage("Would you like to load a previous game? (y/n): ");
        String inputAnswer = input.nextLine();
        if (inputAnswer.equalsIgnoreCase("y")) {
            try {
                game = loadGame();
                showMessage("Game ready.");
            } catch (StrategoException e) {
                showMessage(e.getMessage());
            }
        }
        if (inputAnswer.equalsIgnoreCase("n")) {
            game = new Game();
            showMessage("New game started.");
        }
        return game;
    }

    public static Game loadGame() throws StrategoException {
        showMessage("Enter the filename here: ");
        String fileName = input.nextLine();
        Game game;
        try {
            game = (Game) common.FileManager.read(fileName);
        } catch (FileNotFoundException e) {
            throw new StrategoException("File not found.");
        } catch (IOException e) {
            throw new StrategoException("Error parsing data from the file.");
        } catch (Exception e) {
            throw new StrategoException("Exception found, please contact administrator.");
        }
        if (game == null) {
            throw new StrategoException("File is empty.");
        }
        return game;
    }

   /* public static void startingPhase(Game game){
        showMessage("Welcome to the first phase.");
        showMessage("Would you like to use a standard configuration? (y/n): ");
        String inputAnswer = input.nextLine();
        if (inputAnswer.equalsIgnoreCase("y")){
            loadStandardConfig(game);
        }
        while (game.currentArmyHasUnitsToPlace()){
            Unit selectedUnit = selectUnitToPlace(game.getArmyUnitsToPlace());
            Position unitDestination = askPosition();
            try {
                game.placeUnit(selectedUnit, unitDestination);
                gameUpdate(game);
            }catch (StrategoException e){
                e.getMessage();
            }
        }
        return game;
    }

*/

    public static void loadStandardConfig(Game game){
        game.loadArmyConfig();
    }

    public static Unit selectUnitToPlace(List<Unit> unitList){
        showMessage("What unit would you like to place?");
        boolean isValidInput = true;
        int index = 0;
        while (isValidInput){
            try {
                showUnitsToPlace(unitList);
                showMessage("Enter coördinate: ");
                String answer = input.nextLine();
                index = Integer.parseInt(answer);
                if (index < 0 || index >= unitList.size()){
                    throw new IndexOutOfBoundsException();
                }
                isValidInput = false;
            }catch (NumberFormatException e){
                showMessage("Not a number!");
            }catch (IndexOutOfBoundsException e){
                showMessage("Coördinate out of bounds! ");
            }
        }
        return unitList.get(index);
    }

    public static void showUnitsToPlace(List<Unit> unitsToPlace){

    }

    public static Position askPosition() {
        int x = selectCoordinate(CoordinateAxis.X);
        int y = selectCoordinate(CoordinateAxis.Y);
        return new Position(x, y);
    }

    public static int selectCoordinate(CoordinateAxis axis) {
        boolean coordinateIsInvalid = true;
        int coordinate = 0;
        while (coordinateIsInvalid)
            try {
                showMessage("Enter " + axis + " a coordinate: ");
                String answer = input.nextLine();
                coordinate = Integer.parseInt(answer);
                coordinateIsInvalid = false;
            } catch (NumberFormatException e) {
                showMessage("Input is not a number, try again!");
            }
        return coordinate;
    }

    public static void gameUpdate(Game game){
        game.update();
        if (game.getArmyColor().equals(ArmyColor.RED)){
            showDeadUnits(game.getCurrentArmyDeadUnits());
            showDeadUnits(game.getEnemyArmyDeadUnits());
            drawBoard(game.getGamefield());
        }
    }

    public static void showDeadUnits(List<Unit> deadUnits){
        System.out.println(deadUnits);
    }

    public static void drawBoard(Tile [][] gameField) {
        System.out.print(" - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println();
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                System.out.print(" | ");
                gameField[x][y].draw();
            }
            System.out.print(" |");
            System.out.println();
            System.out.print(" - - - - - - - - - - - - - - - - - - - - - ");
            System.out.println();
        }
    }

}
