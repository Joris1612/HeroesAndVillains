import java.util.ArrayList;

public class Menu implements Weergeefbaar {
    private String naam;
    private final ArrayList<Lijst> lijst;
    Menu(String naam, ArrayList<Lijst> lijst){
        this.naam = naam;
        this.lijst = lijst;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public ArrayList<Lijst> getLijst() {
        return lijst;
    }
    public String getNaam() {
        return naam;
    }
    public void weergave() {
        for(int i =0; i<lijst.size(); i++){
            System.out.println("" +(i+1) +": "+lijst.get(i).getNaam());
        }
    }
}
