package com.heta.service;

import com.heta.entity.OrderView;
import com.heta.repo.OrderViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderViewService {
    @Autowired
    private OrderViewRepository orderViewRepository;

    public void addNewOrderView(OrderView orderView){
        orderViewRepository.addNewOrderView(orderView);
    }

    public OrderView findOrderViewById(int id){
        return orderViewRepository.findOrderViewById(id);
    }

    public List<OrderView> findOrderViewBySellerId(int sellerId){
        return orderViewRepository.findOrderViewBySellerId(sellerId);
    }

    public List<OrderView> findAllOrderView(){
        return orderViewRepository.findAllOrderView();
    }

}
