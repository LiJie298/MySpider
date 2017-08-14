package com.lijie.Pipeline;

import com.lijie.util.Artical;
import org.apache.log4j.Logger;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lijie on 2017/8/13.
 */
public class SinaPipeline implements Pipeline {
    private Logger logger = Logger.getLogger(SinaPipeline.class);

    public void process(ResultItems resultItems, Task task) {
        Artical artical =resultItems.get("artical");
        try {
            saveNews(artical);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        logger.info(artical.toString());

    }

    public void saveNews(Artical artical) throws IOException{
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String fileName = formatter.format(date)+".txt";
        String classPath = Class.class.getResource("/").getPath();
        String dd = classPath.substring(0,classPath.lastIndexOf("MySpider")+8);
        File dir = new File(dd+"/news");
        File file = new File(dd+"/news/"+fileName);
        if(!dir.exists()){
            dir.mkdir();
        }else {
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file,true);
            fileWriter.write(artical.toString());
            fileWriter.flush();
            fileWriter.close();
        }


    }
}
