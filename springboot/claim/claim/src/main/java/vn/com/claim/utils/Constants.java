package vn.com.claim.utils;

public class Constants {

    public static String PREFIX_CODE_CLAIM="CLM";

    public static String VALUE_CODE_CLAIM="xxxx";

    public static String PREFIX_CODE_USER="USR";
    public static String VALUE_CODE_USER="xxxxx";

    private static String VALUE_REPLACE = "x";

    public enum ROLE {
        ADMIN,USER
    }
    public enum STATUS_CODE {
        NEW,APPROVED,REJECTED
    }

    public static String createCode(Long totalData,String prefixCode, String valueCode) {
        String total = String.valueOf(totalData + 1);
        String preValue = valueCode.substring(total.length());
        String finalValue = preValue.replaceAll(VALUE_REPLACE,"0") + total;
        return prefixCode + finalValue;
    }
}
