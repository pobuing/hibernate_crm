package cn.probuing.crm.service;

import cn.probuing.crm.domain.Customer;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/5/11 11:47
 * @Description:
 */
public interface CustomerService {

    /**
     * 保存客户信息customer
     *
     * @param customer
     */
    public void save(Customer customer);
}
