package TD4_MIAGE;

import Laws.UniformLaw;
import org.junit.Test;
import tools.Displayable;

import static org.junit.Assert.assertEquals;

public class TD4S6_exercice6 implements Displayable{
    @Test
    public void exercice6_correction(){
        System.out.println(title_prefix + this.getClass().getSimpleName());
        System.out.println("Soit la var aléatoire qui correspond a un lancer de dés à 6 faces, c acorrespond à une loi uniforme :");
        UniformLaw uniformLaw = new UniformLaw(1, 6);
        System.out.println("que vaut E=P(X<=2|X<=3)? : on utilise la formule des probas conditionnelles cf cours");
        System.out.println("ici P(X<=2 n X<=3) = P(X<=2) ");
        System.out.println("d'ou E= P(X<=2)/P(X<=3) = "+ uniformLaw.F(2)/uniformLaw.F(3));
        assertEquals(2./6.,uniformLaw.F(2.), 0.0001);
        assertEquals(3./6.,uniformLaw.F(3.), 0.0001);
        //a est la var aléatoire qui correspond a un lancer de dés à 6 faces
    }
}
