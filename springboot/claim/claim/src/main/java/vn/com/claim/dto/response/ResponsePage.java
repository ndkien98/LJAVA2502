package vn.com.claim.dto.response;

import lombok.Data;

@Data
public class ResponsePage<T> extends Response<T> {

    private long totalElement;
    private int totalPage;
    private int pageSize;
    private int pageIndex;

}
