package TestingSpring.impl;

import TestingSpring.*;

/**
 * Created by м on 27.01.2017.
 */
public class Robocop implements Robot {

    private Head head;
    private Body body;
    private Hand hand;
    private Leg leg;

    public Robocop() {
    }

    public Robocop(Head head, Body body, Hand hand, Leg leg) {
        this.head = head;
        this.body = body;
        this.hand = hand;
        this.leg = leg;
    }

    @Override
    public void on() {
        System.out.println("Power on");

        head.think();
        body.haveBody();
        hand.catchSomething();
        leg.go();
    }

    @Override
    public void of() {
        System.out.println("Power of");
    }
}
