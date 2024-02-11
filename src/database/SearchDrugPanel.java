package database;

import console.ConsoleIn;
import panel.BasePanel;
import products.Drug;
import texts.Texts;

import java.util.List;
/**
 * Panel obsługujący wyszukiwanie leków w bazie danych.
 */
public class SearchDrugPanel extends BasePanel {

    /**
     * Konstruktor klasy SearchDrugPanel.
     */
    public SearchDrugPanel() {
        super();
    }
    /**
     * Metoda zwracająca tekst początkowy dla panelu wyszukiwania leków.
     * @return Tekst początkowy dla panelu wyszukiwania leków.
     */
    public String textAtTheStart() {
        return Texts.SEARCHDRUG_START;
    }
    /**
     * Metoda rozpoczynająca działanie panelu wyszukiwania leków.
     */
    @Override
    public void functionStart() {
        getDrugName();
        returnTo();
    }
    /**
     * Metoda przenosząca użytkownika z panelu wyszukiwania leków do panelu bazy danych.
     */
    @Override
    public void returnTo() {
        new DatabasePanel();
    }
    /**
     * Metoda pobierająca nazwę leku do wyszukania od użytkownika i wyświetlająca pasujące leki.
     */
    protected void getDrugName() {
        DrugList drugList = DrugList.getInstance();

        condition = true;

        while (condition) {
            consoleIn = new ConsoleIn();
            String console = consoleIn.getConsoleInput();

            List<Drug> selected = drugList.findAllDrugByName(console);
            if(selected != null)
            {
                System.out.println(Texts.DRUG_LIST);

                for(Drug drug : selected)
                {
                    System.out.println(drug.getLabel());
                }

                condition = false;
            }
        }

        }


}
