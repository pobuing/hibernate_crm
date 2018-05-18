package cn.probuing.crm.web.servlet;

import cn.probuing.crm.domain.Customer;
import cn.probuing.crm.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/5/16 10:00
 * @Description:
 */
public class ListCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用Service查询所有客户
        CustomerServiceImpl cs = new CustomerServiceImpl();
        List<Customer> list = cs.getAllCustomer();
        //将客户列表存入域对象中
        request.setAttribute("list", list);
        //转发到list传到页面中
        request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);

    }
}
