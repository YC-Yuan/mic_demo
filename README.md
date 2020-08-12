<h1 align="center">EB 微服务演示</h1>

### 演示说明

部署之前先阅读此篇[博文](https://gudaoxuri.gitbook.io/microservices-architecture/)，初步了解微服务的概念。文章不用全看完，看到“微服务的兴起”，感性的了解什么是微服务就好。通俗的讲，微服务就是分布式的功能模块。	

本demo以一个简单的人事管理系统作为演示，带大家实地部署一个微服务环境。分成三个微服务：公司（organization）——部门（department）——员工（employee）。每一个员工属于一个公司下的某个部门。三个微服务各自可以有很多复杂的功能，在本次演示中，为了方便，只包含对用内存模拟的数据库的增删查改。[to](#建议开发流程)

注意，此微服务划分非最佳实践，仅供演示。

### 环境与框架

* jdk1.8
* maven
* spring cloud Hoxton.SR3(版本号不严格要求同步)
* spring boot 2.2.6.RELEASE(版本号不严格要求同步)
* HashiCorp Consul（[下载链接](https://www.consul.io/downloads))
* docker

### 启动顺序

* Consul
* Gateway
* 自己的业务服务

### 通用类说明

* ResponseBean是正常响应类，QueryBean是分页结果的响应类
* 使用ResponseUtil封装相应
* [响应状态码](https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Status)（不严格要求）

### 运行截图

	以开发模式成功运行consul后，访问http://localhost:8500



  已经注册有多个服务，不再演示

### 建议开发流程

* 先熟悉maven

* 从spring boot入手先熟悉java web开发
* 如果接到了任务，用微服务的思想划分功能模块
* 后期接入网关与注册中心