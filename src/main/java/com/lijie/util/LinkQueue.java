package com.lijie.util;

import java.util.HashSet;
import java.util.Set;

/**
 * 用于存储目前网页的所有连接
 * Created by lijie7 on 2017/8/3.
 */
public class LinkQueue {
    private static Set visitedUrl = new HashSet();
    private static WorkQueue unVisitedUrl = new WorkQueue();

    public static  WorkQueue getUnVisitedUrl(){
        return unVisitedUrl;
    }



    //添加访问过的url到visitedUrl
    public static void addVisitedUrl(String url){
        visitedUrl.add(url);
    }
    //移除访问过url
    public static void removeVisitedUrl(String url){
        visitedUrl.remove(url);
    }
    //保证每个url只被访问一次
    public static void addUnvisitedUrl(String url){
        if(url!=null&& !url.trim().equals("")&& !unVisitedUrl.isRepeat(url)&& !visitedUrl.contains(url)){
            unVisitedUrl.addQueue(url);
        }
    }

    //获取已经访问过的url数量
    public static int getVisitedUrlNum(){
        return visitedUrl.size();
    }

    public static int getUnVisitUrlNum(){
        return unVisitedUrl.getQueueNum();
    }
    //判断问访问的URL队列是否为空
    public static boolean unVisitedUrlEmpty(){
        return  unVisitedUrl.empty();
    }

}