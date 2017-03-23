import Exceptions.CalculationException;
import Exceptions.LawException;
import Laws.BinomialeLaw;
import Laws.ExponentialLaw;
import Laws.NormaleCenteredReducedLaw;
import Laws.NormaleLaw;
import org.junit.Test;
import tools.Calculation;

import java.util.Map;

import static java.lang.Math.sqrt;
import static org.junit.Assert.*;

/**
 * approximation are really bad due to a minimalist implementation of mathematical models...
 */
public class DS3Test {
    @Test
    public void question1() throws CalculationException {
        System.out.println("question1");
        System.out.println("Les notes de la classes sont réparties entre 6 et 17");
        System.out.println("avec une moyenne de 11");
        System.out.println("On choisit un eleve au hasard, truver la meilleur borne pour que cet élève ait une");
        System.out.println("note >=13");

        NormaleLaw law = new NormaleLaw(11., 25.);
        double res = law.F_de_p_superieur_a(13);
        System.out.println("res = " + res);
    }

    @Test
    public void question1_correc_groupe_fb() throws CalculationException {
        System.out.println("question1_correc_groupe_fb");
        System.out.println("Soit X une var aléatoire suivant la loi normale de moyenne u et d'ecart type s\n"+
                "Calculez P(|X-u|<s");

        System.out.println("On va prendre la loi normale");
        NormaleCenteredReducedLaw law = new NormaleCenteredReducedLaw();
        double res = law.F(1.)-law.F(-1.);
        System.out.println("P(|X-u|<s => X is in [-s;+s]");
        System.out.println("Dans notre cas la réponse est P(X<1)-P(X<-1)  ");
        System.out.println("res = law.F(1.)-law.F(-1.) = " + res);
        assertEquals(0.84134, 2.*res, 0.2);

    }
    @Test
    public void question2_correc_groupe_fb() throws CalculationException {
        System.out.println("question2_correc_groupe_fb");
        System.out.println("Une promotion est partagée en deux groupes. Le groupe 1 avec 21 étudiants obtient une moyenne de 7 a l'exam\n"+
                "Le groupe 2 avec 24 étudiants obtient une moyenne de 13. Quelle est la moyenne de la promo ? \n" );
        double res = (21.*7.+24.*13.)/(21.+24.);
        System.out.println(" res = (21.*7.+24.*13.)/(21.+24.) = " + res);
        assertEquals(51./5., res, Calculation.DELTA);

    }
    //Q4 et Q3 sont des lectures inverses
    @Test
    public void question5_correc_groupe_fb() throws CalculationException {
        System.out.println("question5_correc_groupe_fb");
        System.out.println("Soit T1 et T2 deux variables aléatoire suivant la loi normale de parametre lambda = 3\n"+
                "Calculer la proba d'avoir en meme temps T1 et T2 inférieurs à 1./6.");
        ExponentialLaw T1;
        T1 = new ExponentialLaw(3.);
        double res= Math.pow(T1.F(1./6.), 2.);

        assertEquals(0.1547, res, 0.001);

    }
    @Test
    public void question8_correc_groupe_fb() throws CalculationException {
        System.out.println("question8_correc_groupe_fb");
        System.out.println("La taille des habitants d'un pays A suit une loi normale u=169 et s=9\n"+
        "Le pays B u = 180 et s = 14\n" +
                "Quelle est la proba que le mec de a soit plus grand ?");
        NormaleLaw lawA = new NormaleLaw(169., 81.);
        NormaleLaw lawB = new NormaleLaw(180., 196.);
        NormaleLaw lawC = new NormaleLaw((lawA.getEsperance()-lawB.getEsperance()), sqrt(lawA.getVariance()+lawB.getVariance()));
        double res = lawC.F_de_p_superieur_a(0);
        System.out.println("->"+11./sqrt(14*14+81.));
        assertEquals(0.2543, res, 0.001);

    }


}