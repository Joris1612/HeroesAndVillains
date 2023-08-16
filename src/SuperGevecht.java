import java.util.Random;
import java.util.Scanner;

public class SuperGevecht implements Vechtbaar, Weergeefbaar {
    private Super winnaar;
    private Super verliezer;
    private final Held held;
    private final Schurk schurk;
    private int heroPowerLevel;
    private int villainPowerLevel;
    private final String vechtMethode;
    SuperGevecht(Held held, Schurk schurk, String vechtMethode){
        this.held = held;
        this.schurk = schurk;
        this.vechtMethode = vechtMethode;
    }

    public Super getVerliezer() {
        return verliezer;
    }

    public Super getWinnaar() {
        return winnaar;
    }

    public void vechten() {
        powerLevelBereken();
        if (vechtMethode.equals("Handmatig")) {
            boolean correcteKeuze = false;
            while (!correcteKeuze) {
                System.out.println("Type de naam in van de winnaar!");
                Scanner scanner = new Scanner(System.in);
                String keuze = scanner.nextLine();
                if (keuze.equals(held.getNaam())) {
                    winnaar = held;
                    verliezer = schurk;
                    correcteKeuze = true;
                }
                else if (keuze.equals(schurk.getNaam())){
                    winnaar = schurk;
                    verliezer = held;
                    correcteKeuze = true;
                }
                else {
                    System.out.println("Deze persoon is niet aan het vechten! Probeer het opnieuw.");
                }
            }
        }
        else{
            winnaarBereken();
        }
    }
    public void fansWisselen(Super winnaar, Super verliezer, Boolean test){
        if(verliezer.getFanLijst().size() == 0){
            if(!test) {
                System.out.println("Deze held heeft al geen fans!");
            }
        }
        else{
            Fan fan = verliezer.getFanLijst().get(0);
                verliezer.fanVerwijderen(fan);
                fan.superVerwijderen(verliezer);
                winnaar.fanToevoegen(fan);
                fan.superToevoegen(winnaar);    
                if(!test) {
                    if (verliezer.getFanLijst().size() == 0) {
                        System.out.println(verliezer.getNaam()+ " is al zijn fans kwijt!");
                    } else {
                        String fanNaam = fan.getNaam();
                        System.out.println(verliezer.getNaam() + " is " + fanNaam + " kwijt als fan!");
                    }
                }
            }
        }
    public void winnaarBereken() {
        Random random = new Random();
        int rng = random.nextInt(101);
        if(rng < 75){
                if(heroPowerLevel > villainPowerLevel){
                    winnaar = held;
                    verliezer = schurk;
                }
                else{
                    winnaar = schurk;
                    verliezer = held;
                }
            }
        else{
            if(heroPowerLevel > villainPowerLevel){
                winnaar = schurk;
                verliezer = held;
            }
            else{
                winnaar = held;
                verliezer = schurk;
            }
        }
    }
    public void powerLevelBereken() {
        heroPowerLevel = held.powerLevelBerekenen();
        villainPowerLevel = schurk.powerLevelBerekenen();
    }
    public void weergave() {
        System.out.println(held.getNaam()+ " vs "+ schurk.getNaam() + "\nWinnaar: "+winnaar.getNaam());
    }
    public void resultaatWeergeven(){
        System.out.println(winnaar.getNaam()+" heeft gewonnen!");
        System.out.println(winnaar.getNaam()+ ": '" +winnaar.roepOneLiner() + "'");
    }
}
