package com.async.java;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WebServiceClientAsync {

    /*protected final ExecutorService poolAlpha =
            Executors.newFixedThreadPool(10);*/
    /*
        You can all the connection details
     */

    public CompletableFuture firstCall(){

        return CompletableFuture.supplyAsync(() -> firstCallAsync());

    }

    public String firstCallAsync(){
        /*
            Open a connection to the SMS server
            get the response
            extract Json body out of it and return
            And convert JSON to required object and return that object
         */
        System.out.println("entering first call " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Leaving First call");
        return "Response from 1st call is String";
    }

    public CompletableFuture<Integer> secondCall(){
        return CompletableFuture.supplyAsync(() -> secondCallAsycn());
    }

    public Integer secondCallAsycn(){
        /*
            Open a connection to the SMS server
            get the response
            extract Json body out of it and return
            And convert JSON to required object and return that object
         */
        System.out.println("Entering second call " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Leaving second call");
        return 345693;
    }

    public CompletableFuture<String> thirdCall(){
        return CompletableFuture.supplyAsync(() -> thirdCallAsycn());
    }

    public String thirdCallAsycn(){
        /*
            Open a connection to the SMS server
            get the response
            extract Json body out of it and return
            And convert JSON to required object and return that object
         */
        System.out.println("Entering third call " + Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Leaving third call");
        return "Response from 3rd call is again returning String";
    }

}
