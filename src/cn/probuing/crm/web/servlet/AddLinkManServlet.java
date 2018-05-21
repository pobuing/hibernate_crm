package cn.probuing.crm.web.servlet;

import cn.probuing.crm.dao.CustomerDao;
import cn.probuing.crm.domain.LinkMan;
import cn.probuing.crm.service.LinkManService;
import cn.probuing.crm.service.impl.LinkManServiceImp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/5/21 17:01
 * @Description:
 */
public class AddLinkManServlet extends HttpServlet {
    private LinkManService lms = new LinkManServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得参数并封装到LinkMan中
        LinkMan lm = new LinkMan();
        try {
            BeanUtils.populate(lm,request.getParameterMap());
            //调用service保存lm对象
            lms.save(lm);
            //重定向到LinkMan的列表
            response.sendRedirect(request.getContextPath()+"/listLinkManServlet");

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
