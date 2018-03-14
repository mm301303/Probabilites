package TD7;

import Exceptions.CalculationException;
import Exceptions.LawException;
import Laws.ExponentialLaw;
import Laws.GeometricLaw;
import Laws.UniformLaw;
import Laws.functions.Law;
import org.junit.Test;
import tools.Displayable;

import static org.junit.Assert.assertEquals;

public class TD7S6_loi_uniforme implements Displayable {
    @Test
    public void exercice1_esperance_et_variance() {

        System.out.println(title_prefix + this.getClass().getSimpleName());



        System.out.println(closure);

    }
    @Test
    public void exercice2() {

        System.out.println(title_prefix + this.getClass().getSimpleName());

        UniformLaw uniformLaw = new UniformLaw(0, 5);
        uniformLaw.F(3);
        Law.printcalcul("La proba que X soit supérieur à 3 ", "P(X>=3) = 1-P(X<3) = "+ (1-uniformLaw.F(3)));
        Law.printcalcul("La proba que X soit supérieur à 3 sachant qu'il est supérieur à un \nest la probabilité que x soit supérieur à 3", "P(X>=3) = 1-P(X<3) = "+ (1-uniformLaw.F(3)));
        uniformLaw.getEsperance();
        double v = uniformLaw.getVariance();
        Law.printcalcul("ecart-type ", ""+Math.sqrt(v));
        System.out.println(closure);

    }

    @Test
    public void exercice3() {

        System.out.println(title_prefix + this.getClass().getSimpleName());
        System.out.println("on pose : en 27 secondes un mec qui roule a 100 fait 1 km");
        System.out.println("On cree la loi qui donne le nombre de secondes necessaires a atteindre un km dans [30; 70]");
        UniformLaw uniformLaw = new UniformLaw(-30*36, 70*36);
        System.out.println("On cherche la proba d'atteindre une destination dans [-30 ; 70 ] en plus de 30min, soit 1800 secondes");
        System.out.println("On cherche d'abord P(X<1800)");
        double probainf = (uniformLaw.F(1800)-uniformLaw.F(0)) + uniformLaw.F(0);//car on veut la partie gauche et la droite

        double probaSupp = 1.-probainf;

        Law.printcalcul("1-"+probainf, ""+probaSupp);

        System.out.println("de maniere géérale pour avoir P(T>t) il faudra remplacer le 1800 par la vleur souhaitée");

        double density = 60*uniformLaw.f(1);
        Law.printcalcul("density ","" + density);

        double esp = uniformLaw.getEsperance()/60.;
        Law.printcalcul("esp  ","" + esp);


        System.out.println(closure);

    }
    @Test
    public void exercice6() {

        System.out.println(title_prefix + this.getClass().getSimpleName());

        System.out.println("La loi de densité 1/8 * e^(-t/8) est ");
        ExponentialLaw exlaw =  new ExponentialLaw(8.);

        exlaw.getEsperance();

        double var = exlaw.getVariance();
        Law.printcalcul("ecart-type", "1/8="+Math.sqrt(var));

        double pxinf = 1. - exlaw.F(8);
        System.out.println("pxinf = " + pxinf);

        System.out.println(closure);

    }




}