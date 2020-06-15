package com.chance.basis.java8.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-02-13
 */
public class Print {

    public static String processFile(BufferedReaderProcessor p)
            throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br); //处理BufferedReader对象
        }
    }

    public static void main(String[] args) throws IOException {
        //处理一行
        String oneLine = processFile((BufferedReader br) -> br.readLine());

        //处理两行
        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
    }
}
