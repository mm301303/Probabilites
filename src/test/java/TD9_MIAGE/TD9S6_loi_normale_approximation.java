package TD9_MIAGE;

import Exceptions.CalculationException;
import Exceptions.LawException;
import Laws.*;
import Laws.functions.Law;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;
import tools.Displayable;

public class TD9S6_loi_normale_approximation implements Displayable {
    @Test
    public void exercice1_appliation_directe() throws LawException, CalculationException {

        System.out.println(title_prefix + this.getClass().getSimpleName());
        BinomialeLaw binomialeLaw = new BinomialeLaw(100, 1./5.);
        PoissonLaw poissonLaw = new PoissonLaw(25);

        System.out.println("* a) P(X=20) ?");

        double P_x_eq_20 = binomialeLaw.getProbabiliteDeX(20) ;

        System.out.println("P_x_eq_20 = " + P_x_eq_20);

        System.out.println("* b) P(19<=X<=20)");

        double p_x_lt_20;
        double p_x_lt_19;

        System.out.println("``` \n Point leçon :" +
                "On peut approcher une loi binomiale B(Lambda) par une loi normale de parametre N(np, np(1-p)) ssi np(1-p)>=0");
        System.out.println("d'où ");
        NormaleLaw approximationParNormaleLaw = new NormaleLaw(0.2*100, 0.2*100*0.8);
        p_x_lt_19 = approximationParNormaleLaw.F(19);
        System.out.println("p_x_lt_19 = " + p_x_lt_19);
        p_x_lt_20 = approximationParNormaleLaw.F(20);
        System.out.println("p_x_lt_20 = " + p_x_lt_20);
        System.out.println("P_x_dans_19_20 = p_x_lt_20 - p_x_lt_19");
        double P_x_dans_19_20 = p_x_lt_20 - p_x_lt_19 ;
        System.out.println("P_x_dans_19_20 = " + P_x_dans_19_20+ "\n ```");

        System.out.println("* c) comme dit précédemment dans le rappel du cours");
        System.out.println("* d) "+ (100*0.2*0.8 >=0));
        System.out.println("* e) par la loi normale");
        System.out.println("* f) ");
        approximationParNormaleLaw.F(20.-0.5, 20.+0.5);
        System.out.println("* g) ");
        double p_x_lt_21N = approximationParNormaleLaw.F(21.+0.5);
        double p_x_lt_19N = approximationParNormaleLaw.F(19.-0.5);
        Law.printcalcul("P_x_dans_19_21 par la loi normale ", "p_x_lt_21N - p_x_lt_19N");
        double P_x_dans_19_21 = p_x_lt_21N - p_x_lt_19N ;
        System.out.println("P_x_dans_19_21 = " + P_x_dans_19_21);
        System.out.println("* h) ");
        double p_y_eq_25 = poissonLaw.getProbabiliteDeX(25);

        System.out.println("* i)");
        double P_x_dans_23_27_i = 0;

        for(int i=23; i<28; i++) P_x_dans_23_27_i+=poissonLaw.getProbabiliteDeX(i);
        System.out.println("P_x_dans_23_27_i = " + P_x_dans_23_27_i);
        System.out.println("* j)");
        System.out.println("``` \n Point leçon :" +
                "On peut approcher une loi de poisson B(Lambda) par une loi normale de parametre N(Lambda, Lambda) ssi lambda>=20");
        System.out.println("d'où ");
        double lambda = poissonLaw.getEsperance();
        NormaleLaw approximationDePoissonParNormaleLaw = new NormaleLaw(lambda, lambda);
        double p_x_lt_27N = approximationParNormaleLaw.F(27.+0.5);
        double p_x_lt_23N = approximationParNormaleLaw.F(23.-0.5);
        double P_x_dans_23_27 = p_x_lt_27N - p_x_lt_23N ;
        Law.printcalcul("P_x_dans_23_27 = p_x_lt_27N - p_x_lt_23N", P_x_dans_23_27+" \n```");

        System.out.println("* k)"+ (lambda>20));

        System.out.println("* l)");

        double P_y_eq_25 =  approximationDePoissonParNormaleLaw.F(27.+0.5)-approximationDePoissonParNormaleLaw.F(27-0.5);
        Law.printcalcul("y_eq_25 = F(27.+0.5)-F(27-0.5) ","" + P_y_eq_25);


        System.out.println(closure);

    }
    @Test
    public void exercice2() {


    }




}