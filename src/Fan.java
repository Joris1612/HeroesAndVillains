import java.util.ArrayList;

public class Fan extends PowerUp {
    private ArrayList<Super> fanLijst = new ArrayList<>();
    Fan(String naam, int id){
        super(naam, id);
    }
    public void superToevoegen(Super aSuper){
        fanLijst.add(aSuper);
    }
    public void superVerwijderen(Super aSuper){
        fanLijst.remove(aSuper);
    }
    public void alleInformatie(){
        ArrayList<String> superNamen = new ArrayList<>();
        for (Super aSuper : fanLijst) {
            superNamen.add(aSuper.getNaam());
        }
        System.out.println("ID: "+id+"\nNaam: "+naam+
                "\nFan van:");
        for (String naam : superNamen){
            System.out.println(naam);
        }
    }
}
