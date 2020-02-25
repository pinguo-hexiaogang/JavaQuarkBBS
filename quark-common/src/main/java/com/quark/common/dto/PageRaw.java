package com.quark.common.dto;

import java.util.List;

public class PageRaw<T> {
    private int total;
    private List<T> page;
    private int start;
    private int pageSize;

    public PageRaw(int total, List<T> page, int start, int pageSize) {
        this.total = total;
        this.page = page;
        this.start = start;
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getPage() {
        return page;
    }

    public void setPage(List<T> page) {
        this.page = page;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageRaw{" +
                "total=" + total +
                ", page=" + page +
                ", start=" + start +
                ", pageSize=" + pageSize +
                '}';
    }
}
