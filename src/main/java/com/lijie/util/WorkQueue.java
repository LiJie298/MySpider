package com.lijie.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 用于存储没有访问的url
 * Created by lijie7 on 2017/8/3.
 */
public class WorkQueue {
    private LinkedList queue = new LinkedList();

    //入队列
    protected void addQueue(Object t) {
        queue.addLast(t);
    }

    //是否重复
    protected boolean isRepeat(Object t) {
        return queue.contains(t);
    }

    //出队列
    protected void removeQueue() {
        queue.removeFirst();
    }

    //    判断队列是否为空
    protected boolean empty() {
        return queue.isEmpty();
    }

    protected int getQueueNum() {
        return queue.size();
    }
}
