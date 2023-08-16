public class Team implements Weergeefbaar{
    private String naam;
    private int id;
    Team(int id, String naam){
        this.id = id;
        this.naam = naam;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public int getId() {
        return id;
    }
    public String getNaam() {
        return naam;
    }

    public void weergave() {
        System.out.println("ID: "+getId() + "\nNaam: " + getNaam());
    }

}
