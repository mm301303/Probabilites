package DM4;

import Exceptions.CalculationException;
import Exceptions.LawException;
import Laws.BernouilliLaw;
import Laws.BinomialeLaw;
import Laws.GeometricLaw;
import Laws.UniformLaw;
import Laws.functions.Law;
import com.sun.jndi.ldap.Ber;
import org.junit.Test;
import tools.Displayable;

import static org.junit.Assert.assertEquals;
//asserts ajoutés à la correction
public class DM4 implements Displayable{
    private UniformLaw uniformLaw_qa;
    private GeometricLaw geometricLaw_q_b1;

    /**
     * Une personne décide de faire du tir à l’arc,
     * et remarque qu’elle arrive toujours à toucher la cible.
     */
    /**
     * Il se rend compte en jouant qu’au final il a
     * la même chance de tomber sur chacune des zones (numérotées de 1 à 10 qui correspondent exactement au nombre de points marqués),
     * vu que les zones à petits points sont plus grandes mais plus simples à atteindre. On note alors X
     * le nombre de points qu’il va obtenir en un seul tir. Déterminer la loi de probabilité de X.
     * Quelle loi reconnaît-on ?
     */
    @Test
    public void q_a(){
        System.out.println(title_prefix+this.getClass().getSimpleName()+"a)");

        System.out.println("S'il y a équiprobabilité de chacun des résultats, c'est une loiuniforme discrète");

         uniformLaw_qa = new UniformLaw(1, 10);


        System.out.println(closure);
    }
    /**
     * Il estime que son tir est bien s’il arrive au moins à marquer au moins 9 points. On note alors
     * Y la variable aléatoire du nombre de fois où il a dû tirer pour réussir à faire un bon tir.
     */
    @Test
    public void q_b() throws LawException {
        System.out.println(title_prefix+this.getClass().getSimpleName()+"b)");
        //Déterminer la loi de probabilité de Y en reconnaissant une loi classique.
        System.out.println("1)");

        System.out.println("On cherche au bout de combien de répétition on arrive à un succés, c'est une loi Géométrique de paramètre 0.2 :\n" +
                "Il y a 2 évènements qui provoquent un succés, soit une probabilité de à chaque tir 1/10+1/10 ");


        if(uniformLaw_qa==null) uniformLaw_qa = new UniformLaw(1, 10);
        double psucces = uniformLaw_qa.F_de_p_superieur_a(8);//c'est un strictement >
        assertEquals(0.20, psucces, 0.01);

        geometricLaw_q_b1 = new GeometricLaw(psucces);

        //Combien de tirs lui faut-il en moyenne pour réussir à faire un bon tir ?
        System.out.println("2)");

        double esp = geometricLaw_q_b1.getEsperance();
        System.out.println("Epérance de la loi géométrique en 1) : "+esp);
        assertEquals(1./psucces, esp, 0.001);

        //Quel est l’écart-type de Y ?
        System.out.println("3)");

        double var = geometricLaw_q_b1.getVariance();
        double et = Math.sqrt(var);

        Law.printcalcul("Ecart type", "RacinceCarrée(variance)=RacineCarrée("+var+")="+et);

    }

    /**
     *  Il effectue maintenant 5 tirs. On note alors V la variable aléatoire du nombre de fois où il
     *  aura réussi à faire un bon tir.
     */
    @Test
    public void q_c() throws LawException, CalculationException {
        System.out.println(title_prefix+this.getClass().getSimpleName()+"b)");
        //Quelle est la loi de probabilité de Z ? et quelle loi usuelle suit-elle ?
        System.out.println("1) \n C'est une loi binomiale, il a a chaque fois 1/5 chance de faire un bon tir selon l'énoncé précédant");
        BinomialeLaw b = new BinomialeLaw(1./5, 5);

        //Quelle est la probabilité qu’il ait fait au moins un mauvais tir, sachant qu’il a fait au
        //moins 3 bons tirs ? (4 points)
        System.out.println("2) \n Cela revient à chercher e = 1 - P(X>4)");
        double e= b.getProbabiliteDeX(5);
        double non_e = 1. - e;
        Law.printcalcul("1-P(X>4)", "1-"+e+"="+non_e+closure);
    }

    /**
     * Il fait alors un pari avec un ami sur son prochain tir. On commence par noter Z la variable
     * aléatoire qui vaut 1 s’il arrive à faire un tir à 10 points, et 0 sinon
     */
    @Test
    public void q_d() throws LawException, CalculationException {
        System.out.println(title_prefix+this.getClass().getSimpleName()+"d)\n1)\n");
        System.out.println("C'est une expérience de bernouilli de robabilité de succés 1/10");
        //Quelle est la loi de probabilité de Z ? et quelle loi usuelle suit-elle ? (2,5 points)

        BernouilliLaw bernouilliLaw = new BernouilliLaw(1./10.);
        System.out.println("Loi de probabilité de Z : \n" +
                "\t 0 \t 1\n" +
                "\t0.9\t0.1");
        //Dans son pari, il gagne maintenant 10 euros s’il réussit et perd 10 euros sinon. Quelle est
        //l’espérance de gain de son ami ? Etait-ce un bon choix pour celui-ci ?
        double probaSucces,gainSucces,probaEchec,gainEchec;
        System.out.println("2)");
        probaSucces = bernouilliLaw.getEsperance();
        probaEchec = 1 - probaSucces;
        gainSucces = 10;
        gainEchec = -10;

        double esperanceGain = probaSucces*gainSucces+probaEchec*gainEchec;
        Law.printcalcul("Espérance du gain ", "probaSucces*gainSucces+probaEchec*gainEchec="+esperanceGain);
        System.out.println("C'est plutot une mauvaise idée, il perdra en moyenne 8 euros par tentative");
    }
}
