package com.symplifica.test.service;

import com.symplifica.test.entity.Order;
import com.symplifica.test.entity.Product;
import com.symplifica.test.repository.OrderRepository;
import com.symplifica.test.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void createOrder(List<Integer> productsIds) {
        List<Product> products = productRepository.findAllById(productsIds);
        int orderNo = (int) (orderRepository.count() + 1);
        List<Order> orders = products.stream()
                .map(product -> new Order(orderNo, product))
                .collect(Collectors.toList());
        orderRepository.saveAll(orders);
    }
}
