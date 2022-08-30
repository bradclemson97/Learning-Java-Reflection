/*
This main method shows how we can use reflection to peak into the structure of the cat class
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception{
        //create a new cat object
        //as the 'name' variable is static final, once it is set to 'stella' it shouldn't be able to be changed
        Cat myCat = new Cat("Stella", 6);

        //'getClass' is our window into the many reflection tools java offers
        //to get all the fields that are declared in the 'Cat' class we can use .getDeclaredFields
        //and put this into an array of field objects
        Field[] catFields = myCat.getClass().getDeclaredFields();

        for(Field field : catFields){
            //we can use reflection to force change the name of our cat, although name is set as 'private final'
            //and shouldn't be allowed to be changed once it is set
           if (field.getName().equals("name")){
               field.setAccessible(true);
               field.set(myCat, "Jimmy McGill");
           }
        }
        System.out.println(myCat.getName());

        //similar to getting all the fields from the 'Cat' class, we can get all the methods and put them into an array
        Method[] catMethods = myCat.getClass().getDeclaredMethods();

        for (Method method : catMethods){
            //we can use reflection to trigger our private methods
            if (method.getName().equals("thisIsAPrivateStaticMethod")){
                method.setAccessible(true);
                //for static methods which need an object passed in, we can just pass in null
                method.invoke(null);
            }
                System.out.println(method.getName());
        }


    }
}
