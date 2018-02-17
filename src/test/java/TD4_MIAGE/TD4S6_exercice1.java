package TD4_MIAGE;

import Exceptions.CalculationException;
import Exceptions.LawException;
import Laws.BernouilliLaw;
import Laws.UniformLaw;
import tools.Displayable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TD4S6_exercice1 implements Displayable{
    @Test
    public void exercice1_a(){
        System.out.println(title_prefix + this.getClass().getSimpleName());
        System.out.println("Soit E = P(X=5)");
        UniformLaw uniformLaw = new UniformLaw(1, 16);
        System.out.println("E=1/(supp-inf)="+uniformLaw.f(5)+closure);
        assertEquals(1./(16.), uniformLaw.f(5), 0.00001);
    }

    @Test
    public void exercice1_b() throws LawException, CalculationException {
        System.out.println(title_prefix + this.getClass().getSimpleName());
        System.out.println("Soit E = P(X=5)");
        BernouilliLaw bernouilliLaw = new BernouilliLaw(0.25);
        System.out.println("E=1/(supp-inf)="+bernouilliLaw.getProbabiliteDeX(5)+closure);
    }


}