-- 创建数据库
CREATE DATABASE IF NOT EXISTS feiyi DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE feiyi;

-- 用户表
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL UNIQUE,
    avatar_url VARCHAR(255),
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 非遗项目表
CREATE TABLE IF NOT EXISTS heritage_items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    image_url VARCHAR(255),
    category VARCHAR(50) NOT NULL,
    region VARCHAR(100) NOT NULL,
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 文创产品表
CREATE TABLE IF NOT EXISTS products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    image_url VARCHAR(255),
    heritage_id BIGINT,
    stock INT NOT NULL DEFAULT 0,
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (heritage_id) REFERENCES heritage_items(id)
);

-- 社区分享表
CREATE TABLE IF NOT EXISTS posts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    content TEXT NOT NULL,
    image_url VARCHAR(255),
    likes INT NOT NULL DEFAULT 0,
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- 帖子点赞表
CREATE TABLE IF NOT EXISTS post_likes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    post_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES posts(id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    UNIQUE KEY unique_post_user (post_id, user_id)
);

-- 帖子收藏表
CREATE TABLE IF NOT EXISTS post_favorites (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    post_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES posts(id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    UNIQUE KEY unique_post_user (post_id, user_id)
);

-- 评论表
CREATE TABLE IF NOT EXISTS comments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    post_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    content TEXT NOT NULL,
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES posts(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- 插入测试数据
INSERT INTO users (username, password, email, phone) VALUES
('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBpwTTyU3VxqW', 'admin@example.com', '13800138000');

INSERT INTO heritage_items (name, description, category, region) VALUES
('苏绣', '苏绣是中国四大名绣之一，以其精细的针法、优美的图案和独特的艺术风格闻名于世。', '传统美术', '江苏省苏州市'),
('景德镇陶瓷', '景德镇陶瓷以其"白如玉、明如镜、薄如纸、声如磬"的特点闻名于世。', '传统技艺', '江西省景德镇市'),
('京剧', '京剧是中国国粹，融合了唱、念、做、打等艺术形式，具有独特的艺术魅力。', '传统戏剧', '北京市');

INSERT INTO products (name, description, price, heritage_id, stock) VALUES
('苏绣手帕', '精美苏绣手帕，采用上等丝绸制作', 99.00, 1, 100),
('景德镇茶具', '传统景德镇青花瓷茶具套装', 299.00, 2, 50),
('京剧脸谱', '手工绘制的京剧脸谱装饰品', 199.00, 3, 80);

INSERT INTO posts (user_id, content, likes) VALUES
(1, '今天参观了苏绣展览，被其精湛的技艺深深震撼！', 10),
(1, '分享一套精美的景德镇茶具，每一件都是艺术品。', 8),
(1, '京剧表演太精彩了，传统文化需要传承！', 15);

INSERT INTO comments (post_id, user_id, content) VALUES
(1, 1, '苏绣确实很美，希望有机会学习。'),
(2, 1, '这套茶具很精致，在哪里可以买到？'),
(3, 1, '京剧是国粹，应该让更多人了解。');
