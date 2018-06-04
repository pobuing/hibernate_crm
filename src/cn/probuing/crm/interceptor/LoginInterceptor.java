package cn.probuing.crm.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import java.util.Map;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/4 15:44
 * @Description: 除登录以外的所有方法都拦截
 */
public class LoginInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        //获得session
        Map<String, Object> session = ActionContext.getContext().getSession();
        Object user = session.get("user");
        //获得登录标识
        //判断登陆标识是否存在
        if (user == null) {
            //不存在=> 没有登录 => 重定向到登录界面

            return "toLogin";
        } else {
            //存在=>已经登录=>放行
            return actionInvocation.invoke();
        }
    }
}
