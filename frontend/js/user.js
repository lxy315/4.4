// 用户服务类
class UserService {
    // 获取当前登录用户
    static getCurrentUser() {
        const userStr = localStorage.getItem('currentUser');
        return userStr ? JSON.parse(userStr) : null;
    }

    // 检查用户是否已登录
    static isLoggedIn() {
        return !!this.getCurrentUser();
    }

    // 用户登录
    static async login(username, password) {
        try {
            const response = await fetch('/api/users/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                body: JSON.stringify({ username, password })
            });

            if (!response.ok) {
                const error = await response.text();
                throw new Error(error || '登录失败');
            }

            const user = await response.json();
            localStorage.setItem('currentUser', JSON.stringify(user));
            return user;
        } catch (error) {
            throw new Error(error.message || '登录失败');
        }
    }

    // 用户注册
    static async register(username, password, email, phone) {
        try {
            const response = await fetch('/api/users/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                body: JSON.stringify({ username, password, email, phone })
            });

            if (!response.ok) {
                const error = await response.text();
                throw new Error(error || '注册失败');
            }

            const user = await response.json();
            return user;
        } catch (error) {
            throw new Error(error.message || '注册失败');
        }
    }

    // 用户退出登录
    static logout() {
        localStorage.removeItem('currentUser');
        window.location.href = '非遗首页.html';
    }

    // 更新页面登录状态显示
    static updateLoginStatus() {
        const userInfo = document.querySelector('.user-info');
        const loginLink = document.querySelector('.login-link');
        const currentUser = this.getCurrentUser();

        if (userInfo && loginLink) {
            if (currentUser) {
                userInfo.style.display = 'block';
                loginLink.style.display = 'none';
                userInfo.querySelector('.username').textContent = currentUser.username;
            } else {
                userInfo.style.display = 'none';
                loginLink.style.display = 'block';
            }
        }
    }

    // 添加退出登录事件监听
    static addLogoutListener() {
        const logoutBtn = document.querySelector('.logout-btn');
        if (logoutBtn) {
            logoutBtn.addEventListener('click', (e) => {
                e.preventDefault();
                this.logout();
            });
        }
    }
}

// 页面加载时更新登录状态
document.addEventListener('DOMContentLoaded', () => {
    UserService.updateLoginStatus();
    UserService.addLogoutListener();
}); 