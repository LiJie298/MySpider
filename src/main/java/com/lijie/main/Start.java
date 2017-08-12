package com.lijie.main;

import com.lijie.util.LinkQueue;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lijie7 on 2017/8/2.
 */
public class Start {
    private static Logger log = LogManager.getLogger(Start.class);
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        LinkQueue linkQueue= new LinkQueue();
        Vertx  vertx = Vertx.vertx();
        WebClientOptions options = new WebClientOptions().setUserAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)").setKeepAlive(false);
        WebClient client = WebClient.create(vertx,options);
        client.get("https://baijia.baidu.com")
                .timeout(5000)
              .send(result->{
            if (result.succeeded()){
                HttpResponse<Buffer> response = result.result();
                Document doc = Jsoup.parse(response.bodyAsString());
                Elements elements = doc.getElementsByTag("a");
                String regexRule ="https://baijia.baidu.com/s";
                for(Element element:elements){
                    String url = element.attr("href").replaceAll(regexRule,"");
                    System.out.println(url);
                }
                log.info("访问成功！！"+response.statusCode());
            }else {
                log.info("出现错误！！"+result.cause());
            }
        });
        client.close();

    }

}
