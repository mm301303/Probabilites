import java.util.ArrayList;

/**
 * Displayable Law for geometricLaw
 */
public class GeometricLaw implements Law, Displayable{

    private double proba_reussite;
    private int nombre_experience;
    private boolean ok=false;//enable calculation
    private ArrayList<Double> memoisation;

    public GeometricLaw(double probabilite, int i){
        proba_reussite = probabilite;
        nombre_experience = i;
        memoisation = new ArrayList<>();
        if(!(probabilite>1||probabilite<0))
            ok = true;
            compute();

    }

    @Override
    public double compute(int x_egal_i) {
        if(ok) return memoisation.get(x_egal_i);
        else return -1;
    }

    public double getEsperance(){
        if(!ok) return -1;
        return 1/proba_reussite;
    }

    @Override
    public double getVariance() {
        if(!ok) return -1;
        return (1-proba_reussite)/(proba_reussite*proba_reussite);
    }

    public ArrayList<Double> compute(){
        if(!ok) return new ArrayList<>();
        //System.out.println("E="+getEsperance()+" \tV="+getVariance());
        for(int i=0; i<nombre_experience; i++){
            Double res = Math.pow(new Double(1-proba_reussite), i)*proba_reussite;
            memoisation.add(res);

        }
        return memoisation;
    }


    /**
     * x_egal_i est P(X=i), la valeur recherchée
     * @param pSuccess
     * @param nbExperience
     * @param x_egal_i
     */
    public double display(double pSuccess, int nbExperience, int x_egal_i) {
        if (!ok) {
            return -1;
        }
        if (pSuccess == proba_reussite){
            if (nombre_experience == nbExperience){
                if (ok) {
                    Displayable.display(this, x_egal_i);
                } else {
                    if (ok) ok = !ok;//!ok du tout
                    System.out.println("WTF CALL SUPPORT");
                    return -1;
                }
            }
        }
        return -1;
    }

    @Override
    public String getName() {
        return "Geometric Law";
    }

    @Override
    public String getParameters() {
        return "pSuccess = "+proba_reussite ;
    }

    /**
     * getter on pSuccess
     * @return
     */
    public Double getPsuccess() {
        return proba_reussite;
    }
}
