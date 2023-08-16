import java.util.ArrayList;
public class Held extends Super implements Zoekbaar {
    private final String echteNaam;
    private Schurk aartsVijand;
    private final ArrayList<Schurk> antiVriendenBoek = new ArrayList<>();
    Held(String naam, int id, String locatie, String echteNaam, ArrayList<Gadget> gadgets){
        super(naam, id, locatie, gadgets);
        this.echteNaam = echteNaam;
    }
    public void setAartsVijand(Schurk aartsVijand) {
        this.aartsVijand = aartsVijand;
    }
    public void vijandToevoegen(Schurk villain){
        antiVriendenBoek.add(villain);
    }
    public void alleInformatie(){
        System.out.println("ID:" +id);
        System.out.println("Held: " +naam);
        System.out.println("Naam: " +echteNaam);
        System.out.println("Locatie: "+locatie);
        System.out.println("One-liner: "+oneLiner + "\n");
        System.out.println("Gadgets:");
        for(Gadget gadget : gadgets) {
            System.out.println(gadget.naam);
        }
        System.out.println("\nVijanden:");
        for (Schurk schurk : antiVriendenBoek) {
            System.out.println(schurk.naam);
        }
        System.out.println("\nAartsvijand: \n" +aartsVijand.naam);
    }
}
