package com.example.myecsite.form;

import com.example.myecsite.enums.SortEnum;

public class SearchItemForm {
    private String name = "";
    private Integer page = 1;
    private Integer sortId = SortEnum.PRICE_ASC.getId();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
