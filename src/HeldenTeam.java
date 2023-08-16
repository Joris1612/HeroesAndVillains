import java.util.ArrayList;
public class HeldenTeam extends Team implements Zoekbaar{
    private final ArrayList<Held> ledenLijst;
    HeldenTeam(String naam, int id, ArrayList<Held> ledenLijst ){
        super(id, naam);
        this.ledenLijst = ledenLijst;

    }
    public ArrayList<Held> getLedenLijst() {
        return ledenLijst;
    }

    public void alleInformatie() {
        System.out.println("ID: "+getId() + "\nNaam: " + getNaam());
        System.out.println("Leden lijst:");
        for (Held held : ledenLijst) {
            System.out.println(held.getNaam());
        }
    }

}
