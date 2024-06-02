
CREATE TABLE `pages` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '自增\n',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` varchar(2550) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `pages` (`id`, `title`, `author`, `content`, `category`) VALUES (1, '测试案例', 'jack', '这是一个发布文章的测试案例', 'study');
INSERT INTO `pages` (`id`, `title`, `author`, `content`, `category`) VALUES (2, '11', 'Jack', 'Heloooooooooooo', 'technology');
INSERT INTO `pages` (`id`, `title`, `author`, `content`, `category`) VALUES (3, '长测试', 'flp', '在前端监控 sdk 开发中，我们都会用到错误捕获，将页面各类错误进行捕获并上报日志，来获取错误信息，所以我们非常有必要深入了解下各类错误的错误捕获方式。\r\n\r\n补充\r\nsetTimeout 错误捕获方式：https://www.cnblogs.com/beileixinqing/p/16987679.html\r\n\r\nwindow.onerror 和window.addEventListener(\'error\',fn,true)的区别 : https://www.cnblogs.com/beileixinqing/p/17013219.html\r\n\r\n注意\r\n错误捕获事件监听要写在最前面，即要保证在错误代码运行前已经监听\r\nunhandledrejection 事件仅当 promise reject 且没有使用 catch 捕获的时候会触发\r\n由于网络请求异常不会事件冒泡，因此必须在捕获阶段将其捕捉到才行，于是window.addEventListener 设置为 true 在捕获阶段进行', 'entertainment');
INSERT INTO `pages` (`id`, `title`, `author`, `content`, `category`) VALUES (4, '长测试', 'flp', '在前端监控 sdk 开发中，我们都会用到错误捕获，将页面各类错误进行捕获并上报日志，来获取错误信息，所以我们非常有必要深入了解下各类错误的错误捕获方式。\r\n\r\n补充\r\nsetTimeout 错误捕获方式：https://www.cnblogs.com/beileixinqing/p/16987679.html\r\n\r\nwindow.onerror 和window.addEventListener(\'error\',fn,true)的区别 : https://www.cnblogs.com/beileixinqing/p/17013219.html\r\n\r\n注意\r\n错误捕获事件监听要写在最前面，即要保证在错误代码运行前已经监听\r\nunhandledrejection 事件仅当 promise reject 且没有使用 catch 捕获的时候会触发\r\n由于网络请求异常不会事件冒泡，因此必须在捕获阶段将其捕捉到才行，于是window.addEventListener 设置为 true 在捕获阶段进行', 'entertainment');
INSERT INTO `pages` (`id`, `title`, `author`, `content`, `category`) VALUES (5, '44', '44', '44', 'technology');
INSERT INTO `pages` (`id`, `title`, `author`, `content`, `category`) VALUES (6, '44', '44', '44', 'technology');
INSERT INTO `pages` (`id`, `title`, `author`, `content`, `category`) VALUES (7, '66', '66', '66', 'study');
INSERT INTO `pages` (`id`, `title`, `author`, `content`, `category`) VALUES (9, '11', '11', 'ddsf', 'depart');
INSERT INTO `pages` (`id`, `title`, `author`, `content`, `category`) VALUES (30, 'aa', 'aacc', 'cc', 'depart');
INSERT INTO `pages` (`id`, `title`, `author`, `content`, `category`) VALUES (31, '测试', 'FLp', '写在前面\r\n在前端监控 sdk 开发中，我们都会用到错误捕获，将页面各类错误进行捕获并上报日志，来获取错误信息，所以我们非常有必要深入了解下各类错误的错误捕获方式。\r\n\r\n补充\r\nsetTimeout 错误捕获方式：https://www.cnblogs.com/beileixinqing/p/16987679.html\r\n\r\nwindow.onerror 和window.addEventListener(\'error\',fn,true)的区别 : https://www.cnblogs.com/beileixinqing/p/17013219.html\r\n\r\n注意\r\n错误捕获事件监听要写在最前面，即要保证在错误代码运行前已经监听\r\nunhandledrejection 事件仅当 promise reject 且没有使用 catch 捕获的时候会触发\r\n由于网络请求异常不会事件冒泡，因此必须在捕获阶段将其捕捉到才行，于是window.addEventListener 设置为 true 在捕获阶段进行\r\n正文\r\n错误信息是最基础也是最重要的数据，错误信息主要分为下面几类：\r\n\r\nJS 代码运行错误、语法错误等\r\n异步错误等\r\n静态资源加载错误\r\n接口请求报错\r\n错误捕获方式\r\n1）try/catch\r\n\r\n只能捕获代码常规的运行错误，语法错误和异步错误不能捕获到\r\n\r\n示例：\r\n\r\n复制代码\r\n// 示例1：常规运行时错误，可以捕获 ✅\r\n try {\r\n   let a = undefined;\r\n   if (a.length) {\r\n     console.log(\'111\');\r\n   }\r\n } catch (e) {\r\n   console.log(\'捕获到异常：\', e);\r\n}\r\n\r\n// 示例2：语法错误，不能捕获 ❌  \r\ntry {\r\n  const notdefined,\r\n} catch(e) {', 'entertainment');
INSERT INTO `pages` (`id`, `title`, `author`, `content`, `category`) VALUES (32, 'aa', 'aa', 'aa', 'depart');
