# spark-learning
Repository to keep track of Spark learning

Progress tracking:
- [ ] Spark architecture
- [ ] SparkSession
- [ ] DataFrames
- [ ] Transformations
- [ ] Actions
- [ ] End-to-End example
- [ ] Spark toolset
- [ ] Structured APIs—DataFrames, SQL, and Datasets
- [ ] Basic Structured Operations
- [ ] Working with Different Types of Data
- [ ] Aggregations
- [ ] Joins
- [ ] Data Sources
- [ ] SparkSQL
- [ ] Datasets
- [ ] RDDs
- [ ] Advenced RDDs
- [ ] Distributed Shared Variables
- [ ] How Spark Runs on Cluster
- [ ] Developing Spark Applications
- [ ] Deploying Spark
- [ ] Monitoring and Debugging
- [ ] Performance Tuning
- [ ] Stream Processing Fundamentials
- [ ] Structured streaming basics
- [ ] Event-Time and Stateful Processing
- [ ] Structured Streaming in Production
- [ ] Advanced Analytics and Machine Learning
- [ ] Preprocessing and Feature Engineering
- [ ] Classification
- [ ] Regression
- [ ] Recommendation
- [ ] Unsupervised Learning
- [ ] Graph Analytics
- [ ] Deep Learning

# Spark high level architecture
Spark manages and coordinates the execution of tasks on data across a cluster of computers.
The cluster of machines that Spark will use to execute tasks is managed by a cluster manager like Spark’s standalone cluster manager, YARN, or Mesos.
We then submit Spark Applications to these cluster managers, which will grant resources to our application so that we can complete our work.

## Spark Applications
Spark Applications consist of a driver process and a set of executor processes.

The driver process runs your main() function, sits on a node in the cluster, and is responsible for three things: 
* maintaining information about the Spark Application; 
* responding to a user’s program or input; 
* analyzing, distributing, and scheduling work across the executors

The executors are responsible for actually carrying out the work that the driver assigns them. 
This means that each executor is responsible for only two things: executing code assigned to it by the driver, 
and reporting the state of the computation on that executor back to the driver node.

![alt text](https://spark.apache.org/docs/latest/img/cluster-overview.png)

## Spark core components
![alt text](https://www.baeldung.com/wp-content/uploads/2017/10/Components-of-Spark.jpg)
### Spark Core
Spark Core component is accountable for all the basic I/O functionalities, scheduling and monitoring the jobs on spark clusters, task dispatching, networking with different storage systems, fault recovery, and efficient memory management.
Spark Core example [REF 1.1](https://github.com/MichalSzewczyk/spark-learning/blob/master/src/main/java/com/szewczykm/spark/architecture/Main.java)

### Spark SQL
Spark SQL is a Spark module for structured data processing. It's primarily used to execute SQL queries. DataFrame constitutes the main abstraction for Spark SQL. Distributed collection of data ordered into named columns is known as a DataFrame in Spark.

### Spark Streaming
Spark Streaming is an extension of the core Spark API that enables scalable, high-throughput, fault-tolerant stream processing of live data streams. Data can be ingested from a number of sources, such as Kafka, Flume, Kinesis, or TCP sockets.

### Spark Mlib
MLlib is Spark’s machine learning (ML) library. Its goal is to make practical machine learning scalable and easy. 

### Spark GraphX
GraphX is a component for graphs and graph-parallel computations. At a high level, GraphX extends the Spark RDD by introducing a new Graph abstraction: a directed multigraph with properties attached to each vertex and edge.
