package cn.probuing.crm.web.action;

import cn.probuing.crm.domain.Customer;
import cn.probuing.crm.service.CustomerService;
import cn.probuing.crm.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/5/24 09:51
 * @Description:Customer的Action类
 */
public class CustomerAction extends ActionSupport {
    private CustomerService cs = new CustomerServiceImpl();

    public String list() throws Exception {
        // 1. 接收页面参数
        String cust_name = ServletActionContext.getRequest().getParameter("cust_name");
        // 2. 创建Hibernate的离线查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        // 3.判断参数拼装条件
        if (StringUtils.isNotBlank(cust_name)) {
            dc.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
        }
        // 4.调用service将离线对象传递
        List<Customer> allCustomer = cs.getAllCustomer(dc);
        // 5.将返回的list放入request域，转发到list.jsp
        ServletActionContext.getRequest().setAttribute("list", allCustomer);
        return "list";

    }
}
