import java.util.Random;
import java.util.Scanner;
public class TeamGevecht implements Vechtbaar, Weergeefbaar {
    private Team winnaar;
    private HeldenTeam heroTeam;
    private SchurkenTeam villainTeam;
    private int heroesPowerLevel;
    private int villainsPowerLevel;
    private String vechtMethode;
    TeamGevecht(HeldenTeam heroTeam, SchurkenTeam villainTeam, String vechtMethode){
        this.heroTeam = heroTeam;
        this.villainTeam = villainTeam;
        this.vechtMethode = vechtMethode;
    }
    public void vechten() {
        powerLevelBereken();
        if (vechtMethode.equals("Handmatig")) {
            boolean correcteKeuze = false;
            while (!correcteKeuze) {
                System.out.println("Type de naam in van het winnende team!");
                Scanner scanner = new Scanner(System.in);
                String keuze = scanner.nextLine();
                if (keuze.equals(heroTeam.getNaam())) {
                    winnaar = heroTeam;
                    correcteKeuze = true;
                }
                else if (keuze.equals(villainTeam.getNaam())){
                    winnaar = villainTeam;
                    correcteKeuze = true;
                }
                else {
                    System.out.println("Dit is geen team wat aan het vechten is! Probeer het opnieuw");
                    System.out.println("De opties zijn: " +villainTeam.getNaam()+ " of "+heroTeam.getNaam());
                }
            }
        }
        else{
            winnaarBereken();
        }
    }
    public void winnaarBereken() {
        Random random = new Random();
        int rng = random.nextInt(101);
        if(rng < 75){
            if(heroesPowerLevel >= villainsPowerLevel){
                winnaar = heroTeam;
            }
            else{
                winnaar = villainTeam;
            }
        }
        else{
            if(heroesPowerLevel > villainsPowerLevel){
                winnaar = villainTeam;
            }
            else{
                winnaar = heroTeam;
            }
        }
    }
    public void powerLevelBereken() {
        int heroPowerLevel = 0;
        for(int i = 0; i<heroTeam.getLedenLijst().size(); i++){
            heroPowerLevel += heroTeam.getLedenLijst().get(i).powerLevelBerekenen();
        }
        this.heroesPowerLevel = heroPowerLevel;
        int villainsPowerLevel = 0;
        for(int i = 0; i<villainTeam.getLedenLijst().size(); i++){
            int temp = villainTeam.getLedenLijst().get(i).powerLevelBerekenen();
            villainsPowerLevel += temp;
        }
        this.villainsPowerLevel = villainsPowerLevel;
    }
    public void weergave() {
        System.out.println(heroTeam.getNaam()+ " vs "+ villainTeam.getNaam() + "\nWinnaar: "+winnaar.getNaam());
    }
    public void resultaatWeergeven(){
        System.out.println(winnaar.getNaam()+ " hebben gewonnen!");
    }
}
