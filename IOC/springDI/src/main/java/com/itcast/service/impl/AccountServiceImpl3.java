package com.itcast.service.impl;

import com.itcast.service.IAccountService;

import java.util.*;


public class AccountServiceImpl3 implements IAccountService {

    private String[] myStr;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,Object> myMap;
    private Properties myProps;

    public void setMyStr(String[] myStr) {
        this.myStr = myStr;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, Object> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    @Override
    public void savaAccount() {

        //System.out.println("service save ing...."+name+","+age+","+birthday);
        System.out.println(this.toString());
    }


    @Override
    public String toString() {
        return "AccountServiceImpl3{" +
                "myStr=" + Arrays.toString(myStr) +
                ", myList=" + myList +
                ", mySet=" + mySet +
                ", myMap=" + myMap +
                ", myProps=" + myProps +
                '}';
    }
}
