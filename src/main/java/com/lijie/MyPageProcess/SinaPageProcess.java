package com.lijie.MyPageProcess;

import com.lijie.Crawler.SinaCrawler;
import com.lijie.util.Artical;
import com.lijie.util.LinkQueue;
import org.apache.log4j.Logger;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.CssSelector;
import us.codecraft.webmagic.selector.Selector;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by lijie on 2017/8/12.
 */
public class SinaPageProcess implements PageProcessor {
    private Logger logger = Logger.getLogger(SinaPageProcess.class);
    private LinkQueue linkQueue = new LinkQueue();
    private Site site = Site.me()
            .setSleepTime(3000)
            .setTimeOut(30000)
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
    private static Pattern regex = Pattern.compile("http://blog.sina.com.cn/s/blog_\\d+\\w+.html\\?\\w+=1");

    public void process(Page page) {
        Request request = page.getRequest();
        Artical artical = new Artical();
        String type = (String)request.getExtra("type");
        Selector selector = new CssSelector("");
        List urlList = page.getHtml().links().regex("http://blog.sina.com.cn/s/blog_\\d+\\w+.html\\?\\w+=1").all();
        if(type!=null&&type.equals("detail")){
            for(int i=0 ; i<urlList.size();i++){
                artical = SinaCrawler.crawSina(page);
                page.putField("artical",artical);
            }
        }else {
            for(int i=0 ; i<urlList.size();i++){
                linkQueue.addUnvisitedUrl(urlList.get(i).toString());
                Request request1 = new Request(urlList.get(i).toString());
                request1.putExtra("type","detail");
                page.addTargetRequest(request1);
            }
        }
        logger.info("可用连接数目：" + linkQueue.getUnVisitUrlNum());
    }

    public Site getSite() {
        return this.site;
    }
}
