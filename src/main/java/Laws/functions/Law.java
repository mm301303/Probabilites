package Laws.functions;

import Exceptions.CalculationException;

/**
 * Created by maxime on 02/03/17.
 */
public interface Law {
     String getName();
     String getParameters();
     double getEsperance();
     double getVariance();

     static void printcalcul(String intitule, String op){
          System.out.println("Détail du calcul : \n "+intitule+" => "+op);
     }
}
