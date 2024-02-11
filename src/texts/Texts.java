package texts;
/**
 * Klasa przechowująca teksty wykorzystywane w programie.
 */
public class Texts {

    public static  final String WAREHOUSE_START = "WITAJ W MAGAZYNIE LEKÓW, WYBIERZ JEDNĄ Z OPCJI: \n1. Baza leków \n2. Wyjscie z programu";
    public static  final String SWITCH_DEFAULT = "Zły wybór, spróbuj ponownie!";
    public static  final String DATABASE_START = "WITAJ W BAZIE LEKÓW, WYBIERZ JEDNĄ Z OPCJI: \n1. Dodaj kartę leku \n2. Usuń kartę leku \n3. Aktualizuj kartę leku \n4. Wyszukaj lek. \n5. Wyswietl listę leków \n6. Wróć do Magazynu \n7. Wyjscie z programu";
    public static  final String DRUGCARD_START = "Podaj nazwę leku:";
    public static  final String DOSE_ASK = "Podaj dawkę w mg:";
    public static  final String DOSE_ERROR = "Dawka nie moze byc mniejsza badz równa 0!";
    public static  final String NUMBEREXCEPTION_ERROR = "Nieprawidłowy format liczby! Spróbuj ponownie";
    public static  final String TABLETS_ASK = "Podaj liczbę tabletek w opakowaniu (liczba całkowita): ";
    public static  final String TABLETS_ERROR = "Liczba tabletek nie moze byc mniejsza lub równa 0!";
    public static  final String PRICE_ASK = "Podaj cenę leku w formacie [#.##]:";
    public static  final String PRICE_ERROR = "Cena nie moze byc mniejsza lub równa 0!";
    public static  final String DRUG_ADD = "Dodany lek: ";
    public static  final String DRUG_EXISTS = "Ten lek już istnieje na liście.";
    public static  final String DRUG_NOTEXISTS = "Nie ma takiego leku, spróboj ponownie!";
    public static  final String REMOVEDRUG_START = "Podaj nazwę produktu który chcesz usunąć:";
    public static  final String REMOVEDRUG_REMOVE = "Usuwam lek. ";
    public static  final String UPDATEDRUG_START = "Podaj nazwę produktu który chcesz aktualizować:";
    public static  final String UPDATEDRUG_NOTUPDATE = "Nie udalo sie zaktualizować.";
    public static  final String UPDATEDRUG_UPDATE = "Aktualizuję lek ";
    public static  final String SEARCHDRUG_START = "Podaj tekst do filtrowania po nazwie produktu:";
    public static  final String DRUG_LIST = "Lista leków";
    public static  final String DRUGLIST_EMPTY = "Lista leków";
    public static  final String IOEXCEPTION_READERROR = "Błąd odczytu pliku";
    public static  final String IOEXCEPTION_SAVEERROR = "Błąd zapisu do pliku!.";
    public static  final String EXCEPTION_LINEERROR = "Błąd odczytu lini: ";



}
