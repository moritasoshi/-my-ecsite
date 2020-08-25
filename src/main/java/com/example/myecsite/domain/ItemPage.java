package com.example.myecsite.domain;

import java.util.List;

public class ItemPage{
    private List<Item> itemList;
    // ページング関連
    /**
     * 一致するItem数
     */
    private Integer size;
    /**
     * ページ数
     * page > 0 かつ page <= totalPage
     */
    private Integer page;
    /**
     * 1ページあたりの表示数
     */
    private Integer pageSize;
    /**
     * 総ページ数
     */
    private Integer totalPage;

    public ItemPage() {
    }

    public ItemPage(List<Item> itemList, Integer size, Integer page, Integer pageSize, Integer totalPage) {
        this.itemList = itemList;
        this.size = size;
        this.page = page;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
