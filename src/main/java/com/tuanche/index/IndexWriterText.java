package com.tuanche.index;

import com.tuanche.utils.JedisUtils;
import com.tuanche.utils.StringUtils;
import redis.clients.jedis.Jedis;

/**
  * @description 索引创建类
  * @author ants·ht
  * @date 2018/2/2 14:39
*/
public class IndexWriterText {

    private final Jedis jedis;
    private final int dataBase;



    public IndexWriterText(Jedis jedis,int dataBase) {
        if(!jedis.isConnected()) {
            jedis.connect();
        }
        this.dataBase = JedisUtils.getDataBaseAndCheckDataBase(dataBase);
        // 选择数据库
        jedis.select(this.dataBase);
        this.jedis = jedis;
    }

    /**
     * @description  要创建的文本内容和文本对应的id
     * @author ants·ht
     * @date 2018/2/2 15:41
     * @param id 文本id
     * @param text 文本内容
     * @return
    */
    public void addIndexItem(String id,String text) {

    }

    private void analysisText(final String text) {
        if(StringUtils.isEmpty(text)) {return;}
    }
}
