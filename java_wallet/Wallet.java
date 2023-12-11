import java.util.Scanner;

public class Wallet {
    private double solde;
    private long lastActivityTime;
    private final Cin cin;
    private final Money money;
    private final CarteBancaire carteBancaire;
    private final PermisConduire permisConduire;
    private final CarteVisite carteVisite;
    private final IdPhoto idPhoto;

    public Wallet() {
        this.solde = 0;
        this.lastActivityTime = System.currentTimeMillis();
        this.cin = new Cin("Informations du CIN...", "123456789");
        this.money = new Money(0);
        this.carteBancaire = new CarteBancaire("987654321");
        this.permisConduire = new PermisConduire("Informations du permis de conduire...");
        this.carteVisite = new CarteVisite("Informations de la carte de visite...");
        this.idPhoto = new IdPhoto("Photo du propriétaire...");
    }

    public void afficherMenu() {
        System.out.println("\nMenu principal :");
        System.out.println("1. CIN");
        System.out.println("2. Money");
        System.out.println("3. Carte bancaire");
        System.out.println("4. Permis de conduire");
        System.out.println("5. Carte de visite");
        System.out.println("6. ID photo");
        System.out.println("7. Quitter");
    }

    public void afficherInformationsCIN() {
        System.out.println(cin.getInformations());
    }

    public void afficherNumeroCIN() {
        System.out.println("Numero CIN : " + cin.getNumero());
    }

    public void consulterSolde() {
        System.out.println("Solde actuel : " + money.getSolde() + " euros");
    }

    public void ajouterArgent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le montant à ajouter : ");
        double montant = scanner.nextDouble();
        if (montant > 0) {
            money.ajouterArgent(montant);
            System.out.println("Vous avez ajouté " + montant + " euros à votre portefeuille.");
        } else {
            System.out.println("Veuillez entrer un montant valide.");
        }
    }

    public void retirerArgent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le montant à retirer : ");
        double montant = scanner.nextDouble();
        if (montant > 0 && montant <= money.getSolde()) {
            money.retirerArgent(montant);
            System.out.println("Vous avez retiré " + montant + " euros de votre portefeuille.");
        } else {
            System.out.println("Veuillez entrer un montant valide ou vérifier votre solde.");
        }
    }

    public void afficherNumeroCarteBancaire() {
        System.out.println("Numero Carte Bancaire : " + carteBancaire.getNumero());
    }

    public void payerParCarteBancaire() {
        System.out.println("Paiement par Carte Bancaire effectué.");
    }

    public void afficherInformationsPermisConduire() {
        System.out.println(permisConduire.getInformations());
    }

    public void afficherInformationsCarteVisite() {
        System.out.println(carteVisite.getInformations());
    }

    public void partagerCarteVisite() {
        System.out.println("La carte de visite a été partagée sous format .pdf.");
    }

    public void afficherPhotoID() {
        System.out.println(idPhoto.getPhoto());
    }

    public void partagerPhotoID() {
        System.out.println("La photo ID a été partagée.");
    }

    public void quitterAutomatiquement() {
        long currentTime = System.currentTimeMillis();
        double elapsedTime = (currentTime - lastActivityTime) / 1000.0 / 60.0; // en minutes

        if (elapsedTime >= 15) {
            System.out.println("Le portefeuille a été quitté automatiquement après 15 minutes d'inactivité.");
            System.exit(0);
        }
    }

    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            afficherMenu();
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("\nCIN :");
                    System.out.println("1. Afficher informations CIN");
                    System.out.println("2. Afficher numero CIN");
                    int choixCIN = scanner.nextInt();
                    if (choixCIN == 1) afficherInformationsCIN();
                    else if (choixCIN == 2) afficherNumeroCIN();
                    else System.out.println("Option invalide.");
                    break;
                case 2:
                    System.out.println("\nMoney :");
                    System.out.println("1. Consulter solde");
                    System.out.println("2. Ajouter");
                    System.out.println("3. Retirer");
                    int choixMoney = scanner.nextInt();
                    if (choixMoney == 1) consulterSolde();
                    else if (choixMoney == 2) ajouterArgent();
                    else if (choixMoney == 3) retirerArgent();
                    else System.out.println("Option invalide.");
                    break;
                case 3:
                    System.out.println("\nCarte bancaire :");
                    System.out.println("1. Afficher numero CB");
                    System.out.println("2. Payer par CB");
                    int choixCB = scanner.nextInt();
                    if (choixCB == 1) afficherNumeroCarteBancaire();
                    else if (choixCB == 2) payerParCarteBancaire();
                    else System.out.println("Option invalide.");
                    break;
                case 4:
                    System.out.println("\nPermis de conduire :");
                    System.out.println("1. Afficher permis de conduire");
                    int choixPermis = scanner.nextInt();
                    if (choixPermis == 1) afficherInformationsPermisConduire();
                    else System.out.println("Option invalide.");
                    break;
                case 5:
                    System.out.println("\nCarte de visite :");
                    System.out.println("1. Afficher informations carte de visite");
                    System.out.println("2. Partager sous format .pdf");
                    int choixCarteVisite = scanner.nextInt();
                    if (choixCarteVisite == 1) afficherInformationsCarteVisite();
                    else if (choixCarteVisite == 2) partagerCarteVisite();
                    else System.out.println("Option invalide.");
                    break;
                case 6:
                    System.out.println("\nID photo :");
                    System.out.println("1. Afficher photo");
                    System.out.println("2. Partager photo");
                    int choixIDPhoto = scanner.nextInt();
                    if (choixIDPhoto == 1) afficherPhotoID();
                    else if (choixIDPhoto == 2) partagerPhotoID();
                    else System.out.println("Option invalide.");
                    break;
                case 7:
                    System.out.println("Merci, au revoir !");
                    System.exit(0);
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }

            lastActivityTime = System.currentTimeMillis(); // Met à jour le temps de la dernière activité
        }
    }

    public static void main(String[] args) {
        Wallet wallet = new Wallet();
        wallet.menuPrincipal();
    }
}

class Cin {
    private String informations;
    private String numero;

    public Cin(String informations, String numero) {
        this.informations = informations;
        this.numero = numero;
    }

    public String getInformations() {
        return informations;
    }

    public String getNumero() {
        return numero;
    }
}

class Money {
    private double solde;

    public Money(double solde) {
        this.solde = solde;
    }

    public double getSolde() {
        return solde;
    }

    public void ajouterArgent(double montant) {
        solde += montant;
    }

    public void retirerArgent(double montant) {
        solde -= montant;
    }
}

class CarteBancaire {
    private String numero;

    public CarteBancaire(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
}

class PermisConduire {
    private String informations;

    public PermisConduire(String informations) {
        this.informations = informations;
    }

    public String getInformations() {
        return informations;
    }
}

class CarteVisite {
    private String informations;

    public CarteVisite(String informations) {
        this.informations = informations;
    }

    public String getInformations() {
        return informations;
    }
}

class IdPhoto {
    private String photo;

    public IdPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }
}
