package TestingSpring.impl;

import TestingSpring.Hand;

/**
 * Created by м on 27.01.2017.
 */
public class HandImpl implements Hand {
    @Override
    public void catchSomething() {
        System.out.println("I am catching an apple !");
    }
}
