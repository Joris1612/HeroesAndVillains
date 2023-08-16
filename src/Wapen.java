public class Wapen extends Gadget {
    private final int powerLevel;
    Wapen(String naam, int id, String omschrijving, int powerLevel){
        super(naam, id, omschrijving);
        this.powerLevel = powerLevel;
    }
    public int getPowerLevel() {
        return powerLevel;
    }
}
