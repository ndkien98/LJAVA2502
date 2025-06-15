package vn.com.claim.dto.response;

import lombok.Data;

@Data
public class Response <T>{

    private Integer code;
    private String message;
    private T data;
}
