package org.hackerandpainter.springbootasync.dataobject.vo;

import lombok.Data;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * 存储异步处理信息
 *
 * @author Logen
 *
 * @param <I> 接口输入参数
 * @param <O> 接口返回参数
 */
@Data
public class AsyncVo<I, O> {

    /**
     * 请求参数
     */
    private I params;

    /**
     * 响应结果
     */
    private DeferredResult<O> result;

}
