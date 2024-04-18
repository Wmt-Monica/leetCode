package google.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Classname MyHandler
 * @Description TODO
 * @Date 2022/4/15 19:19
 * @Created by 翊
 */
public class MyHandler implements InvocationHandler {

    private Object object;

    public MyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy starting...");
        Object result = method.invoke(object, args);
        System.out.println("proxy ending...");
        return result;
    }
}
