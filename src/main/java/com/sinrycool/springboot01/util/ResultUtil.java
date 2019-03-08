package com.sinrycool.springboot01.util;

import com.sinrycool.springboot01.entity.Result;

/**
 * Http请求处理
 *
 * @author ：Sinry
 * @date ：Created in 2019-03-04 17:10
 */
public class ResultUtil {
    public static Result<Object> success (Object object)
    {
        Result<Object> result = new Result<>();
        result.setCode(200);
        result.setMessage("成功");
        result.setData(object);

        return result;
    }

    public static Result<Object> successNoData ()
    {
        return success(null);
    }

    public static Result error (Integer code, String message)
    {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
