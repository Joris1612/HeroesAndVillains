public class Gadget extends PowerUp {
    protected final String omschrijving;
    Gadget(String naam, int id, String omschrijving){
        super(naam, id);
        this.omschrijving = omschrijving;
    }
    public void alleInformatie(){
        System.out.println("ID: "+id+"\nNaam: "+naam+
                "\nOmschrijving: "+omschrijving);
    }
}
