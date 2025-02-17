package com.heta.controller;

import com.heta.entity.OrderView;
import com.heta.service.OrderViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heta/orderView")
public class OrderViewController {

    @Autowired
    private OrderViewService orderViewService;

    @PostMapping("/addNewOrderView")
    public void addNewOrderView(@RequestBody OrderView orderView){
        orderViewService.addNewOrderView(orderView);
    }

    @GetMapping("/findOrderViewById/{id}")
    public OrderView findOrderViewById(@PathVariable("id") int id){
        return orderViewService.findOrderViewById(id);
    }

    @GetMapping("/findOrderViewBySellerId/{sellerId}")
    public List<OrderView> findOrderViewBySellerId(@PathVariable("sellerId") int sellerId){
        return orderViewService.findOrderViewBySellerId(sellerId);
    }

    @GetMapping("/findAllOrderView")
    public List<OrderView> findAllOrderView(){
        return orderViewService.findAllOrderView();
    }
}
