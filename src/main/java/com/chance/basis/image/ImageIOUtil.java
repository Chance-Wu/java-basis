package com.chance.basis.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author: chance
 * @date: 2022/4/26 09:00
 * @since: 1.0
 */
public class ImageIOUtil {


    /**
     * 将指定颜色变透明 只能保存 png jpg
     *
     * @param imageSrc 源图片
     * @param mask     颜色
     * @return
     */
    public static BufferedImage createImageByMaskColorEx(BufferedImage imageSrc, Color mask) {
        int x, y;
        x = imageSrc.getWidth(null);
        y = imageSrc.getHeight(null);
        BufferedImage imageDes = new BufferedImage(x, y,
                BufferedImage.TYPE_4BYTE_ABGR);
        WritableRaster rasterDes = imageDes.getRaster();
        int[] des = new int[4];
        while (--x >= 0) {
            for (int j = 0; j < y; ++j) {
                int rgb = imageSrc.getRGB(x, j);
                int sr, sg, sb;
                sr = (rgb & 0xFF0000) >> 16;
                sg = (rgb & 0xFF00) >> 8;
                sb = rgb & 0xFF;
                if (sr == mask.getRed() && sg == mask.getGreen()
                        && sb == mask.getBlue()) {
                    des[3] = 0;
                } else {
                    des[0] = sr;
                    des[1] = sg;
                    des[2] = sb;
                    des[3] = 255;
                }
                rasterDes.setPixel(x, j, des);
            }
        }
        return imageDes;
    }

    /**
     * 按倍率缩小图片
     *
     * @param imageSrc    读取图片路径
     * @param imageDest   写入图片路径
     * @param widthRatio  宽度缩小比例
     * @param heightRatio 高度缩小比例
     */
    public static void reduceImageByRatio(String imageSrc, String imageDest, int widthRatio, int heightRatio) {
        FileOutputStream outputStream = null;
        try {
            File file = new File(imageSrc);
            BufferedImage read = ImageIO.read(file);
            int width = read.getWidth();
            int height = read.getHeight();
            /**
             * 根据缩放比较 构建新的BufferImage 对象
             */
            BufferedImage destBufferImage = new BufferedImage(width / widthRatio, height / heightRatio, BufferedImage.TYPE_INT_RGB);
            /**
             * 绘制 缩小  后的图片
             */
            destBufferImage.getGraphics().drawImage(read, 0, 0, width / widthRatio, height / heightRatio, null);
            outputStream = new FileOutputStream(imageDest);
            ImageIO.write(destBufferImage, "jpg", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按比例放大图片
     *
     * @param imageSrc    读取图片路径
     * @param imageDest   写入图片路径
     * @param widthRatio  宽度放大比例
     * @param heigthRatio 高度放大比例
     */
    public static void enlargementImageByRatio(String imageSrc, String imageDest, int widthRatio, int heigthRatio) {
        FileOutputStream outputStream = null;
        try {
            //读取图片构建 BufferImage对象
            BufferedImage read = ImageIO.read(new File(imageSrc));
            int width = read.getWidth();
            int height = read.getHeight();
            //构建BufferImage对象
            BufferedImage newBufferImage = new BufferedImage(width * widthRatio, height * heigthRatio, BufferedImage.TYPE_INT_RGB);
            //绘制放大后的图片
            newBufferImage.getGraphics().drawImage(read, 0, 0, width * widthRatio, height * heigthRatio, null);
            //写入文件
            outputStream = new FileOutputStream(imageDest);
            ImageIO.write(newBufferImage, "jpg", outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 指定图形的长和宽
     *
     * @param imageSrc  读取图片路径
     * @param imageDest 写入图片路径
     * @param width     长
     * @param height    宽
     * @throws IOException
     */
    public static void resizeImage(String imageSrc, String imageDest, int width, int height) {
        FileOutputStream outputStream = null;
        try {
            //读入文件
            File file = new File(imageSrc);
            // 构造Image对象
            BufferedImage src = javax.imageio.ImageIO.read(file);
            // 放大边长
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //绘制放大后的图片
            tag.getGraphics().drawImage(src, 0, 0, width, height, null);
            outputStream = new FileOutputStream(imageDest);
            outputStream = new FileOutputStream(imageDest);
            ImageIO.write(tag, "jpg", outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将图片附加到底图的正中央
     *
     * @param negativeImagePath 底图路径
     * @param additionImagePath 附加图路径
     * @param imagePathDest     保存路径
     */
    public static void mergeBothImageCenter(String negativeImagePath, String additionImagePath, String imagePathDest) {
        FileOutputStream outputStream = null;
        try {
            BufferedImage negativeBufferImge = ImageIO.read(new File(negativeImagePath));
            BufferedImage additionBufferImage = ImageIO.read(new File(additionImagePath));
            /**
             *additionImagePath 绘制在 negativeImagePath 上的 中央区域
             */
            negativeBufferImge.getGraphics().drawImage(additionBufferImage, (negativeBufferImge.getWidth() - additionBufferImage.getWidth()) / 2, (negativeBufferImge.getHeight() - additionBufferImage.getHeight()) / 2, null);
            outputStream = new FileOutputStream(imagePathDest);
            /**
             * 输出到文件
             */
            ImageIO.write(negativeBufferImge, "jpg", outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 图片灰化操作
     *
     * @param srcImage 读取图片路径
     * @param toPath   写入灰化后的图片路径
     */
    public static void grayImage(String srcImage, String toPath) {
        try {
            BufferedImage src = ImageIO.read(new File(srcImage));
            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
            ColorConvertOp op = new ColorConvertOp(cs, null);
            src = op.filter(src, null);
            ImageIO.write(src, "jpg", new File(toPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 在源图片上设置水印文字
     * <p>
     * (AlphaComposite  设置透明度)
     * Graphics2D (绘制图片)
     * 当alpha==1时文字不透明（和在图片上直接输入文字效果一样）
     * </p>
     *
     * @param srcImagePath 原图片路径
     * @param alpha        透明度（0<alpha<1）
     * @param rotate       旋转的角度，以弧度为单位
     * @param font         字体（例如：宋体）
     * @param fontStyle    字体格式(例如：普通样式--Font.PLAIN、粗体--Font.BOLD )
     * @param fontSize:    字体大小
     * @param color        字体颜色(例如：黑色--Color.BLACK)
     * @param inputWords   输入显示在图片上的文字数组
     * @param x            文字显示起始的x坐标（最左上角的值大约0左右）
     * @param y            文字显示起始的y坐标（为了能完全看清，最左上角的值为大约50左右）
     * @param imageFormat  写入图片的类型
     * @param toPath       写入图片路径
     */
    public static void word2Image(String srcImagePath, float alpha, double rotate, String font, int fontStyle, int fontSize, Color color,
                                  List<String> inputWords, int x, int y, String imageFormat, String toPath) {
        FileOutputStream outputStream = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(srcImagePath));
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            /**
             * 得到绘图对象 Graphics
             */
            Graphics2D graphics = bufferedImage.createGraphics();
            /**
             * 原图像填充
             */
            graphics.drawImage(bufferedImage, 0, 0, width, height, null, null);
            /**
             * 获取透明度对象AlphaComposite
             * static int  SRC
             将源色复制到目标色（Porter-Duff Source 规则）。
             static int    SRC_ATOP
             目标色中的源色部分将被合成到目标色中（Porter-Duff Source Atop Destination 规则）。
             static int    SRC_IN
             目标色中的源色部分将替换目标色（Porter-Duff Source In Destination 规则）。
             static int    SRC_OUT
             目标色以外的源色部分将替换目标色（Porter-Duff Source Held Out By Destination 规则）。
             static int    SRC_OVER
             在目标色之上合成源色（Porter-Duff Source Over Destination 规则）。
             */
            AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            /**
             * 设置响应属性
             */
            graphics.setComposite(alphaComposite);
            //设置文字字体名称、样式、大小
            graphics.setFont(new Font(font, fontStyle, fontSize));
            graphics.setColor(color);
            //遍历水印文字数组
            for (int i = 0; i < inputWords.size(); i++) {
                //输入水印文字及其起始x、y坐标
                graphics.drawString(inputWords.get(i), x, y);
                y += 60;
            }
            graphics.dispose();
            /**
             * 输出
             */
            ImageIO.write(bufferedImage, imageFormat, new File(toPath));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 在源图像上设置图片水印
     * <p>
     * ---- 当alpha==1时文字不透明（和在图片上直接输入文字效果一样）
     * </p>
     *
     * @param srcImagePath    源图片路径
     * @param appendImagePath 水印图片路径
     * @param alpha           透明度
     * @param x               水印图片的起始x坐标
     * @param y               水印图片的起始y坐标
     * @param width           水印图片的宽度
     * @param height          水印图片的高度
     * @param imageFormat     图像写入图片格式
     * @param toPath          图像写入路径
     * @throws IOException
     */
    public static void alphaImage2Image(String srcImagePath, String appendImagePath, float alpha, int x, int y, int width, int height,
                                        String imageFormat, String toPath) throws IOException {
        FileOutputStream fos = null;
        try {
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            //创建java2D对象
            Graphics2D g2d = image.createGraphics();
            //用源图像填充背景
            g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null, null);
            //设置透明度
            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(ac);
            //设置水印图片的起始x/y坐标、宽度、高度
            BufferedImage appendImage = ImageIO.read(new File(appendImagePath));
            g2d.drawImage(appendImage, x, y, width, height, null, null);
            g2d.dispose();
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }
}
