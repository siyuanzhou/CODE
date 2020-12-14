package site.newvalue.thinkInJava.ch20;

import java.util.List;

public class PasswordUtils {
    @UseCase(id=47,description = "length of password must bigger than 1")
    public boolean validatePassword(String pass){
        return pass.trim().length()>1;
    }
    @UseCase(id=48)
    public String encryptPassword(String pass){
        return new StringBuilder(pass).reverse().toString();
    }
    @UseCase(id=49,description = "can not use old password")
    public boolean checkPassword(List<String> list, String pass){
        return !list.contains(pass);
    }

}
