import java.util.ArrayList;

/**
 * Created by maxime on 02/03/17.
 */
public interface Law {
     ArrayList<Double> compute();
     double getEsperance();
     double getVariance();
     double getPrecomputedValForX(int x_egal_i);
     String getName();

    Double getPsuccess();
}
