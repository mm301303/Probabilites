package tools;

import Exceptions.CalculationException;
import Laws.NormaleLaw;
import Laws.functions.ContinuousLaw;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by max on 09/03/17.
 */
public class CalculationTest {

    double delta = 0.01;
    @Test
    public void factorielle() throws Exception {
        try{
            assertEquals(1,Calculation.factorielle(0),delta);
            assertEquals(2,Calculation.factorielle(2),delta);
            assertEquals(1,Calculation.factorielle(1),delta);
            assertEquals(6,Calculation.factorielle(3),delta);
            assertEquals(362880,Calculation.factorielle(9),delta);

        }catch (CalculationException e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void kParmisN() throws Exception {
        try{
            assertEquals(36,Calculation.kParmisN(1,36),delta);
            assertEquals(1,Calculation.kParmisN(36,36),delta);
            assertEquals(906192.,Calculation.kParmisN(6,32),delta);


        }catch (CalculationException e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void integrale() throws Exception {

        ContinuousLaw cl = returnCL();

        double res = cl.F(2)-cl.F(1);
        double res2 =  cl.F(-2)-cl.F(-1);
        assertEquals(7./3.,res,Calculation.DELTA);
        assertEquals(7./3.,res2,Calculation.DELTA);

    } @Test
    public void integraleSimpsonTest() throws Exception {

        ContinuousLaw cl = returnCL();

        double res = Calculation.integraleParSimpson(1,2, cl);
        double res2 = Calculation.integraleParSimpson(-2,-1, cl);
        assertEquals(7./3.,res,Calculation.DELTA);
        assertEquals(7./3.,res2,Calculation.DELTA);

    }
    @Test
    public void integrale2() throws Exception {

        ContinuousLaw cl = returnCL2();
        assertEquals(primitivedeXcosX(2)-primitivedeXcosX(1), Calculation.approximationDintegrale(1,2, cl), Calculation.DELTA);
        assertEquals(primitivedeXcosX(50)-primitivedeXcosX(1), Calculation.approximationDintegrale(1,50, cl), Calculation.DELTA);
        assertEquals(primitivedeXcosX(10)-primitivedeXcosX(-20), Calculation.approximationDintegrale(-20,10, cl), Calculation.DELTA);

    }
    @Test
    public void integrale2_Simpson() throws Exception {

        ContinuousLaw cl = returnCL2();
        assertEquals(primitivedeXcosX(10)-primitivedeXcosX(-20), Calculation.integraleParSimpson(-20,10, cl), Calculation.DELTA);
        assertEquals(primitivedeXcosX(2)-primitivedeXcosX(1), Calculation.integraleParSimpson(1,2, cl), Calculation.DELTA);
        assertEquals(primitivedeXcosX(50)-primitivedeXcosX(1), Calculation.integraleParSimpson(1,50, cl), Calculation.DELTA);

    }
    private ContinuousLaw returnCL() {
        ContinuousLaw cl = new ContinuousLaw() {
            @Override
            public double f(double a) {
                return a*a;
            }

            @Override
            public double F(double x_inferieur_a_y) {
                return (x_inferieur_a_y>=0)?Calculation.integraleParSimpson(0, x_inferieur_a_y, this):Calculation.integraleParSimpson(x_inferieur_a_y, 0, this);
            }

            @Override
            public double F_de_p_superieur_a(double b) {
                return 0;
            }

        };
        return cl;
    }
    private ContinuousLaw returnCL2() {
        ContinuousLaw cl = new ContinuousLaw() {
            @Override
            public double f(double a) {
                return a*Math.cos(a);
            }

            @Override
            public double F(double x_inferieur_a_y) {
                return (x_inferieur_a_y>=0)?Calculation.integraleParSimpson(0, x_inferieur_a_y, this):Calculation.integraleParSimpson(x_inferieur_a_y, 0, this);
            }

            @Override
            public double F_de_p_superieur_a(double b) {
                return 1 - F(b);
            }

        };
        return cl;
    }
    private double primitivedeXcosX(double x){
        return x*Math.sin(x) + Math.cos(x) ;
    }

}