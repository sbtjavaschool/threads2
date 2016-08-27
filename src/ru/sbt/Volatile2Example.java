package ru.sbt;

public class Volatile2Example {
    private volatile Person person = new Person("Bob", "L", 12);

    public void changePerson(String name, int x) {
        person = new Person(name, person.getLastName(), x);
    }

    public Person getPerson() {
        return person;
    }

    public static void main(String[] args) throws InterruptedException {
        Volatile2Example example = new Volatile2Example();

        new Thread(()-> example.changePerson("Alex", 12)).start();

        Thread.sleep(1_000);

        new Thread(()-> System.out.println(example.getPerson().getName())).start();
    }
}