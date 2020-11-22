import res.ImageSet;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;


public class TestImage {

    @Test
    public void testLoadImage() throws IOException {


            BufferedImage image = ImageSet.Player1ImageU;
        BufferedImage imageU = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/format/player1.png"));
            assertNotNull(image);

    }

    @Test
    public void testRotateImage(){

        try {
            BufferedImage[] explodes = new BufferedImage[8];
            for (int i=0;i<8;i++){
                explodes[i] = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/blast"+i+".gif"));
                assertNotNull(explodes[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

    /** * 旋转图片为指定角度  图片宽高不变*
     * @param bufferedimage * 目标图像 *
     * @param degree * 旋转角度 *
     * @return */
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

    @Test
    public void testWall() throws IOException {
       BufferedImage Wall = ImageIO.read(ImageSet.class.getClassLoader().getResourceAsStream("resource/image/format/wall.gif"));
       assertNotNull(Wall);
    }

}
