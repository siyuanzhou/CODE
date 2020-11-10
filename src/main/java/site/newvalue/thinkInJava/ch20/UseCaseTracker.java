package site.newvalue.thinkInJava.ch20;

import java.lang.reflect.Method;

//利用反射获取注解相关信息
public class UseCaseTracker {
    public static void trackUseCases(Class<?> cl){
        for(Method m:cl.getDeclaredMethods()){
            UseCase uc=m.getAnnotation(UseCase.class);
            System.out.println(uc.id()+":"+uc.description());
        }
    }

    public static void main(String[] args) {
        trackUseCases(PasswordUtils.class);
    }
}
