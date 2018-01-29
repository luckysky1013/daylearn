package com.springboot.mybatis;

import java.util.Calendar;

import javax.swing.plaf.synth.SynthTextAreaUI;

/**
 * @author liujian
 * @date 2018/1/26
 */
public class Main {
    public static  void main(String []arg){
        int year = Calendar.getInstance().get();
        System.out.println(year);
    }
}
