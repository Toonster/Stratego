package army.unit;

import army.Army;
import common.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Unit {

    private int movementSpeed;
    private int strength;
    protected Position position;
    private boolean isAlive = true;
    private Character character;
    private final Rank rank;
    private int visibleForTurns = 0;


    public Unit(int movementSpeed, int power, Character character, Rank rank) {
        this.movementSpeed = movementSpeed;
        this.strength = power;
        this.character = character;
        this.rank = rank;
    }

    public enum Rank {
        BOMB, CAPTAIN, COLONEL, FLAG, GENERAL, LIEUTANENT, MAJOR, MARSHALL, MINER, SCOUT, SERGEANT, SPY
    }

    public int getStrength() {
        return strength;
    }

    public void die() {
        isAlive = false;
        position = null;
    }

    public String toString() {

        return String.format("%s - (%d)\n",this.getClass().getName(),strength);
    }

    public boolean canMoveTo(Position destination) {
        int deltaX = Math.abs(this.position.getX() - destination.getX());
        int deltaY = Math.abs(this.position.getY() - destination.getY());
        return (deltaX <= this.movementSpeed && deltaY == 0) || (deltaY <= this.movementSpeed && deltaX == 0);
    }

    public void place(Position position) {
        this.position = position;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void battle(Unit enemyUnit) {
        if (strength > enemyUnit.strength) {
            this.position = enemyUnit.position;
            enemyUnit.die();
            return;
        }
        if (strength == enemyUnit.strength) {
            enemyUnit.die();
        }
        die();
        enemyUnit.setVisibleToEnemy();
    }

    public void setVisibleToEnemy(){
        visibleForTurns = 3;
    }

    public void updateSVTE(){
        if (visibleForTurns > 0 ){
            this.visibleForTurns--;
        }
    }

    public boolean isVisibleToEnemy(){
        return visibleForTurns > 0;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public boolean isPlaced() {
        return this.isAlive && this.position != null;
    }

    public boolean atPosition(Position position) {
        return this.position.equals(position);
    }

    public List<Position> getPathTo(Position destination) {

        List<Position> destinationPath = new ArrayList<>();

        int xMin = Math.min(this.position.getX(), destination.getX());
        int xMax = Math.max(this.position.getX(), destination.getX());
        int yMin = Math.min(this.position.getY(), destination.getY());
        int yMax = Math.max(this.position.getY(), destination.getY());

        for (int x = xMin; x < xMax + 1; x++) {
            for (int y = yMin; y < yMax + 1; y++) {
                destinationPath.add(new Position(x, y));
            }
        }
        if (destinationPath.size() >= 2) {
            destinationPath.remove(destinationPath.size() - 1);
        }
        destinationPath.remove(0);
        return destinationPath;
    }

    public Character getCharacter() {
        return character;
    }

    public void setChar(Character character) {
        this.character = character;
    }

    public Position getPosition() {
        return position;
    }

    public void remove(){

    }

    public Rank getRank(){
        return this.rank;
    }

    public boolean isDead(){
        return !isAlive;
    }
}