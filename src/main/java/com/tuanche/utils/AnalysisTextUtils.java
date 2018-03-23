package com.tuanche.utils;

import com.tuanche.enums.AnalysisEnum;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.ansj.splitWord.analysis.IndexAnalysis;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;

/**
  * @description 文本分词工具类
  * @author ants·ht
  * @date 2018/3/17 16:18
*/
public final class AnalysisTextUtils {

    /**
     * @description 基本分词
     * @author ants·ht
     * @date 2018/3/17 16:15
     * @param text 要被分词的 文本内容
     * @return  返回结果为 | 隔开的 字符集合
    */
    public static String analysisText(String text) {
        return analysisText(AnalysisEnum.BASE,text);
    }

    /**
     * @description 按照指定类型分词
     * @author ants·ht
     * @date 2018/3/17 16:16
     * @param analysisEnum 指定分词类型
     * @param text 要被分词的文本内容
     * @return  返回结果为 | 隔开的 字符集和
    */
    public static String analysisText(AnalysisEnum analysisEnum,String text) {
        if(StringUtils.isEmpty(text)) {
            return "";
        }
        Result parse = null;
        String res = "";
        switch (analysisEnum) {
            case BASE:
                parse = BaseAnalysis.parse(text);
                break;
            case PRECISE:
                parse = ToAnalysis.parse(text);
                break;
            case NLP:
                parse = NlpAnalysis.parse(text);
                break;
            case INDEX:
                parse = IndexAnalysis.parse(text);
                break;
            default:
                parse = BaseAnalysis.parse(text);
                break;
        }
        StringBuilder sb = new StringBuilder();
        if(null != parse) {
            for (Term term : parse.getTerms()) {
                String name = term.getRealName();
                sb.append(name);
                sb.append("|");
            }
        }
        String tmp = sb.toString();
        if(tmp.endsWith("|")) {
            res = tmp.substring(0,tmp.length()-1);
        } else {
            res = tmp;
        }
        return res;
    }
}
