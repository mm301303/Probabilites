import java.util.ArrayList;

/**
 * Created by maxime on 02/03/17.
 */
public interface Law {
     double compute(int x_egal_i);
     double getEsperance();
     double getVariance();
     String getName();
     String getParameters();
}
