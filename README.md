# Java_ConcurrentPractice

并发练习系列
- [x] 生产者消费者
- [ ] 使用await, signal,signalAll实现生产者消费者
- [ ] 多线程打印字符数组
- [ ] 两个线程交替打印奇偶数
- [ ] 设计一段死锁代码
- [x] 线程池

pratice>juc>Future

**myFuture**:自己实现的Future模式，核心是加一个FutureData类，把设置数据和获取数据方法用synchronize修饰，目的是可以直接返回FutureData，但是RealData的结果阻塞获取。

**JDKFuture**:JDK实现的Future模式，使用juc包内的FutureTask代替我们自己写的FutureData。给FutureTask传入一个继承callable接口的线程类实例（这句话怎么这么拗口呢...）换句话说，就是传入**所要异步调用的任务。**新建线程池用于提交执行FutureTask，就可以在未来某个时间段获取的到返回值。

核心思想是**异步调用**。去除了主函数的等待时间，并使得原本需要等待的时间段可以用于处理其他业务逻辑。用我的话解释就是，一个函数的调用必须花那么多时候，但你可以选择傻等或者机智的先去做其他事情。**Future模式即相当于你拿到一个调用函数的凭证，在未来的某个时候，你可以去取得函数的结果**


其他
- [x] LRU [博文地址](http://wangxuanni.top/2019/07/25/LRU/)
