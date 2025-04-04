# 东北非物质文化遗产网站后端

这是一个基于Spring Boot的东北非物质文化遗产网站后端项目。

## 技术栈

- Spring Boot 2.7.0
- Spring Security
- Spring Data JPA
- MySQL 8.0
- Maven
- JWT

## 功能特性

- 用户管理（注册、登录、信息更新）
- 非遗项目管理（展示、搜索、分类）
- 文创商品管理（展示、搜索、库存管理）
- RESTful API设计
- 安全认证

## 环境要求

- JDK 11+
- MySQL 8.0+
- Maven 3.6+

## 快速开始

1. 克隆项目到本地
```bash
git clone [项目地址]
```

2. 创建MySQL数据库
```sql
CREATE DATABASE heritage CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

3. 修改配置文件
编辑 `src/main/resources/application.properties` 文件，配置数据库连接信息：
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/heritage?useSSL=false&serverTimezone=UTC
spring.datasource.username=你的用户名
spring.datasource.password=你的密码
```

4. 编译运行项目
```bash
mvn clean install
mvn spring-boot:run
```

## API文档

### 用户相关接口

- POST /api/users/register - 用户注册
- GET /api/users/{username} - 获取用户信息
- PUT /api/users/{id} - 更新用户信息

### 非遗项目相关接口

- GET /api/heritage-items - 获取所有非遗项目
- GET /api/heritage-items/{id} - 获取指定非遗项目
- GET /api/heritage-items/category/{category} - 按分类获取非遗项目
- GET /api/heritage-items/search - 搜索非遗项目
- POST /api/heritage-items - 创建非遗项目
- PUT /api/heritage-items/{id} - 更新非遗项目
- DELETE /api/heritage-items/{id} - 删除非遗项目

### 商品相关接口

- GET /api/products - 获取所有商品
- GET /api/products/{id} - 获取指定商品
- GET /api/products/search - 搜索商品
- GET /api/products/price-range - 按价格范围获取商品
- POST /api/products - 创建商品
- PUT /api/products/{id} - 更新商品
- DELETE /api/products/{id} - 删除商品
- PUT /api/products/{id}/stock - 更新商品库存

## 注意事项

1. 首次运行时会自动创建数据库表
2. 默认管理员账号需要手动在数据库中创建
3. 文件上传大小限制为10MB
4. 建议在生产环境中修改JWT密钥 