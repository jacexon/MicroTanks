
/**
 * Klasa <code>Exit</code> odpowiada za obsługę wyjścia z programu,
 * dziedziczy ona po klasie abstrakcyjnej <code>Frame</code>
 *
 * @author      Bartłomiej Bielecki <address @ example.com>
 * @author      Jacek Polak <polakjacek@gmail.com>
 * @version     1.1
 * @since       2016-03-26
 */
/**
 * Klasa opisująca gracza.
 */
public class Player
{
    private String tankColour = "Czerwony";
    private String name = "player1";
    private int points;
    private int hit;
    private int numberOfMoves;
    private int allShots;

    /**
     * Konstruktor klasy gracza
     * @param colour Kolor czołgów należących do gracza
     * @param name Nazwa gracza
     */
    public Player(String colour, String name)
    {
        tankColour = colour;
        this.name = name;
        points = 0;
        hit = 0;
        allShots = 0;
        numberOfMoves=5;
    }

    /**
     * Metoda zwracająca kolor czołgu gracza.
     * @return Kolor czołgu
     */
    public String getTankColour() {return tankColour;}

    /**
     * Metoda zwracająca nazwę gracza.
     * @return Nazwa gracza
     */
    public String getName() {return name;}

    /**
     * Metoda dodająca punkty do obecnej puli, którą zgromadził gracz
     * @param addedPoints Punkty do dodania
     */
    public void addPoints(int addedPoints){points=points+addedPoints;}

    /**
     * Metoda zwracająca ilość punktów gracza
     * @return Ilość punktów
     */
    public int getPoints() {return points;}

    /**
     * Metoda zwracająca ilość trafień gracza w przeciwnika.
     * @return Ilość trafień
     */
    public int getHit() {return hit;}

    /**
     * Metoda zwracająca ilość wszystkich oddanych strzałów przez gracza.
     * @return Celne strzały
     */
    public int getAllShots() {return allShots;}

    /**
     * Metoda zmniejszająca licznik dostępnych ruchów gracza o 1.
     */
    public void oneMove(){numberOfMoves--;}

    /**
     * Metoda zwracająca ilość dostępnych ruchów gracza.
     * @return Dostępne ruchy
     */
    public int checkNumberOfMoves(){return numberOfMoves;}


    /**
     * Metoda dodająca strzał celny, gdy trafimy czołg przeciwnika.
     */
    public void addHit(){hit++;}

    /**
     * Metoda dodająca do licznika każdy strzał, jaki odda gracz.
     */
    public void addShot(){allShots++;}

    /**
     * Metoda służąca do zresetowania celnych strzałów, a także wszystkich strzałów
     * Ustawienia ruchów dostępnych na 5.
     */
    public void resetAll()
    {
        hit = 0;
        allShots = 0;
        numberOfMoves = 5;
    }
}

