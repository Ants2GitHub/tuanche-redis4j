package com.tuanche.analysis;

import com.tuanche.enums.AnalysisEnum;
import com.tuanche.utils.AnalysisTextUtils;

/**
 * Created by sosma on 2018/3/17.
 */
public class AnalysisUtilsTest {

    public static void main(String[] args) {
        String s = AnalysisTextUtils.analysisText(AnalysisEnum.INDEX,"张新竹是个大傻子!");
        System.out.println(s);
    }
}
