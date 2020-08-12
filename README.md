<h1 align="center">EB 微服务演示</h1>
### 演示说明

部署之前先阅读此篇[博文](https://gudaoxuri.gitbook.io/microservices-architecture/)，初步了解微服务的概念。文章不用全看完，看到“微服务的兴起”，感性的了解什么是微服务就好。通俗的讲，微服务就是分布式的功能模块。	

本demo以一个简单的人事管理系统作为演示，带大家实地部署一个微服务环境。分成三个微服务：公司（organization）——部门（department）——员工（employee）。每一个员工属于一个公司下的某个部门。三个微服务各自可以有很多复杂的功能，在本次演示中，为了方便，只包含对用内存模拟的数据库的增删查改。

注意，此微服务划分非最佳实践，仅供演示。

项目中，员工服务可能调用部门服务和公司服务的接口，部门服务可能调用公司服务提供的接口。具体的定义见`organization-service/src/main/java/com/eb/demo/organization/client`和`department-service/src/main/java/com/eb/demo/department/client`

### 环境与框架

* jdk1.8
* maven
* spring cloud Hoxton.SR3(版本号不严格要求同步)
* spring boot 2.2.6.RELEASE(版本号不严格要求同步)
* HashiCorp Consul（[下载链接](https://www.consul.io/downloads))
* Docker
* Docker-compose

### 启动

只需要先安装maven、docker和docker-compose

* 先在自己电脑上安装maven
* 在项目根目录下运行`mvn package`生成jar包
* 在根目录下运行`docker-compose up -d`

### 运行截图

运行成功后，访问http://localhost:8500`

![image-20200812160112465](F:\Laboratory\Microservices\Code\microservices_demo\assets\image-20200812160112465.png)

`访问localhost:11300/swagger-ui.html`进行接口调试，验证服务成功运行

![image-20200812160125185](F:\Laboratory\Microservices\Code\microservices_demo\assets\image-20200812160125185.png)

`还可以调用FeignClient中的接口验证服务之间可以相互访问`

![image-20200812160029827](F:\Laboratory\Microservices\Code\microservices_demo\assets\image-20200812160029827.png)

### 建议开发流程

* 先熟悉maven

* 从spring boot入手先熟悉java web开发
* 如果接到了任务，用微服务的思想划分功能模块
* 后期接入网关与注册中心