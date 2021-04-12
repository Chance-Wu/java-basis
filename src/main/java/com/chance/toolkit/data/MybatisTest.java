package com.chance.toolkit.data;

import com.chance.designpatterns.patterns.entity.User;
import com.google.common.collect.Maps;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 反射机制，sql解析替换，JDK动态代理来实现Mapper接口的方法拦截
 * @Author: chance
 * @Date: 4/7/21 2:37 PM
 * @Version 1.0
 */
interface UserMapper {
    @Select("SELECT * FROM blog WHERE id = #{id}")
    List<User> selectUserList(Integer id, String name);
}

public class MybatisTest {

    public static void main(String[] args) {
        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(MybatisTest.class.getClassLoader(), new Class<?>[]{UserMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Select annotation = method.getAnnotation(Select.class);

                Map<String, Object> nameArgMap = buildMethodArgNameMap(method, args);

                if (null != annotation) {
                    String[] value = annotation.value();
                    String sql = value[0];
                    sql = parseSQL(sql, nameArgMap);
                    System.out.println(sql);

                    // 获取返回类型去处理结果集（ResultSet）
                    System.out.println(method.getReturnType());
                    System.out.println(method.getGenericReturnType());
                }
                return null;
            }
        });
        userMapper.selectUserList(1, "test");
    }

    /**
     * 解析SQL，进行参数替换
     *
     * @param sql        原sql
     * @param nameArgMap 方法参数map
     * @return
     */
    public static String parseSQL(String sql, Map<String, Object> nameArgMap) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = sql.length();
        for (int i = 0; i < length; i++) {
            char c = sql.charAt(i);
            if (c == '#') {
                int nextIndex = i + 1;
                char nextChar = sql.charAt(nextIndex);
                if (nextChar != '{') {
                    throw new RuntimeException(String.format("这里应该为#{\nsql:%s\nindex:%d}"
                            , stringBuilder.toString(), nextIndex));
                }
                // 如果当前字符为'{'，获取到参数名
                StringBuilder argSB = new StringBuilder();
                i = parseSQLArg(argSB, sql, nextIndex);
                String argName = argSB.toString();
                Object argValue = nameArgMap.get(argName);
                stringBuilder.append(argValue.toString());
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    /**
     * 解析sql中的参数
     *
     * @param argSB
     * @param sql
     * @param nextIndex
     * @return
     */
    private static int parseSQLArg(StringBuilder argSB, String sql, int nextIndex) {
        nextIndex++;
        for (; nextIndex < sql.length(); nextIndex++) {
            char c = sql.charAt(nextIndex);
            if (c != '}') {
                argSB.append(c);
                continue;
            }
            if (c == '}') {
                return nextIndex;
            }
        }
        throw new RuntimeException(String.format("缺少右括号\nindex:%d}"
                , nextIndex));
    }


    /**
     * 构建方法参数 Map
     *
     * @param method
     * @param args
     * @return
     */
    public static Map<String, Object> buildMethodArgNameMap(Method method, Object[] args) {
        HashMap<String, Object> nameArgMap = Maps.newHashMap();
        Parameter[] parameters = method.getParameters();

        final int[] index = {0};
        Arrays.asList(parameters).forEach(parameter -> {
            String name = parameter.getName();
            nameArgMap.put(name, args[index[0]]);
            index[0]++;
        });
        return nameArgMap;
    }
}
