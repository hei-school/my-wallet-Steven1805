const readlineSync = require('readline-sync');

class PortefeuilleVirtuel {
    constructor() {
        this.solde = 0;
        this.lastActivityTime = Date.now();
        this.cin = {
            informations: "Informations du CIN...",
            numero: "123456789",
        };
        this.money = {
            solde: 0,
        };
        this.carteBancaire = {
            numero: "987654321",
        };
        this.permisConduire = {
            informations: "Informations du permis de conduire...",
        };
        this.carteVisite = {
            informations: "Informations de la carte de visite...",
        };
        this.idPhoto = {
            photo: "Photo du propriétaire...",
        };
    }

    afficherMenu() {
        console.log("\nMenu principal :");
        console.log("1. Afficher menu");
        console.log("2. CIN");
        console.log("3. Money");
        console.log("4. Carte bancaire");
        console.log("5. Permis de conduire");
        console.log("6. Carte de visite");
        console.log("7. ID photo");
        console.log("8. Quitter");
    }

    afficherInformationsCIN() {
        console.log(this.cin.informations);
    }

    afficherNumeroCIN() {
        console.log(`Numero CIN : ${this.cin.numero}`);
    }

    consulterSolde() {
        console.log(`Solde actuel : ${this.money.solde} euros`);
    }

    ajouterArgent() {
        const montant = parseFloat(readlineSync.question('Entrez le montant à ajouter : '));
        if (!isNaN(montant) && montant > 0) {
            this.money.solde += montant;
            console.log(`Vous avez ajouté ${montant} euros à votre portefeuille.`);
        } else {
            console.log('Veuillez entrer un montant valide.');
        }
    }

    retirerArgent() {
        const montant = parseFloat(readlineSync.question('Entrez le montant à retirer : '));
        if (!isNaN(montant) && montant > 0 && montant <= this.money.solde) {
            this.money.solde -= montant;
            console.log(`Vous avez retiré ${montant} euros de votre portefeuille.`);
        } else {
            console.log('Veuillez entrer un montant valide ou vérifier votre solde.');
        }
    }

    afficherNumeroCarteBancaire() {
        console.log(`Numero Carte Bancaire : ${this.carteBancaire.numero}`);
    }

    payerParCarteBancaire() {
        console.log('Paiement par Carte Bancaire effectué.');
    }

    afficherInformationsPermisConduire() {
        console.log(this.permisConduire.informations);
    }

    afficherInformationsCarteVisite() {
        console.log(this.carteVisite.informations);
    }

    partagerCarteVisite() {
        console.log('La carte de visite a été partagée sous format .pdf.');
    }

    afficherPhotoID() {
        console.log(this.idPhoto.photo);
    }

    partagerPhotoID() {
        console.log('La photo ID a été partagée.');
    }

    quitterAutomatiquement() {
        const currentTime = Date.now();
        const elapsedTime = (currentTime - this.lastActivityTime) / 1000 / 60; // en minutes

        if (elapsedTime >= 15) {
            console.log('Le portefeuille a été quitté automatiquement après 15 minutes d\'inactivité.');
            process.exit(0);
        }
    }

    menuPrincipal() {
        setInterval(() => this.quitterAutomatiquement(), 60000); // Vérifie automatiquement toutes les minutes

        while (true) {
            console.log("\nMenu principal :");
            console.log("1. CIN");
            console.log("2. Money");
            console.log("3. Carte bancaire");
            console.log("4. Permis de conduire");
            console.log("5. Carte de visite");
            console.log("6. ID photo");
            console.log("7. Quitter");

            const choix = parseInt(readlineSync.question('Choisissez une option : '));

            switch (choix) {
                case 1:
                    console.log("\nCIN :");
                    console.log("1. Afficher informations CIN");
                    console.log("2. Afficher numero CIN");
                    const choixCIN = parseInt(readlineSync.question('Choisissez une option : '));
                    if (choixCIN === 1) this.afficherInformationsCIN();
                    else if (choixCIN === 2) this.afficherNumeroCIN();
                    else console.log('Option invalide.');
                    break;
                case 2:
                    console.log("\nMoney :");
                    console.log("1. Consulter solde");
                    console.log("2. Ajouter");
                    console.log("3. Retirer");
                    const choixMoney = parseInt(readlineSync.question('Choisissez une option : '));
                    if (choixMoney === 1) this.consulterSolde();
                    else if (choixMoney === 2) this.ajouterArgent();
                    else if (choixMoney === 3) this.retirerArgent();
                    else console.log('Option invalide.');
                    break;
                case 3:
                    console.log("\nCarte bancaire :");
                    console.log("1. Afficher numero CB");
                    console.log("2. Payer par CB");
                    const choixCB = parseInt(readlineSync.question('Choisissez une option : '));
                    if (choixCB === 1) this.afficherNumeroCarteBancaire();
                    else if (choixCB === 2) this.payerParCarteBancaire();
                    else console.log('Option invalide.');
                    break;
                case 4:
                    console.log("\nPermis de conduire :");
                    console.log("1. Afficher permis de conduire");
                    const choixPermis = parseInt(readlineSync.question('Choisissez une option : '));
                    if (choixPermis === 1) this.afficherInformationsPermisConduire();
                    else console.log('Option invalide.');
                    break;
                case 5:
                    console.log("\nCarte de visite :");
                    console.log("1. Afficher informations carte de visite");
                    console.log("2. Partager sous format .pdf");
                    const choixCarteVisite = parseInt(readlineSync.question('Choisissez une option : '));
                    if (choixCarteVisite === 1) this.afficherInformationsCarteVisite();
                    else if (choixCarteVisite === 2) this.partagerCarteVisite();
                    else console.log('Option invalide.');
                    break;
                case 6:
                    console.log("\nID photo :");
                    console.log("1. Afficher photo");
                    console.log("2. Partager photo");
                    const choixIDPhoto = parseInt(readlineSync.question('Choisissez une option : '));
                    if (choixIDPhoto === 1) this.afficherPhotoID();
                    else if (choixIDPhoto === 2) this.partagerPhotoID();
                    else console.log('Option invalide.');
                    break;
                case 7:
                    console.log('Merci, au revoir !');
                    process.exit(0);
                default:
                    console.log('Option invalide. Veuillez réessayer.');
            }

            this.lastActivityTime = Date.now(); // Met à jour le temps de la dernière activité
        }
    }
}

// Lancement du programme
const portefeuille = new PortefeuilleVirtuel();
portefeuille.menuPrincipal();
