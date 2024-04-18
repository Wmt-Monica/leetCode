package google.stack;


/**
 * @Classname JudgeBrackets
 * @Description TODO
 * @Date 2021/7/15 21:18
 * @Created by 翊
 * 利用栈来判断括号的合法性
 */
public class JudgeBrackets {

    private String brackets;

    public String getBrackets() {
        return brackets;
    }

    public void setBrackets(String brackets) {
        this.brackets = brackets;
    }

    public JudgeBrackets(String brackets) {
        this.brackets = brackets;
    }

    public boolean judge() {
        // 创建临时存放左括号的栈对象
        ArrayStack<Character> stack = new ArrayStack<>();
        for (char c : brackets.toCharArray()) {
            // 当字符括号为左括号入栈
            if (c == '{' || c == '[' || c == '(') {
                stack.add(c);
            } else if (c == '}' && !stack.isEmpty() && stack.pep() == '{') {
                // 出栈
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.pep() == '[') {
                stack.pop();
            } else if (c == ')' && !stack.isEmpty() && stack.pep() == '(') {
                stack.pop();
            } else {
                return false;
            }
            stack.print();
        }

        // 如果栈中不存在任何左括号说明括号合法，否则不合法
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
