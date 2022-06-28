package com.chance.basis.image;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: chance
 * @date: 2022/4/25 14:51
 * @since: 1.0
 */
public class BufferedImageTest {

    @Test
    public void testCreateBufferedImage() throws IOException {
        int width = 120;
        int height = 60;
        //指定宽高、创建带灰色的对象
        BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        FileOutputStream fileOutputStream1 = new FileOutputStream("src/main/resources/images/demo1.jpg");
        ImageIO.write(grayImage, "jpg", fileOutputStream1);

        //创建一个不带透明色的对象
        BufferedImage intImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        FileOutputStream fileOutputStream2 = new FileOutputStream("src/main/resources/images/demo2.jpg");
        ImageIO.write(grayImage, "jpg", fileOutputStream2);

        //创建一个带透明色的对象
        BufferedImage argeImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        FileOutputStream fileOutputStream3 = new FileOutputStream("src/main/resources/images/demo3.jpg");
        ImageIO.write(grayImage, "jpg", fileOutputStream3);
    }

    @Test
    public void testReadAndWrite() throws IOException {
        // 本地图片
        File pngFile = new File("src/main/resources/images/img.png");
        // 将本地图片文件读到缓存
        BufferedImage bufferedImage = ImageIO.read(pngFile);
        FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/images/test.png");
        // png为要保存的格式
        ImageIO.write(bufferedImage, "png", fileOutputStream);
        System.out.println(bufferedImage.getData());
        fileOutputStream.close();
    }

    /**
     * --------------------------测试ImageIOUtil工具类--------------------------
     */
    public static void main(String[] args) {
        //将指定颜色变透明测试
        createImageByMaskColorExTest();
        //按倍率缩小图片测试
//        reduceImageByRatioTest();
        //按比例放大图片测试
//        enlargementImageByRatioTest();
        //指定图形的长和宽测试
//        resizeImageTest();
        //将图片附加到底图的正中央测试
//        mergeBothImageCenterTest();
        //图片灰化操作测试
//        grayImageTest();
        //在源图片上设置水印文字测试
//        word2ImageTest();
        //在源图像上设置图片水印测试
//        alphaImage2ImageTest();

    }

    /**
     * 将指定颜色变透明测试
     */
    private static void createImageByMaskColorExTest() {
        String imagePath = "src/main/resources/images/1.jpeg";
        try {
            File file = new File(imagePath);
            BufferedImage imageRead = ImageIO.read(file);
            BufferedImage imageOut = ImageIOUtil.createImageByMaskColorEx(imageRead, Color.RED);
            ImageIO.write(imageOut, "jpeg", new FileOutputStream("src/main/resources/images/2.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按倍率缩小图片测试
     */
    private static void reduceImageByRatioTest() {
        String imageSrc = "D:/x/1.jpg";
        String imageDest = "D:/x/3.jpg";
        int widthRatio = 8;
        int heightRatio = 8;
        ImageIOUtil.reduceImageByRatio(imageSrc, imageDest, widthRatio, heightRatio);

    }

    /**
     * 按比例放大图片测试
     */
    private static void enlargementImageByRatioTest() {
        String imageSrc = "D:/x/3.jpg";
        String imageDest = "D:/x/4.jpg";
        int widthRatio = 8;
        int heightRatio = 8;
        ImageIOUtil.enlargementImageByRatio(imageSrc, imageDest, widthRatio, heightRatio);

    }

    /**
     * 指定图形的长和宽测试
     */
    private static void resizeImageTest() {
        String imageSrc = "D:/x/1.jpg";
        String imageDest = "D:/x/5.jpg";
        int widthRatio = 50;
        int heightRatio = 50;
        ImageIOUtil.resizeImage(imageSrc, imageDest, widthRatio, heightRatio);

    }

    /**
     * 将图片附加到底图的正中央测试
     */
    private static void mergeBothImageCenterTest() {
        String negativeImagePath = "D:/x/1.jpg";
        String additionImagePath = "D:/x/a.jpg";
        String imagePathDest = "D:/x/6.jpg";
        ImageIOUtil.mergeBothImageCenter(negativeImagePath, additionImagePath, imagePathDest);
    }

    /**
     * 图片灰化操作测试
     */
    private static void grayImageTest() {
        String srcImage = "D:/x/1.jpg";
        String toPath = "D:/x/7.jpg";
        ImageIOUtil.grayImage(srcImage, toPath);
    }

    /**
     * 在源图片上设置水印文字测试
     */
    private static void word2ImageTest() {
        String srcImagePath = "D:/x/a.jpg";
        float alpha = 1;
        double rotate = 0;
        String font = "宋体";
        int fontStyle = Font.PLAIN;
        int fontSize = 50;
        Color color = Color.RED;
        String r1 = "时间：2021年05月31日 14时43分14秒 \t";
        String r2 = "事件：图片处理测试 \t";
        String r3 = "作者：小叶子（LEAVES） \t";
        List<String> inputWords = new ArrayList<>();
        inputWords.add(r3);
        inputWords.add(r2);
        inputWords.add(r1);
        int x = 0;
        int y = 50;
        String imageFormat = "jpg";
        String toPath = "D:/x/8.jpg";
        ImageIOUtil.word2Image(srcImagePath, alpha, rotate, font, fontStyle, fontSize, color, inputWords, x, y, imageFormat, toPath);
    }

    /**
     * 在源图像上设置图片水印测试
     */
    private static void alphaImage2ImageTest() {
        String srcImagePath = "D:/x/a.jpg";
        String appendImagePath = "D:/x/b.jpg";
        float alpha = 1F;
        int x = 0;
        int y = 50;
        int width = 500;
        int height = 500;
        String imageFormat = "jpg";
        String toPath = "D:/x/9.jpg";
        try {
            ImageIOUtil.alphaImage2Image(srcImagePath, appendImagePath, alpha, x, y, width, height, imageFormat, toPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
