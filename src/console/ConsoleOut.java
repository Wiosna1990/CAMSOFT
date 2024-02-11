package console;
import java.util.Scanner;
/**
 * Klasa ConsoleOut  - służy do wyświetlania danych w konsoli.
 */
public class ConsoleOut {


    private String consoleOutput;

    /**
     * Konstruktor klasy ConsoleOut - inicjuje wyświetlanie danych w konsoli.
     * @param consoleOutput Dane do wyświetlenia w konsoli.
     */

    public ConsoleOut(String consoleOutput){
        this.consoleOutput = consoleOutput;
        getConsoleOutput();
    }

    /**
     * Metoda  - ustawia dane, które mają być wyświetlone w konsoli.
     * @param consoleOutput Dane do wyświetlenia w konsoli.
     */
    public void setConsoleOutput(String consoleOutput) {
        this.consoleOutput = consoleOutput;
    }

    /**
     * Metoda - zwraca dane, które mają być wyświetlone w konsoli.
     * Wyświetla również dane w konsoli.
     * @return Dane do wyświetlenia w konsoli.
     */
    public String getConsoleOutput() {
        System.out.println(consoleOutput);
        return consoleOutput;
    }



}
