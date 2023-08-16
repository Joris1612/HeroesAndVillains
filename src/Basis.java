public class Basis extends Gadget {
    private final String locatie;
    Basis(String naam, int id, String omschrijving, String locatie){
        super(naam, id, omschrijving);
        this.locatie = locatie;
    }
    public void alleInformatie() {
        super.alleInformatie();
        System.out.println("Locatie: " + locatie + ".");
    }
}
