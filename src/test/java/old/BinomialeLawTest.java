package old;

import Exceptions.CalculationException;
import Exceptions.LawException;
import Laws.BinomialeLaw;
import Laws.functions.DiscreteLaw;
import Laws.functions.Law;
import org.junit.Test;
import tools.Calculation;

import static org.junit.Assert.*;

/**
 * Created by max on 09/03/17.
 */
public class BinomialeLawTest {
    BinomialeLaw law;
    double delta = Calculation.DELTA;
    @Test
    public void TD1exo21() throws Exception, LawException, CalculationException {
        System.out.println("\nTD1exo21");
        // P qu’il ait au moins un garçon ?
        BinomialeLaw law = new BinomialeLaw(0.5, 2);
        System.out.println("Le voisin a deux enfants\nP qu’il ait au moins un garçon ?");
        double res = 0;
        for(int X=1; X<=2; X++) res+= law.getProbabiliteDeX(X);
        System.out.println("res = " + res);
        assertEquals(3./4., res, delta);
        System.out.println("Quelle est la probabilité qu’il ait un garçon, sachant que l’aînée est une fille ?");
        law = new BinomialeLaw(0.5,1);
        res = law.getProbabiliteDeX(1);
        System.out.println("res = " + res);
        assertEquals(0.5, res, delta);
    }

    @Test
    public void TD1exo26() throws Exception, LawException, CalculationException {
        System.out.println("\nTD1exo26");
        System.out.println("medicament qui provoque une allergie a 1 personne sur 100");
        System.out.println("probabilité d'au moins une allergie sur 70 patients ?");
        BinomialeLaw law = new BinomialeLaw(0.01, 70);
        double res = 0;
        res = 1 - law.getProbabiliteDeX(0);
        System.out.println("res = 1 - law.getProbabiliteDeX(0) = " + res);

        assertEquals(50.51/100.0, res, delta);
    }

    @Test
    public void TD1exo30() throws Exception, LawException, CalculationException {
        System.out.println("\nTD1exo30");

        int bonNombreDeTirage = 0;
        System.out.println("Pour construire un robot, un étudiant de Polytech a besoin de 12 circuits intégrés identiques R2D2.\n Chaque circuit intégré a 5% de chance d’être défectueux.\n"
                +" Combien (au minimum) de circuits cet étudiant doit-il acheter pour être certain (à 90%) d’avoir au moins 12 circuits intégrés sans défauts ?");
        //12 circuits
        //p succes = p sans defaut = 0.95
        //achats pour 90% de chance d'avoir 12 succes

        System.out.println("pour n=12 :");
        int n=12,i;
        double proba12 = 0;
        BinomialeLaw law = new BinomialeLaw(0.95, n);
        proba12=law.getProbabiliteDeX(12);
        System.out.println("proba12= " + proba12);
        assertEquals(0.5404, proba12, delta);

        assertFalse(proba12>=0.9);
        System.out.println("Pour 12 tirages P(X>=12) = "+proba12);


        System.out.println("pour n=13 :");
        n=13;
        double proba13 = 0; //On garde la proba précédente
        law = new BinomialeLaw(0.95, n);
        for(i=12; i<n+1; i++) proba13+=law.getProbabiliteDeX(i);
        assertEquals(0.8646, proba13, delta);
        assertFalse(proba13>=0.9);
        System.out.println("Pour 13 tirages P(X>=12) = P(X=12)+P(X=13) = "+proba13);



        System.out.println("pour n=14 :");
        n=14;
        double proba14 = 0;
        law = new BinomialeLaw(0.95, n);
        for(i=12; i<n+1; i++)
            proba14+=law.getProbabiliteDeX(i);
        //assertEquals(0.9699,proba14, delta);//TODO ask for correction or explanation
        assertTrue(proba14>=0.9);
        System.out.println("Pour 14 tirages P(X>=12) = P(X=12)+P(X=13)+P(X=14) = "+proba14);
        System.out.println(law.getProbabiliteDeX(14));
    }





}