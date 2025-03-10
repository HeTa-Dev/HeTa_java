package com.heta.tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class CaptchaUtils {
    // 验证码字符集
    private static final String CHAR_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    // 图片宽度
    private static final int WIDTH = 120;
    // 图片高度
    private static final int HEIGHT = 40;
    // 验证码长度
    private static final int CODE_LENGTH = 4;

    public static String generateCaptcha(OutputStream os) throws IOException {
        // 创建一个空白的图片对象
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        // 获取图片的绘图上下文
        Graphics g = image.getGraphics();
        Random random = new Random();

        // 设置背景颜色
        g.setColor(getRandomColor(200, 250));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // 设置字体
        g.setFont(new Font("Arial", Font.ITALIC, 30));

        // 生成随机验证码
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            String rand = String.valueOf(CHAR_SET.charAt(random.nextInt(CHAR_SET.length())));
            captcha.append(rand);
            g.setColor(getRandomColor(100, 200));
            g.drawString(rand, 25 * i + 10, 30);
        }

        // 绘制干扰线
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(WIDTH);
            int y1 = random.nextInt(HEIGHT);
            int x2 = random.nextInt(WIDTH);
            int y2 = random.nextInt(HEIGHT);
            g.setColor(getRandomColor(100, 200));
            g.drawLine(x1, y1, x2, y2);
        }

        // 释放绘图上下文资源
        g.dispose();
        // 将图片以 JPEG 格式写入输出流
        ImageIO.write(image, "JPEG", os);
        return captcha.toString();
    }

    private static Color getRandomColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) fc = 255;
        if (bc > 255) bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}