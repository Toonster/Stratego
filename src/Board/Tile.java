package Board;

public class Tile {
    private char character;
    private Surface surface;
    private GrondSoorten soorten;

    public Tile (Surface surface){
        this.surface=surface;
    }

    public Tile(GrondSoorten soorten) {
        this.soorten = soorten;
    }

    public void draw(){
        System.out.println("|\t|");
    }

    public void update(char character){
        this.character = character;
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


    public void removeChar(){   //clear()
        this.character = ' ';
    }
}
