package com.dilatoit.engine.engines.mtc.util;

import java.text.DecimalFormat;

/**
 * Created by xueshan.wei on 3/22/2017.
 */
public class NumUtils {
    private static DecimalFormat dfTwo = new DecimalFormat("######0.00");

    /**
     * 格式化保留两位小数
     * @param num
     * @return
     */
    public static String formatToTwo(double num){
        return dfTwo.format(num);
    }
}
