# STEP TO RUN THE PROJECT
### Guides
The following is guidelines to work on this project
1. run the *zookeeper-server.bat* the file will be in the folder 
   *D:\kafka-testing\kafka_2.12-2.3.0\bin\windows*
2. run the *kafka-server-start.bat* the file in the same folder above
    <br>2.1 kafka-server-start.bat ..\..\config\server.properties (first broker)
    <br>2.2 kafka-server-start.bat ..\..\config\server-1.properties (second broker)
    <br>2.3 kafka-server-start.bat ..\..\config\server-2.properties (third broker)
3. run this project using command *mvn spring-boot:run* 
4. hit request uri *localhost:8082/sending-message*
    <br/>4.1 first param: (<b>message</b> = your message to be send)
    <br/>4.2 second param: (<b>topic</b> = topic-name)
    
### Features
1. this project is handling multiple brokers (for this project using 3 brokers)
2. for this project partition of the topic will only be 1

### Need to Improve
1. Create multiple broker
2. Create consumer
3. Fixing producer configuration

### More to Learn
* [Spring kafka documentation](https://docs.spring.io/spring-kafka/docs/2.3.3.RELEASE/reference/html)
