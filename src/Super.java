import java.util.ArrayList;

public abstract class Super implements Weergeefbaar {
    protected String naam;
    protected int id;
    protected String locatie;
    protected String oneLiner = "Ik kan jou wel aan!";
    protected ArrayList<Fan> fanLijst = new ArrayList<Fan>();
    protected final ArrayList<Gadget> gadgets;
    protected int powerLevel;
    public String roepOneLiner(){
        return oneLiner;
    }
    Super(String naam, int id, String locatie, ArrayList<Gadget> gadgets){
        this.naam = naam;
        this.id = id;
        this.locatie = locatie;
        this.gadgets = gadgets;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public void setOneLiner(String oneLiner) {
        this.oneLiner = oneLiner;
    }
    public int getId() {
        return id;
    }
    public String getNaam() {
        return naam;
    }
    public ArrayList<Fan> getFanLijst() {
        return fanLijst;
    }
    public void fanToevoegen(Fan fan){
        fanLijst.add(fan);
    }
    public void fanVerwijderen(Fan fan){
        fanLijst.remove(fan);
    }
    public int powerLevelBerekenen() {
        int powerLevel = 0;
        for(Fan fan : fanLijst){
            powerLevel += 5;
        }
        for(Gadget gadget : gadgets){
            if(gadget.getClass()== Wapen.class){
                powerLevel = ((Wapen) gadget).getPowerLevel();
            }
            else{
                powerLevel += 5;
            }
        }
        this.powerLevel = powerLevel;
        return powerLevel;
    }
    public void weergave() {
        System.out.println("ID: "+id + "\nNaam: " + naam);
    }
}

