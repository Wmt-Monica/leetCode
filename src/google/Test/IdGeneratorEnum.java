package google.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname AEnum
 * @Description TODO
 * @Date 2022/4/15 9:06
 * @Created by 翊
 */
public enum IdGeneratorEnum {
    INSTANCE;
    private AtomicInteger atomicInteger = new AtomicInteger();
    public int getId() {
        return atomicInteger.getAndIncrement();
    }
}
