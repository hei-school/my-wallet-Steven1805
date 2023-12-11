class PortefeuilleVirtuel
  def initialize
    @solde = 0
    @last_activity_time = Time.now.to_i
    @cin = { informations: 'Informations du CIN...', numero: '123456789' }
    @money = { solde: 0 }
    @carte_bancaire = { numero: '987654321' }
    @permis_conduire = { informations: 'Informations du permis de conduire...' }
    @carte_visite = { informations: 'Informations de la carte de visite...' }
    @id_photo = { photo: 'Photo du propriétaire...' }
  end

  def afficher_menu
    puts "\nMenu principal :"
    puts "1. CIN"
    puts "2. Money"
    puts "3. Carte bancaire"
    puts "4. Permis de conduire"
    puts "5. Carte de visite"
    puts "6. ID photo"
    puts "7. Quitter"
  end

  def afficher_informations_cin
    puts @cin[:informations]
  end

  def afficher_numero_cin
    puts "Numero CIN : #{@cin[:numero]}"
  end

  def consulter_solde
    puts "Solde actuel : #{@money[:solde]} euros"
  end

  def ajouter_argent
    print 'Entrez le montant à ajouter : '
    montant = gets.chomp.to_f
    if montant > 0
      @money[:solde] += montant
      puts "Vous avez ajouté #{montant} euros à votre portefeuille."
    else
      puts 'Veuillez entrer un montant valide.'
    end
  end

  def retirer_argent
    print 'Entrez le montant à retirer : '
    montant = gets.chomp.to_f
    if montant > 0 && montant <= @money[:solde]
      @money[:solde] -= montant
      puts "Vous avez retiré #{montant} euros de votre portefeuille."
    else
      puts 'Veuillez entrer un montant valide ou vérifier votre solde.'
    end
  end

  def afficher_numero_carte_bancaire
    puts "Numero Carte Bancaire : #{@carte_bancaire[:numero]}"
  end

  def payer_par_carte_bancaire
    puts 'Paiement par Carte Bancaire effectué.'
  end

  def afficher_informations_permis_conduire
    puts @permis_conduire[:informations]
  end

  def afficher_informations_carte_visite
    puts @carte_visite[:informations]
  end

  def partager_carte_visite
    puts 'La carte de visite a été partagée sous format .pdf.'
  end

  def afficher_photo_id
    puts @id_photo[:photo]
  end

  def partager_photo_id
    puts 'La photo ID a été partagée.'
  end

  def quitter_automatiquement
    current_time = Time.now.to_i
    elapsed_time = (current_time - @last_activity_time) / 60.0 # en minutes

    if elapsed_time >= 15
      puts 'Le portefeuille a été quitté automatiquement après 15 minutes d\'inactivité.'
      exit
    end
  end

  def menu_principal
    while true
      afficher_menu
      print 'Choisissez une option : '
      choix = gets.chomp.to_i

      case choix
      when 1
        puts "\nCIN :"
        puts '1. Afficher informations CIN'
        puts '2. Afficher numero CIN'
        choix_cin = gets.chomp.to_i
        if choix_cin == 1
          afficher_informations_cin
        elsif choix_cin == 2
          afficher_numero_cin
        else
          puts 'Option invalide.'
        end
      when 2
        puts "\nMoney :"
        puts '1. Consulter solde'
        puts '2. Ajouter'
        puts '3. Retirer'
        choix_money = gets.chomp.to_i
        if choix_money == 1
          consulter_solde
        elsif choix_money == 2
          ajouter_argent
        elsif choix_money == 3
          retirer_argent
        else
          puts 'Option invalide.'
        end
      when 3
        puts "\nCarte bancaire :"
        puts '1. Afficher numero CB'
        puts '2. Payer par CB'
        choix_cb = gets.chomp.to_i
        if choix_cb == 1
          afficher_numero_carte_bancaire
        elsif choix_cb == 2
          payer_par_carte_bancaire
        else
          puts 'Option invalide.'
        end
      when 4
        puts "\nPermis de conduire :"
        puts '1. Afficher permis de conduire'
        choix_permis = gets.chomp.to_i
        if choix_permis == 1
          afficher_informations_permis_conduire
        else
          puts 'Option invalide.'
        end
      when 5
        puts "\nCarte de visite :"
        puts '1. Afficher informations carte de visite'
        puts '2. Partager sous format .pdf'
        choix_carte_visite = gets.chomp.to_i
        if choix_carte_visite == 1
          afficher_informations_carte_visite
        elsif choix_carte_visite == 2
          partager_carte_visite
        else
          puts 'Option invalide.'
        end
      when 6
        puts "\nID photo :"
        puts '1. Afficher photo'
        puts '2. Partager photo'
        choix_id_photo = gets.chomp.to_i
        if choix_id_photo == 1
          afficher_photo_id
        elsif choix_id_photo == 2
          partager_photo_id
        else
          puts 'Option invalide.'
        end
      when 7
        puts 'Merci, au revoir !'
        exit
      else
        puts 'Option invalide. Veuillez réessayer.'
      end

      @last_activity_time = Time.now.to_i # Met à jour le temps de la dernière activité
    end
  end
end

# Lancement du programme
portefeuille = PortefeuilleVirtuel.new
portefeuille.menu_principal
