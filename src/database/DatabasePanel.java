package database;

import console.ConsoleIn;
import panel.BasePanel;
import texts.Texts;
import warehouse.WarehousePanel;

/**
 * Panel obsługujący interakcję z bazą danych.
 */
public class DatabasePanel extends BasePanel {

    /**
     * Konstruktor klasy DatabasePanel.
     */
    public DatabasePanel() {
        super();
    }


    /**
     * Metoda zwracająca tekst początkowy dla panelu bazy danych.
     * @return Tekst początkowy dla panelu bazy danych.
     */
    public String textAtTheStart() {
        return Texts.DATABASE_START;
    }

    /**
     * Metoda przenosząca użytkownika z panelu bazy danych do panelu magazynu.
     */
    public void returnTo(){
        new WarehousePanel();
    }

    /**
     * Metoda rozpoczynająca działanie panelu bazy danych.
     */
    public void functionStart() {

        while (condition) {
            consoleIn = new ConsoleIn();
            String console = consoleIn.getConsoleInput();

            if (console.equals("1") || console.equals("2") || console.equals("3") || console.equals("4")) {
                condition = false;
            }
            switch (console) {
                case "1":
                    new DrugCardPanel();
                    break;
                case "2":
                    new RemoveDrugPanel();
                    break;
                case "3":
                    new UpdateDrugPanel();
                    break;
                case "4":
                    new SearchDrugPanel();
                    break;
                case "5":
                    DrugList.getInstance().displayDrugs();
                    System.out.println("--------------------");
                    new DatabasePanel();
                    break;
                case "6":
                    returnTo();
                    break;
                case "7":
                    System.exit(0);
                default:
                    System.out.println(Texts.SWITCH_DEFAULT);
                    break;

            }
        }
    }
}
