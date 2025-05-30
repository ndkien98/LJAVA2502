package vn.com.t3h.utils;

public class CaculatorUtils {

    public static Long getOffset(Long pageIndex,Long pageSize){
        return (pageIndex-1)*pageSize;
    }

    public static Long getTotalPage(Long totalElements,Long pageIndex,Long pageSize){
        Long totalPage= totalElements/pageSize;
        if (totalElements % pageSize > 0){
            totalPage++;
        }
        return totalPage;
    }
}
