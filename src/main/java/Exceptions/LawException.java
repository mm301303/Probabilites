package Exceptions;

/**
 * Created by maxime on 09/03/17.
 */
public class LawException extends Throwable {
    public LawException(String s) {
        super(s);
    }
    public LawException(Class c, String s) {
        super("at "+c.getSimpleName()+" : "+s);
    }
}
