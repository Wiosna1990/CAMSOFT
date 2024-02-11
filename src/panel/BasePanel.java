package panel;

import console.ConsoleIn;
import console.ConsoleOut;

/**
 * Klasa bazowa - dla paneli w aplikacji.
 */
public abstract class BasePanel {
    protected ConsoleIn consoleIn;
    protected ConsoleOut consoleOut;
    protected boolean condition = true;

    /**
     * Konstruktor klasy BasePanel - inicjuje wyświetlanie tekstu na konsoli i uruchamia funkcję startową.
     */
    public BasePanel() {
        consoleOut = new ConsoleOut(textAtTheStart());
        functionStart();
    }

    /**
     * Metoda textAtTheStart - abstrakcyjna zwracająca tekst początkowy dla danego panelu.
     * @return Tekst początkowy dla panelu.
     */
    public abstract String textAtTheStart();

    /**
     * Metoda functionStart - abstrakcyjna wywoływana na początku działania danego panelu.
     */
    public abstract void functionStart();

    public abstract void returnTo();
}
