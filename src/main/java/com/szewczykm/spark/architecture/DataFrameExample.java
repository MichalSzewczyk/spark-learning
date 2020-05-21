package com.szewczykm.spark.architecture;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class DataFrameExample {
    private static final String HADOOP_HOME_DIR = "D:\\Coding\\hadoop-winutil";

    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", HADOOP_HOME_DIR);
        SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark SQL basic example")
                .config("spark.master", "local")
                .getOrCreate();
        Dataset<Row> dataFrame = spark.read().csv("src/main/resources/addresses.csv");
        dataFrame.show();
        dataFrame.select("_c0").show(2);
    }
}
