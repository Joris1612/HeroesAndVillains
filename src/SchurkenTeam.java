import java.util.ArrayList;
public class SchurkenTeam extends Team implements Zoekbaar {
    private final ArrayList<Schurk> ledenLijst;
    SchurkenTeam(String naam, int id, ArrayList<Schurk> ledenLijst ){
        super(id, naam);
        this.ledenLijst = ledenLijst;

    }
    public ArrayList<Schurk> getLedenLijst() {
        return ledenLijst;
    }

    public void alleInformatie() {
        System.out.println("ID: "+getId() + "\nNaam: " + getNaam());
        System.out.println("Leden lijst:");
        for (Schurk schurk : ledenLijst) {
            System.out.println(schurk.getNaam());
        }
    }
}
