package client;

import frame.MainFrame;
import frame.TankPanel;

import java.io.IOException;

public class Client {

    private static final int FLASHTIME = 20;

    public void launchFrame() throws IOException, InterruptedException {

        MainFrame mainFrame = new MainFrame();

//        tankFrame.setUndecorated(true);
        mainFrame.setVisible(true);

        for(;;){
            mainFrame.repaint();
            Thread.sleep(FLASHTIME);
        }
    }

}
