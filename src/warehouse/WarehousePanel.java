package warehouse;

import console.ConsoleIn;
import database.DatabasePanel;
import panel.BasePanel;
import texts.Texts;

import java.sql.SQLOutput;
/**
 * Panel obsługujący funkcje magazynu leków.
 */
public class WarehousePanel extends BasePanel {
    /**
     * Konstruktor klasy WarehousePanel.
     */
    public WarehousePanel() {
        super();
    }

    /**
     * Metoda zwracająca tekst początkowy dla panelu magazynu.
     * @return Tekst początkowy dla panelu magazynu.
     */
    public String textAtTheStart() {
        return Texts.WAREHOUSE_START;
    }
    /**
     * Metoda przenosząca użytkownika z panelu magazynu do panelu bazy danych.
     */
    public void returnTo(){
        System.exit(0);
    }
    /**
     * Metoda rozpoczynająca działanie panelu magazynu.
     */
    public void functionStart() {

        while (condition) {
            consoleIn = new ConsoleIn();
            String console = consoleIn.getConsoleInput();

            if (console.equals("1") || console.equals("2")) {
                condition = false;
            }
            switch (console) {
                case "1":
                    new DatabasePanel();
                    break;
                case "2":
                    returnTo();
                    break;
                default:
                    System.out.println(Texts.SWITCH_DEFAULT);
                    break;

            }
        }
    }
}

