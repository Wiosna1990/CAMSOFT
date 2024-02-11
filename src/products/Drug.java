package products;

import texts.Texts;
/**
 * Klasa reprezentująca lek.
 */
public class Drug {

    protected String tradeName;
    protected double price;
    protected double dose;
    protected int numberOfTablets;
    /**
     * Konstruktor domyślny klasy Drug.
     */
    public Drug() {}
    /**
     * Konstruktor klasy Drug.
     * @param tradeName Nazwa handlowa leku.
     * @param dose Dawka leku.
     * @param numberOfTablets Liczba tabletek.
     * @param price Cena leku.
     */
    public Drug(String tradeName, double dose, int numberOfTablets,  double price) {
        this.tradeName = tradeName;
        this.price = price;
        this.numberOfTablets = numberOfTablets;
        this.dose = dose;
    }
    /**
     * Metoda zwracająca opis leku.
     * @return Opis leku.
     */
    public String getLabel(){
        String result = tradeName + " " + dose + " mg " + numberOfTablets + " tabl. " + price + " zł";

        return result;
    }
    /**
     * Metoda zwracająca liczbę tabletek leku.
     * @return Liczba tabletek leku.
     */
    public int getNumberOfTablets() {
        return numberOfTablets;
    }
    /**
     * Metoda ustawiająca liczbę tabletek leku.
     * @param numberOfTablets Nowa liczba tabletek leku.
     */
    public void setNumberOfTablets(int numberOfTablets) {
        this.numberOfTablets = numberOfTablets;
    }

    /**
     * Metoda zwracająca dawkę leku.
     * @return Dawka leku.
     */
    public double getDose() {
        return dose;
    }
    /**
     * Metoda ustawiająca dawkę leku.
     * @param dose Nowa dawka leku.
     */
    public void setDose(double dose) {
        this.dose = dose;
    }
    /**
     * Metoda zwracająca nazwę handlową leku.
     * @return Nazwa handlowa leku.
     */
    public String getTradeName() {
        return tradeName;
    }
    /**
     * Metoda ustawiająca nazwę handlową leku.
     * @param tradeName Nowa nazwa handlowa leku.
     */
    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    /**
     * Metoda zwracająca cenę leku.
     * @return Cena leku.
     */
    public double getPrice() {
        return price;
    }
    /**
     * Metoda ustawiająca cenę leku.
     * @param price Nowa cena leku.
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Metoda zwracająca linię tekstu reprezentującą lek w formacie do zapisu.
     * @return Linia tekstu reprezentująca lek.
     */
    public String getTextLine()
    {
        String result = tradeName + ";" + dose + ";" + numberOfTablets + ";" + price + System.lineSeparator();

        return result;
    }
    /**
     * Metoda parsująca linię tekstu i aktualizująca dane leku.
     * @param line Linia tekstu do sparsowania.
     * @return true jeśli parsowanie przebiegło pomyślnie, false w przeciwnym razie.
     */
    public Boolean parseTextLine(String line)
    {
        try
        {
            String [] lineValues = line.split(";");

            tradeName = lineValues[0];
            dose = Double.parseDouble(lineValues[1]);;
            numberOfTablets = Integer.parseInt(lineValues[2]);;
            price = Double.parseDouble(lineValues[3]);

            return true;
        }
        catch(Exception ex)
        {
            System.out.println(Texts.EXCEPTION_LINEERROR + line);

            return false;
        }
    }

}
