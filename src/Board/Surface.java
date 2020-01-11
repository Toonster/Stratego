package Board;

public class Surface {

    private boolean accessable;
    private char character;

    public Surface(boolean accessable, char character) {
        this.accessable = accessable;
        this.character = character;
    }

    public boolean isAccessable(){
        return accessable;
    }

    public char getCharacter(){
        return character;
    }


}
