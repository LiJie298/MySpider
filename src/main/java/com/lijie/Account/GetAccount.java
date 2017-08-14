package com.lijie.Account;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.selector.PlainText;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by lijie7 on 2017/8/14.
 */
public class GetAccount {
    private static String urllistno[] = {"https://baijia.baidu.com/", "https://baijia.baidu.com/channel?cat=1",
            "https://baijia.baidu.com/channel?cat=2", "https://baijia.baidu.com/channel?cat=3",
            "https://baijia.baidu.com/channel?cat=4", "https://baijia.baidu.com/channel?cat=5"
    };
    private static Logger logger = Logger.getLogger(GetAccount.class);
    public static void main(String[] args) {
        WebDriver driver = new PhantomJSDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        while (true) {
            try {
                for (int i = 0; i <= urllistno.length; i++) {
                    String url1 = urllistno[i];
                    driver.get(url1);
                    Request request = new Request(url1);
                    WebElement getMoreArticles = driver.findElement(By.ById.id("getMoreArticles"));
                    for (int j = 0; j <10; j++) {
                        getMoreArticles.click();
                        Thread.sleep(2000);
                    }
                    WebElement webElement = driver.findElement(By.xpath("/html"));
                    String content = webElement.getAttribute("outerHTML");
                    Page page = new Page();
                    page.setRawText(content);
                    page.setUrl(new PlainText(request.getUrl()));
                    page.setRequest(request);
                    List<Selectable> lists = page.getHtml().css("div.article-info").nodes();
                    for (Selectable selectable : lists) {
                        String mediaName = selectable.xpath("//div[@class='art-info']/div[@class='art-other']/div[@class='author']/a[1]/text()").toString();
                        String linkUrl = selectable.xpath("//div[@class='art-info']/div[@class='art-other']/div[@class='author']/a[1]/@href").toString();
                        logger.info("mediaName:"+mediaName+"\t"+"linkUrl:"+linkUrl+"\n");
                    }
                }
            }catch (Exception e){
                logger.error(e.getMessage());
            }
        }
    }


}
