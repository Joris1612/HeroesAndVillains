public abstract class PowerUp implements Weergeefbaar, Zoekbaar{
    protected String naam;
    protected int id;
    PowerUp(String naam, int id){
        this.naam = naam;
        this.id = id;
    }
    public String getNaam() {
        return naam;
    }
    public int getId() {
        return id;
    }
    public void weergave() {
        System.out.println("ID: "+id+ "\nNaam: "+naam);
    }
}
