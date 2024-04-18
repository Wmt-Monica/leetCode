package google.Test;

/**
 * @Classname Notification
 * @Description TODO
 * @Date 2022/4/15 19:40
 * @Created by 翊
 */
public abstract class Notification {
    MessageSender sender;
    public Notification(MessageSender sender) {
        this.sender = sender;
    }
    public abstract void messageNotify();
}
