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

        double res = cl.F(1,2);
        double res2 = cl.F(-2,-1);
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
    private ContinuousLaw returnCL() {
        ContinuousLaw cl = new ContinuousLaw() {
            @Override
            public double f(double a) {
                return a*a;
            }

            @Override
            public double F(double x_inferieur_a_y, double x_superieur_a_y) {
                double nb_points=100000;
                double dx = 1./nb_points;
                double surface =0;
                double i=x_inferieur_a_y;
                //la fonction est paire
                for(; i<x_superieur_a_y; i=i+dx)
                {
                    surface += f(i)*dx;


                }
                return surface;
            }

            @Override
            public double F_de_p_superieur_a(double b) {
                return 0;
            }

            @Override
            public double F_de_p_inferieur_a(double b) {
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
            public double F(double x_inferieur_a_y, double x_superieur_a_y) {
                double nb_points=100000;
                double dx = 1./nb_points;
                double surface =0;
                double i=x_inferieur_a_y;
                //la fonction est paire
                for(; i<x_superieur_a_y; i=i+dx)
                {
                    surface += f(i)*dx;


                }
                return surface;
            }

            @Override
            public double F_de_p_superieur_a(double b) {
                return 0;
            }

            @Override
            public double F_de_p_inferieur_a(double b) {
                return 0;
            }
        };
        return cl;
    }
    private double primitivedeXcosX(double x){
        return x*Math.sin(x) + Math.cos(x) ;
    }

}