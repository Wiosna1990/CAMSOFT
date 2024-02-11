package console;
import java.util.Scanner;
/**
 * Klasa - służy do odczytu danych z konsoli.
 */
public class ConsoleIn {

    private String consoleInput;

    /**
     * Konstruktor klasy ConsoleIn - inicjuje odczyt danych z konsoli.
     */
    public ConsoleIn(){
        Scanner scan = new Scanner(System.in);
        this.consoleInput = scan.nextLine();
    }
    /**
     * Metoda zwraca odczytane dane z konsoli.
     * @return Odczytane dane z konsoli.
     */
    public String getConsoleInput() {
        return consoleInput;
    }


}
