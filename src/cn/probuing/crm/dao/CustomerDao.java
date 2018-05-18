package cn.probuing.crm.dao;

import cn.probuing.crm.domain.Customer;

import java.util.List;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/5/11 11:48
 * @Description:
 */
public interface CustomerDao {
    void save(Customer customer);

    List<Customer> getAllCustomer();
}
