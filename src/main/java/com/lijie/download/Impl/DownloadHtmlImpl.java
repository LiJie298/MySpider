package com.lijie.download.Impl;

import com.lijie.download.Download;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lijie7 on 2017/8/2.
 */
public class DownloadHtmlImpl implements Download {
    private Logger log = LogManager.getLogger(DownloadHtmlImpl.class.getName());
    private int threadNumber ;
    private ExecutorService threadService ;


    public synchronized String getStartDownload(String url){
        log.info("DownLoading : "+url);
        String html = "";

        return html;
    }

    @Override
    public void setThreadNum(int num ){
        if(num>0){
            this.threadNumber = num;
            this.threadService = Executors.newFixedThreadPool(num);
            log.info("threadPool has created");
            for(int i = 0;i<num;i++){

            }
        }

    }

    @Override
    public void run() {
//        getStartDownload();
    }
}
