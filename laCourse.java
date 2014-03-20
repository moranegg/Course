

/**

 *

 * @author Morane Otilia

 */

public class laCourse {



    /**
     * @param args the command line arguments
     */

   //methode 1 continuer

    public static void continuer(){

        Terminal.sautDeLigne();

        Terminal.ecrireString("Veuillez tapez 'entrée' pour continuer");

        Terminal.lireChar();

        Terminal.sautDeLigne();

    }

 
    // methode 2 trouver nom de participants avec numéro de dossard

    public static void trouver (String n, String [] participants, int Dossard ){

    
       participants [Dossard]= n;        

       Terminal.ecrireString("le participant n°"+ Dossard+ " est "+ n);

           

    }

    // methode 3 enregitrer un abandon dans la table abandon, et effacer le participants dans la table des participants

    public static void abandonner (int dossard, String []participants, String [] abandon ){

         

         String n= participants[dossard];

         

         participants [dossard]= "####";

         abandon [dossard]= n;

         Terminal.ecrireString("le participant n°"+dossard+ "- "+ abandon [dossard]+ " a abandoné la course!");

    }

    //methode 3 enregitrer un disqualification dans la table abandon, et effacer le participants dans la table des participants

    public static void disqualification (int dossard, String []participants, String [] disqualifier ){

         Terminal.ecrireStringln( "ce participant sera suprimé des participants");

         String n= participants[dossard];

         trouver (n, participants, dossard );

         participants [dossard]= "####";

         disqualifier [dossard]= n;

         Terminal.ecrireString("le participant n°"+dossard+ "- "+  disqualifier [dossard]+ 

                 " a été disqualifié de la course!");

         Terminal.sautDeLigne();

    }

    // methode 4 afficher le tableau en question

    public static void affichertab (String [] tab){

        Terminal.ecrireString(tab[0]);

        for ( int i = 1; i<tab.length; i++){

                if (tab[i]==null || tab[i]== "####"){

                 Terminal.ecrireChar(' ');   

                }else{

                Terminal.sautDeLigne();

                Terminal.ecrireInt(i);

                Terminal.ecrireChar(':');

                Terminal.ecrireString(tab[i]);

                                        

                }

        }

    }

    // methode 5 classement des arrivées

    public static void classement (String [] participants, int [] classement, double [] arrivee){

        Terminal.ecrireString("Classement des arrivées: ");

        Terminal.sautDeLigne();

        int i=0;

        while (classement[i]!=0){

                Terminal.ecrireInt(i+1);

                Terminal.ecrireChar(':');

                Terminal.ecrireString("Dossard numéro- "+ classement[i]+ " ,");

                Terminal.ecrireString(participants[classement[i]]+ " , temps d'arrivée: ");

                Terminal.ecrireDouble(arrivee[classement[i]]);

                Terminal.sautDeLigne();              

                i++;

                        

         }

    

    }

    // methode 6 vérification si le temps d'arrivé est correct

    public static boolean vraiTemps(double temps, double[] arrivee){

        boolean ssi= false;

        for ( int i = 1; i<arrivee.length; i++){

            if (arrivee[i]<  temps)

                ssi= true;

            else

                return false;

        }

            

        return ssi;

    }

    //methode 7 vérification si le participant enregistré n'est pas déjà arrivé 

    public static boolean dejaArrive (int [] classement, int arrivee){

        

        for ( int i = 1; i<classement.length; i++){

            if (classement[i]== arrivee)

                

                return false;

        }

            

        

        

        return true;

    }

    // classement des 3 finaliste à la fin du programme

    public static void classementFinaliste (int [] classement, String [] participants){

              Terminal.ecrireStringln("Les trois finaliste de la " + participants[0]+" sont:");

              int [] finalistes = new int [3];

              int cl=0;

              while (cl<3){

                for (int i=0; i<classement.length; i++){

                  if (participants[classement[i]]!= "####"){

                      classement[i]= finalistes[cl];

                      cl++;

                  }

                }

              }

                  

              if (finalistes[0]!=0)   

                Terminal.ecrireStringln( participants[finalistes[0]]+ " en premier ");

              if (finalistes[1]!=0)

                Terminal.ecrireStringln( participants[finalistes[1]]+ " en deuxième ");

              if (finalistes[2]!=0)

                Terminal.ecrireStringln( participants[finalistes[2]]+ " en troisième ");

    }

    //début programme

    public static void main(String[] args) {

        // intialisation du programme

        Terminal.ecrireString("Programme des courses de cyclistes");

        Terminal.sautDeLigne();

        Terminal.ecrireString("Entrez le numéro de la course: ");

        int NumCourse = Terminal.lireInt();

        Terminal.ecrireString("Entrez l'emplacement de la course:  ");

        String  localisation = Terminal.lireString();

        // étape n°1 l'enregistrement des cyclistes avant le debut de la course

        

        Terminal.ecrireString("Intialisation de l'inscription à la course n°" + NumCourse+

                " qui a lieu à "+ localisation+ ". L'inscription est ouverte seulemant "

                + "avant le debut de la course");

        Terminal.sautDeLigne();

        Terminal.ecrireString("Quel est le maximum de participants dans cette course?");

         

         int max = Terminal.lireInt();// max est le numero de participant maximal pour la course

        

         

        // intialisation des tableaux par raport à max 

        // participants_ numéro de case par dossard- affectation du nom du participant 

        String [] participants = new String [max+1];

        participants [0]= "course n°"+ NumCourse+" à "+ localisation;

        // la case 0 pour garder l'information de la course par chaque tableau

        // donc le tableau est de taille max+1 la taille qui a été tapée par l'utilisateur

        //abandon_ les nom des participants dans la case du numéro de leur dossard

        String [] abandon = new String [max+1];

        abandon [0]= "Les abandons";

        //Disqualifier_les nom des participants dans la case du numéro de leur dossard

        String []  disqualifier = new String [max+1];

        disqualifier [0]= "les disqualification";

        //arrivee_ temps par NumDossard

        double [] arrivee = new double [max+1] ;

        arrivee[0]=  NumCourse;

        // classement_ par arrivée (premier dans la case 0, est stocké le numDossard)

        int [] classement = new int [max] ;

       

       

       

        

        

        int NumDossard= 0;

        String nom;

        int choix;

        

        do{

            Terminal.ecrireStringln("Pour ajouter un cycliste tapez 1");

            Terminal.ecrireStringln("Pour enregistrer un abandon tapez 2");

            Terminal.ecrireStringln("Pour afficher les participants tapez 3");

            Terminal.ecrireStringln("Pour  commencer la course tapez 4");

            choix = Terminal.lireInt();

            //ajouter un cycliste

           if (choix == 1){

               

               Terminal.ecrireString("veuillez saisir numéro de dossard: ");

               NumDossard = Terminal.lireInt();

               if (NumDossard<participants.length && NumDossard>0 ){

                   if (participants [ NumDossard]== null){

                       Terminal.ecrireString("veuillez saisir nom: ");

                       nom = Terminal.lireString();  

                       trouver (nom, participants , NumDossard); // methode 2 affectation du nom au numero de dossard

                    }else { 

                         Terminal.ecrireStringln("Erreur! numéro de dossard est déjà utilisé!");

                  }

               

               }else {

                   Terminal.ecrireStringln("Erreur! numéro de dossard incorrect");

                   

               }   

               continuer();//methode 1

           }

             

               

              

           

           //abandon d'un cycliste avant la course

           if (choix == 2){

               Terminal.ecrireString("veuillez saisir numéro de dossard");

               int i = Terminal.lireInt();

               if (i<participants.length && i>0 && participants[i] !=null && participants[i]!= "####"){

                    Terminal.ecrireString("êtes-vous sûr de vouloir supprimer le participant n°"+i+"-  "+participants[i] 

                       +" ? tapez 'o' pour oui");

                    if (Terminal.lireChar()=='o'){

                        abandonner (i, participants, abandon);

                    } else {

                         Terminal.ecrireString( "ce participant ne sera pas suprimé!");

                      }

               } else {

                 Terminal.ecrireStringln("Erreur! numéro de dossard incorrect");    

               

           }

               continuer();//methode 1

           }

           if (choix == 3){

               affichertab (participants); // affichage des participants par numéro de dossard et nom, sans les abandons

               continuer();//methode 1

           }

           

        } while ( choix != 4);

    Terminal.ecrireString("Depart!!");

    continuer();//methode 1

        

        int cl=0; // compteur des arrivée pour le classement

        

        

        do {

            Terminal.ecrireStringln("Pour enregistrer un abandon tapez 1");

            Terminal.ecrireStringln("Pour enregistrer une disqualification tapez 2");

            Terminal.ecrireStringln("Pour enregistrer une arrivée tapez 3");

            Terminal.ecrireStringln("Pour afficher classement provisoir tapez 4");

            Terminal.ecrireStringln("Pour afficher les participants  tapez 5");

            Terminal.ecrireStringln("Pour afficher les abandons et les disqualifications tapez 6");

            Terminal.ecrireStringln("pour sortir du programme tapez 7");

            choix = Terminal.lireInt();

            //abandon

           if (choix == 1){

               Terminal.ecrireString("veuillez  saisir numéro de dossard");

               int i = Terminal.lireInt();

               if (i<participants.length && i>0 && participants[i]!=null && participants[i]!= "####"){

                    Terminal.ecrireString("êtes-vous sûr de vouloir supprimer le participant n°"+i

                            +"-  "+participants[i] +" ? tapez 'o' pour oui");

                    if (Terminal.lireChar()=='o'){

                        abandonner (i, participants, abandon);

                    } else {

                   Terminal.ecrireString( "ce participant ne sera pas suprimé!");

               }

               

           } else {

                   Terminal.ecrireStringln("Erreur! numéro de dossard incorrect");

                   

               }

               continuer();//methode 1

           }

           //disqualification

           if (choix == 2){

              Terminal.ecrireString("veuillez saisir numéro de dossard");

               int j = Terminal.lireInt();

               if (j<participants.length && j>0 && participants[j]!=null && participants[j]!= "####"){

                     Terminal.ecrireString("êtes-vous sûr de vouloir disqualifier le participant n°"+j

                             +"-  "+participants[j] +" ? tapez 'o' pour oui");

                    if (Terminal.lireChar()=='o'){

                     disqualification (j, participants, disqualifier);

                     classement[j]=0;

                    } else {

                   Terminal.ecrireString( "ce participant ne sera pas disqualifié!");

                    }

               

           }else {

                Terminal.ecrireStringln("Erreur! numéro de dossard incorrect");

                

               }

           continuer();//methode 1   

           }

           //arrivée

           if (choix == 3){

               Terminal.ecrireString("veuillez saisir numéro de dossard");

               int j = Terminal.lireInt();

               

               if (j<participants.length && j>0 && participants[j]!=null && participants[j]!= "####"){

                   if (!dejaArrive ( classement, j))

                   Terminal.ecrireString("Participant est déjà arrivé");

                   else {

                   classement [cl]= j;

                    cl++;

                    Terminal.ecrireString("veuillez  saisir le temps d'arrivée");

                    double temps = Terminal.lireDouble();

                    while (vraiTemps( temps,  arrivee)== false){

                         Terminal.ecrireStringln("Erreur! Temps d'arrivée incorrect");

                         Terminal.ecrireString("veuillez  saisir le temps d'arrivée");

                         temps = Terminal.lireDouble();

                    }

                   arrivee [j]= temps; // temps du cycliste est stocké dans la case par le numéro de dossard

                        

                           

                   }    

                   

              } else {

                    Terminal.ecrireStringln("Erreur! numéro de dossard incorrect");

                   

               }

               continuer();//methode 1 

           } 

           //afficher classement

            if (choix == 4){

                if (classement[0]==0){

                    Terminal.ecrireString("pas de coureur arrivée!");

                }

                else{

                   classement ( participants, classement, arrivee);

               }

               continuer();//methode 1

            }

            //afficher les participants

              if (choix == 5){

                  affichertab (participants);

                 continuer();//methode 1

            }

            //afficjer les abandons et disqualificatiions

              if (choix == 6){

                  

                  affichertab (abandon);

                  Terminal.sautDeLigne();

                                   

                  affichertab (disqualifier);

                  continuer();//methode 1

              }

              // fin de la course

             if (choix == 7){

              Terminal.ecrireStringln("La course est terminée!!!");

              classementFinaliste ( classement, participants);

                      

                     

                }

              

         } while (choix != 7);

         

      Terminal.ecrireStringln("Fin du programme!");

         

         

        

    }

}

