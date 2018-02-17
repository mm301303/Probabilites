package TD4_MIAGE;

import Exceptions.LawException;
import Laws.GeometricLaw;
import org.junit.Test;

import java.lang.reflect.GenericArrayType;

import static org.junit.Assert.assertEquals;
import static tools.Displayable.closure;
import static tools.Displayable.title_prefix;

public class TD4S6_exercice4 {


    @Test
    public void beaujolais() throws LawException {
        /*Un amateur éclairé, mais excessif, se déplace de réverbère en réverbère. Quand il se lance
        pour attraper le suivant, il a 80% de chances de ne pas tomber. Pour gagner le bistrot
        convoité, il faut en franchir 7. On notera X le nombre de réverbères atteints sans chute.
        Quelles valeurs peut prendre la variable aléatoire X ? Préciser sa loi.*/

        /*X prend des valeurs qui sont des nombres entiers strictement positifs. S’il tombe dès
        son premier essai, il aura atteint un seul réverbère, celui de départ. X compte le nombre
        de réverbères avant de chuter : on est donc dans le cas d’une loi géométrique où un
        succès (l’événement qui fait arrêter les tentatives) est une chute. X suit alors une loi
        géométrique. La probabilité de chuter en un seul essai vaut 0, 20, puisqu’il a 80% de
        chances de ne pas tomber. Donc X ∼ G(0.2)*/


        /*Une fois dans le batiment, il prend l’ascenseur et appuie au hasard sur un des huit boutons.
        S’il atteint son étage ou s’il déclenche l’alarme, il sort de l’ascenseur, sinon il réappuie au
        hasard sur un des huit boutons. Soit Y le nombre de boutons pressés avant d’atteindre
        son étage ou de déclencher l’alarme. Quelle est la loi de Y ? Donner son espérance et sa
        variance.*/
        //c'est également une loi géométrique : il y a un succès qui vaut 2/8 qui arrete les tentatives, on compte le nombre de tentatives
        System.out.println("b)");
        GeometricLaw gl = new GeometricLaw(0.25);
        double esp = gl.getEsperance();
        double var = gl.getVariance();

        assertEquals(4., esp, 0.0001);
        assertEquals(12., var, 0.0001);

    }
}
