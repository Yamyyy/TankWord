import client.Client;

import java.io.IOException;

public class Main {

    /**
     *
     *@Description:主函数、程序入口
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.launchFrame();
    }
}
