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
        OrderView orderView = orderViewRepository.findOrderViewById(id);
        orderView.setImagePathList(List.of(orderView.getImagePathList().get(0).split(",")));
        return orderView;
    }

    public List<OrderView> findOrderViewBySellerId(int sellerId){
        List<OrderView> orderViewList = orderViewRepository.findOrderViewBySellerId(sellerId);
        for(OrderView orderView: orderViewList){
            orderView.setImagePathList(List.of(orderView.getImagePathList().get(0).split(",")));
        }
        return orderViewList;
    }

    public List<OrderView> findAllOrderView(){
        List<OrderView> orderViewList = orderViewRepository.findAllOrderView();
        for(OrderView orderView: orderViewList){
            orderView.setImagePathList(List.of(orderView.getImagePathList().get(0).split(",")));
        }
        return orderViewList;
    }

    public List<OrderView> findOrderViewByItemName(String itemName){
        List<OrderView> orderViewList = orderViewRepository.findOrderViewByItemName(itemName);
        for(OrderView orderView: orderViewList){
            orderView.setImagePathList(List.of(orderView.getImagePathList().get(0).split(",")));
        }
        return orderViewList;
    }

}
