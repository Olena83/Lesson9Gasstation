package Gasstation;

 public enum Petrol {
    A_95("95"),
    A_98("98"),
    DIESEL("Diesel");

    private String type;

    public String getDescription() {
        return type;
    }

    Petrol(String type) {
        this.type = type;
    }
}

