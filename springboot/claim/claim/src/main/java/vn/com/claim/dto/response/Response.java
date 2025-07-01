package vn.com.claim.dto.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response <T>{

    private Integer code;
    private String message;
    private T data;

    public Response<T> success(String message,T data){
        Response<T> response = new Response<>();
        response.setCode(HttpStatus.OK.value());
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
