package com.qf.reactor;

import java.io.IOException;

/**
 * @author Administrator
 * @version V1.0
 * @Project reactor
 * @Package com.qf.reactor
 * @Description:
 * @Date 2022/7/7 16:22
 */

public class TestFlux1 {
    public static void main(String[] args) throws IOException {
//        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5);
//        flux.subscribe(System.err::print);

//        Flux<String> flux = Flux
//                .just("a", "b", "c", "d", "e")
//                .doOnNext(s -> {
//                    System.err.println("doOnNext方法执行了.");
//                })
//                .doOnComplete(() -> {
//                    System.err.println("doOnComplete执行了.");
//                });
//        flux.subscribe(s -> {
//            System.err.println("收到消息是："+s);
//        });

//        Flux<String> flux = Flux.
//                just("a", "b", "c", "d", "e")
//                .doOnNext(s -> {
//                    System.err.println("doOnNext执行了，发出的数据是：" + s);
//                })
//                .doOnComplete(() -> {
//                    System.err.println("发送执行完毕");
//                });
////        flux.subscribe(System.err::println);
//        flux.subscribe(new Subscriber<String>() {
//            private Subscription subscription;
//            /**
//             * 当我们开始订阅的时候会执行这个函数
//             * @param subscription
//             */
//            @Override
//            public void onSubscribe(Subscription subscription) {
//                this.subscription = subscription;
//                //由这一句话可以看出，是订阅了，但是没有请求数据，所以需要请求数据，才会有反应
////                System.err.println("TestFlux1类中的onSubscribe方法执行了-->");
//                subscription.request(1);
//            }
//
//            /**
//             * 当我们开始订阅之后请求数据的时候会执行这个函数
//             * @param s
//             */
//            @Override
//            public void onNext(String s) {
//                System.err.println("收到的数据是" + s);
//                // 当收到一个数据的时候，需要再次请求,直到运行结束
//                subscription.request(1);
//            }
//
//            /**
//             * 当出现错误的时候执行这个
//             * @param throwable
//             */
//            @Override
//            public void onError(Throwable throwable) {
//                System.err.println("出现错误了");
//            }
//
//            /**
//             * 订阅结束的时候执行这个函数
//             */
//            @Override
//            public void onComplete() {
//                System.err.println("订阅结束了。");
//            }
//        });


//        Flux.create(fluxSink -> {
//            fluxSink.next("张三").next("李四").next("王五").next("赵六");
//        }).subscribe(System.err::println);

        // generate和create的区别是一个是可以有多个，一个只能next一个，但是generate不加结束的时候是一直循环不会结束的
//        Flux.generate(synchronousSink -> {
//            synchronousSink.next("张三");
//            // 通知结束了，否则会一直循环
//            synchronousSink.complete();
//        }).subscribe(System.err::println);
//      虽然只能放一个对象，但是一个list集合也是一个对象啊
        // 里面有多少个对象我不管，反正我list集合就只是一个对象
//        Flux.generate(synchronousSink -> {
//            List list = new ArrayList();
//            for (int i = 0; i < 10; i++) {
//                list.add("这个是第"+i+"个元素");
//            }
//            synchronousSink.next(list);
//            // 通知结束了，否则会一直循环
//            synchronousSink.complete();
//        }).subscribe(System.err::println);

//        Flux<Integer> flux1 = Flux.just(1, 2, 3, 4, 5);
//        Flux<Integer> flux2 = Flux.from(flux1);
//        flux2.subscribe(System.err::println);


//        Flux<String> flux = Flux.fromArray(new String[]{"张三", "李四", "王五", "赵六"});
//        flux.subscribe(System.err::println);

//        Set<String> set = new HashSet<>();
//        for (int i = 0; i < 10; i++) {
//            set.add(UUID.randomUUID().toString());
//        }
//        Flux<String> flux = Flux.fromIterable(set);
//        flux.subscribe(System.err::println);

//        List<String> list = new ArrayList();
//        for (int i = 0; i < 20; i++) {
//            list.add("这是集合中的"+i);
//        }
//        Stream stream = list.stream().filter(s->
//             Integer.parseInt(s.substring(s.indexOf("的")+1))>10
//        );
//        Flux flux = Flux.fromStream(stream);
//        flux.subscribe(System.err::println);


//        Flux.defer(()->
//            Flux.create(
//                    fluxSink -> {
//                        fluxSink.next(1).next(2).next(3).next(4).next(5);
//                    }
//            ).doOnNext(o -> {
//                try {
//                    Thread.sleep(new Random().nextInt(3000));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            })
//            ).subscribe(System.err::println);

//        Flux.interval(Duration.of(1000, ChronoUnit.MILLIS)).subscribe(System.err::println);
//        System.in.read();

//        Flux.error(new RuntimeException("错误错误错误"))
//                .subscribe(System.err::println);
//        Flux.empty().subscribe();
//        Flux.never().subscribe();

        // 从10开始 拿100个数
//        Flux.range(10, 100).subscribe(System.err::println);

//        Flux.create(fluxSink ->
//                fluxSink.next(1).next(2).next(3).complete())
//                .concatWithValues(4,5,6)
//                .subscribe(System.err::println);

//        Flux.concat(Flux.just(1,2,0).doOnNext(n->{
//            int i = 1000/n;
//        }),Flux.just(4,5,6))
//                .subscribe(new Subscriber<Integer>() {
//                    private Subscription subscription;
//                    @Override
//                    public void onSubscribe(Subscription subscription) {
//                        this.subscription = subscription;
//                        subscription.request(1);
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        System.err.println(integer);
//                        subscription.request(1);
//                    }
//
//                    @Override
//                    public void onError(Throwable throwable) {
//                        System.err.println(throwable.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        System.err.println("程序运行结束");
//                    }
//                });

//        Flux.concatDelayError(Flux.just(1,2,0).doOnNext(n->{
//            int i = 1000/n;
//        }),Flux.just(4,5,6))
//                .subscribe(new Subscriber<Integer>() {
//                    private Subscription subscription;
//                    @Override
//                    public void onSubscribe(Subscription subscription) {
//                        this.subscription = subscription;
//                        subscription.request(1);
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        System.err.println(integer);
//                        subscription.request(1);
//                    }
//
//                    @Override
//                    public void onError(Throwable throwable) {
//                        System.err.println(throwable.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        System.err.println("程序运行结束");
//                    }
//                });


        // 这里直接输出就算了，这还用写实现类？不想写了
//        Flux.firstWithSignal(Flux.just(1,2,3),Flux.just(4,5,6)).subscribe(System.err::println);

        // 交替，嘶，这个参数不是很懂，我草
//        Flux.merge(Flux.interval(Duration.ofMillis(0), Duration.ofMillis(100)).take(5), Flux.interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(5))
//                .toStream()
//                .forEach(System.out::println);
//        Flux.mergeComparing((s1, s2)-> s1-s2, Flux.just(1, 3, 2), Flux.just(6, 5, 4)).subscribe(System.out::println);
////如果每个只有一个数据,可以看到明显的排序效果
//        Flux.mergeComparing((s1,s2)-> s2-s1, Flux.just(1), Flux.just(6), Flux.just(2), Flux.just(4), Flux.just(7)).subscribe(System.out::println);

//        //每个flux的每个位置的数据合并到一个数组中交给订阅者
        // 可以自定义合并的方式
//        Flux.zip(Flux.just(1, 2, 0), Flux.just(4, 5, 6)).subscribe(System.out::println);
////分组并进行响应操作后返回一个结果交给订阅者
//        Flux.zip(Flux.just(1, 2, 0), Flux.just(4, 5, 6),(i1,i2)->i1+i2).subscribe(System.out::println);

        // 全部的数字大于0？？
//        Flux.just(1,2,3,4).all(a->a>0).subscribe(System.err::println);
//        Flux.just(1,2,3,0).all(a->a>0).subscribe(System.err::println);

        // 判断任意一个小于0
//        Flux.just(1,2,3,4).any(a->a<0).subscribe(System.err::println);
//        Flux.just(1,2,3,-1).any(a->a<0).subscribe(System.err::println);

        // ==============================================================
        // 啊，暂时看不懂
//        System.err.println(Flux.just(1, 2, 3)
//                .as(new Function<Flux<Integer>, Object>() {
//                    @Override
//                    public Object apply(Flux<Integer> integerFlux) {
//                        final String[] s = {""};
//                        integerFlux.subscribe(integer -> s[0] = s[0] + integer);
//                        return s[0];
//                    }
//                }));

        // 分组用的估计是，分组发送
//        Flux.just(1,2,3,4,5).buffer(2,1).subscribe(System.err::println);

//        Flux<Integer> cache = Flux.just(1, 2, 3).cache(2);
//        //一开始可以获取到所有数据
//        cache.subscribe(System.out::println);
//        //再次订阅只能获取cache指定个数的数据.从后面数
//        cache.subscribe(System.out::println);



    }


}