package cn.probuing.crm.web.action;

import cn.probuing.crm.domain.User;
import cn.probuing.crm.service.UserService;
import cn.probuing.crm.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.Map;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/1 15:47
 * @Description:
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();
    private UserService userService = new UserServiceImpl();

    public String login() throws Exception {
        //调用service执行登录操作
        User u = userService.login(user);
        //将返回的user对象放入session域
        Map<String, Object> map = ActionContext.getContext().getSession();
        map.put("user", u);
        //重定向到项目首页

        return "toHome";
    }

    @Override
    public User getModel() {
        return user;
    }
}
