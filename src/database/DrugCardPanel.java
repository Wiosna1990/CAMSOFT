package database;
import console.ConsoleIn;
import panel.BasePanel;
import products.Drug;
import texts.Texts;

/**
 * Panel obsługujący tworzenie nowej karty leku w bazie danych.
 */
public class DrugCardPanel extends BasePanel {
    protected String tradeName = "";
    protected double dose;
    protected int numberOfTablets;
    protected double price;

    /**
     * Konstruktor klasy DrugCardPanel.
     */
    public DrugCardPanel() {
        super();
    }

    /**
     * Metoda zwracająca tekst początkowy dla panelu karty leku.
     * @return Tekst początkowy dla panelu karty leku.
     */

    public String textAtTheStart() {
        return Texts.DRUGCARD_START;
    }

    /**
     * Metoda rozpoczynająca działanie panelu karty leku.
     */
    public void functionStart() {

        getDrugName();
        getDrugDetails();
        createDrug();
        returnTo();
    }
    /**
     * Metoda przenosząca użytkownika z panelu karty leku do panelu bazy danych.
     */
    public void returnTo(){
        new DatabasePanel();
    }

    protected void getDrugName() {
        consoleIn = new ConsoleIn();
        tradeName = consoleIn.getConsoleInput();
    }

    /**
     * Metoda pobierająca szczegóły dotyczące leku od użytkownika.
     */
    protected void getDrugDetails() {
        condition = true;

        while (condition) {
            System.out.println(Texts.DOSE_ASK);
            consoleIn = new ConsoleIn();
            String console3 = consoleIn.getConsoleInput();
            try {
                dose = Double.parseDouble(console3);
                dose = Math.round(dose*100.0) / 100.0 ;

                if(dose<=0){
                    System.out.println(Texts.DOSE_ERROR);
                }else{
                    condition = false;
                }

            } catch (NumberFormatException e) {
                System.out.println(Texts.NUMBEREXCEPTION_ERROR);
            }
        }
        condition = true;
        while (condition) {
            System.out.println(Texts.TABLETS_ASK);
            consoleIn = new ConsoleIn();
            String console2 = consoleIn.getConsoleInput();
            try {
                numberOfTablets = Integer.parseInt(console2);

                if(numberOfTablets<=0){
                    System.out.println(Texts.TABLETS_ERROR);
                }else{
                    condition = false;
                }

            } catch (NumberFormatException e) {
                System.out.println(Texts.NUMBEREXCEPTION_ERROR);
            }
        }
        condition = true;

        while (condition) {
            System.out.println(Texts.PRICE_ASK);
            consoleIn = new ConsoleIn();
            String console1 = consoleIn.getConsoleInput();
            try {
                price = Double.parseDouble(console1);
                price = Math.round(price*100.0)/100.0;
                if(price<=0){
                    System.out.println(Texts.PRICE_ERROR);
                }else{
                    condition = false;
                }
            } catch (NumberFormatException e) {
                System.out.println(Texts.NUMBEREXCEPTION_ERROR);
            }
        }


    }
    /**
     * Metoda tworząca nowy obiekt leku na podstawie wprowadzonych danych i dodająca go do bazy danych.
     */
    protected void createDrug() {

        DrugList drugList = DrugList.getInstance();
        Drug drug = new Drug(tradeName, dose, numberOfTablets, price);

        if (!drugList.containsDrug(drug)) {

            System.out.println(Texts.DRUG_ADD + drug.getLabel());
            drugList.addDrug(drug);
        } else {
            System.out.println(Texts.DRUG_EXISTS);
        }


    }

}
