package database;

import console.ConsoleIn;
import panel.BasePanel;
import products.Drug;
import texts.Texts;
/**
 * Panel obsługujący usuwanie leku z bazy danych.
 */
public class RemoveDrugPanel extends BasePanel {
    /**
     * Konstruktor klasy RemoveDrugPanel.
     */
    public RemoveDrugPanel() {
        super();
    }
    /**
     * Metoda zwracająca tekst początkowy dla panelu usuwania leku.
     * @return Tekst początkowy dla panelu usuwania leku.
     */
    public String textAtTheStart() {
        return Texts.REMOVEDRUG_START;
    }
    /**
     * Metoda rozpoczynająca działanie panelu usuwania leku.
     */
    public void functionStart() {
        getDrugName();
        returnTo();
    }
    /**
     * Metoda przenosząca użytkownika z panelu usuwania leku do panelu bazy danych.
     */
    public void returnTo() {
        new DatabasePanel();
    }
    /**
     * Metoda pobierająca nazwę leku do usunięcia od użytkownika i usuwająca go z bazy danych.
     */
    protected void getDrugName() {
        DrugList drugList = DrugList.getInstance();

        condition = true;

        while (condition) {
            consoleIn = new ConsoleIn();
            String console = consoleIn.getConsoleInput();

            Drug selected = drugList.findDrugByName(console);
            if(selected != null)
            {
                System.out.println(Texts.REMOVEDRUG_REMOVE);
                drugList.removeDrug(selected);
                condition = false;
            }
            else
            {
                System.out.println(Texts.DRUG_NOTEXISTS);
            }
        }
    }


}










