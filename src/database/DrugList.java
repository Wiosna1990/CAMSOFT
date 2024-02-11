package database;
import products.Drug;
import texts.Texts;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Klasa reprezentująca listę leków w bazie danych.
 */
public class DrugList {

    private static DrugList instance;

    private List<Drug> drugs;
    /**
     * Konstruktor klasy DrugList. Inicjuje listę leków, wczytuje dane z pliku i sortuje listę.
     */
    public DrugList() {
        drugs = new ArrayList<>();
        loadDrugsFile();
        sortDrugsList();
    }
    /**
     * Metoda zwracająca instancję klasy DrugList.
     * @return Instancja klasy DrugList.
     */
    public static DrugList getInstance() {
        if (instance == null) {
            instance = new DrugList();
        }
        return instance;
    }
    /**
     * Metoda dodająca lek do listy i zapisująca zmiany do pliku.
     * @param drug Lek do dodania.
     */
    public void addDrug(Drug drug) {
        drugs.add(drug);
        saveDrugsFile();
    }
    /**
     * Metoda usuwająca lek z listy i zapisująca zmiany do pliku.
     * @param drug Lek do usunięcia.
     */
    public void removeDrug(Drug drug) {
        drugs.remove(drug);
        saveDrugsFile();
    }
    /**
     * Metoda sprawdzająca, czy dany lek jest już w liście.
     * @param drug Lek do sprawdzenia.
     * @return true jeśli lek jest w liście, false w przeciwnym razie.
     */
    public boolean containsDrug(Drug drug) {
        for (Drug d : drugs) {

            if (d.getTradeName().equals(drug.getTradeName())
                   &&
                    d.getDose() == drug.getDose() &&
                    d.getNumberOfTablets() == drug.getNumberOfTablets()
            )
            {
                return true;
            }
        }
        return false;
    }
    /**
     * Metoda wyświetlająca listę leków.
     */
    public void displayDrugs() {
        if (drugs.isEmpty()) {
            System.out.println(Texts.DRUGLIST_EMPTY);
        } else {
            System.out.println(Texts.DRUG_LIST);
            for (Drug drug : drugs) {
                System.out.println(drug.getLabel());
            }
        }
    }
    /**
     * Metoda wczytująca leki z pliku.
     */
    public void loadDrugsFile() {
        try {
            List<String> allLines = Files.readAllLines(Paths.get("src/Drugs.txt"));

            for (String line : allLines) {
                Drug drug = new Drug();
                if(drug.parseTextLine(line))
                {
                    drugs.add(drug);
                }
            }
        } catch (IOException e) {
            System.out.println(Texts.IOEXCEPTION_READERROR);
        }
    }
    /**
     * Metoda zapisująca leki do pliku.
     */
    public void saveDrugsFile() {
        try {
            FileWriter myWriter = new FileWriter("src/Drugs.txt");
            StringBuilder res = new StringBuilder();
            for (Drug drug : drugs) {
                res.append(drug.getTextLine());
            }
            myWriter.write(res.toString());
            myWriter.close();
        } catch (IOException e) {
            System.out.println(Texts.IOEXCEPTION_SAVEERROR);
        }
        sortDrugsList();
    }
    /**
     * Metoda wyszukująca lek po nazwie.
     * @param name Nazwa leku do wyszukania.
     * @return Lek znaleziony po nazwie.
     */
    public Drug findDrugByName(String name) {
        for(Drug drug : drugs)
        {
            if(drug.getTradeName().equalsIgnoreCase(name))
            {
                return drug;
            }
        }
        return null;
    }
    /**
     * Metoda wyszukująca leki po częściowej nazwie.
     * @param name Częściowa nazwa leku do wyszukania.
     * @return Lista leków pasujących do częściowej nazwy.
     */
    public List<Drug> findAllDrugByName(String name) {
        List<Drug>  res = new ArrayList<>();

        for(Drug drug : drugs)
        {
            if(drug.getTradeName().toLowerCase().startsWith(name.toLowerCase()))
            {
                res.add(drug);
            }
        }
        return res;
    }
    /**
     * Metoda sortująca listę leków alfabetycznie.
     */
    public void sortDrugsList() {
        drugs.sort((c1, c2) -> c1.getTradeName().toLowerCase().compareTo(c2.getTradeName().toLowerCase()));
    }

}

