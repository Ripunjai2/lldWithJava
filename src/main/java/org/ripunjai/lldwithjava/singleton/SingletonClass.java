package org.ripunjai.lldwithjava.singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingletonClass {
    private static SingletonClass instance;
    static Lock lock = new ReentrantLock();

//    Private constructor to prevent instantiation
//    private SingletonClass(SingletonClass instance) {
//        this.instance = instance;
//    }

//    EagerLoading -- the only issue with this approach is that it will create the instance even if it is not used
//    and if we have parameters to pass in the constructor in the constructor, we cannot use this approach as it
//    will be loaded at the time of class loading or compile time
//    private static final SingletonClass instance = new SingletonClass()

//    Lazy Loading with Double-Checked Locking for multithreaded environment
    public static SingletonClass getInstance() {
        if(instance == null){
            lock.lock();
            if(instance == null){
                instance = new SingletonClass();
            }
            lock.unlock();
        }
        return instance;
    }
}
