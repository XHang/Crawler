package com.crawler.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Htmlutil {

    public static List<String> GetPicUrl(String content) {
        String[] matchs = RegUtil.getMatchText(content, "(http|https)://([a-z0-9A-Z]+\\.)+([a-z0-9A-Z]+/)+([a-z0-9A-Z]|-|_)+\\.jpg");
        return new ArrayList<>(Arrays.asList(matchs));
    }

}
