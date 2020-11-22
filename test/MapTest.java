import base.BaseObject;
import obstacle.Wall;
import org.junit.Test;
import res.MapSet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MapTest {


    // 地图数据文件路径
    public final static String DATA_PATH = "map/data/";
    // 地图预览图路径
    public final static String IMAGE_PATH = "map/image/";
    // 地图数据文件后缀
    public final static String DATA_SUFFIX = ".map";
    // 地图预览图后缀
    public final static String IMAGE_SUFFIX = ".png";
    /**
     * 获取指定名称地图的所有墙块集合
     *
     * @param
     * @return
     */

    // 地图数据文件路径
    public final static String MAP_PATH = "resource/map/";
    // 地图数据文件后缀
    public final static String MAP_SUFFIX = ".map";


    /**
     * 获取指定名称地图的所有墙块集合
     *
     * @param
     * @return
     */
    @Test
    public void readMap2() {
        // 创建对应名称的地图文件
        File file = new File(MapTest.class.getClassLoader().getResource("resource/map/1.map").getPath());
//        System.out.println(file.getName());
//        File file = new File(DATA_PATH + mapName + DATA_SUFFIX);
        List<BaseObject> baseObjects = readMap(file);// 调用重载方法
        for (BaseObject e : baseObjects) System.out.println(e.getX()+e.getY());
    }

    public static List<BaseObject> readMap(File file) {
        Properties pro = new Properties();// 创建属性集对象
        List<BaseObject> baseObjectList = new ArrayList<>();// 创建总墙块集合
        try {
            pro.load(new FileInputStream(file));// 属性集对象读取地图文件
            String wallsStr = (String) pro.get("wall");// 读取地图文件中砖墙名称属性的字符串数据
            String grassStr = (String) pro.get("glass");// 读取地图文件中草地名称属性的字符串数据
            String riverStr = (String) pro.get("river");// 读取地图文件中河流名称属性的字符串数据
            String ironStr = (String) pro.get("iron");// 读取地图文件中铁墙名称属性的字符串数据
            if (wallsStr  != null) {// 如果读取的砖墙数据不是null
                baseObjectList.addAll(readWall(wallsStr, "wall"));// 解析数据，并将数据中解析出的墙块集合添加到总墙块集合中
            }
            if (grassStr != null) {// 如果读取的草地数据不是null
                baseObjectList.addAll(readWall(grassStr, "grass"));// 解析数据，并将数据中解析出的墙块集合添加到总墙块集合中
            }
            if (riverStr != null) {// 如果读取的河流数据不是null
                baseObjectList.addAll(readWall(riverStr, "river"));// 解析数据，并将数据中解析出的墙块集合添加到总墙块集合中
            }
            if (ironStr != null) {// 如果读取的铁墙数据不是null
                baseObjectList.addAll(readWall(ironStr, "iron"));// 解析数据，并将数据中解析出的墙块集合添加到总墙块集合中
            }
            return baseObjectList;// 返回总墙块集合
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析墙块数据
     *
     * @param data
     *              墙块坐标数据字符串
     * @param type
     *              墙块类型
     * @return 墙块集合
     */
    private static List<BaseObject> readWall(String data, String type) {
        String baseobject[] = data.split(";");// 使用“;”分割字符串
        BaseObject baseObject;// 创建墙块对象
        List<BaseObject> baseObjects = new ArrayList<>();// 创建墙块集合
        switch (type) {// 判断墙块类型
            case "wall":// 如果是砖墙
                for (String pice : baseobject) {// 遍历分割结果
                    String axes[] = pice.split(",");// 使用“,”分割字符串
                    // 创建墙块对象，分割的第一个值为横坐标，分割的第二个值为纵坐标
                    BaseObject obj = new Wall(Integer.parseInt(axes[0]), Integer.parseInt(axes[1]));// 在此坐标上创建砖墙对象
                    baseObjects.add(obj);// 集合中添加此墙块
                }
                break;
//            case RIVER:// 如果是河流
////                for (String wStr : walls) {// 遍历分割结果
////                    String axes[] = wStr.split(",");// 使用“,”分割字符串
////                    // 创建墙块对象，分割的第一个值为横坐标，分割的第二个值为纵坐标
////                    wall = new RiverWall(Integer.parseInt(axes[0]), Integer.parseInt(axes[1]));// 在此坐标上创建河流对象
////                    w.add(wall);// 集合中添加此墙块
////                }
////                break;
////            case GRASS:// 如果是草地
////                for (String wStr : walls) {// 遍历分割结果
////                    String axes[] = wStr.split(",");// 使用“,”分割字符串
////                    // 创建墙块对象，分割的第一个值为横坐标，分割的第二个值为纵坐标
////                    wall = new GrassWall(Integer.parseInt(axes[0]), Integer.parseInt(axes[1]));// 在此坐标上创建草地对象
////                    w.add(wall);// 集合中添加此墙块
////                }
////                break;
            case "iron":// 如果是铁墙
                for (String pice : baseobject) {// 遍历分割结果
                    String axes[] = pice.split(",");// 使用“,”分割字符串
                    // 创建墙块对象，分割的第一个值为横坐标，分割的第二个值为纵坐标
                    BaseObject obj = new Wall(Integer.parseInt(axes[0]), Integer.parseInt(axes[1]));// 在此坐标上创建砖墙对象
                    baseObjects.add(obj);// 集合中添加此墙块
                }
                break;
            default:
                break;
        }
        return baseObjects;// 返回墙块集合
    }
}
