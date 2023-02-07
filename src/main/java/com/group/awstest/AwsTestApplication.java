package com.group.awstest;

import com.group.awstest.test.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsTestApplication {

    //test

    public static void main(String[] args) {
        Test test = new Test();
        try { test.writeExcel(); }
        catch (Exception e) {
            e.getMessage();
        }
//        SpringApplication.run(AwsTestApplication.class, args);
    }
}
