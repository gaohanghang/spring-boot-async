# Spring boot 实现高吞吐量异步处理

> 原文地址: [Spring boot 实现高吞吐量异步处理（适用于高并发场景）](https://www.cnblogs.com/jonban/p/async.html)
> 参考文章: [理解Callable 和 Spring DeferredResult（翻译）](https://www.cnblogs.com/aheizi/p/5659030.html)

> 大致思路是释放容器线程，使用队列异步的在后台处理任务，使controller不会阻塞，从而提高服务端吞吐量

## 运行效果

请求url: http://localhost:8080/order?number=10001

正常情况处理3秒返回，返回结果如下

![](https://raw.githubusercontent.com/gaohanghang/images/master/img/20191010173855.png)

观察控制台打印日志，如下所示：

```
[ OrderController ] 接到下单请求
当前待处理订单数： 0
[ OrderController ] 返回下单结果
[ OrderTask ]开始处理订单
[ OrderTask ]订单处理完成
```

## 结论

结论：Controller层几乎在接收到请求的同时就已经返回，处理程序在后台异步处理任务。

快速多次刷新浏览器，目的为了高并发测试，观察控制台打印信息

现象：Controller层快速返回，待处理请求在队列中开始增加，异步处理程序在按顺序处理请求。

优点：对客户端响应时间不变，但提高了服务端的吞吐量。大大提升高并发处理性能！


