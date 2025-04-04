// 主页面的主要功能
class MainPage {
    // 初始化页面
    static init() {
        // 检查登录状态
        UserService.updateLoginStatus();
    }
}

// 页面加载完成后初始化
document.addEventListener('DOMContentLoaded', () => {
    MainPage.init();
}); 