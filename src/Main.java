// import array list en scanner
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Vijand toevoegen aan beide kanten van het vriendenboek.
    public static void vijandToevoegen(Super superA, Super superB) {
        if (superA.getClass() == Held.class) {
            ((Held) superA).vijandToevoegen((Schurk) superB);
            ((Schurk) superB).vijandToevoegen((Held) superA);
        } else if (superA.getClass() == Schurk.class) {
            ((Schurk) superA).vijandToevoegen((Held) superB);
            ((Held) superB).vijandToevoegen((Schurk) superA);
        } else {
            System.out.println("Deze Supers zijn geen vijanden van elkaar!");
        }
    }
    // Fans toevoegen aan lijst voor Supers, en andersom.
    public static void fanLijstToevoegen(Super Super, Fan fan) {
        Super.fanToevoegen(fan);
        fan.superToevoegen(Super);
    }
    // Aarstvijand toevoegen
    public static void aartsVijandToevoegen(Super superA, Super superB) {
        if (superA.getClass() == Held.class) {
            ((Held) superA).setAartsVijand(((Schurk) superB));
            ((Schurk) superB).setAartsVijand(((Held) superA));
        } else if (superA.getClass() == Schurk.class) {
            ((Schurk) superA).setAartsVijand(((Held) superB));
            ((Held) superB).setAartsVijand(((Schurk) superA));
        } else {
            System.out.println("Deze Supers zijn geen vijanden van elkaar!");
        }
    }
    // statische lijsten aanmaken voor het gebruik in de menus en gevecht aanmaken
    public static ArrayList alleHelden;
    public static ArrayList alleSchurken;
    public static ArrayList alleHeldenNamen;
    public static ArrayList alleSchurkenNamen;
    public static ArrayList alleHeldenTeams;
    public static ArrayList alleSchurkenTeams;
    public static ArrayList alleHeldenTeamsNamen;
    public static ArrayList alleSchurkenTeamsNamen;
    public static ArrayList alleFans;
    public static ArrayList alleFansNamen;
    public static ArrayList alleGadgets;
    public static ArrayList alleGadgetsNamen;
    public static ArrayList alleGevechten;
    public static Menu supersTeamsMenu;
    public static Menu gadgetsMenu;
    public static Menu vechtenMenu;

    // Methode voor het casten van (Super) helden naar (Held) helden
    public static ArrayList<Held> heldCasten(ArrayList<Super> lijst){
        ArrayList<Held> heldenLijst = new ArrayList<>();
        for (Super aSuper : lijst) {
            heldenLijst.add((Held) aSuper);
        }
        return heldenLijst;
    }
    // Methode voor het casten van (Super) schurken naar (Schurk) schurken
    public static ArrayList<Schurk> schurkCasten(ArrayList<Super> lijst){
        ArrayList<Schurk> schurkenLijst = new ArrayList<>();
        for(Super aSuper : lijst){
            schurkenLijst.add((Schurk) aSuper);
        }
        return schurkenLijst;
    }

    // Methode voor het ophalen van de namen van Supers

    public static ArrayList<String> naamOphalenSupers(ArrayList<Super> lijst){
        ArrayList<String> namenLijst = new ArrayList<>();
        for (Super aSuper : lijst) {
            namenLijst.add(aSuper.getNaam());
        }
        return namenLijst;
    }

    //methode voor het ophalen van de namen van Powerups
    public static ArrayList<String> naamOphalenPowerUps(ArrayList<PowerUp> lijst){
        ArrayList<String> namenLijst = new ArrayList<>();
        for(PowerUp powerUp : lijst){
            namenLijst.add(powerUp.getNaam());
        }
        return namenLijst;
    }

    // getters om alle statische lijsten te vullen
    public static void getAlleMenus (Menu supersTeamsMenus, Menu gadgetsMenus, Menu vechtenMenus){
        supersTeamsMenu = supersTeamsMenus;
        gadgetsMenu = gadgetsMenus;
        vechtenMenu = vechtenMenus;
    }
    public static void getAlleLijsten(ArrayList alleHeldenLijst, ArrayList alleFansLijst, ArrayList alleSchurkenLijst, ArrayList alleGadgetsLijst, ArrayList alleHeldenTeamsLijst, ArrayList alleSchurkenTeamsLijst, ArrayList alleGevechtenLijst){
        alleHelden = alleHeldenLijst;
        alleSchurken = alleSchurkenLijst;
        alleFans = alleFansLijst;
        alleGadgets = alleGadgetsLijst;
        alleHeldenTeams = alleHeldenTeamsLijst;
        alleSchurkenTeams = alleSchurkenTeamsLijst;
        alleGevechten = alleGevechtenLijst;
    }
    public static void getAlleNamen(ArrayList alleHeldenNamenLijst, ArrayList alleSchurkenNamenLijst, ArrayList alleFansNamenLijst, ArrayList alleGadgetsNamenLijst, ArrayList alleHeldenTeamsNamenLijst, ArrayList alleSchurkenTeamsNamenLijst){
        alleHeldenNamen = alleHeldenNamenLijst;
        alleSchurkenNamen = alleSchurkenNamenLijst;
        alleFansNamen = alleFansNamenLijst;
        alleGadgetsNamen = alleGadgetsNamenLijst;
        alleHeldenTeamsNamen = alleHeldenTeamsNamenLijst;
        alleSchurkenTeamsNamen = alleSchurkenTeamsNamenLijst;
    }

    // Hoofdmenu
    public static void hoofdMenu(){
        boolean correcteKeuze = false;
        while(!correcteKeuze){
            System.out.println("1: Alle supers en teams menu");
            System.out.println("2: Gadgets menu");
            System.out.println("3: Vechten menu");
            System.out.println("4: Zoeken");
            System.out.println("5: Stoppen");
            System.out.println("Wat wilt u doen?");
            Scanner gebruikerKeuze = new Scanner(System.in);
            int keuze = gebruikerKeuze.nextInt();
            switch (keuze) {
                case 1:
                    subMenu(supersTeamsMenu);
                case 2:
                    subMenu(gadgetsMenu);
                case 3:
                    subMenu(vechtenMenu);
                case 4:
                    zoeken();
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Ongeldige keuze.");
                    break;
            }
        }
    }

    // submenu
    public static void subMenu(Menu menu) {
        while (true) {
            if (menu.getNaam().equals("Alle supers en teams menu")) {
                for (int i = 0; i < menu.getLijst().size(); i++) {
                    System.out.println("" + (i + 1) + ": " + menu.getLijst().get(i).getNaam());
                }
                System.out.println("Wat wilt u doen?");
                Scanner gebruikerKeuze = new Scanner(System.in);
                int keuze = gebruikerKeuze.nextInt();
                switch (keuze) {
                    case 1:
                        menu.getLijst().get(0).weergave();
                        subMenu(menu);
                    case 2:
                        menu.getLijst().get(1).weergave();
                        subMenu(menu);
                    case 3:
                        menu.getLijst().get(2).weergave();
                        subMenu(menu);
                    case 4:
                        menu.getLijst().get(3).weergave();
                        subMenu(menu);
                    case 5:
                        zoeken();
                    case 6:
                        hoofdMenu();
                    default:
                        System.out.println("Ongeldige keuze.");
                        break;
                }
            }
            else if (menu.getNaam().equals("Gadgets menu")) {
                for (int i = 0; i < menu.getLijst().size(); i++) {
                    System.out.println("" + (i + 1) + ": " + menu.getLijst().get(i).getNaam());
                }
                System.out.println("Wat wilt u doen?");
                Scanner gebruikerKeuze = new Scanner(System.in);
                int keuze = gebruikerKeuze.nextInt();
                switch (keuze) {
                    case 1:
                        menu.getLijst().get(0).weergave();
                        subMenu(menu);
                    case 2:
                        zoeken();
                    case 3:
                        hoofdMenu();
                    default:
                        System.out.println("Ongeldige keuze.");
                        break;
                }
            }
            else if (menu.getNaam().equals("Vechten menu")) {
                for (int i = 0; i < menu.getLijst().size(); i++) {
                    System.out.println("" + (i + 1) + ": " + menu.getLijst().get(i).getNaam());
                }
                System.out.println("Wat wilt u doen?");
                Scanner gebruikerKeuze = new Scanner(System.in);
                int keuze = gebruikerKeuze.nextInt();
                switch (keuze) {
                    case 1:
                        menu.getLijst().get(0).weergave();
                        subMenu(menu);
                    case 2:
                        System.out.println("1: 1 tegen 1 \n2: team tegen team");
                        int vs = gebruikerKeuze.nextInt();
                        if(vs == 1){
                            supersGevechtAanmaken();
                        }
                        else if (vs == 2) {
                            teamsGevechtAanmaken();
                        }
                        else{
                            System.out.println("Selecteer een optie door een nummer te kiezen");
                        }
                    case 3:
                        zoeken();
                    case 4:
                        hoofdMenu();
                    default:
                        System.out.println("Ongeldige keuze.");
                        break;
                }
            }
        }
    }
    // Zoek functie die alle informatie aanbied
    public static void zoeken() {
        System.out.println("Waar wilt u meer over weten?");
        System.out.println("1: Helden\n2: Schurken\n3: Fans\n4: Gadgets\n5: Terug\n6: Stopppen");
        Scanner gebruikerKeuze = new Scanner(System.in);
        int keuze = gebruikerKeuze.nextInt();
        switch (keuze) {
            case 1:
                Held hero = (Held) kiesItem(alleHelden, alleHeldenNamen, "held");
                hero.alleInformatie();
                break;
            case 2:
                Schurk schurk = (Schurk) kiesItem(alleSchurken, alleSchurkenNamen, "schurk");
                schurk.alleInformatie();
                break;
            case 3:
                Fan fan = (Fan) kiesItem(alleFans, alleFansNamen, "fan");
                fan.alleInformatie();
                break;
            case 4:
                Gadget gadget = (Gadget) kiesItem(alleGadgets, alleGadgetsNamen, "gadget");
                gadget.alleInformatie();
                break;
            case 5:
                hoofdMenu();
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Ongeldige keuze.");
                break;
        }
    }
    // Methode voor het kiezen van een item om meer informatie over te laten zien
    public static Object kiesItem(List<Object> objecten, List<String> namen, String type) {
        boolean correcteInput = false;
        Object item = null;
        while (!correcteInput) {
            toonLijst(namen);
            System.out.printf("Kies een %s:%n", type);
            Scanner gebruikersInput = new Scanner(System.in);
            String input = gebruikersInput.nextLine();
            int index = namen.indexOf(input);
            if (index >= 0) {
                item = objecten.get(index);
                correcteInput = true;
            } else {
                System.out.printf("Type de naam in van een %s!%n", type);
            }
        }
        return item;
    }
    // Methode om een lijst te laten zien van alle objecten van de klassen
    public static void toonLijst(List<String> namen) {
        for (String naam : namen) {
            System.out.println(naam);
        }
    }
    // Hoofd methode voor het aanmaken van een 1 op 1 gevecht.
    public static void supersGevechtAanmaken() {
        Scanner gebruikerKeuze = new Scanner(System.in);
        Held hero = kiesHeld(gebruikerKeuze);
        Schurk villain = kiesSchurk(gebruikerKeuze);
        String vechtMethode = selecteerVechtMethode(gebruikerKeuze);
        SuperGevecht SuperGevecht = new SuperGevecht(hero, villain, vechtMethode);
        SuperGevecht.vechten();
        SuperGevecht.fansWisselen(SuperGevecht.getWinnaar(), SuperGevecht.getVerliezer(), false);
        SuperGevecht.resultaatWeergeven();
        alleGevechten.add(SuperGevecht);
        hoofdMenu();
    }
    // Methode om een held te kiezen voor het 1 op 1 gevecht.
    public static Held kiesHeld(Scanner gebruikerKeuze) {
        while (true) {
            for (int i = 0; i < alleHelden.size(); i++) {
                System.out.println(alleHeldenNamen.get(i));
            }
            System.out.println("Kies een held:");
            String keuze = gebruikerKeuze.nextLine();
            for (int j = 0; j < alleHelden.size(); j++) {
                if (keuze.equals(alleHeldenNamen.get(j))) {
                    return (Held) alleHelden.get(j);
                }
            }
            System.out.println("Type de naam in van een held!");
        }
    }
    // Methode om een schurk te kiezen voor het 1 op 1 gevecht.
    public static Schurk kiesSchurk(Scanner gebruikerKeuze) {
        while (true) {
            for (int i = 0; i < alleSchurken.size(); i++) {
                System.out.println(alleSchurkenNamen.get(i));
            }
            System.out.println("Kies een schurk:");
            String keuze = gebruikerKeuze.nextLine();
            for (int j = 0; j < alleSchurken.size(); j++) {
                if (keuze.equals(alleSchurkenNamen.get(j))) {
                    return (Schurk) alleSchurken.get(j);
                }
            }
            System.out.println("Type de naam in van een schurk!");
        }
    }
    // hoofd methode om teams gevecht aan te maken
    public static void teamsGevechtAanmaken(){
        Scanner gebruikerKeuze = new Scanner(System.in);
        HeldenTeam heroTeam = selecteerHeroesTeam(gebruikerKeuze);
        SchurkenTeam schurkenTeam = selecteerSchurkenTeam(gebruikerKeuze);
        String vechtMethode = selecteerVechtMethode(gebruikerKeuze);
        TeamGevecht teamGevecht = new TeamGevecht(heroTeam, schurkenTeam, vechtMethode);
        teamGevecht.vechten();
        teamGevecht.resultaatWeergeven();
        alleGevechten.add(teamGevecht);
        hoofdMenu();
    }
    // Methode om een helden team te selecteren voor team gevecht
    private static HeldenTeam selecteerHeroesTeam(Scanner gebruikerKeuze) {
        boolean correcteKeuze = false;
        boolean typeFout = true;
        HeldenTeam heroTeam = null;
        while (!correcteKeuze) {
            for (int i = 0; i < alleHeldenTeams.size(); i++) {
                System.out.println(alleHeldenTeamsNamen.get(i));
            }
            System.out.println("Kies een helden team:");
            String keuze = gebruikerKeuze.nextLine();
            for (int j = 0; j < alleHeldenTeams.size(); j++) {
                if (keuze.equals(alleHeldenTeamsNamen.get(j))) {
                    heroTeam = (HeldenTeam) alleHeldenTeams.get(j);
                    correcteKeuze = true;
                    typeFout = false;
                }
            }
            if (typeFout) {
                System.out.println("Type de naam in van het team!");
            }
        }
        return heroTeam;
    }
    // Methode om een schurken team te selecteren voor het team gevecht
    private static SchurkenTeam selecteerSchurkenTeam(Scanner gebruikerKeuze) {
        boolean correcteKeuze = false;
        boolean typeFout = true;
        SchurkenTeam schurkenTeam = null;
        while (!correcteKeuze) {
            for (int i = 0; i < alleSchurkenTeams.size(); i++) {
                System.out.println(alleSchurkenTeamsNamen.get(i));
            }
            System.out.println("Kies een schurken team:");
            String keuze = gebruikerKeuze.nextLine();
            for (int j = 0; j < alleSchurkenTeams.size(); j++) {
                if (keuze.equals(alleSchurkenTeamsNamen.get(j))) {
                    schurkenTeam = (SchurkenTeam) alleSchurkenTeams.get(j);
                    correcteKeuze = true;
                    typeFout = false;
                }
            }
            if (typeFout) {
                System.out.println("Type de naam in van het team");
            }
        }
        return schurkenTeam;
    }
    // Methode om een vechtmethode te kiezen voor het team gevecht(Handmatig of het programma laten berekenen)
    private static String selecteerVechtMethode(Scanner gebruikerKeuze) {
        String vechtMethode = "";
        boolean correcteKeuze = false;
        while (!correcteKeuze) {
            System.out.println("Wilt u zelf kiezen wie wint, of ze eerlijk laten vechten?");
            System.out.println("1: Zelf kiezen");
            System.out.println("2: Eerlijk laten vechten");

            int keuze;
            try {
                keuze = Integer.parseInt(gebruikerKeuze.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Voer een getal in!");
                continue;
            }
            if (keuze == 1) {
                vechtMethode = "Handmatig";
                correcteKeuze = true;
            } else if (keuze == 2) {
                vechtMethode = "Berekenen";
                correcteKeuze = true;
            } else {
                System.out.println("Kies een van de opties door een nummer in te voeren!");
            }
        }
        return vechtMethode;
    }
    // Main methode
    public static void main(String[] args) {
        //Fans aanmaken
        PowerUp Harry = new Fan("Harry de Wit", 1);
        PowerUp Bert = new Fan("Bert Janssen", 2);
        PowerUp Fred = new Fan("Fred Freddington", 3);
        PowerUp Marie = new Fan("Marie de Wit", 4);
        PowerUp Ash = new Fan("Ashleigh heidmann", 5);
        PowerUp Cosmo = new Fan("Cosmo de hond", 6);
        PowerUp Blaze = new Fan("Blaze de kat", 7);
        PowerUp Luna = new Fan("Luna Heidmann", 8);
        PowerUp Phoenix = new Fan("Phoenix de vogel", 9);
        PowerUp zekerNietAsh = new Fan("Zeker niet Ashleigh", 10);
        // Gadgets aanmaken (met invoeging in een lijst voor het koppelen aan een Super)
        PowerUp batmobiel = new Voertuig("Bat mobiel", 1, "De auto van batman", 100, 2);
        PowerUp batarang = new Wapen("Batarang", 2, "De boomerang van Batman", 100);
        ArrayList<Gadget> batmansGadgets = new ArrayList<>();
        batmansGadgets.add((Gadget) batmobiel);
        batmansGadgets.add((Gadget) batarang);
        PowerUp oogVanAgamotto = new Wapen("Oog van Agamotto", 3, "Het wapen van Doctor Strange", 300);
        PowerUp sanctumSanctorum = new Basis("Sanctum Sanctorum", 4, "De basis van Doctor Strange", "Multiverse");
        ArrayList<Gadget> doctorStrangesGadgets = new ArrayList<>();
        doctorStrangesGadgets.add((Gadget) oogVanAgamotto);
        doctorStrangesGadgets.add((Gadget) sanctumSanctorum);
        PowerUp webShooter = new Wapen("Web schieter", 5, "Spiderman's web schieter" , 150);
        PowerUp spiderDrone = new Voertuig("Spider Drone", 6, "Spiderman's auto", 150, 1);
        ArrayList<Gadget> spidermansGadgets = new ArrayList<>();
        spidermansGadgets.add((Gadget) webShooter);
        spidermansGadgets.add((Gadget) spiderDrone);
        PowerUp blueLightsaber = new Wapen("Lightsaber", 7, "Obi=Wan's lightsaber" , 150);
        PowerUp starFighter = new Voertuig("Star Fighter", 8, "Obi-Wan's Star Fighter", 100000, 1);
        ArrayList<Gadget> obiwansGadgets = new ArrayList<>();
        obiwansGadgets.add((Gadget) blueLightsaber);
        obiwansGadgets.add((Gadget) starFighter);
        PowerUp superCostume = new Wapen("Super kostuum", 9, "Superman's kostuum", 200);
        PowerUp superMobile = new Voertuig("Super mobiel", 10, "Superman's auto", 150, 1);
        ArrayList<Gadget> supermansGadgets = new ArrayList<>();
        supermansGadgets.add((Gadget) superCostume);
        supermansGadgets.add((Gadget) superMobile);
        PowerUp adamantiumSkeleton = new Wapen("Adamantium skelet", 11, "Wolverine's adamantium skelet", 200);
        PowerUp adamantiumClaws = new Wapen("Adamantium klauwen", 12, "Wolverine's adamantium klauwen", 200);
        ArrayList<Gadget> wolverinesGadgets = new ArrayList<>();
        wolverinesGadgets.add((Gadget) adamantiumClaws);
        wolverinesGadgets.add((Gadget) adamantiumSkeleton);
        PowerUp lassoOfTruth = new Wapen("Lasso van waarheid", 13, "Wonder woman's lasso", 170);
        PowerUp invisiblePlane = new Voertuig("Onzichtbaar vliegtuig", 14, "Wonder woman's onzichtbare vliegtuig", 1000, 4);
        ArrayList<Gadget> wonderwomansGadgets = new ArrayList<>();
        wonderwomansGadgets.add((Gadget) lassoOfTruth);
        wonderwomansGadgets.add((Gadget) invisiblePlane);
        PowerUp greenLightsaber = new Wapen("Lightsaber", 15, "Yoda's lightsaber", 160);
        PowerUp forcefield = new Wapen("Krachtveld", 16, "Yoda's krachtveld", 150);
        ArrayList<Gadget> yodasgadgets = new ArrayList<>();
        yodasgadgets.add((Gadget) greenLightsaber);
        yodasgadgets.add((Gadget) forcefield);
        PowerUp magicalStaff = new Wapen("Magische staf", 17, "Gandalf's vertrouwde staf", 170);
        PowerUp towerOfOrthanac = new Basis("De toren van Orthanac", 18, "De toren van Orthanac", "Middel Aarde");
        ArrayList<Gadget> gandalfsGadgets = new ArrayList<>();
        gandalfsGadgets.add((Gadget) magicalStaff);
        gandalfsGadgets.add((Gadget) towerOfOrthanac);
        PowerUp theRing = new Wapen("De ring", 19, "Een ring om ze allemaal te beheersen", 250);
        PowerUp sting = new Wapen("Sting", 20, "Frodo's zwaard", 50);
        ArrayList<Gadget> frodosGadgets = new ArrayList<>();
        frodosGadgets.add((Gadget) theRing);
        frodosGadgets.add((Gadget) sting);
        PowerUp playingCards = new Wapen("Speelkaarten", 21, "Waarom zouden speelkaarten een wapen zijn?", 150);
        PowerUp explosives = new Wapen("Explosieven", 22, "Boem", 250);
        ArrayList<Gadget> jokersGadgets = new ArrayList<>();
        jokersGadgets.add((Gadget) playingCards);
        jokersGadgets.add((Gadget) explosives);
        PowerUp infinityGauntlet = new Wapen("The infinity gauntlet", 23, "De perfecte balans", 300);
        PowerUp spaceShip = new Voertuig("UFO", 24, "Het is simpelweg een UFO", 150000, 1);
        ArrayList<Gadget> thanosGadgets = new ArrayList<>();
        thanosGadgets.add((Gadget) infinityGauntlet);
        thanosGadgets.add((Gadget) spaceShip);
        PowerUp electromagneticPulses = new Wapen("Electromagnetische pulsen", 25, "Ik  beheers metaal", 200);
        PowerUp flyingSaucer = new Voertuig("Vliegende schotel", 26, "Ik ben geen alien", 2000, 4);
        ArrayList<Gadget> magnetosGadgets = new ArrayList<>();
        magnetosGadgets.add((Gadget) flyingSaucer);
        magnetosGadgets.add((Gadget) superMobile);
        PowerUp goblinGlider = new Voertuig("Goblin glider", 27, "Green goblin's glider", 200, 1);
        PowerUp secretLab = new Basis("Geheim laboratorium", 28, "Green golbin's geheime laboratorium", "New york");
        ArrayList<Gadget> greengoblinsGadgets = new ArrayList<>();
        greengoblinsGadgets.add((Gadget) goblinGlider);
        greengoblinsGadgets.add((Gadget) secretLab);
        PowerUp mallet = new Wapen("Hamer", 29, "Ik hamer er niet op", 120);
        PowerUp aceChemical = new Basis("Ace chemical gebouw", 30, "Ace chemical gebouw", "Gotham city");
        ArrayList<Gadget> harleysGadgets = new ArrayList<>();
        harleysGadgets.add((Gadget) mallet);
        harleysGadgets.add((Gadget) aceChemical);
        PowerUp warSuit = new Wapen("Oorlog pak", 31, "Lex Luthor's oorlog pak", 100);
        PowerUp kryptonite = new Wapen("Kryptonite", 32, "Wat is jouw kyptonite?", 150);
        ArrayList<Gadget> lexsGadgets = new ArrayList<>();
        lexsGadgets.add((Gadget) warSuit);
        lexsGadgets.add((Gadget) kryptonite);
        PowerUp sauronsRing = new Wapen("Sauron's ring", 33, "Gelukkig maar dat hij hem kwijt is.", 300);
        PowerUp club = new Wapen("Knuppel", 34, "Één serieuze knuppel!", 100);
        ArrayList<Gadget> sauronsGadgets = new ArrayList<>();
        sauronsGadgets.add((Gadget) sauronsRing);
        sauronsGadgets.add((Gadget) club);
        PowerUp crystalBall = new Wapen("Kristallen bol", 35, "Wat zie jij er in?", 200);
        PowerUp wizardsStaff = new Wapen("Wizard's staf", 36, "Saruman's staf", 160);
        ArrayList<Gadget> sarumansGadgets = new ArrayList<>();
        sarumansGadgets.add((Gadget) crystalBall);
        sarumansGadgets.add((Gadget) wizardsStaff);
        PowerUp redLightsaber = new Wapen("Red light saber", 37, "Palpatine's lightsaber", 90);
        PowerUp lambda = new Voertuig("Lambda-class T-4a shuttle", 38, "Palpatine's shuttle", 120000, 1);
        ArrayList<Gadget> palpatinesGadgets = new ArrayList<>();
        palpatinesGadgets.add((Gadget) redLightsaber);
        palpatinesGadgets.add((Gadget) lambda);
        PowerUp darthsLightsaber = new Wapen("Darth Vader's lightsaber", 39, "Darth Vader's lightsaber", 90);
        PowerUp theForce = new Wapen("The force", 40, "Stik hier maar in!", 120);
        ArrayList<Gadget> darthsGadgets = new ArrayList<>();
        darthsGadgets.add((Gadget) darthsLightsaber);
        darthsGadgets.add((Gadget) theForce);
        // Heroes aanmaken (met het setten van de one-liner)
        Super batman = new Held("Batman", 1, "Gotham City", "Bruce Wayne", batmansGadgets);
        batman.setOneLiner("Of je sterft als held, of je leeft lang genoeg om jezelf de schurk te zien worden.");
        Super doctorStrange = new Held("Doctor Strange", 2, "Multiverse", "Stephen Strange", doctorStrangesGadgets);
        doctorStrange.setOneLiner("Je breekt de regels, en je wordt een held");
        Super spiderMan = new Held("Spider Man", 3, "New York", "Peter Parker", spidermansGadgets);
        spiderMan.setOneLiner("Mijn  sipdey-zintuigen trillen!");
        Super obiWan = new Held("Obi Wan Kenobi", 4, "Ergens in een melkweg ver, ver hiervandaan",
                "Obi Wan Kenobi", obiwansGadgets);
        obiWan.setOneLiner("Moge de kracht met jou zijn.");
        Super superMan = new Held("Superman", 5, "Metropolis", "Clark Kent", supermansGadgets);
        superMan.setOneLiner("Er is een goed, en een fout in het universum");
        Super wolverine = new Held("Wolverine", 6, "Canada", "Logan", wolverinesGadgets);
        wolverine.setOneLiner("Geduld is niet mijn sterkste kant");
        Super wonderWoman = new Held("Wonder Woman", 7, "Themyscira", "Diana Prince", wonderwomansGadgets);
        wonderWoman.setOneLiner("Ik vecht voor mensen die niet voor zichzelf kunnen vechten");
        Super yoda = new Held("Yoda", 8, "Dagobah", "Yoda", yodasgadgets);
        yoda.setOneLiner("Als je naar de donkere kant kijkt, voorzichtig moet je zijn. De donkere kant kijkt terug.");
        Super gandalf = new Held("Gandalf", 9, "Middle Earth", "Olorin", gandalfsGadgets);
        gandalf.setOneLiner("Je mag er niet door!");
        Super frodo = new Held("Frodo", 10, "The Shire", "Frodo Baggins", frodosGadgets);
        frodo.setOneLiner("Ik zal de Shire redden!");
        // Villains aanmaken (met het setten van de one-liner)
        Super joker = new Schurk("The Joker", 11, "Gotham City", "Batman verslaan", jokersGadgets);
        joker.setOneLiner("Waarom zo serieus?");
        Super thanos = new Schurk("Thanos", 12, "Multiverse", "Het universum vernietigen", thanosGadgets);
        thanos.setOneLiner("In perfecte balans, zoals het moet zijn");
        Super magneto = new Schurk("Magneto", 13, "Aarde", "Mutanten aan de macht krijgen", magnetosGadgets);
        magneto.setOneLiner("De mutanten zullen opstaan!");
        Super greenGoblin = new Schurk("The Green Goblin", 14, "New York", "Spider Man verslaan", greengoblinsGadgets);
        greenGoblin.setOneLiner("Maak het af! Maakt het af!");
        Super harleyQuin = new Schurk("Harley Quinn", 15, "Gotham City", "Batman verslaan", harleysGadgets);
        harleyQuin.setOneLiner("Je weet wat ze zeggen: Achter elke succesvolle man staat een super dame.");
        Super lexLuthor = new Schurk("Lex Luthor", 16, "Metropolis", "De wereld veroveren", lexsGadgets);
        lexLuthor.setOneLiner("We weten nu dat de duivels niet van onder ons uit de hel komen, ze komen uit de lucht");
        Super darthVader = new Schurk("Darth Vader", 17, "In a galaxy far, far away", "Het universum veroveren", darthsGadgets);
        darthVader.setOneLiner("Luke, ik ben je vader!");
        Super sauron = new Schurk("Sauron", 18, "Middle Earth", "Middle Earth veroveren", sauronsGadgets);
        sauron.setOneLiner("Een ring om ze allemaal te beheersen.");
        Super saruman = new Schurk("Saruman", 19, "Isengard", "Macht verkrijgen", sarumansGadgets);
        saruman.setOneLiner("We moeten alleen zei, die ons tegenstaan verwijderen.");
        Super palpatine = new Schurk("Emperor Palpatine", 20, "In a galaxy far, far away", "Het universum veroveren", palpatinesGadgets);
        palpatine.setOneLiner("Jouw zwakke kunsten zijn niks vergeleken met de kracht van de donkere kant!");
        // Antivriendenboeken vullen
        vijandToevoegen(batman, joker);
        vijandToevoegen(batman, harleyQuin);
        vijandToevoegen(doctorStrange, thanos);
        vijandToevoegen(spiderMan, greenGoblin);
        vijandToevoegen(obiWan, darthVader);
        vijandToevoegen(obiWan, palpatine);
        vijandToevoegen(superMan, thanos);
        vijandToevoegen(superMan, lexLuthor);
        vijandToevoegen(wolverine, magneto);
        vijandToevoegen(wonderWoman, thanos);
        vijandToevoegen(wonderWoman, lexLuthor);
        vijandToevoegen(yoda, darthVader);
        vijandToevoegen(yoda, palpatine);
        vijandToevoegen(gandalf, saruman);
        vijandToevoegen(gandalf, sauron);
        vijandToevoegen(frodo, saruman);
        vijandToevoegen(frodo, sauron);
        // Aarts vijanden toevoegen
        aartsVijandToevoegen(batman, joker);
        aartsVijandToevoegen(doctorStrange, thanos);
        aartsVijandToevoegen(spiderMan, greenGoblin);
        aartsVijandToevoegen(obiWan, darthVader);
        aartsVijandToevoegen(superMan, lexLuthor);
        aartsVijandToevoegen(wolverine, magneto);
        aartsVijandToevoegen(wonderWoman, harleyQuin);
        aartsVijandToevoegen(yoda, palpatine);
        aartsVijandToevoegen(gandalf, saruman);
        aartsVijandToevoegen(frodo, sauron);
        // Fanlijsten aanmaken aan beide kanten (Heroes en Fans)
        fanLijstToevoegen(batman, (Fan)Harry);
        fanLijstToevoegen(batman, (Fan)Fred);
        fanLijstToevoegen(batman, (Fan)Ash);
        fanLijstToevoegen(doctorStrange, (Fan)Harry);
        fanLijstToevoegen(doctorStrange, (Fan)Luna);
        fanLijstToevoegen(spiderMan, (Fan)Blaze);
        fanLijstToevoegen(spiderMan, (Fan)Cosmo);
        fanLijstToevoegen(spiderMan, (Fan)Luna);
        fanLijstToevoegen(obiWan, (Fan)Cosmo);
        fanLijstToevoegen(obiWan, (Fan)Phoenix);
        fanLijstToevoegen(superMan, (Fan)Luna);
        fanLijstToevoegen(superMan, (Fan)Harry);
        fanLijstToevoegen(superMan, (Fan)Marie);
        fanLijstToevoegen(superMan, (Fan)zekerNietAsh);
        fanLijstToevoegen(wolverine, (Fan)Marie);
        fanLijstToevoegen(wolverine, (Fan)Fred);
        fanLijstToevoegen(wonderWoman, (Fan)Ash);
        fanLijstToevoegen(wonderWoman, (Fan)Harry);
        fanLijstToevoegen(yoda, (Fan)Luna);
        fanLijstToevoegen(frodo, (Fan)Blaze);
        fanLijstToevoegen(frodo, (Fan)Cosmo);
        fanLijstToevoegen(frodo, (Fan)Luna);
        fanLijstToevoegen(gandalf, (Fan)Cosmo);
        fanLijstToevoegen(gandalf, (Fan)Phoenix);
        // Fanlijsten aanmaken aan beide kanten (Villains en Fans)
        fanLijstToevoegen(joker, (Fan)Harry);
        fanLijstToevoegen(joker, (Fan)Fred);
        fanLijstToevoegen(thanos, (Fan)Ash);
        fanLijstToevoegen(thanos, (Fan)Harry);
        fanLijstToevoegen(thanos, (Fan)Luna);
        fanLijstToevoegen(greenGoblin, (Fan)Blaze);
        fanLijstToevoegen(greenGoblin, (Fan)Cosmo);
        fanLijstToevoegen(greenGoblin, (Fan)Luna);
        fanLijstToevoegen(darthVader, (Fan)Cosmo);
        fanLijstToevoegen(darthVader, (Fan)Phoenix);
        fanLijstToevoegen(lexLuthor, (Fan)zekerNietAsh);
        fanLijstToevoegen(lexLuthor, (Fan)Harry);
        fanLijstToevoegen(magneto, (Fan)Marie);
        fanLijstToevoegen(magneto, (Fan)zekerNietAsh);
        fanLijstToevoegen(magneto, (Fan)Phoenix);
        fanLijstToevoegen(harleyQuin, (Fan)Fred);
        fanLijstToevoegen(harleyQuin, (Fan)Ash);
        fanLijstToevoegen(harleyQuin, (Fan)Harry);
        fanLijstToevoegen(palpatine, (Fan)Luna);
        fanLijstToevoegen(palpatine, (Fan)Blaze);
        fanLijstToevoegen(saruman, (Fan)Cosmo);
        fanLijstToevoegen(saruman, (Fan)Luna);
        fanLijstToevoegen(sauron, (Fan)zekerNietAsh);
        fanLijstToevoegen(sauron, (Fan)Phoenix);
        // Teams aanmaken
        ArrayList<Schurk> marvelBadGuys = new ArrayList<>();
        marvelBadGuys.add((Schurk) joker);
        marvelBadGuys.add((Schurk) harleyQuin);
        marvelBadGuys.add((Schurk) thanos);
        marvelBadGuys.add((Schurk) greenGoblin);
        marvelBadGuys.add((Schurk) lexLuthor);
        Team marvelVillains = new SchurkenTeam("De marvel villains", 1, marvelBadGuys);
        ArrayList<Schurk> andereBadGuys = new ArrayList<>();
        marvelBadGuys.add((Schurk) magneto);
        marvelBadGuys.add((Schurk) darthVader);
        marvelBadGuys.add((Schurk) palpatine);
        marvelBadGuys.add((Schurk) saruman);
        marvelBadGuys.add((Schurk) sauron);
        Team legionOfDoom = new SchurkenTeam("Het legioen van DOEM", 2, andereBadGuys);
        ArrayList<Held> avengers = new ArrayList<>();
        avengers.add((Held) spiderMan);
        avengers.add((Held) superMan);
        avengers.add((Held) doctorStrange);
        avengers.add((Held) batman);
        avengers.add((Held) wonderWoman);
        Team theAvengers = new HeldenTeam("The Avengers", 3, avengers);
        ArrayList<Held> antiHelden = new ArrayList<>();
        antiHelden.add((Held) obiWan);
        antiHelden.add((Held) yoda);
        antiHelden.add((Held) frodo);
        antiHelden.add((Held) gandalf);
        antiHelden.add((Held) wolverine);
        Team deAntiHelden = new HeldenTeam("De anti-helden", 4, antiHelden);
        //Eerste Supers test gevecht
        SuperGevecht test1 = new SuperGevecht((Held) batman, (Schurk) joker, "berekenen");
        test1.vechten();
        //Eerste Teams test gevecht:
        TeamGevecht test2 = new TeamGevecht((HeldenTeam) deAntiHelden, (SchurkenTeam) legionOfDoom, "berekenen");
        test2.vechten();
        // "Lijsten" aanmaken voor menu's en gevechten aanmaken zodat we stoppen, terug, vechten starten en zoeken kunnen selecteren binnen het menu
        ArrayList<Lijst> terug = new ArrayList<>();
        Lijst terugLijst = new Lijst("Terug", terug);
        ArrayList<Weergeefbaar> zoeken = new ArrayList<>();
        Lijst allesZoeken = new Lijst("Zoeken", zoeken);
        ArrayList<Weergeefbaar> vechtenStarten = new ArrayList<>();
        Lijst vechtenStartenLijst = new Lijst("Vechten starten", vechtenStarten);
        //Lijst van helden voor het gebruik buiten de main methode
        ArrayList<Super> helden = new ArrayList<>();
        helden.add(batman);
        helden.add(doctorStrange);
        helden.add(spiderMan);
        helden.add(obiWan);
        helden.add(wolverine);
        helden.add(superMan);
        helden.add(wonderWoman);
        helden.add(yoda);
        helden.add(gandalf);
        helden.add(frodo);
        Lijst alleHelden = new Lijst("Alle helden", helden);
        ArrayList<Held> alleHeldenLijst = heldCasten(helden);
        ArrayList<String> alleHeldenNamen = naamOphalenSupers(helden);
        //Lijst van schurken voor het gebruik buiten de main methode
        ArrayList<Super> schurken = new ArrayList<>();
        schurken.add(joker);
        schurken.add(thanos);
        schurken.add(greenGoblin);
        schurken.add(darthVader);
        schurken.add(lexLuthor);
        schurken.add(magneto);
        schurken.add(harleyQuin);
        schurken.add(palpatine);
        schurken.add(saruman);
        schurken.add(sauron);
        Lijst alleSchurken = new Lijst("Alle Schurken", schurken);
        ArrayList<Schurk> alleSchurkenLijst = schurkCasten(schurken);
        ArrayList<String> alleSchurkenNamen = naamOphalenSupers(schurken);
        //Lijst van alle teams
        ArrayList<Team> teams = new ArrayList();
        teams.add(marvelVillains);
        teams.add(legionOfDoom);
        teams.add(theAvengers);
        teams.add(deAntiHelden);
        Lijst alleTeams = new Lijst("Alle teams", teams);
        //Lijst van alle helden teams en namen
        ArrayList<HeldenTeam> alleHeldenTeams = new ArrayList<>();
        alleHeldenTeams.add((HeldenTeam) theAvengers);
        alleHeldenTeams.add((HeldenTeam) deAntiHelden);
        ArrayList<String> alleHeldenTeamsNamen = new ArrayList<>();
        alleHeldenTeamsNamen.add(theAvengers.getNaam());
        alleHeldenTeamsNamen.add(deAntiHelden.getNaam());
        //Lijst van alle schurken teams en namen
        ArrayList<SchurkenTeam> alleSchurkenTeams = new ArrayList<>();
        alleSchurkenTeams.add((SchurkenTeam) marvelVillains);
        alleSchurkenTeams.add((SchurkenTeam) legionOfDoom);
        ArrayList<String> alleSchurkenTeamsNamen = new ArrayList<>();
        alleSchurkenTeamsNamen.add(marvelVillains.getNaam());
        alleSchurkenTeamsNamen.add(legionOfDoom.getNaam());
        // Lijst van alle fans voor het gebruik buiten main
        ArrayList<PowerUp> fanLijst = new ArrayList<>();
        fanLijst.add(Harry);
        fanLijst.add(Bert);
        fanLijst.add(Fred);
        fanLijst.add(Marie);
        fanLijst.add(Ash);
        fanLijst.add(Cosmo);
        fanLijst.add(Blaze);
        fanLijst.add(Luna);
        fanLijst.add(Phoenix);
        fanLijst.add(zekerNietAsh);
        Lijst alleFansLijst = new Lijst("Alle fans", fanLijst);
        ArrayList<String> alleFansNamen = naamOphalenPowerUps(fanLijst);
        // Lijst prepareren voor invoeging in het menu
        ArrayList<Lijst> alleSupersTeamsLijst = new ArrayList<>();
        alleSupersTeamsLijst.add(alleHelden);
        alleSupersTeamsLijst.add(alleSchurken);
        alleSupersTeamsLijst.add(alleTeams);
        alleSupersTeamsLijst.add(alleFansLijst);
        alleSupersTeamsLijst.add(allesZoeken);
        alleSupersTeamsLijst.add(terugLijst);
        // Lijst van gadgets voor het gebruik buiten main
        ArrayList<PowerUp> alleGadgets = new ArrayList<>();
        alleGadgets.add(batmobiel);
        alleGadgets.add(batarang);
        alleGadgets.add(oogVanAgamotto);
        alleGadgets.add(sanctumSanctorum);
        alleGadgets.add(webShooter);
        alleGadgets.add(spiderDrone);
        alleGadgets.add(blueLightsaber);
        alleGadgets.add(starFighter);
        alleGadgets.add(superCostume);
        alleGadgets.add(superMobile);
        alleGadgets.add(adamantiumClaws);
        alleGadgets.add(adamantiumSkeleton);
        alleGadgets.add(lassoOfTruth);
        alleGadgets.add(invisiblePlane);
        alleGadgets.add(greenLightsaber);
        alleGadgets.add(forcefield);
        alleGadgets.add(magicalStaff);
        alleGadgets.add(towerOfOrthanac);
        alleGadgets.add(theRing);
        alleGadgets.add(sting);
        alleGadgets.add(playingCards);
        alleGadgets.add(explosives);
        alleGadgets.add(infinityGauntlet);
        alleGadgets.add(spaceShip);
        alleGadgets.add(electromagneticPulses);
        alleGadgets.add(flyingSaucer);
        alleGadgets.add(goblinGlider);
        alleGadgets.add(secretLab);
        alleGadgets.add(mallet);
        alleGadgets.add(aceChemical);
        alleGadgets.add(warSuit);
        alleGadgets.add(kryptonite);
        alleGadgets.add(sauronsRing);
        alleGadgets.add(club);
        alleGadgets.add(crystalBall);
        alleGadgets.add(wizardsStaff);
        alleGadgets.add(redLightsaber);
        alleGadgets.add(theForce);
        Lijst alleGadgetsLijst = new Lijst("Alle gadgets", alleGadgets);
        ArrayList<String> gadgetsNamen = naamOphalenPowerUps(alleGadgets);
        //Gadgets menu aanmaken
        ArrayList<Lijst> alleGadgetsMenu = new ArrayList<>();
        alleGadgetsMenu.add(alleGadgetsLijst);
        alleGadgetsMenu.add(allesZoeken);
        alleGadgetsMenu.add(terugLijst);
        //Alle gevechten in een lijst zetten
        ArrayList<Weergeefbaar> alleGevechten = new ArrayList<>();
        alleGevechten.add(test1);
        alleGevechten.add(test2);
        Lijst alleGevechtenLijst = new Lijst("Alle gevechten", alleGevechten);
        ArrayList<Lijst> vechtMenu = new ArrayList<>();
        //Vecht menu maken
        vechtMenu.add(alleGevechtenLijst);
        vechtMenu.add(vechtenStartenLijst);
        vechtMenu.add(allesZoeken);
        vechtMenu.add(terugLijst);
        // Alle submenus aanmaken
        Menu supersTeamsMenu = new Menu("Alle supers en teams menu", alleSupersTeamsLijst);
        Menu gadgetsMenu = new Menu("Gadgets menu", alleGadgetsMenu);
        Menu vechtenMenu = new Menu("Vechten menu", vechtMenu);

        // alle lijsten en menu's buiten main plaatsen zodat ze daar gebruikt kunnen worden.
        getAlleLijsten(alleHeldenLijst, fanLijst, alleSchurkenLijst, alleGadgets, alleHeldenTeams, alleSchurkenTeams, alleGevechten);
        getAlleNamen(alleHeldenNamen, alleSchurkenNamen, alleFansNamen, gadgetsNamen, alleHeldenTeamsNamen, alleSchurkenTeamsNamen);
        getAlleMenus(supersTeamsMenu, gadgetsMenu, vechtenMenu);
        //Hoofmenu activeren zodat de applicatie start
        hoofdMenu();
    }
}