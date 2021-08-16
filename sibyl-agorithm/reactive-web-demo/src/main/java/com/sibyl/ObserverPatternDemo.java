package com.sibyl;

import com.sibyl.utils.Utils;

import java.util.Observable;

/**
 * @Classname ObserverPatternDemo
 * @Description TODO
 * @Date 2021/8/16 20:14
 * @Created by dyingleaf3213
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {

        //当前:同步非阻塞
        MyObserverable observerable = new MyObserverable();
        Utils.prinf("observerable add=>");
        observerable.addObserver(((o, values) -> {
            Utils.prinf("accept update => " + values);
        }));
        observerable.addObserver(((o, values) -> {
            Utils.prinf("2accept update => " + values);
        }));observerable.addObserver(((o, values) -> {
            Utils.prinf("3accept update => " + values);
        }));
        Utils.prinf("notify all");
        observerable.setChanged();//
        observerable.notifyObservers("new world");// -> push


    }

    public static class MyObserverable extends Observable{
        @Override
        public synchronized void setChanged(){
            super.setChanged();
        }
    }
}
