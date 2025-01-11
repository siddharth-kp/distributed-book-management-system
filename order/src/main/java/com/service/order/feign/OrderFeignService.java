package com.service.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="BOOK")
public interface OrderFeignService {
    @GetMapping("/{id}")
    public ResponseEntity<Object> getBook(@PathVariable int id);

    @GetMapping("/quantity/{id}")
    public ResponseEntity<Integer> getQuantity(@PathVariable int id);


    @GetMapping("setQuantity/{id}/{quantity}")
    public ResponseEntity<Object> setQuantity(@PathVariable int id, @PathVariable int quantity);
}
