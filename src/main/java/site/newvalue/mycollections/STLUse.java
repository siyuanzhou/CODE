package site.newvalue.mycollections;

import java.util.*;

public class STLUse {
    public static void arrayList() {
        System.out.println("================arraylist================");
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        System.out.println(list.contains(new Integer(2)));

        // 遍历
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        // ACID
        list.add(0, 9);
        System.out.println(list.indexOf(3));
        System.out.println(list.lastIndexOf(3));
        list.remove(2);
        list.remove(new Integer(3));
        System.out.println(list.toString());
        list.set(0, 1000);

        // 排序
        Collections.sort(list);
        System.out.println(list.toString());
        Collections.sort(list, new Comparator<Integer>() {
            // o1排在o2后面,返回值大于0 ，来查看升序还是降序
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o2 - o1;
            }
        });
        System.out.println(list.toString());

    }

    public static void linklist() {
        System.out.println("================linklist================");
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        // 遍历
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        // ACID
        list.add(0, 9);
        System.out.println(list.indexOf(3));
        System.out.println(list.lastIndexOf(3));
        list.remove(2);
        list.remove(new Integer(3));
        System.out.println(list.toString());
        list.set(0, 1000);

        // 排序
        Collections.sort(list);
        System.out.println(list.toString());
        Collections.sort(list, new Comparator<Integer>() {

            // o1排在o2后面,返回值大于0 ，来查看升序还是降序
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o2 - o1;
            }
        });
        System.out.println(list.toString());

        list.addFirst(1);
        list.addLast(9);
        list.getFirst();
        list.getLast();
        System.out.println(list.toString());

    }

    public static void queue() {
        System.out.println("================queue================");
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        // q.element();//返回队头
        System.out.println(q.peek());
        // q.remove();//移除并返回队头
        System.out.println(q.poll());
        System.out.println(q.toString());
    }

    private static void stack() {
        System.out.println("================stack================");
        LinkedList<Integer> s = new LinkedList<Integer>();
        for (int i = 0; i < 4; i++) {
            s.push(i);
        }
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.toString());

    }

    // 无序不可重复,非线程安全的
    // 首先，hashCode()方法返回的是一个哈希值，这个哈希值是由对象在内存中的地址所形成的，
    // 如果两个对象的哈希值不一样，那么这两个对象肯定是不相同的，如果哈希值一样，那么这还不能肯定这两个对象是否一样，
    // 还需要通过equlas()方法比较一下两个对象是否一样，equals()返回true才能说明这两个对象是相同的
    private static void hashset() {
        System.out.println("================hashset================");
        Set<String> set = new HashSet<String>();
        set.add("123");
        set.add("456");
        set.add("zsy");
        set.add("123");
        System.out.println(set.size());
        set.remove("zsy");
        set.remove("456");
        System.out.println(set.toString());
    }

    // 非线程安全的，排序规则是默认使用元素的自然排序,重不重复也是通过compareTo()方法来完成的，当compareTo()方法返回值为0时，两个对象是相同的。
    // LinkedHashSet将会以元素的放入顺序来依次访问
    private static void treeset() {
        System.out.println("================treeset================");
        Set<String> set = new TreeSet<String>();
        set.add("123");
        set.add("963");
        set.add("125");
        set.add("456");
        set.add("zsy");
        set.add("123");
        System.out.println(set.size());
        set.remove("zsy");
        set.remove("456");
        System.out.println(set.toString());
    }

    private static void hashmap() {
        System.out.println("================hashmap================");
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("zsy", 93);
        map.put("syz", 86);
        map.put("ysz", 88);

        // 1.通过遍历键的Set集合来遍历整个Map集合
        System.out.println("foreach遍历");
        for (String str : map.keySet()) {
            System.out.println(str + ":" + map.get(str));
        }

        System.out.println("迭代器遍历");
        Iterator<String> intertor = map.keySet().iterator();
        while (intertor.hasNext()) {
            String key = intertor.next();
            System.out.println(key + ":" + map.get(key));
        }

        // 2.使用Map集合的关系遍历
        System.out.println("Map关系遍历");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        map.remove("zsy");
        System.out.println(map.toString());
    }

    private static void treemap() {

        System.out.println("================treemap================");
        Map<String, Integer> map = new TreeMap<String, Integer>();
        map.put("zsy", 93);
        map.put("syz", 86);
        map.put("ysz", 88);

        // 1.通过遍历键的Set集合来遍历整个Map集合
        System.out.println("foreach遍历");
        for (String str : map.keySet()) {
            System.out.println(str + ":" + map.get(str));
        }

        System.out.println("迭代器遍历");
        Iterator<String> intertor = map.keySet().iterator();
        while (intertor.hasNext()) {
            String key = intertor.next();
            System.out.println(key + ":" + map.get(key));
        }

        // 2.使用Map集合的关系遍历
        System.out.println("Map关系遍历");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        map.remove("zsy");
        System.out.println(map.toString());
    }

    public static void main(String[] args) {
        arrayList();
        linklist();
        queue();
        stack();
        hashset();
        treeset();
        hashmap();
        treemap();
    }

}
