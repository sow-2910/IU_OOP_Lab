package question1b;

public class BigDog extends Dog {
    public BigDog(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("wooow");
    }

    @Override
    public void greets(Dog another) {
        System.out.println("wooooow");
    }

    public void greets(BigDog another) {
        System.out.println("Wooooow");
    }

}
