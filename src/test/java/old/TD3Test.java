package old;

import Exceptions.CalculationException;
import Exceptions.LawException;
import Laws.*;
import Properties.CentralLimitTheorem;
import Properties.Markov;
import Properties.Tchebychev;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tools.Calculation;

import static java.lang.Math.sqrt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * approximation are really bad due to a minimalist implementation of mathematical models...
 */
public class TD3Test {

    String consignes, reponses;
    @Before
    public void init(){
        consignes = "";
        reponses = "";
        System.out.println("\n* * * * * * * * * * * *");
    }

    @After
    public void display(){
        System.out.println(consignes+"\n"+reponses);
    }



    @Test
    public void ex2() throws CalculationException {
        double moy=65., s=5.;
        consignes+=("\nExercice 2");
        consignes+=("\n65 de moyenne a un examen, s=5, donnez la proportion d'etudiants entre 45 et 85");
        assertEquals(0.0625, Tchebychev.inequality(5,20), Calculation.DELTA);
        reponses+=("\nselon Tchebychev : "+Tchebychev.inequality(5,20));

        reponses+=("\nPar la loi uniforme :");
        reponses+=("\non doit calculer la borne inf et supp");
        reponses+=("\nPar la loi uniforme sur un intervalle de longeur lambda on a V(X)=lambda^2 / 12");

        double var_x = s*s;
        double lambda = Math.sqrt(12.*25.);
        assertEquals(17.32, lambda, 0.001);
        reponses+=("\nlambda = "+lambda);
        reponses+=("\ndonc pour une longueur lambda : [65-lambda/2;65+lambda/2]");
        UniformLaw law = new UniformLaw(moy-lambda/2, moy+lambda/2);
        assertEquals(1., law.F(45,85), 0.001 );
        reponses+=("\nPar la loi uniforme sur un intervalle de longeur lambda la proportion d'etudiants entre 45 et 85 vaut " +law.F(45,85));
        System.out.println("\nPar la loi normale :");
        NormaleLaw normaleLaw = new NormaleLaw(moy, s*s);
        double res = 1.-(2.*normaleLaw.F(45));
        //TODO Fix
        assertEquals(0.999937, res, Calculation.DELTA );
        reponses+=("\n Par la loi normale la proportion d'etudiants entre 45 et 85 vaut " +res);

    }

    @Test
    public void ex3() throws CalculationException {
        double moy=10.;
        consignes+=("\nExercice 3");
        consignes+=("\nSoit X une variable aléatoire à valeur positive d’espérance\n" +
                "E(X) = 10");
        consignes+=("\nTrouver une borne inférieure pour P(X<20)");
        reponses+=("\nPar Markov:");
        double res = Markov.P_x_sup_a_y_inferieur_a(moy, 20);
        reponses+=("\nres = " + res);

        assertEquals(0.5, res,Calculation.DELTA);
        consignes+=("\nMême question si X suit une loi exponentielle.");
        ExponentialLaw exponentialLaw = new ExponentialLaw(1./moy);
        System.out.println("Rappel : Moyenne = 1/lambda");
        assertEquals(moy,exponentialLaw.getEsperance(), Calculation.DELTA);
        double resExp = exponentialLaw.F( 20);
        assertEquals(0.8647, resExp,Calculation.DELTA);
        reponses+=("\nres = " + resExp);

        consignes+=("\nMême question si X suit une loi uniforme.");
        consignes+=("\nRappel : Moyenne = (inf+supp)/2");

        double inf=0;
        double supp=20;
        UniformLaw ulaw = new UniformLaw(inf,supp);
        assertEquals(moy, ulaw.getEsperance(), Calculation.DELTA );
        double resUni = ulaw.F( 20);
        assertEquals(1,resUni, Calculation.DELTA);
        reponses+=("\nres = " + resUni);

    }

    @Test
    public void ex4() throws CalculationException {

        consignes+=("\nExercice 4");
        consignes+=("\nTrouvez la meilleure borne pour P(X>10) : ");
        double resA=0,resB=0,resC=0,resD=0;
        reponses+=("\nE(X) = 3 & X>0");
        resA = Markov.P_x_sup_a_y_inferieur_a(3., 10);
        reponses+=("\n"+resA);
        reponses+=("\nE(X) = 7 & X>6");
        resB = Markov.P_x_sup_a_y_inferieur_a(7.-6., 10.-6.);
        reponses+=("\n"+resB);
        reponses+=("\nE(X) = 2 & X>-5");
        resC = Markov.P_x_sup_a_y_inferieur_a(2.+5, 15);
        reponses+=("\n"+resC);
        reponses+=("\nE(X) = 5 & X>-10");
        resD = Markov.P_x_sup_a_y_inferieur_a(5+10, 20);
        reponses+=("\n"+resD);

        assertEquals(0.3, resA, Calculation.DELTA);
        assertEquals(0.25, resB, Calculation.DELTA);
        assertEquals(7./15., resC, Calculation.DELTA);
        assertEquals(15./20., resD, Calculation.DELTA);

    }

    @Test
    public void ex5() throws CalculationException {

        System.out.println("\nExercice 5");
        consignes += "Soit une variable aléartoire d'espérence E(X)=0" +
                "\ntelle que P(-3<X<2)=1/2"+
                "\na) Trouvez une borne inférieure pour V(X)"+
                "\nb) Trouvez V(X) si X suit une loi uniforme";
        System.out.println("a) \n -on sait que P(-3<X<2) < P(-2<X<2)" +
                "\net p(|x|<2)=1-(P(|X|>2)<1/2, on ne peut pas appliquer l'inégalité de markov car X est d'esperance nulle." +
                "\nOn peut appliquer Tchbichev P( |X-E(X)| > t ) < V(X) / (t^2) avec t = 1/2 et E(X) = 0 :" +
                "\ncomme P(|x-0|<2)<P(-3<X<2)  on obtient  P(|x-0|<2) < 1/2");
       double res = 0;
       res = Tchebychev.inequality(2.,2.);
       System.out.println("Pour une variance >= 2, P(|x-0|<2)=2/2*2 = "+res+">= 1/2");
       assertEquals(1/2., res, Calculation.DELTA);

        System.out.println("b) Si X suit une loi uniforme comme P(-3<X<2)=1/2" +
                "\nSur 5 valeurs on vaut 1/2, il faut 10 valeurs pour un d'ou :" );
        UniformLaw law = new UniformLaw(-5,5);
        double esp = law.getEsperance();
        double var = law.getVariance();
        assertEquals(0, esp, Calculation.DELTA);
        assertEquals(8.33, var, 0.01);

    }

    @Test
    public void ex6() throws CalculationException {

        System.out.println("\nExercice 6");
        consignes = "On lance un dé 100 fois et on fait la somme S des résultats." +
                "\nQue peut-on dire de P(|S-350|>50 ? ";
        System.out.println("E(S) vaut 100*E(Dé)= 100*3.5");
        System.out.println("Calculons la variance");
        double variance = 100*(7*5)/(2*6) ;//WHY ??
        System.out.println("variance = " + variance);
        double res = Tchebychev.inequality(variance,50);
        System.out.println("res = Tchebychev.inequality(variance,50);");
        assertEquals(7./60., res, 0.001);
        System.out.println("par le tcl, S suit une loi normale avec u = 350 et ecart_type = racine(100*(7*5)/(2*6))= "+ Math.sqrt(100*(7*5)/(2*6)));
        NormaleLaw normaleLaw = new NormaleLaw(350, Math.sqrt(291));
        res = normaleLaw.F(-400,300);
        assertEquals(0.3415, res, Calculation.DELTA);

        assertFalse(true);

    }

    @Test
    public void ex8() throws LawException, CalculationException {

        System.out.println("\nExercice 8");
        consignes = "Un fournisseur d'accés a 5000 abonnés sur un point d'accés. " +
                "a un instant donné, chaque abonné a 20% de chance d'etre connecté." +
                "\nLes comportements des abonnés sont supposés indépendants les uns des autres";

        consignes+="\na) Quelle est la loi de X = le nombre de connecté a un instant t ? Esperance, ecart-type ?";
        reponses = "a)BinomialeLaw law = new BinomialeLaw(0.2,5000)\n";
        consignes+="\nb) Quelle variable aléatoire Y a une loi approximable par le loi normale(0,1) ?";
        consignes+="\nc) Le fournisseur d'accés veut savoir combien de connexion simultanée le point d'accés doit pouvoir gérer pour que sa proba d'etre" +
                "saturé soit inférieure a 2.5%\n" +
                "en utilisant l'approximation précédente, proposer une valeur approchée de ce nombre de connexions ?";

        //a)
        BinomialeLaw X = new BinomialeLaw(0.2,5000);
        double variance = X.getVariance();//n*p*(1-p)
        System.out.println("variance = " + variance);
        double esperance = X.getEsperance();//n*p
        reponses+="\nesperance = " + esperance;
        //b)
        NormaleCenteredReducedLaw law2 = new NormaleCenteredReducedLaw();
        reponses+="\nb)Z = ( X - E(x) ) / s(x)  avec s l'ecart type\n";
        //Z = ( X - E(x) ) / s(x)  avec s l'ecart type
        //c)Par Markoff ça marche
        // E/a=2.5% => a = 40E => a=40 000
        //on essaie de savoir combien de ligne on doit installer
        //assertEquals(0.975, law2.F(1.96), Calculation.DELTA);//lecture inverse

        double X_  = esperance + 1.96 * Math.sqrt(variance);
        reponses+="\nc) On cherche P(X>a) = 2.5% = F(-1.96) par lecture inverse \n" +
                "Donc a = 1.96 et pour X = esperance + 1.96 * sqrt(variance)\n" +
                "X >= " + X_ +" lignes ("+(int) X_+")";
        assertEquals(0.975, law2.F(1.96), Calculation.DELTA);//lecture inverse
    }

    @Test
    public void ex9() throws CalculationException {

        System.out.println("\nExercice 9");
        String consigne = "Une entreprise compte 300 employés, chacun d'eux téléphone 6 min par h, \n";
        consigne+=" combien de lignes l'entreprise doit elle installer pour que la probabilité que toutes les lignes soient utilisées au même instant soit au plus égale à 2.5%\n";

        String reponse = "par la loi normale on sait de l'exo d'au dessus que F(-1.96) = 97.5%\n";
        double esperance = 300 * 0.1;
        double variance = 300 * 0.1 * 0.9; //loi binomiale
        double X_  = esperance + 1.96 * Math.sqrt(variance);
        reponse+="X>="+X_+"\n";
        System.out.println(consigne);
        System.out.println(reponse);
    }

 @Test
    public void ex10() throws CalculationException {

        consignes += "\nExercice 10";
        consignes += "\nL'ampoule qui éclaire un ascenceur reste toujours allumée \n";
        consignes+="Sa durée de vie suit une loi exponentielle de moyenne 30 jours\n";
        consignes+="a) Quelle est la proba de ne pas changer l'ampoule pendant 2 mois ?\n";

        reponses += "a) esperance = 1/30 , variance = 30*30; //loi exponentielle \n";
        double esperance = 1/30;

        double variance = 30*30; //loi exponentielle
        double X_  = esperance + 1.96 * Math.sqrt(variance);
        reponses+="X>="+X_+"\n";

        assertFalse(true);//not finished
        //TODO refaire loi exponentielle
    }

    @Test
    public void ex11() throws CalculationException {

        consignes += "\nExercice 11\n" +
                "Arrondis Soit X une variable aléatoire de loi exponentielle de paramètre lamdba . Soit Y = ⌈ X ⌉ , \n" +
                " l’arrondi par valeur supérieure de X .\n Quelle loi suit Y ?";


        reponses+=" * P(Y=n)=P(n-1<X<=n)=e^⁽-lambda(n-1)) - e^⁽-lambda)\n" +
                " *\t(1-p)^(n-1) * p avec p=1-e^(lambda)";

        assertFalse(true);//not finished
        //TODO refaire loi exponentielle
    }


    @Test
    public void ex12() throws CalculationException {

        consignes += "\nExercice 12\n" +
                "Soit X une variable aléatoire de moyenne E et d’écart-type s\n." +
                "\nQuelle est la taille du plus grand intervalle ? I = [E-lambda, E-lambda], centré autour de la moyenne tel qu’il est possible d’avoir\n" +
                "P(X appartenant à I) = 0\n";



        reponses+=" *P(E-lambda <= X <= E+lamda) =0 possible pour lambda < s\n" +
                "P(|X-E|>=lambda)<=V/lambda^2";

        assertFalse(true);//not finished
    }

}