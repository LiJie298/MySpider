package com.lijie.util;

/**
 * Created by lijie on 2017/8/12.
 */
public class Artical {
    private String title;
    private String content;

    public Artical() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString(){
        return "\ntitle:"+title+"\tcontent:"+content+"\n";
    }
}
