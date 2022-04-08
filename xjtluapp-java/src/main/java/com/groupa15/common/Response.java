package com.groupa15.common;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

@Data
@Accessors(chain = true)
public class Response implements Serializable {

    private int code;
    private String msg;
    private Object data;

    public static Response success(HttpStatus code, String msg, Object data) {
        return response(code, msg, data);
    }

    public static Response success(HttpStatus code, String msg) {
        return response(code, msg, null);
    }

    public static Response fail(HttpStatus code, String msg, Object data) {
        return response(code, msg, data);
    }

    public static Response fail(HttpStatus code, String msg) {
        return response(code, msg, null);
    }

    public static Response response(HttpStatus code, String msg, Object data) {
        return new Response()
                .setCode(code.value())
                .setMsg(msg)
                .setData(data);
    }

}
