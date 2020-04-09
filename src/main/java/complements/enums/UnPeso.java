package complements.enums;

public enum UnPeso {
    ml("ml"),
    l("L"),
    g("g"),
    kg("Kg");

    private String desc;

    UnPeso(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
