package Properties;

/**
 * Si Xi est une suite de var aléatoires *indépendantes* de même loi
 * avec E(X) finie et ecart_type^2 (variance) finie
 */
public class CentralLimitTheorem {
    //pour n grand
        public static double getZn(double Sn, double n, double esperance_de_Sn, double ecart_type){
        double res = (Sn- (n*esperance_de_Sn))/(ecart_type*Math.sqrt(n));
        return res;
    }
}
