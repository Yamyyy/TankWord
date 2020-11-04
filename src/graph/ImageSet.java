package graph;

import base.BaseObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageSet {

    public static BufferedImage PlayerImageU,PlayerImageR,PlayerImageL,PlayerImageD;
    public static BufferedImage BulletU,BulletL,BulletR,BulletD;
    public static BufferedImage Water,Steel,Wall,Basement;

    static {
        try{
            PlayerImageU = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/player.png"));
            PlayerImageL = rotateImage(PlayerImageU,-90);
            PlayerImageD = rotateImage(PlayerImageU,180);
            PlayerImageR = rotateImage(PlayerImageU,90);

            BulletU = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/bullet.png"));
            BulletL = rotateImage(BulletU,-90);
            BulletD = rotateImage(BulletU,180);
            BulletR = rotateImage(BulletU,90);

            Wall = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/wall.gif"));
            Water = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/water.gif"));
            Steel = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/steel.gif"));
            Basement = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/basement.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage rotateImage(final BufferedImage bufferedimage, final int degree)
    {
        int w= bufferedimage.getWidth(); // 得到图片宽度。
        int h= bufferedimage.getHeight();// 得到图片高度。
        int type= bufferedimage.getColorModel().getTransparency();// 得到图片透明度。
        BufferedImage img;// 空的图片。
        Graphics2D graphics2d;// 空的画笔。
        (graphics2d= (img= new BufferedImage(w, h, type)).createGraphics()).setRenderingHint( RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(degree), w/2, h/2);// 旋转，degree是整型，度数，比如垂直90度。   •rotate(double arc,double x, double y)：图形以点(x,y)为轴点，旋转arc弧度。
        graphics2d.drawImage(bufferedimage, 0, 0, null);// 从bufferedimagecopy图片至img，0,0是img的坐标。
        graphics2d.dispose();

        return img;// 返回复制好的图片，原图片依然没有变，没有旋转，下次还可以使用。
    }


}
