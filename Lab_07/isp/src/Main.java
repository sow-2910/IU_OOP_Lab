interface Printer {
    void print(String content);
}

interface Scanner {
    void scan(String content);
}

interface Fax {
    void fax(String content);
}

class OldPrinter implements Printer {
    @Override
    public void print(String content) {
        System.out.println("Old Printer printing: " + content);
    }
}

class MultiFunctionMachine implements Printer, Scanner, Fax {
    @Override
    public void print(String content) {
        System.out.println("MFM Printing: " + content);
    }

    @Override
    public void scan(String content) {
        System.out.println("MFM Scanning: " + content);
    }

    @Override
    public void fax(String content) {
        System.out.println("MFM Faxing: " + content);
    }
}

public class Main {
    public static void main(String[] args) {
        Printer myOldPrinter = new OldPrinter();
        myOldPrinter.print("Hello World");

        MultiFunctionMachine officeMachine = new MultiFunctionMachine();
        officeMachine.print("Report");
        officeMachine.scan("Image");
        officeMachine.fax("Contract");
    }
}