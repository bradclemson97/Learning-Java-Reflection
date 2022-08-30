

/*
Java's reflection API allows you to write a program that can look at itself and even change itself while its running aka. meta programming
 */

public class Cat {

    /*from outside of this class the private 'name' variable cant be accessed and cant be changed to another value, for this we usually use
    accessors or mutator methods (getters and setters) to manipulate the value.
    We have these below but we can't 'set' the name variable as it is 'private final' (once its set once it cant be changed).
     */
    private final String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void meow(){
        System.out.println("Meow");
    }

    //with reflection, be careful if changing the name of methods, as they are being used by the Main class
    public void heyThisIsPrivate(){
        System.out.println("How did you call this??");
    }

    public static void thisIsAPublicStaticMethod(){
        System.out.println("I'm public and static!");
    }

    private static void thisIsAPrivateStaticMethod(){
        System.out.println("I'm private and static!");
    }


}
