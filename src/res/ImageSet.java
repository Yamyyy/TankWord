package res;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageSet {

    public static BufferedImage Player1ImageU,Player1ImageR,Player1ImageL,Player1ImageD;
    public static BufferedImage Player2ImageU,Player2ImageR,Player2ImageL,Player2ImageD;
    public static BufferedImage Enemy1ImageU,Enemy1ImageR,Enemy1ImageL,Enemy1ImageD;
    public static BufferedImage Enemy2ImageU,Enemy2ImageR,Enemy2ImageL,Enemy2ImageD;
    public static BufferedImage Enemy3ImageU,Enemy3ImageR,Enemy3ImageL,Enemy3ImageD;
    public static BufferedImage BulletU,BulletL,BulletR,BulletD;
    public static BufferedImage Iron,Wall,Basement,BasementDestroy,Grass,River;


    public static BufferedImage[] explodes = new BufferedImage[8];
    public static BufferedImage[] borns = new BufferedImage[4];

    static {
        try{
            Player1ImageU = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/format/player1.png"));
            Player1ImageL = rotateImage(Player1ImageU,-90);
            Player1ImageD = rotateImage(Player1ImageU,180);
            Player1ImageR = rotateImage(Player1ImageU,90);

            Player2ImageU = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/format/player2.png"));
            Player2ImageL = rotateImage(Player2ImageU,-90);
            Player2ImageD = rotateImage(Player2ImageU,180);
            Player2ImageR = rotateImage(Player2ImageU,90);

            Enemy1ImageU = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/format/enemy1U.gif"));
            Enemy1ImageL = rotateImage(Enemy1ImageU,-90);
            Enemy1ImageD = rotateImage(Enemy1ImageU,180);
            Enemy1ImageR = rotateImage(Enemy1ImageU,90);


            Enemy2ImageU = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/format/enemy2U.gif"));
            Enemy2ImageL = rotateImage(Enemy2ImageU,-90);
            Enemy2ImageD = rotateImage(Enemy2ImageU,180);
            Enemy2ImageR = rotateImage(Enemy2ImageU,90);


            Enemy3ImageU = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/format/enemy3U.gif"));
            Enemy3ImageL = rotateImage(Enemy3ImageU,-90);
            Enemy3ImageD = rotateImage(Enemy3ImageU,180);
            Enemy3ImageR = rotateImage(Enemy3ImageU,90);


            BulletU = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/format/tankmissile.gif"));
//            BulletU = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/bullet.png"));
            BulletL = rotateImage(BulletU,-90);
            BulletD = rotateImage(BulletU,180);
            BulletR = rotateImage(BulletU,90);

            Wall = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/format/wall.gif"));
            River = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/format/water.gif"));
            Iron = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/format/iron.gif"));
            Basement = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/format/basement.gif"));
            BasementDestroy = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/format/destroy.gif"));

            for (int i=0;i<8;i++){
                explodes[i] = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/format/blast"+i+".gif"));
            }
            for (int i=0;i<3;i++){
                explodes[i] = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/format/born"+i+".gif"));
            }
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
