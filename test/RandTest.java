import org.junit.Test;

import java.util.Random;

public class RandTest {


    @Test
    public void rand(){
        for (int i=0;i<1000;i++)
        System.out.println(new Random().nextInt(4));
    }
}
