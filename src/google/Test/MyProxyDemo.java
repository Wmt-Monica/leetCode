package google.Test;

import java.lang.reflect.Proxy;

/**
 * @Classname MyProxyDemo
 * @Description TODO
 * @Date 2022/4/15 19:21
 * @Created by 翊
 */
public class MyProxyDemo {
    public static void main(String[] args) {
        ProxyInterface proxyObject = (ProxyInterface) Proxy.newProxyInstance(Proxied.class.getClassLoader(), Proxied.class.getInterfaces(), new MyHandler(new Proxied()));
        proxyObject.method();
    }
}

interface ProxyInterface {
    public void method();
}


class Proxied implements ProxyInterface {

    @Override
    public void method() {
        System.out.println("method is running...");
    }
}
