package com.sibyl.application.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * @Classname UnionTest
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2021/11/14 19:16
 */

public class UnionTest {

    public static void main(String[] args) {
        Obj o1 = new Obj();
        o1.setMin(10);
        o1.setMax(20);
        Obj o2 = new Obj();
        o2.setMin(100);
        o2.setMax(200);
        Obj o3 = new Obj();
        o3.setMin(150);
        o3.setMax(250);
        Obj o4 = new Obj();
        o4.setMin(1);
        o4.setMax(5);
        Obj o5 = new Obj();
        o5.setMin(1000);
        o5.setMax(5000);

        List<Obj> objs = Arrays.asList(o1, o2, o3,o4,o5);
        List<Obj> minSorted = objs.stream().sorted(Comparator.comparing(Obj::getMin)).collect(Collectors.toList());
        List<Obj> maxSorted = objs.stream().sorted(Comparator.comparing(Obj::getMax).reversed()).collect(Collectors.toList());
        System.err.println(objs);
        System.err.println(minSorted);
        System.err.println(maxSorted);
        System.err.println();

        ArrayList<Obj> alones = new ArrayList<>();
        ArrayList<Obj> unions = new ArrayList<>();

        objs.forEach(item1->{

            AtomicBoolean flag = new AtomicBoolean(true);
            System.err.println(item1);
            objs.forEach(item2->{
                if (item1.equals(item2)){
                    return;
                }
                if(isCover(item1,item2)){
                    System.err.println(item1 +" ==> "+ item2);
                    flag.set(false);
                }
            });

            //flag.set(collect);

            if(flag.get()){
                System.err.println("alone => " + item1);
            }else {
                System.err.println("union => " + item1);
            }
            System.err.println();
        });

    }

    private static boolean isCover(Obj item1, Obj item2) {
        if(Collections.max(Arrays.asList(item1.getMin(),item2.getMin())) <= Collections.min(Arrays.asList(item1.getMax(),item2.getMax())))
            return true;
        return false;
    }

}

@Data
@EqualsAndHashCode
@ToString
class Obj{
    private int min;
    private int max;
}