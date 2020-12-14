package site.newvalue.jvm3th;

public class P106ReferenceCountingGC {
    public  Object instance=null;
    private byte[] bigSize=new byte[1024*1024*2];
    public static void testGC(){
        P106ReferenceCountingGC O1=new P106ReferenceCountingGC();
        P106ReferenceCountingGC O2=new P106ReferenceCountingGC();
        O1.instance=O2;
        O2.instance=O1;
        O1=null;
        O2=null;
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
