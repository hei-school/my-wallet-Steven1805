import time

class PortefeuilleVirtuel:
    def __init__(self):
        self.solde = 0
        self.last_activity_time = time.time()
        self.cin = {
            'informations': 'Informations du CIN...',
            'numero': '123456789',
        }
        self.money = {
            'solde': 0,
        }
        self.carte_bancaire = {
            'numero': '987654321',
        }
        self.permis_conduire = {
            'informations': 'Informations du permis de conduire...',
        }
        self.carte_visite = {
            'informations': 'Informations de la carte de visite...',
        }
        self.id_photo = {
            'photo': 'Photo du propriétaire...',
        }

    def afficher_menu(self):
        print("\nMenu principal :")
        print("1. CIN")
        print("2. Money")
        print("3. Carte bancaire")
        print("4. Permis de conduire")
        print("5. Carte de visite")
        print("6. ID photo")
        print("7. Quitter")

    def afficher_informations_cin(self):
        print(self.cin['informations'])

    def afficher_numero_cin(self):
        print(f"Numero CIN : {self.cin['numero']}")

    def consulter_solde(self):
        print(f"Solde actuel : {self.money['solde']} euros")

    def ajouter_argent(self):
        montant = float(input('Entrez le montant à ajouter : '))
        if montant > 0:
            self.money['solde'] += montant
            print(f"Vous avez ajouté {montant} euros à votre portefeuille.")
        else:
            print('Veuillez entrer un montant valide.')

    def retirer_argent(self):
        montant = float(input('Entrez le montant à retirer : '))
        if 0 < montant <= self.money['solde']:
            self.money['solde'] -= montant
            print(f"Vous avez retiré {montant} euros de votre portefeuille.")
        else:
            print('Veuillez entrer un montant valide ou vérifier votre solde.')

    def afficher_numero_carte_bancaire(self):
        print(f"Numero Carte Bancaire : {self.carte_bancaire['numero']}")

    def payer_par_carte_bancaire(self):
        print('Paiement par Carte Bancaire effectué.')

    def afficher_informations_permis_conduire(self):
        print(self.permis_conduire['informations'])

    def afficher_informations_carte_visite(self):
        print(self.carte_visite['informations'])

    def partager_carte_visite(self):
        print('La carte de visite a été partagée sous format .pdf.')

    def afficher_photo_id(self):
        print(self.id_photo['photo'])

    def partager_photo_id(self):
        print('La photo ID a été partagée.')

    def quitter_automatiquement(self):
        current_time = time.time()
        elapsed_time = (current_time - self.last_activity_time) / 60  # en minutes

        if elapsed_time >= 15:
            print("Le portefeuille a été quitté automatiquement après 15 minutes d'inactivité.")
            exit()

    def menu_principal(self):
        while True:
            self.afficher_menu()
            choix = int(input('Choisissez une option : '))

            if choix == 1:
                print("\nCIN :")
                print("1. Afficher informations CIN")
                print("2. Afficher numero CIN")
                choix_cin = int(input('Choisissez une option : '))
                if choix_cin == 1:
                    self.afficher_informations_cin()
                elif choix_cin == 2:
                    self.afficher_numero_cin()
                else:
                    print('Option invalide.')
            elif choix == 2:
                print("\nMoney :")
                print("1. Consulter solde")
                print("2. Ajouter")
                print("3. Retirer")
                choix_money = int(input('Choisissez une option : '))
                if choix_money == 1:
                    self.consulter_solde()
                elif choix_money == 2:
                    self.ajouter_argent()
                elif choix_money == 3:
                    self.retirer_argent()
                else:
                    print('Option invalide.')
            elif choix == 3:
                print("\nCarte bancaire :")
                print("1. Afficher numero CB")
                print("2. Payer par CB")
                choix_cb = int(input('Choisissez une option : '))
                if choix_cb == 1:
                    self.afficher_numero_carte_bancaire()
                elif choix_cb == 2:
                    self.payer_par_carte_bancaire()
                else:
                    print('Option invalide.')
            elif choix == 4:
                print("\nPermis de conduire :")
                print("1. Afficher permis de conduire")
                choix_permis = int(input('Choisissez une option : '))
                if choix_permis == 1:
                    self.afficher_informations_permis_conduire()
                else:
                    print('Option invalide.')
            elif choix == 5:
                print("\nCarte de visite :")
                print("1. Afficher informations carte de visite")
                print("2. Partager sous format .pdf")
                choix_carte_visite = int(input('Choisissez une option : '))
                if choix_carte_visite == 1:
                    self.afficher_informations_carte_visite()
                elif choix_carte_visite == 2:
                    self.partager_carte_visite()
                else:
                    print('Option invalide.')
            elif choix == 6:
                print("\nID photo :")
                print("1. Afficher photo")
                print("2. Partager photo")
                choix_id_photo = int(input('Choisissez une option : '))
                if choix_id_photo == 1:
                    self.afficher_photo_id()
                elif choix_id_photo == 2:
                    self.partager_photo_id()
                else:
                    print('Option invalide.')
            elif choix == 7:
                print('Merci, au revoir !')
                exit()
            else:
                print('Option invalide. Veuillez réessayer.')

            self.last_activity_time = time.time()  # Met à jour le temps de la dernière activité

# Lancement du programme
portefeuille = PortefeuilleVirtuel()
portefeuille.menu_principal()
