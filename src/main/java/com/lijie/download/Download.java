package com.lijie.download;

/**
 * Created by lijie7 on 2017/8/2.
 */
public interface Download  extends Runnable{
    String getStartDownload(String url);
    void setThreadNum(int number);

}
