import Exceptions.CalculationException;
import Exceptions.LawException;
import Laws.UniformLaw;
import org.junit.Test;
import tools.Calculation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Créé avec les rares archives du ds précédent
 */
public class DS2Test {
    double delta = Calculation.DELTA;
    @Test
    // TODO fix 
    public void question12(){

        System.out.println("\n"+this.getClass().getSimpleName()+" question12");
        System.out.println("On tire une valeur de T selon une loi unifome (discrete) sur [-9;5]");
        System.out.println("Pour quelle valeur de X a-t'on P(T<X)= 0.25 ?");
        assertEquals(-5.5, computeForQuestion12(), delta);
    }

    private double computeForQuestion12(){
        double borneInf = -9., borneSupp = 5.;
        UniformLaw law = new UniformLaw(borneInf, borneSupp);
        double res =0;
        for(double i=-9.0; i<5.0; i+=0.01){
            res=law.F(-9, i);
            if(res<=0.25+delta && res>=0.25-delta){
                return i;
            }
        }
        return 0.;
    }

    @Test
    public void question10(){
        System.out.println("On tire une valeur de T selon une loi uniforme sur [-7;7]");
        System.out.println(this.getClass().getSimpleName()+" question10");
        System.out.println("Pour quelle valeur de X a-t'on P(T>X)= 0.20 ?");
        assertEquals(-4.2, computeForQuestion10(), delta);
    }

    private double computeForQuestion10(){

        int borneInf = -7, borneSupp = 7;
        UniformLaw law = new UniformLaw(borneInf, borneSupp);
        double res =0;
        double i=borneInf;
        for(; i<=borneSupp; i+=0.1){
            res = law.F(borneInf,i);//on veut la partie droite de la courbe
            if(res <= 0.2+0.0001 && res >= 0.2-0.0001){
                System.out.println("res = " + res);
                break;
            }
        }
        return i;
    }
    @Test
    public void question1() throws LawException {
        System.out.println("\nDS2 question 1");
        System.out.println("La taille des carrotes de la ferme suit une loi uniforme sur l'intervalle [67;128]\n"
                +"Quelle est la proportion de carrotes de grande taille, soit dans la catégorie [83;144] ?");
        UniformLaw uniformeLaw = new UniformLaw(67.,128.);
        double res = uniformeLaw.F(144.)- uniformeLaw.F(83.);
        System.out.println("res = uniformeLaw.f(83.,144.) = " + res);
        assertEquals(45./61., res, Calculation.DELTA);
    }

    @Test
    public void question2() throws LawException {
        System.out.println("\nDS2 question 2");
        System.out.println("Les clients arrievent de manière uniforme entre H ouverture et H fermeture du magasin\n"
                + "1/3 des clients passent avant midi et 1/2 avant 13h30\n"
                + "Quel est l'horaire d'ouverture ?");

        System.out.println("Résolution : P(X<MIDI) = 1/3 et P(X<13H30)= 1/2");
        System.out.println("La loi est uniforme, on peut en déduire P(X<Houverture+1h30) = 1/6");
        System.out.println("Ainsi la plage horaire est de 6x1H30 soit 9 h, et comme on sait que les clients sont répartis");
        System.out.println("de maniere homogene on sait que 13H30-9H/2 = Houverture");
        System.out.println("on peut aussi le calculer :");
        /*SOLUTION
        double res = -1;
        UniformLaw uniformLaw = new UniformLaw(9., 18 );
        assertEquals(13.5,uniformLaw.getEsperance(), Calculation.DELTA);
        assertEquals(1./3, uniformLaw.f(12), Calculation.DELTA);
        */
        for(double i=0.; i<6.; i+=0.5){
            UniformLaw uniformLaw = new UniformLaw(13.5-i, 13.5 +i);
            if(uniformLaw.f(12)==1./3. && uniformLaw.f(13.5)==1./2.){
                System.out.println("tatonnement :On trouve l'heure d'ouverture a "+(double)(13.5-i)+"h" );
                assertEquals(9.0, 13.5-i, Calculation.DELTA);
            }
        }
    }
    @Test
    //TODO
    //encore lui
    public void question3() throws CalculationException {
        System.out.println("\nDS2 question 3");
        double res = 0;
        System.out.println("\nQuestion3DS1Test");
        System.out.println("Jeu de carte a 3 couleurs, 39 cartes, à valeur entre 1 et 13\n"+
                "On tire 5 cartes quelle est la proba d'obtenir trois cartes de même valeur ?");
        System.out.println("kParmisN(3,5)*premiere*deuxieme*troisieme*quatrieme*ciquieme");
        double premiere=1;
        System.out.println("premiere = " + premiere);
        double deuxieme= 36./38.;
        System.out.println("deuxieme = " + deuxieme);
        double troisieme= 33./37.;//avoir 3 cartes identiques en 1 tirage
        System.out.println("troisieme = " + troisieme);
        double quatrieme= 30./36.;
        System.out.println("quatrieme = " + quatrieme);
        double cinquieme= 27./35.;
        System.out.println("cinquieme = " + cinquieme);

        res= premiere*deuxieme*troisieme*quatrieme*cinquieme*Calculation.factorielle(5);

        System.out.println("P(X=0) = " + res);

        assertEquals(2673./4021., res,delta);

    }
}