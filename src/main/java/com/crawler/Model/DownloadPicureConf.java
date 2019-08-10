package com.crawler.Model;

import com.crawler.rule.PicRule;

/**
 * 下载文件配置类
 */
public class DownloadPicureConf {
    /**
     * 下载文件的源地址
     */
    private String srcUrl;
    /**
     * 保存地址
     */
    private String savePatch;
    /**
     * 过滤规则
     */
    private PicRule rule;

    public String getSrcUrl() {
        return srcUrl;
    }

    public void setSrcUrl(String srcUrl) {
        this.srcUrl = srcUrl;
    }

    public String getSavePatch() {
        return savePatch;
    }

    public void setSavePatch(String savePatch) {
        this.savePatch = savePatch;
    }

    public PicRule getRule() {
        return rule;
    }

    public void setRule(PicRule rule) {
        this.rule = rule;
    }
}
