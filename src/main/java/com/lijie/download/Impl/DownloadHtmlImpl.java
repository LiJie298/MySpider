package com.lijie.download.Impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.downloader.HttpClientGenerator;

/**
 * Created by lijie7 on 2017/8/2.
 */
public class DownloadHtmlImpl extends HttpClientDownloader {
    private Logger log = LogManager.getLogger(DownloadHtmlImpl.class.getName());
    private HttpClientGenerator httpClientGenerator = new HttpClientGenerator();
    private int threadNum;

    public DownloadHtmlImpl(int threadNum) {
        this.threadNum = threadNum;
    }

    public Page download(Request request, Task task) {
       Page page = super.download(request,task);
        return page;
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
