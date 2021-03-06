package com.example.jc.myapplication.observer;


import android.util.Log;
import android.widget.Toast;

/**
 * Created by jc on 2017/7/23.
 */

//具体目标类,具体目标类的变动将引发具体观察者类做出相应的动作
public class ConcreteLogin extends Login {

    private static ConcreteLogin concreteLogin;

    //通过单列，实现一对多的通知
    public static ConcreteLogin getInstance() {
        if (concreteLogin == null) {
            synchronized (ConcreteLogin.class) {
                if (concreteLogin == null) {
                    concreteLogin = new ConcreteLogin();
                }
            }
        }

        return concreteLogin;
    }


    @Override
    public void register(LoginObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(LoginObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void loginNotify(UserBean loginBean) {
        String password = loginBean.getPassword();
        String userName = loginBean.getUserName();

        Boolean success = false;
        //模拟登录
        if (password.contains("123") && userName.contains("123")) {
            success = true;
        }

        for (Object obs : observers) {
            LoginObserver loginObserver = (LoginObserver) obs;
            if (success) {
                Log.v(getClass().getSimpleName(), "登录成功");
                loginObserver.login(loginBean);
            } else {
                Log.v(getClass().getSimpleName(), "登录失败");
            }
        }

    }

    @Override
    public void exitNotify() {
        Log.v(getClass().getSimpleName(), "退出登录");
        for (Object obs : observers) {
            LoginObserver loginObserver = (LoginObserver) obs;
            loginObserver.exit();
        }
    }
}
