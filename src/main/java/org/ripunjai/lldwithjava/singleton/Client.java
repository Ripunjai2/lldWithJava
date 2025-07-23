package org.ripunjai.lldwithjava.singleton;

public class Client {

    public static void main(String[] args) {

        SingletonClass singletonClass1 = SingletonClass.getInstance();
        SingletonClass singletonClass2 = SingletonClass.getInstance();

        System.out.println("Are both instances equal? " + (singletonClass1 == singletonClass2) + " obj1 : " + singletonClass1 + "  obj2 : " + singletonClass2);
    }
}
