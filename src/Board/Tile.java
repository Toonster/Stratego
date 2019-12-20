package Board;

public class Tile {
    private char character;
    private Surface surface;

    public Tile (Surface surface){
        this.surface=surface;
    }

    public void draw(){
        System.out.println("|\t|");
    }

    public void update(char character){

    }

    public void clear(){

    }

    public boolean isFree(){
        if (surface.isAccessable()) {
            return true;
        }
        return false;
    }

    public boolean isAccessable(){
        if (surface.isAccessable()){
            return true;
        }
        return false;
    }
}
