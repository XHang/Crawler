package com.crawler.crawlertool;

import com.crawler.Model.DownloadPicureConf;

import java.util.Timer;

import static org.junit.Assert.*;

public class CrawlertoolTest {

    @org.junit.Test
    public void downloadPicure() {
        DownloadPicureConf conf = new DownloadPicureConf();
        conf.setSrcUrl("https://www.zhihu.com/collection/324462441");
        conf.setSavePatch("D:\\知乎图片");
        conf.setRule(url -> {
            String[] eles = url.split("_");
            if (eles.length<2){
                return true;
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            eles = eles[eles.length - 1].split("\\.");
            String ele = eles[0];
            return "r".equals(ele);
        });
        Crawlertool.downloadPicure(conf);
    }
}