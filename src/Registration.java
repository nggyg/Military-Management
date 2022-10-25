import basic.*;

public class Registration {
    public Registration() {
    }
}

/*
    Jeder Soldat - hat eine Rustung, Waffe und Rang
                 - ist eine Person
                 - wenn Rang 'Private' ist dann kann auch jeder soldat ein Fahrer fur
                   ein Vehicle sein
    Jede Waffe, Rustung und Auto ist ein Item
    Item ist eine abstrakte Klasse welche zu einem Soldat 'assigned' ist
        - wenn ein Item usable als false hat kann man es nicht zu einen
          Soldat zuordnen
    Ein Battalion enthalt mehrere Soldaten
    Einen Vehicle kann mehrere Fahrer haben, ein Soldat kann mehrere Vehicles fahren
    In der Registration wird sich eine Person als Soldat registrieren,
    wird random zu einer Battalion zugeordnet und bekommt Waffe und Rustung.

* */