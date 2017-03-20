package Laws.functions;

/**
 * Created by maxime on 07/03/17.
 */
public interface ContinuousLaw {
    double f(double a);
    double F(double x_inferieur_a_y , double x_superieur_a_y);
    double F_de_p_superieur_a(double b);
    double F_de_p_inferieur_a(double b);

}
