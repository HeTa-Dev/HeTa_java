package com.heta.repo;

import com.heta.entity.OrderView;

import java.util.List;

public interface OrderViewRepository {
    public void addNewOrderView(OrderView orderView);
    public OrderView findOrderViewById(int id);
    public List<OrderView> findOrderViewBySellerId(int sellerId);
}
