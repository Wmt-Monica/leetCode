package google.Test;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Classname AClass
 * @Description TODO
 * @Date 2022/4/14 21:51
 * @Created by 翊
 */
public class IdGenerator {
//    private String name;
    private AtomicLong idGenerator = new AtomicLong();
    private static IdGenerator instance;
    public static synchronized IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

//    public static synchronized void init(String name) {
//        if (instance != null) {
//            throw new RuntimeException("instance is not null....");
//        } else {
//            instance = new IdGenerator();
//            instance.name = name;
//        }
//    }
    public long getId() {
        return idGenerator.getAndIncrement();
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}



