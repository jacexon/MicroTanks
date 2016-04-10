import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Klasa implementująca pojedynczy czołg.
 * @author      Bartłomiej Bielecki <address @ example.com>
 * @author      Jacek Polak <polakjacek@gmail.com>
 * @version     1.1
 * @since       2016-03-26
 */

public class Tank implements Runnable {

    private int x,y,xDirection;

    /**
     * Konstruktor klasy <code>Tank</code> tworzy czołg w zależności od współrzędnych,
     * na których chcemy go umieścić.
     * @param width Współrzędna 'x' ekranu
     * @param height Współrzędna 'y' ekranu
     */
    public Tank(int width,int height){
        x=width/20;
        y=height;
    }

    /**
     * Metoda rysująca pojedynczy czołg.
     * @param g Kontekst graficzny
     */
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y-10, 40, 10);
        g.fillRect(x + 18, y - 15, 4, 7);
    }

    /**
     * Metoda odpowiadająca za ruch czołgu.
     * @return Brak
     */
    public void move() {
        x += xDirection;
        if (x <= 0)
            x = 0;
        if (x >= 360)
            x = 360;
    }

    /**
     * Metoda ustawiająca kierunek(?) czołgu.
     * @param xdir Kierunek
     */
    public void setXDirection(int xdir)
    {
        xDirection = xdir;
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == e.VK_LEFT) {
            setXDirection(-1);
        }
        if (keyCode == e.VK_RIGHT) {
            setXDirection(1);
        }
    }

    /**
     * Metoda ustawiająca kierunek czołgu.
     * @param e KeyEvent
     */
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == e.VK_LEFT) {
            setXDirection(0);
        }
        if (keyCode == e.VK_RIGHT) {
            setXDirection(0);
        }
    }

    /**
     * Metoda zdarzeniowa wykonująca wątek.
     */
    public void run() {
        try {
            while (true) {

                move();
                Thread.sleep(5);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
