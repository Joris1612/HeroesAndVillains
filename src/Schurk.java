import java.util.ArrayList;
public class Schurk extends Super implements Zoekbaar {
    private final String evilPlan;
    private Held aartsVijand;
    private final ArrayList<Held> antiVriendenBoek = new ArrayList<>();
    Schurk(String naam, int id, String locatie, String evilPlan, ArrayList<Gadget> gadgets){
        super(naam, id, locatie, gadgets);
        this.evilPlan = evilPlan;
    }
    public void setAartsVijand(Held aartsVijand) {
        this.aartsVijand = aartsVijand;
    }
    public void vijandToevoegen(Held hero){
        antiVriendenBoek.add(hero);
    }
    public void alleInformatie(){
        System.out.println("ID:" +id);
        System.out.println("Held: " +naam);
        System.out.println("Evil plan: " +evilPlan);
        System.out.println("Locatie: "+locatie);
        System.out.println("One-liner: "+oneLiner+ "\n");
        System.out.println("Gadgets:");
        for(Gadget gadget : gadgets) {
            System.out.println(gadget.naam);
        }
        System.out.println("\nVijanden:");
        for (Held held : antiVriendenBoek) {
            System.out.println(held.naam);
        }
        System.out.println("\nAartsvijand: \n" +aartsVijand.naam);
    }
}
