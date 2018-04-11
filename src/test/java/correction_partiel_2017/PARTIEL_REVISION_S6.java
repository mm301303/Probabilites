package correction_partiel_2017;

import Exceptions.CalculationException;
import Laws.functions.Law;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;
import tools.Calculation;
import tools.Displayable;

public class PARTIEL_REVISION_S6 implements Displayable {
    @Test
    public void exercice1_melimelodelettre() throws CalculationException {

        System.out.println(title_prefix + this.getClass().getSimpleName());

        System.out.println("a) combien de mots de 5 lettres peut-on former avec les lettres de l'alphabet");
        Law.printcalcul("combinaisons de 5 lettres dans l'alphabet", "26^5  = " + Math.pow(26, 5));

        System.out.println("b) combien de mots de 5 lettres peut-on former avec les lettres de l'alphabet et au moins une voyelle");
        System.out.println("la réponse est le nombre de mot de 5 lettres - le nombre de mots ne contenant pas de voyelles");

        int nbWordsWith = (int) Math.pow(26, 5);
        int nbWordsWithout = (int) Math.pow(26-6, 5);
        Law.printcalcul("nbWordsWith - nbWordsWithout", ""+(nbWordsWith-nbWordsWithout));

        System.out.println("c) et sans s'authoriser a réutiliser les lettres ?");
        Law.printcalcul("Arrangement de 5 lettres dans l'alphabet", "26!/5!*(26-5)!= " + (int)Calculation.kParmisN(5,26));
        int nbWordsWith2 = (int)Calculation.kParmisN(5,26);
        int nbWordsWithout2 = (int)Calculation.kParmisN(5,26-6);
        Law.printcalcul("nbWordsWith - nbWordsWithout", ""+(nbWordsWith2-nbWordsWithout2));

        System.out.println(closure);

    }

 @Test
    public void exercice2_travail() throws CalculationException {

        System.out.println(title_prefix + this.getClass().getSimpleName());
        System.out.println("a) choisir un jour de semaine");
        int nombredejoursouverts = (52*5);
        int nombredejourswe = (52*2) + 1;
        double ps = ((nombredejoursouverts)/365.);
        Law.printcalcul("P(S)", ""+(nombredejoursouverts)+ "/365 soit " + ps);

        System.out.println("b) Soit Ts l'évènement on travaille un jour de semaine");
        System.out.println("on sait qu'on ne bosse pas 44 j par an + 9 jours en semaine ");
        int nbCongés = 44+9;
        double ptravailensemaine = (nombredejoursouverts-nbCongés)/365.;
     System.out.println("ptravailensemaine = " + ptravailensemaine);
        System.out.println("c) calculer la proba que le mec bosse un jour pris au hasard de l'année sachant qu'il taffe un we sur trois");
        double jdetravailenwe = (52*2+1)/3.;
        double ptravail = (jdetravailenwe+nombredejoursouverts-nbCongés)/365.;
     System.out.println("ptravail = " + ptravail);
        System.out.println("c) calculer la proba d'etre en we sachant que le mec bosse");
        //P(A)B = P(A n B) / P(B), A etre en we, B le mec bosse
        double proba_d_etre_en_we = nombredejourswe/365.;
        //ici p(etreenwe n travail) =
        double pwesachantquonbosse = (ptravail+(nombredejourswe*0.3))/(nombredejoursouverts+nombredejourswe*0.3);
     System.out.println("pwesachantquonbosse = " + pwesachantquonbosse);
     System.out.println(closure);

    }




}