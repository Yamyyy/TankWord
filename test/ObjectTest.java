import base.BaseObject;
import obstacle.Wall;
import org.junit.Test;
import res.ImageSet;

import static org.junit.Assert.assertNotNull;

public class ObjectTest {
    @Test
    public void init(){

        assertNotNull(ImageSet.Wall);

//        BaseObject wall = new Wall(340,40);
//        System.out.println(wall.getX());
    }
}
