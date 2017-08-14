package com.lijie.Crawler;

import com.lijie.util.Artical;
import org.jsoup.nodes.Document;
import us.codecraft.webmagic.Page;

/**
 * Created by lijie on 2017/8/12.
 */
public class SinaCrawler {
    public static Artical crawSina(Page page){
        Artical artical = new Artical();
        Document document = page.getHtml().getDocument();
        artical.setTitle(document.select("h2.titName").select(".SG_txta").text());
        artical.setContent(document.select("div#sina_keyword_ad_area2").toString());
        return artical;
    }

}
