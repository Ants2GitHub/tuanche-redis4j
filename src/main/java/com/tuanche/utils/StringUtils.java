package com.tuanche.utils;

/**
  * @description 字符串操作的相关的工具类
  * @author ants·ht
  * @date 2018/2/2 15:44
*/
public final class StringUtils {

    public static boolean isEmpty(final String str) {
        return null == str ? true : "".equals(str) ? true : str.trim().length() == 0 ? true : false;
    }

    public static boolean isNotEmpty(final String str) {
        return !isEmpty(str);
    }
}
