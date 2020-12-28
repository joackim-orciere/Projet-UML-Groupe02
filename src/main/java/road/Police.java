package road;

public class Police extends RoadTrap{

    Police(int x, int y) {
        super(x, y);
        name = "Police";
    }

    @Override
    public void activeTrap() {
        double d = Math.random() ;
        if(d <= 0.05) {
            changeMorale(1);
        }
    }
}
