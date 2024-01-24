package at.fhv.se.smartmeter.domain;

public enum Unit {
    A("A"),
    V("V"),
    KW("kW"),
    KWH("kWh"),
    KVARH("kvarh");

    private final String label;

    Unit(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Unit fromString(String text) {
        for (Unit unit : Unit.values()) {
            if (unit.label.equalsIgnoreCase(text)) {
                return unit;
            }
        }
        throw new IllegalArgumentException("No constant with label " + text + " found in enum Unit");
    }
}
