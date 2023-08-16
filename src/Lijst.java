import java.util.ArrayList;
public class Lijst implements Weergeefbaar {
    private String naam;
    private ArrayList<Weergeefbaar> items;
    Lijst(String naam, ArrayList items){
        this.naam = naam;
        this.items = items;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public String getNaam() {
        return naam;
    }
    public void weergave() {
        for(int i = 0; i<items.size(); i++){
            items.get(i).weergave();
        }
    }
}
