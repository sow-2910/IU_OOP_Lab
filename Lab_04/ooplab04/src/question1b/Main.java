package question1b;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("concac");
        Dog dog = new Dog("Messi");
        BigDog dogMessi = new BigDog("Huy");

        cat.greets();
        dog.greets();
        dog.greets(dog);
        dogMessi.greets(dog);
    }
}
