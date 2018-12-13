以spring-jms、spring-webmvc、activemq-core这有个jar包为例，如下为正确与错误的依赖编写顺序
错误的依赖顺序下出错异常：
java.lang.NoSuchMethodError: org.springframework.beans.support.ResourceEditorRegistrar
就是找不到ClassPathXmlApplicationContext("contextLocation")

从两者依赖顺序导入的jar包截图中发现，错误的截图中多了一个spring-asm.3.0.7.RELEASE的包，
且spring-context也不是指定的5.0.7.RELEASE，而是3.0.7.RELEASE

这是由于pom解决依赖冲突的规则引起的，参考：
https://blog.csdn.net/Jason20Ming/article/details/7192486
http://yanan0628.iteye.com/blog/2270409


        <!-- 正确的依赖顺序 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jms</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.activemq</groupId>
            <artifactId>activemq-core</artifactId>
            <version>${activemq.version}</version>
        </dependency>

        <!-- 报错的依赖顺序 -->
        <dependency>
            <groupId>org.apache.activemq</groupId>
            <artifactId>activemq-core</artifactId>
            <version>${activemq.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jms</artifactId>
            <version>${spring.version}</version>
        </dependency>