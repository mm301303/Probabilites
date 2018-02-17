package Laws;

import Laws.functions.ContinuousLaw;
import Laws.functions.Law;
import tools.Displayable;


public class UniformLaw implements Law, ContinuousLaw, Displayable {
    private double supp;
    private double inf;
    private static final int MAX_EVAL=10;


    public UniformLaw(double inf, double supp) {
        this.inf = (inf<=supp)?inf:supp;
        this.supp = (inf>=supp)?inf:supp;
        display();

    }

    public double F(double a, double b) {
        Law.printcalcul("F("+a+"<X<"+b+")", "F(b) - F(a) = " + (F(b) - F(a)) );
        return F(b) - F(a);
    }

    @Override
    public double f(double a) {
        Law.printcalcul("f(X="+a+")", "1./plageDeValeur = 1./(supp-inf+1) = "+ (1./(supp-inf+1)));
        return 1./(supp-inf+1);//si supp = 16 et inf 1, on a pas 15 valeurs entières mais 16
    }

    public double F(double x_inferieur_a_y) {
        Law.printcalcul("f(X<"+x_inferieur_a_y+")", "(x_inferieur_a_y-inf+1)/(supp-inf+1) = ("+x_inferieur_a_y+"-"+inf+"+1)/("+supp+"-"+inf+ "+1) = "+ (x_inferieur_a_y-inf+1)/(supp-inf+1) );
        if(x_inferieur_a_y>=supp) return 1;
        if(x_inferieur_a_y<=inf) return 0;
        return (x_inferieur_a_y-inf+1)/(supp-inf+1);//ne pas oublier la borne inférieure, c'est un nombre de valeurs
    }

    @Override
    public double F_de_p_superieur_a(double b) {
        Law.printcalcul("P(X>"+b+")", "1-F(b)="+(1-F(b)));
        if(supp-b>0) return 1-F(b);
        return 0;
    }


    @Override
    public double getEsperance() {
        Law.printcalcul("E[X]", "(inf+supp+1)/2 = "+((inf+supp+1)/2) );
        return (inf+supp+1)/2;
    }

    @Override
    public double getVariance() {
        double base = 12;
        double num = Math.pow(supp-inf, 2);
        Law.printcalcul("V[X]", "(supp-inf+1)²/12 = "+(num/base) );
        return num/base;
    }

    public String getName() {

        return "Uniform Law : X suit une loi uniforme sur {inf, . . . , supp} si : \n"+
                "∀k ∈ {inf, . . . , supp}, P(X = k ) = 1/(supp-inf)\n";
    }

    public String display() {
        return Displayable.title_prefix+getName()+Displayable.closure+"\n"+getParameters();
    }

    @Override
    public String getParameters() {
        return "borne inf:"+inf+"; borne supp:"+supp;

    }

}
