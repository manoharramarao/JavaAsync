package com.async.java;

import java.util.concurrent.CompletableFuture;

public class WebServiceClient {

    public static void main(String[] args) {

        WebServiceClientAsync client = new WebServiceClientAsync();
        CompletableFuture<String> firstFuture = client.firstCall();
        CompletableFuture<Integer> secondFuture = client.secondCall();
        CompletableFuture<String> thirdFuture = client.thirdCall();


        CompletableFuture<DTO> finalFuture = CompletableFuture.allOf(firstFuture, secondFuture, thirdFuture)
                .thenApplyAsync(getDTO -> {
                    DTO dto = new DTO();

                    String firstRes = firstFuture.join();
                    Integer secRes = secondFuture.join();
                    String thirdRes = thirdFuture.join();
                    if(firstRes != null && !firstRes.isEmpty()){
                        dto.setFirstCallResponse(firstRes);
                    }
                    if(secRes != null){
                        dto.setSecondCallResponse(secRes);
                    }
                    if(thirdRes != null && !thirdRes.isEmpty()){
                        dto.setThirdCallResponse(thirdRes);
                    }

                    return dto;
                });

        System.out.println(finalFuture.join().getFirstCallResponse());
        System.out.println(finalFuture.join().getSecondCallResponse());
        System.out.println(finalFuture.join().getThirdCallResponse());

    }
}
