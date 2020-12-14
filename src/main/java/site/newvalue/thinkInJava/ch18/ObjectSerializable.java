package site.newvalue.thinkInJava.ch18;

import java.io.*;

class User implements Serializable{
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class ObjectSerializable  {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User u1=new User(1,"123"),u2=new User(2,"456");
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("c.txt"));
//        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(new File(Thread.currentThread().getContextClassLoader().getResource("user.txt").getPath())));
        out.writeObject(u1);
        out.writeObject(u2);
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("c.txt"));
        User u3=(User)in.readObject();
        System.out.println(u3);

    }
}
