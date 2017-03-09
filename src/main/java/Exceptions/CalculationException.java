package Exceptions;

/**
 * Created by max on 09/03/17.
 */
public class CalculationException extends Throwable {
    public CalculationException(int n) {
        super("invalid calculation parameter :["+n+"]");
    }
    public CalculationException(int n, int n2) {
        super("invalid calculation parameter :["+n+"]["+n2+"]");
    }
}
