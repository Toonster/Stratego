package Board;

public class Surface {
    private boolean accessable;
    private Grond grond;
    private Surface surface;

    public Surface(boolean accessable) {
        this.accessable = accessable;
    }

    public boolean isAccessable(){
        if (surface.equals(grond) && accessable){
            return true;
        }
        return false;
    }
}
