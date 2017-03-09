import javax.sound.midi.Soundbank;

/**
 * Created by maxime on 02/03/17.
 */
public interface Displayable {
    public static String title_prefix = " [ * [ ";
    public static String body_prefix = " [\t* [ ";
    public static String closure = " ]] ";


    String getName();
}
