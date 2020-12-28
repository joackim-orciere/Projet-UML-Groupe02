package road;

public class Pothole extends RoadTrap{

    Pothole(int x, int y) {
        super(x, y);
        name = "Pothole";
    }

    @Override
    public void activeTrap() {
        double d = Math.random();
        if(d <= 0.05) {
            changeHydration(2);
            changeSatiety(2);
        }
    }
}
