package cn.probuing.crm.service.impl;

import cn.probuing.crm.dao.CustomerDao;
import cn.probuing.crm.dao.impl.CustomerDaoImpl;
import cn.probuing.crm.domain.Customer;
import cn.probuing.crm.service.CustomerService;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/5/11 11:50
 * @Description:
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public void save(Customer customer) {

    }
}
