package client;

import graph.TankFrame;

import java.io.IOException;

public class Client {


    public void launchFrame() throws IOException {

        TankFrame tankFrame = TankFrame.INSTANCE;
        tankFrame.drawFrame();
        tankFrame.setUndecorated(true);
        tankFrame.setVisible(true);

        for(;;){
            tankFrame.repaint();
        }
    }

}
