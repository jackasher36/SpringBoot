
# 项目名称

325的集成化网站系统

## 项目简介

springboot架构完成的项目,有不错的前端页面,具有session的登入功能和发布文章

## 功能特点

列出你的项目的主要功能和特点。可以使用列表或表格。

- 功能1：提供学校论坛功能
- 功能2：拥有评论系统,审核后方可发布
- 功能3：同时具有二手交易,生活分享等功能

## 技术栈

- Java:17
- Spring Framework：6.3.3
- Spring MVC：3.0.2
- Hibernate：版本号
- Centos: 7.9
- MySQL：8.0.20

## 快速开始

以下是如何在本地运行该项目的快速开始指南：

1. 克隆项目到本地：`git clone git@github.com:jackasher36/SpringBoot.git`
2. 导入项目到IDE（例如Eclipse或IntelliJ IDEA）。
3. 修改数据库配置文件（例如application.properties或application.yml），将数据库连接信息改为你本地的配置。
4. 运行项目：在IDE中运行项目，或者使用构建工具（例如Maven或Gradle）运行项目。
5. 准备好相关的数据库表,主要是两张user和pages,用于登入验证和文章存储,我已经给了一张pages的sql表,我默认数据库是jack,建议创建jack维护数据库,user表参考pojo类中的account类,注意不是User类
6. 在浏览器中访问项目：打开浏览器，输入URL `http://localhost:8081/welcom.html`, 可以访问项目的首页。

## 配置

- 数据库配置：用的本地mysql8
- 日志配置：日志还未额外配置
- 第三方服务配置：无其他配置

## 文档
项目内以内置相关文档
## 贡献

- 如何报告问题
- 如何提交特性请求
- 贡献流程和准则

## 版权和许可

可自由使用

## 鸣谢

这里感谢和致谢与项目相关的人或组织。

如果你需要更多的部分，可以根据项目需求进行添加和修改。祝项目大获成功！