package com.example.myecsite.domain;

import com.example.myecsite.enums.SortEnum;

public class SearchItem {
    private String name = "";
    private Integer page = 1;
    private SortEnum sortEnum = SortEnum.PRICE_ASC;
    private Integer pageSize;

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

    public SortEnum getSortEnum() {
        return sortEnum;
    }

    public void setSortEnum(SortEnum sortEnum) {
        this.sortEnum = sortEnum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}