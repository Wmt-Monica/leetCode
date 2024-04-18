package google.Test;

/**
 * @Classname MessagerNotify
 * @Description TODO
 * @Date 2022/4/15 19:42
 * @Created by 翊
 */
public class MessageNotify {
    public static void main(String[] args) {
        AMessageNotify aMessageNotify = new AMessageNotify(new QQSender());
        aMessageNotify.messageNotify();
        AMessageNotify aMessageNotify1 = new AMessageNotify(new WeCharSender());
        aMessageNotify1.messageNotify();
        BMessageNotify bMessageNotify = new BMessageNotify(new QQSender());
        bMessageNotify.messageNotify();
        BMessageNotify bMessageNotify1 = new BMessageNotify(new WeCharSender());
        bMessageNotify1.messageNotify();
    }
}

class QQSender implements MessageSender {
    @Override
    public void send() {
        System.out.println("used QQ sender....");
    }
}

class WeCharSender implements MessageSender {
    @Override
    public void send() {
        System.out.println("used WeChar sender....");
    }
}

class AMessageNotify extends Notification {

    public AMessageNotify(MessageSender sender) {
        super(sender);
    }

    @Override
    public void messageNotify() {
        this.sender.send();
        System.out.println("AMessage is sending....");
    }
}

class BMessageNotify extends Notification {

    public BMessageNotify(MessageSender sender) {
        super(sender);
    }

    @Override
    public void messageNotify() {
        this.sender.send();
        System.out.println("BMessage is sending....");
    }
}
