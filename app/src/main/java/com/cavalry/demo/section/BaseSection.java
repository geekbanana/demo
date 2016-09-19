package com.cavalry.demo.section;

/**
 * Created by Cavalry on 2016/8/6.
 */
public class BaseSection<T>{
    public boolean isHead;
    public String headText;
    public T content;

    public BaseSection(boolean isHead, String headText){
        this.isHead = isHead;
        this.headText = headText;
        this.content = null;
    }

    public BaseSection(T content){
        isHead = false;
        headText = null;
        this.content = content;
    }

}
