package vn.com.claim.utils;

public class Constants {

    public static String PREFIX_CODE_CLAIM="CLM";

    public static String VALUE_CODE_CLAIM="xxxx";

    private static String VALUE_REPLACE = "x";

    public static String createCodeClaim(Long totalClaim){
        String total = String.valueOf(totalClaim + 1);
        String preValue = VALUE_CODE_CLAIM.substring(total.length());
        String finalValue = preValue.replaceAll(VALUE_REPLACE,"0") + total;
        return PREFIX_CODE_CLAIM + finalValue;
    }
}
