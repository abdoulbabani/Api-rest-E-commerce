package com.ecommerce.serviceimpl;

import com.ecommerce.dao.OrderProductDao;
import com.ecommerce.modal.OrderProduct;
import com.ecommerce.service.OrderProductService;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {
    @Autowired
    private OrderProductDao orderProductDao;




    @Override
    public OrderProduct create(
            @NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct) {
        return this.orderProductDao.save(orderProduct);
    }
}
