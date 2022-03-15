package com.groupa15.common.lang;

import lombok.Data;
import lombok.experimental.Accessors;

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

    public static Response succ(int code, String msg, Object data) {
        return response(code, msg, data);
    }

    public static Response fail(int code, String msg, Object data) {
        return response(code, msg, data);
    }

    public static Response response(int code, String msg, Object data) {
        return new Response()
                .setCode(code)
                .setMsg(msg)
                .setData(data);
    }

}
