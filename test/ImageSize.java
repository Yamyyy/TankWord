import graph.ImageSet;
import org.junit.Test;

public class ImageSize {


    @Test
    public void getInfo(){

        System.out.println(ImageSet.Steel.getWidth());
        System.out.println(ImageSet.Steel.getHeight());

        System.out.println(ImageSet.Water.getWidth());
        System.out.println(ImageSet.Water.getHeight());

        System.out.println(ImageSet.BulletU.getWidth());
        System.out.println(ImageSet.BulletU.getHeight());

        System.out.println(ImageSet.PlayerImageU.getWidth());
        System.out.println(ImageSet.PlayerImageU.getHeight());
    }
}
