package google.Test;

/**
 * @Classname VisitorDemo
 * @Description TODO
 * @Date 2022/4/17 10:35
 * @Created by 翊
 */
public class VisitorDemo {
    public static void main(String[] args) {
        SourceFile file = new PdfFile();
        file.print(new Visitor1());
        file.print(new Visitor2());
    }
}

class SourceFile {
    public void print(Visitor visitorFile) {
        System.out.println("SourceFile......");
    }
}


class PptFile extends SourceFile {
    @Override
    public void print(Visitor visitorFile) {
        visitorFile.visitor(this);
    }
}

class PdfFile extends SourceFile {
    @Override
    public void print(Visitor visitorFile) {
        visitorFile.visitor(this);
    }
}


abstract class Visitor {
    public abstract void visitor(PptFile file);
    public abstract void visitor(PdfFile file);
}

class Visitor1 extends Visitor {

    @Override
    public void visitor(PptFile file) {
        System.out.println("Visitor1 PptFile......");
    }

    @Override
    public void visitor(PdfFile file) {
        System.out.println("Visitor1 PdfFile......");
    }
}

class Visitor2 extends Visitor {

    @Override
    public void visitor(PptFile file) {
        System.out.println("Visitor2 PptFile......");
    }

    @Override
    public void visitor(PdfFile file) {
        System.out.println("Visitor2 PdfFile......");
    }
}


