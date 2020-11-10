package site.newvalue.jvm3th;

import java.util.ArrayList;
import java.util.List;

public class P90HeapOOM {
    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<>();
        while (true){
            list.add(new OOMObject());

        }
    }
}
