package com.chance.basis.regexp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * @Description: 正则表达式
 * @Author: chance
 * @Date: 2020-09-28 09:34
 * @Version 1.0
 */
public class RegexpTest {

    //    private static Pattern NUMBER_PATTERN = Pattern.compile("^[-\\+]?[\\d]*$");
    private static Pattern NUMBER_PATTERN = Pattern.compile("-?[0-9]+(\\\\.[0-9]+)?");

    @Test
    public void test() {
        ArrayList<String> list = new ArrayList<>();
        list.add("12312");
        list.add("142a");
        list.add("142");
        list.add("12232342343333");
        for (String str : list) {
            // 判断字符串是否为纯数字
            if (!isNumeric(str)) {
                // 跳过，进入下一次循环
                continue;
            }
            System.out.println(str);
        }
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
//        return NUMBER_PATTERN.matcher(str).matches();
        return str.matches("12" + "[0-9]{12}");
    }
}
