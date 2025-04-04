 USE heritage;

-- 插入测试用户（密码：123456）
INSERT INTO users (username, password, email, nickname) VALUES 
('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBpwTTyU7IxG6O', 'admin@example.com', '管理员'),
('test', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBpwTTyU7IxG6O', 'test@example.com', '测试用户');

-- 插入非遗项目数据
INSERT INTO heritages (title, description, category, location, user_id) VALUES 
('满族剪纸', '满族剪纸是满族传统民间艺术，具有独特的艺术风格和深厚的文化内涵。', '传统美术', '辽宁省', 1),
('萨满文化', '萨满文化是东北地区重要的非物质文化遗产，包含了丰富的民间信仰和仪式。', '民间信仰', '吉林省', 1),
('二人转', '二人转是东北地区最具代表性的民间艺术形式之一，融合了说唱、表演等多种艺术元素。', '民间艺术', '黑龙江省', 1);

-- 插入社区分享数据
INSERT INTO posts (title, content, user_id, heritage_id) VALUES 
('满族剪纸艺术展示', '今天参观了满族剪纸艺术展，感受到了传统文化的魅力...', 2, 1),
('萨满文化体验', '参加了一次萨满文化体验活动，非常震撼...', 2, 2),
('二人转表演', '观看了精彩的二人转表演，演员们的表演非常生动...', 2, 3);

-- 插入评论数据
INSERT INTO comments (content, user_id, post_id) VALUES 
('剪纸作品真的很精美！', 1, 1),
('萨满文化确实很神秘', 1, 2),
('二人转表演很精彩', 1, 3),
('感谢分享，让我对满族文化有了更深的了解', 2, 1),
('萨满文化确实值得传承', 2, 2);