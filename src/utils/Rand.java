package utils;

import base.Dir;

import java.util.Random;

public class Rand {

    public static Dir randDir(){
        int e  = new Random().nextInt(4);
        switch (e){
            case 0:return Dir.U;
            case 1:return Dir.D;
            case 2:return Dir.L;
            case 3:return Dir.R;
        }
        return Dir.D;
    }

    public static boolean randFire(){

        int e = new Random().nextInt(10);
        if (e<2){
            return true;
        }
        else return false;
    }
}
