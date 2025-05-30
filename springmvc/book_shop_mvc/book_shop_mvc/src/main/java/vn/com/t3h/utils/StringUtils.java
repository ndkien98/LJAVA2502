package vn.com.t3h.utils;

public class StringUtils {

    public static String formatQueryStr(String str){
        if (org.springframework.util.StringUtils.isEmpty(str)){
            return str;
        }
        return "%" + str + "%";
    }
}
