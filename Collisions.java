import java.awt.*;

/**
 * Klasa <code>Collisions</code> służy do skalowania obrazka wybuchu pocisku i rysowaniu go w miejscu kolizji.
 *
 * @author      Bartłomiej Bielecki <address @ example.com>
 * @author      Jacek Polak <polakjacek@gmail.com>
 * @version     1.1
 * @since       2016-03-26
 */

public class Collisions {

    public Collisions(int width, int height, Graphics g, int x, int y, Image bI){

        bI = bI.getScaledInstance(width/10,height/10,100);
        g.drawImage(bI, x-width/20,y-width/20, null);
    }
}
