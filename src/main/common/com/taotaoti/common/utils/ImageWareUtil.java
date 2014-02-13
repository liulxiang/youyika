package com.taotaoti.common.utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.taotaoti.common.commons.GlobalConstant;
/**
 * 图片水印
 */
public class ImageWareUtil {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String srcImgPath = "c:/images/bg.jpg";
        String iconPath = "C:/images/taotaoti.png";
        String targerPath = "C:/images/45.jpg";
        // 给图片添加水印
      //  ImageWareUtil.waterMarkImageByIcon(iconPath, srcImgPath, targerPath, 0, 100,100, 1f);
        //ImageWareUtil.waterMarkByText(GlobalConstant.WEBLOGO, srcImgPath, targerPath, 0, 100,100, 1f);
        ImageWareUtil.waterMarkByText2(GlobalConstant.WEBLOGO, srcImgPath, targerPath, 0, 100,100, 1f);
    }
    /**
     * 给图片添加水印、可设置水印图片旋转角度
     * 
     * @param iconPath
     *            水印图片路径
     * @param srcImgPath
     *            源图片路径
     * @param targerPath
     *            目标图片路径
     * @param degree
     *            水印图片旋转角度
     * @param width
     *            宽度(与左相比)
     * @param height
     *            高度(与顶相比)
     * @param clarity
     *            透明度(小于1的数)越接近0越透明
     */
    public static void waterMarkImageByIcon(String iconPath, String srcImgPath,
            String targerPath, Integer degree, Integer width, Integer height,
            float clarity) {
        OutputStream os = null;
        try {
            Image srcImg = ImageIO.read(new File(srcImgPath));
            System.out.println("width:" + srcImg.getWidth(null));
            System.out.println("height:" + srcImg.getHeight(null));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
                    srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
            // 得到画笔对象
            // Graphics g= buffImg.getGraphics();
            Graphics2D g = buffImg.createGraphics();
            // 设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(
                    srcImg.getScaledInstance(srcImg.getWidth(null),
                            srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
                    null);
            if (null != degree) {
                // 设置水印旋转
                g.rotate(Math.toRadians(degree),
                        (double) buffImg.getWidth() / 2,
                        (double) buffImg.getHeight() / 2);
            }
            // 水印图象的路径 水印一般为gif或者png的，这样可设置透明度
            ImageIcon imgIcon = new ImageIcon(iconPath);
            // 得到Image对象。
            Image img = imgIcon.getImage();
            float alpha = clarity; // 透明度
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));
            // 表示水印图片的位置
            //System.out.println("width:" + srcImg.getWidth(null));
            //System.out.println("height:" + srcImg.getHeight(null));
            //g.drawImage(img, width, height, null);
            g.drawImage(img, srcImg.getWidth(null)-img.getWidth(null), srcImg.getHeight(null)-img.getHeight(null), null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            g.dispose();
            os = new FileOutputStream(targerPath);
            // 生成图片
            ImageIO.write(buffImg, "JPG", os);
            System.out.println("添加水印图片完成!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 给图片添加水印、可设置水印图片旋转角度
     * 
     * @param logoText
     *            水印文字
     * @param srcImgPath
     *            源图片路径
     * @param targerPath
     *            目标图片路径
     * @param degree
     *            水印图片旋转角度
     * @param width
     *            宽度(与左相比)
     * @param height
     *            高度(与顶相比)
     * @param clarity
     *            透明度(小于1的数)越接近0越透明
     */
    public static void waterMarkByText(String logoText, String srcImgPath,
            String targerPath, Integer degree, Integer width, Integer height,
            Float clarity) {
        // 主图片的路径
        InputStream is = null;
        OutputStream os = null;
        try {
            Image srcImg = ImageIO.read(new File(srcImgPath));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
                    srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
            // 得到画笔对象
            // Graphics g= buffImg.getGraphics();
            Graphics2D g = buffImg.createGraphics();
            // 设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(
                    srcImg.getScaledInstance(srcImg.getWidth(null),
                            srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
                    null);
            if (null != degree) {
                // 设置水印旋转
                g.rotate(Math.toRadians(degree),
                        (double) buffImg.getWidth() / 2,
                        (double) buffImg.getHeight() / 2);
            }
            // 设置颜色
            g.setColor(Color.red);
            // 设置 Font
            g.setFont(new Font("宋体", Font.BOLD, 30));
            float alpha = clarity;
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));
            // 第一参数->设置的内容，后面两个参数->文字在图片上的坐标位置(x,y) .
            g.drawString(logoText, width, height);
            
            g.dispose();
            os = new FileOutputStream(targerPath);
            // 生成图片
            ImageIO.write(buffImg, "JPG", os);
            System.out.println("添加水印文字完成!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is)
                    is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean waterMarkByText2(String logoText, String srcImgPath,
    		String targerPath, Integer degree, Integer width, Integer height,
    		Float clarity) {
    	// 主图片的路径
    	try {
    		BufferedImage originalImage = ImageIO.read(new File(srcImgPath));
    		int originalWidth = originalImage.getWidth(null);
    		int originalHeight = originalImage.getHeight(null);
    		if (originalWidth < 50 || originalHeight < 50){
    			return false;
    		}
    		if(logoText==null || logoText.trim().equals("")){
    			return false;
    		}
    		BufferedImage newImage = new BufferedImage(originalWidth, originalHeight, BufferedImage.TYPE_INT_RGB);
    		Graphics2D g = newImage.createGraphics();
    		g.drawImage(originalImage, 0, 0, originalWidth, originalHeight, null);
    		g.setColor(Color.RED);
    		int fontSize = 30;
    		g.setFont(new Font("宋体", Font.PLAIN, fontSize));
    		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
    		int len = GlobalConstant.WEBLOGO.length();
    		if(GlobalConstant.IS_WATER_CENTER==0){
    			g.drawString(GlobalConstant.WEBLOGO, originalWidth-len*fontSize/2-6,originalHeight-6);
    		}else{
    			g.drawString(GlobalConstant.WEBLOGO, (originalWidth-(len*fontSize))/2, (originalHeight-fontSize)/2);
    		}
    		g.dispose();
    		 OutputStream os = new FileOutputStream(targerPath);
    		// 生成图片
    		ImageIO.write(newImage, "png", os);
    		System.out.println("添加水印文字完成!");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
		return false; 
    }
}
