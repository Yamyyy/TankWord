import org.junit.Test;



public class Work {

    public abstract  class  Fa1{

        int x;
        Fa1(int x){
            this.x = x;
        }
        public abstract void say();
    }

    public abstract class Fa2 extends  Fa1{
        Fa2(int x) {
            super(x);
        }

//        public void say(){
//            System.out.println("+++"+x);
//        }
    }

    public class Son extends  Fa2{

        Son(int x) {
            super(x);
        }

        public void say(){
            System.out.println("+++"+x);
        }
    }

    @Test
    public void test(){

        Fa2 fa = new Son(1);
        fa.say();

    }


}
