package frame;

import frame.LoginPanel;
import frame.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *游戏设置界面
 * @author L
 */
public class GameSettingPanel extends JPanel {
    private MainFrame frame;

    public GameSettingPanel(final MainFrame frame){
        this.frame=frame;

        JButton mute=new JButton("关闭音效");
//        mute.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent arg0) { //关闭音效
//                AudioPlayer.AudioThread.interrupted();
//                frame.requestFocus();
//                gotoLoginPanel();
//            }
//        });
        JButton noMute=new JButton("开启音效");
        noMute.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.requestFocus();
                gotoLoginPanel();
            }

        });
        this.add(mute);
        this.add(noMute);
        JButton easy=new JButton("简单难度");
        easy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.requestFocus();
                gotoLoginPanel();
            }

        });
        JButton difficulty=new JButton("困难难度");
        difficulty.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.requestFocus();
                gotoLoginPanel();
            }

        });
        this.add(easy);
        this.add(difficulty);
    }
    private void gotoLoginPanel() {
        frame.setPanel(new LoginPanel(frame));
    }
}
