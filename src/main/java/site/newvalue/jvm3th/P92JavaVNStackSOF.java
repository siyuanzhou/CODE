package site.newvalue.jvm3th;

public class P92JavaVNStackSOF {
    private int stackLength=1;
    public void stackLeak(){
        stackLength++;
        stackLeak();

    }

    public static void main(String[] args) {
        P92JavaVNStackSOF oom=new P92JavaVNStackSOF();
        try {
            oom.stackLeak();

        }
        catch (Throwable e){
            System.out.println("stackLength:"+oom.stackLength);
            throw e;
        }
    }
}
