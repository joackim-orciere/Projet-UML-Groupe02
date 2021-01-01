package road;

public class RedLight extends RoadTrap {

    RedLight(int x, int y) {
        super(x, y);
        name = "RedLight";
    }

    @Override
    public void activeTrap() {
        double d = Math.random();
        if (d <= 0.05) {
            changeHealth(1);
        }
    }
}
