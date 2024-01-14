package at.fhv.se.smartmeter.adapter.timescaledb.mapper;

public enum Unit {
    A("Amperes"),
    V("Volts"),
    KWH("Kilowatt Hours");

    private final String label;

    Unit(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
