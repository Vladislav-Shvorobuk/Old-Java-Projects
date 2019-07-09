package TestingSpring.impl;

import TestingSpring.Leg;

/**
 * Created by м on 27.01.2017.
 */
public class LegImpl implements Leg {
    @Override
    public void go() {
        System.out.println("I can move !");
    }
}
