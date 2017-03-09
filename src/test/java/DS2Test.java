import Laws.UniformDiscreteLaw;
import Laws.UniformLaw;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by max on 07/03/17.
 */
public class DS2Test {
double delta =0.001;
    @Test
    public void question12(){
        System.out.println("On tire une valeur de T selon une loi unifome (discrete) sur [-9;5]");
        System.out.println("Pour quelle valeur de X a-t'on P(T<X)= 0.25 ?");
       assertEquals(-5.5, computeFor12(), delta);
    }

    private double computeFor12(){
        int borneInf = -9, borneSupp = 5;
        UniformLaw law = new UniformLaw(borneInf, borneSupp);
        double res =0;
        for(double i=-9.0; i<5.0; i+=0.1){
            res=law.density(-9., (double) i);
            if(res<=0.25+delta && res>=0.25-delta){
                System.out.println("pour i = " + i+" on obient res = " +res);
                return i;
            }
            System.out.println("res = " + res);
        }
        return 0.;
    }

}