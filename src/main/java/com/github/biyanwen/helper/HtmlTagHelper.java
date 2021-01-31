package com.github.biyanwen.helper;

import com.github.biyanwen.enums.HtmlTagEnum;

/**
 * @author 10644
 */
public class HtmlTagHelper {

    public static boolean isTag(String tagName, HtmlTagEnum tagEnum) {
        if (tagName.equals(tagEnum.name())) {
            return true;
        }
        return false;
    }

}
