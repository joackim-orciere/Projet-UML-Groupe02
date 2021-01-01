package road;

public abstract class RoadTrap extends Road {

    String name;

    RoadTrap(int x, int y) {
        super(x, y);
    }


    public abstract void activeTrap();
}
