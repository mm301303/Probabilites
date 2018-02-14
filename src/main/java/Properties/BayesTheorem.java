package Properties;

//TODO test

public abstract class BayesTheorem {
    private static void printEnonce(String detail){
        System.out.println("***Théorème de Bayes***\n"+
                "Pour A et B deux événements tels que P(A) ! = 0 et P(B) ! = 0, alors :\n"+"" +
                " \" P(A | B) × P(B) = P(B | A) × P(A) \"");
        System.out.println("ici on fera : "+ detail +"\n");
    }

    public static double get_probA_n_probB(double probB_knowing_probA, double probA){
        String details = "probB_knowing_probA*probA";
        printEnonce(details);
        return probB_knowing_probA*probA;
    }
    public static double get_probB_n_probA(double probA_knowing_probB, double probB){
        String details = "probA_knowing_probB*probB";
        printEnonce(details);
        return probA_knowing_probB*probB;
    }
    public static double get_probA(double probA_knowing_probB, double probB_knowing_probA, double probB){
        String details = "probA_knowing_probB*probB/probB_knowing_probA";
        printEnonce(details);
        return probA_knowing_probB*probB/probB_knowing_probA;
    }
    public static double get_probB(double probB_knowing_probA, double probA_knowing_probB, double probA){
        String details = "probB_knowing_probA*probA/probA_knowing_probB";
        printEnonce(details);
        return probB_knowing_probA*probA/probA_knowing_probB;
    }
}
