package com.qf.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.event
 * @Description:
 * @Date 2022/5/23 12:45
 */
@Component
public class FireMan {

    @EventListener
    public void onEvent(FireWarning fireWarning){
        System.err.println("FireMan类中的onEvent方法执行了-->"+fireWarning);
    }
}
