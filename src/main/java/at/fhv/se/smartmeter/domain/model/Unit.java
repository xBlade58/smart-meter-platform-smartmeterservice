package at.fhv.se.smartmeter.domain.model;

public enum Unit {
    A("A"),
    V("V"),
    KWH("kWh"),
    KVARH("kvarh");

    private final String label;

    Unit(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
