package com.lijie.main;

import com.lijie.MyPageProcess.SinaPageProcess;
import com.lijie.Pipeline.SinaPipeline;
import com.lijie.download.Impl.DownloadHtmlImpl;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijie on 2017/8/12.
 */
public class SinaSpider {
    public static void main(String[] args) {
        String url = "http://www.sina.com.cn/";
        Request request = new Request(url);
        List pipeLineList = new ArrayList();
        pipeLineList.add(new SinaPipeline());
        Spider.create(new SinaPageProcess()).addRequest(request)
                .setDownloader(new DownloadHtmlImpl(15)).setPipelines(pipeLineList).start();
    }
}
