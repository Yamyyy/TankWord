package util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 音效工具类
 *
 *  @author L
 */

@SuppressWarnings("deprecation")
public class AudioSet{
    /**
     * 坦克诞生音效
     */
    public static final String ADD=AudioSet.class.getClassLoader().getResource("resource/bgm/add.wav").getPath();
    /**
     * 爆炸音效
     */
    public static final String BLAST=AudioSet.class.getClassLoader().getResource("resource/bgm/blast.wav").getPath();
    /**
     * 发射子弹音效
     */
    public static final String FIRE=AudioSet.class.getClassLoader().getResource("resource/bgm/fire.wav").getPath();
    /**
     * 游戏结束音效
     */
//    public static final String GAMEOVER="audio/gameover.wav";
    /**
     * 子弹撞击音效
     */
    public static final String HIT="audio/hit.wav";
    /**
     * 游戏开始音效
     */
    public static final String START=AudioSet.class.getClassLoader().getResource("resource/bgm/hit.wav").getPath();

        //audios.add(Applet.newAudioClip(AudioUtil.class.getResource(AudioUtil.BGM)));

}