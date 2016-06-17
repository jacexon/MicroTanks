import java.awt.*;
/**
 * Klasa <code>Weapon</code> jest odpowiedzialna za skalowanie obrazków broni i rysowanie ich<code>Frame</code>
 *
 * @author      Bartłomiej Bielecki <address @ example.com>
 * @author      Jacek Polak <polakjacek@gmail.com>
 * @version     1.1
 * @since       2016-03-26
 */
public class Weapon {

    /**
     * Konstruktor klasy broni
     * @param g Kontekst graficzny
     * @param weapon Obrazek broni
     * @param x współrzędna x do rysowania obrazka
     * @param y współrzędna y do rysowania obrazka
     * @param width Szerokość obrazka
     * @param height Wysokość obrazka
     */
    public Weapon(Graphics g,Image weapon, int x, int y, int width, int height ){

        weapon = weapon.getScaledInstance(width,height,100);
        g.drawImage(weapon, x,y, null);

    }

}
