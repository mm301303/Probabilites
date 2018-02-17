package TD4_MIAGE;

import Exceptions.CalculationException;
import Exceptions.LawException;
import Laws.BinomialeLaw;
import Laws.GeometricLaw;
import org.junit.Test;
import tools.Calculation;

import java.lang.reflect.GenericArrayType;

import static org.junit.Assert.assertEquals;
import static tools.Displayable.closure;
import static tools.Displayable.title_prefix;

public class TD4S6_exercice5 {

    @Test
    public void bonAppetit() throws LawException, CalculationException {
        System.out.println(title_prefix + this.getClass().getSimpleName());

        //contexte
        /*
        Un étudiant en mathématiques arrondit ses fins de mois à la caisse d’une cantine. Il se rend
        compte que de nombreux plateaux différents passent sous ses yeux chaque jour, et sa curiosité
        déplacée de mathématicien veut essayer d’en savoir un peu plus. Il constate notamment qu’il
        peut y avoir au total 250 plateaux différents.
        */
        System.out.println("a)");
        /*
        L’étudiant passe avant tous les clients à la cantine, et respecte les contraintes pour le plateau.
        Sachant que 500 personnes vont venir manger à la cantine ce jour, quelle est la loi de la
        variable aléatoire X du nombre de clients qui ont pris le même plateau que l’étudiant ?
        Pourquoi et quel(s) paramètre(s) a cette loi ?
        */

        //l'expérience consiste a comparer 2 par 2 les 500 plateaux de la cantines. Chaque plateau peut etre d'une des 250 sortes possibles
        //Soit B la loi Binomiale de parametres 1/250 500 qui modélise cette expérience

        BinomialeLaw bl = new BinomialeLaw(1./250., 500);

        /*  Correction
            Dans cette situation, on répète 500 fois l’expérience consistant à regarder si la personne
            a le même plateau que l’étudiant, et compte le nombre de fois où cela arrive. X suit
            donc une loi binomiale de paramètres n = 500, le nombre de répétitions et p = 1/250,
            la probabilité qu’une personne ait le même plateau que l’étudiant (chaque plateau a la
            même probabilité d’apparaître). Donc, X ∼ B(500, 1/250).
        */
        System.out.println("b)");
        double p5 = bl.getProbabiliteDeX(5);
        assertEquals(Calculation.kParmisN(5, 500)*1.*Math.pow(249., 495.)/Math.pow(250., 500.), p5, 0.0001);

        /*Combien de personnes en moyenne l’étudiant doit-il voir passer avant que quelqu’un ait le
        même plateau que lui ?
        */
        System.out.println("c)");
        /*soit Y la variable aléatoire correspondant au nombre 'd'essais', soit le nombre de tentatives avant de retrouver le meme plateau.
        On a une chance sur 250 de retrouver le même plateau*/
        GeometricLaw gl = new GeometricLaw(1./250.);
        assertEquals(250., gl.getEsperance(), 0.001);

        System.out.println(closure);

    }
}
