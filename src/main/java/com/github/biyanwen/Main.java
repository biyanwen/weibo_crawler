package com.github.biyanwen;

import com.github.biyanwen.helper.CookieHelper;
import com.github.biyanwen.parse.ExclusiveArticleParse;
import com.github.biyanwen.parse.HtmlParse;
import com.github.biyanwen.pojo.MarkDownBean;
import com.github.biyanwen.render.MarkDownRender;
import com.github.biyanwen.render.Render;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, String> cookieMap = CookieHelper.createCookieMap("SINAGLOBAL=4097953661225.5884.1602151644629; _s_tentry=-; Apache=1763623193358.3967.1611384020310; ULV=1611384020373:2:1:1:1763623193358.3967.1611384020310:1602151644636; login_sid_t=c7ccf8703205c3c3734c563d3785005b; cross_origin_proto=SSL; UOR=,,login.sina.com.cn; SSOLoginState=1611389187; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WFCzlREeOF4P6mZ9x__61pk5JpX5KMhUgL.Fo-f1h.E1hzX1Ke2dJLoIXnLxKqLB-qL1K-LxKqLB-qL1K-LxKqLB-qL1K-LxKqLB-qL1K-LxKqLB-qL1K-LxKqLB-qL1K-LxK-L1h-L1hnLxKML1KBL1-qt; ALF=1643012058; SCF=Am1oB4s4nOQGITezeQoiWR4pm9V3jb4NUNhf4eogMm__MznYb-_231EXCWIrQDcWym44dcibtLqJpopST7POoDM.; SUB=_2A25NCVwODeRhGeNL41sT-CzIwj-IHXVuf8rGrDV8PUNbmtANLRPfkW9NSMSk6wD8z3uhhIZx3mnEWgxuM37nvReV; wvr=6; wb_view_log_5589282493=1280*8002; webim_unReadCount=%7B%22time%22%3A1611476094006%2C%22dm_pub_total%22%3A0%2C%22chat_group_client%22%3A0%2C%22chat_group_notice%22%3A0%2C%22allcountNum%22%3A0%2C%22msgbox%22%3A0%7D; WBStorage=8daec78e6a891122|undefined");
        HtmlParse htmlParse = new ExclusiveArticleParse();
        MarkDownBean markDownBean = htmlParse.parse("https://weibo.com/ttarticle/p/show?id=2309404595914059677855#_0", cookieMap);
        Render render = new MarkDownRender();
        Path path = Paths.get(System.getProperty("user.dir") + File.separator + markDownBean.getTitle().getText() + ".md");
        render.render(markDownBean, path);
    }
}
