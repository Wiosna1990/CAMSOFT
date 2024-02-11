package database;

import console.ConsoleIn;
import products.Drug;
import texts.Texts;
/**
 * Panel obsługujący aktualizację danych leku w bazie danych.
 */
public class UpdateDrugPanel extends DrugCardPanel {

    Drug selected;
    /**
     * Konstruktor klasy UpdateDrugPanel.
     */
    public UpdateDrugPanel() {
        super();
    }

    public String textAtTheStart() {
        return Texts.UPDATEDRUG_START;
    }

    /**
     * Metoda pobierająca nazwę leku do aktualizacji od użytkownika.
     */
    protected void getDrugName() {
        DrugList drugList = DrugList.getInstance();

        condition = true;

        while (condition) {
            consoleIn = new ConsoleIn();
            String console = consoleIn.getConsoleInput();

            selected = drugList.findDrugByName(console);
            if(selected != null)
            {
                condition = false;
            }
            else
            {
                System.out.println(Texts.UPDATEDRUG_NOTUPDATE);
                returnTo();
            }
        }
    }
    /**
     * Metoda aktualizująca dane wybranego leku.
     */
    protected void createDrug() {
        selected.setDose(dose);
        selected.setNumberOfTablets(numberOfTablets);
        selected.setPrice(price);

        DrugList.getInstance().saveDrugsFile();

        System.out.println(Texts.UPDATEDRUG_UPDATE + selected.getTradeName());
    }


}
