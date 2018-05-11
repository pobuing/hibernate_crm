package cn.probuing.crm.web.servlet;

import cn.probuing.crm.domain.Customer;
import cn.probuing.crm.service.CustomerService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/5/11 11:42
 * @Description: 客户添加Servlet
 */
public class AddCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //1.获得参数并封装到customer对象
            Customer customer = new Customer();
            //2.调用service保存客户
            Map<String, String[]> parameterMap = request.getParameterMap();
            BeanUtils.populate(customer, parameterMap);
            //3.重定向到客户列表
            CustomerService customerService = new CustomerServiceImpl();
            customerService.save(customer);
            response.sendRedirect(request.getContextPath() + "/ListCustomerServlet");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
