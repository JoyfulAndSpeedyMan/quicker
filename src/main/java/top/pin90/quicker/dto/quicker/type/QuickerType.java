package top.pin90.quicker.dto.quicker.type;

public enum QuickerType {
    CALC("calc"),
    URL("url"),
    SEARCH("search");

    private final String name;

    QuickerType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
