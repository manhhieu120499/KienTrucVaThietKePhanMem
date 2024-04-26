package iuh.store_event_driven.entity;

public class Price {
    private String display;

    public Price(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Price{" +
                "display='" + display + '\'' +
                '}';
    }
}
