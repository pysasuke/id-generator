# id-generator ID生成器

## 项目简介

该项目位id生成器，ID的构造为：2位服务代码+8位时间戳(格式为20150509)+不定位(不同的服务生成id长度不同)数(从1开始，不足补0)

## 项目结构

1.	constans包：包含一个Constants常量类。
2.	domain包：包含服务积累对象ServiceModel、子类FirstServiceModel和SecondServiceModel、区间对象Section(生成id的区间，同样是返回对象)。
3.	factory包：包含工厂类ServiceModelFactory(根据不同情况生成不同的ServiceModel子类对象)。
4.	service包：包含物业类GenneratorService(id生成具体实现)。
5.	util包：包含时间工具类TimeTools类(日期时间戳生成)。
6.	web包：包含请求处理类StringRedisController(请求接收)。
7.	IdGeneratorApplication：SpringBoot启动类。

## 技术选型

1、后端

* 核心框架：Spring boot 4.0
* 缓存框架：Redis
* 日志管理：logback

4、平台

* 服务器中间件：在jdk1.8规范下开发，使用应用服务器为Tomcat 7。

* 开发环境：Java、IDEA 2017、Maven 3.9、Git

## 核心代码
----
    String value = valOpsStr.get(key);
            if (null == value) {
                //服务号2位 + 时间戳8位 + 不定位
                String value2 = serviceId + TimeTools.getCodingDate() + String.format(format, 0);//用0补够6位
                valOpsStr.set(key, value2);
                value = valOpsStr.get(key);
            }
            //前缀替换(时间戳需要改变)
            prefix = serviceId + TimeTools.getCodingDate();
            start = Long.parseLong(value.substring(Constants.GUDINGWEISHU_Service, size)) + 1;
            end = start + num - 1;

            valOpsStr.set(key, prefix + String.format(format, end));
----
## 演示地址

* <http://localhost:8080/getSection?serviceId=01&size=5000>
