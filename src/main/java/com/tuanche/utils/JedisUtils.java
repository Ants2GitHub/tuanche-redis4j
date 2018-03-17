package com.tuanche.utils;

/**
  * @description 操作redis相关的工具类
  * @author ants·ht
  * @date 2018/1/29 16:30
*/
public final class JedisUtils {

    /**
     * @description 根据选择的db校验db是否合理
     * @author ants·ht
     * @date 2018/1/29 16:33
     * @param dataBase 选择的db的索引
     * @return int 返回正确的db
    */
    public static int getDataBaseAndCheckDataBase(final int dataBase){
        final int default_dataBase = 15;
        // 校验选择的数据库是否正确，最大是15，否则默认15
        if(dataBase < 0 || dataBase > 15) {
            return default_dataBase;
        }
        return dataBase;
    }
}
