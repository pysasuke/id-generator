package com.py.domain;


/**
 * Created by pysasuke on 2017/5/5.
 * <p>
 * 区间对象
 */
public class Section {

    private String start;
    private String end;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Section(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public Section() {
    }
}
