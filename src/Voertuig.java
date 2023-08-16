public class Voertuig extends Gadget {
    private final int snelheid;
    private final int capaciteit;
    Voertuig(String naam, int id, String omschrijving, int snelheid, int capaciteit){
        super(naam, id, omschrijving);
        this.snelheid = snelheid;
        this.capaciteit = capaciteit;
    }

    @Override
    public void alleInformatie() {
        super.alleInformatie();
        System.out.println("Snelheid: "+ snelheid +" m/s.");
        if(capaciteit == 1){
            System.out.println("Capaciteit: " + capaciteit + " persoon.");
        }
        else{
            System.out.println("Capaciteit: " + capaciteit + " personen.");
        }
    }
}
