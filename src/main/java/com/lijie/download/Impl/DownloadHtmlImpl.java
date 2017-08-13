package com.lijie.download.Impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.AbstractDownloader;
import us.codecraft.webmagic.downloader.HttpClientGenerator;

/**
 * Created by lijie7 on 2017/8/2.
 */
public class DownloadHtmlImpl extends AbstractDownloader {
    private Logger log = LogManager.getLogger(DownloadHtmlImpl.class.getName());
    private HttpClientGenerator httpClientGenerator = new HttpClientGenerator();
    private int threadNum;

    public DownloadHtmlImpl(int threadNum) {
        this.threadNum = threadNum;
    }

    public Page download(Request request, Task task) {
        Site site = null;
        if(task != null) {
            site = task.getSite();
        }
        return this.addToCycleRetry(request,site);
    }

    public void setThread(int threadNum) {
        this.httpClientGenerator.setPoolSize(getThreadNum());
    }

    public int getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(int threadNum) {
        this.threadNum = threadNum;
    }

}
