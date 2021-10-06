package com.shop.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.ecommerce.domain.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
