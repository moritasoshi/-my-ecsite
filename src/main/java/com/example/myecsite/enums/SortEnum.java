package com.example.myecsite.enums;

import java.util.Arrays;

public enum SortEnum {
    PRICE_ASC(1, "価格が安い順", "price_m", "ASC"),
    PRICE_DESC(2, "価格が高い順", "price_m", "DESC"),
    NAME_ASC(3, "名前順", "name", "ASC");

    private Integer id;
    private String label;
    private String column;
    private String order; //  ascending vs descending

    SortEnum(Integer id, String label, String column, String order) {
        this.id = id;
        this.label = label;
        this.column = column;
        this.order = order;
    }

    /**
     * id によって合致するSortEnumを返すメソッド
     * @param id
     * @return
     */
    public static SortEnum getById(Integer id) {
        return Arrays.stream(SortEnum.values())
                .filter(data -> data.getId().equals(id))
                .findFirst()
                .orElse(null);
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

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
