package com.example.myecsite.enums;

public enum SortEnum {
    PRICE_ASC(1, "価格が安い順"),
    PRICE_DESC(2, "価格が高い順"),
    NAME_ASC(3, "名前順");

    private Integer id;
    private String label;

    private SortEnum(Integer id, String label){
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
