# Military_Management_V1
first phase of final project
Jeder Soldat - hat eine Rustung, Waffe und Rang
                 - ist eine Person
                 - wenn Rang 'Private' ist dann kann auch jeder soldat ein Fahrer fur
                   ein Vehicle sein
    Jede Waffe, Rustung und Auto ist ein Item
    Item ist eine abstrakte Klasse welche zu einem Soldat 'assigned' ist
        - wenn ein Item usable als false hat kann man es nicht zu einen
          Soldat zuordnen
    Ein Battalion enthalt mehrere Soldaten und ein leader
    Einen Vehicle kann mehrere Fahrer haben, ein Soldat kann mehrere Vehicles fahren
    In der Registration wird sich eine Person als Soldat registrieren,
    wird random zu einer Battalion zugeordnet und bekommt Waffe und Rustung.
    Inventory hat eine liste fur Waffe, Rustung und Vehicles, aus dieser wird der Soldat der sich
    registriert eine Waffe und Rustung welche nicht zugeordnet sind.
    Jeder Soldat hat eine Stat-Klasse welche ihre Fahigkeiten verspiegelt.
