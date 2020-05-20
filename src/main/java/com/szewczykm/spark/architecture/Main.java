package com.szewczykm.spark.architecture;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

/**
 * [REF 1.1]
 */

public class Main {
    public static void main(String[] args) {
        SparkConf config = new SparkConf().setAppName("Longest ascending subsequence.");
        JavaSparkContext context = new JavaSparkContext(config);
        JavaRDD<Integer> rdd = context.parallelize(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        double sumOfSquaredEvenNumbers = rdd.filter(Main::isEven).map(Math::sqrt).reduce(Double::sum);
        System.out.println("Spark Job execution result: " + sumOfSquaredEvenNumbers);
    }

    private static boolean isEven(int value) {
        return (value % 2) == 0;
    }
}
