package com.szewczykm.spark.architecture;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * [REF 1.1]
 */

public class RDDExample {
    // Replace with your hadoop home dir
    private static final String HADOOP_HOME_DIR = "D:\\Coding\\hadoop-winutil";
    private static final int WHILE = 1000;

    public static void main(String[] args) {
        JavaSparkContext context = configureSparkContext();

        JavaRDD<Integer> rdd = context.parallelize(new ArrayList<>(IntStream.range(1, 10000000).boxed().collect(Collectors.toList())));
        double sumOfSquaredEvenNumbers = rdd.filter(RDDExample::isEven).map(Math::sqrt).map(RDDExample::sleepForAWhile).reduce(Double::sum);
        System.out.println("Spark Job execution result: " + sumOfSquaredEvenNumbers);
    }

    private static JavaSparkContext configureSparkContext() {
        System.setProperty("hadoop.home.dir", HADOOP_HOME_DIR);
        SparkConf config = new SparkConf().setAppName("Example spark application.");
        config.set("spark.master", "local");
        return new JavaSparkContext(config);
    }

    private static boolean isEven(int value) {
        return (value % 2) == 0;
    }

    private static <T> T sleepForAWhile(T value) {
        try {
            Thread.sleep(WHILE);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return value;
    }
}
