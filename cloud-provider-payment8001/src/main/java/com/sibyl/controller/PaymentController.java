package com.sibyl.controller;

import com.sibyl.entity.CommonResult;
import com.sibyl.entity.Payment;
import com.sibyl.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id) {
        Payment payment = this.paymentService.queryById(id);
        log.info("***********selectById ret => " + payment);
        return new CommonResult<Payment>(200, "select success", payment);
    }

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        Payment insert = this.paymentService.insert(payment);
        log.info("***********insert ret => " + insert);
        return new CommonResult<>(200, "insert success", insert);
    }

    @GetMapping("queryAllByLimit")
    public CommonResult<List<Payment>> queryAllByLimit(@RequestParam(defaultValue = "0") int offset,
                                                       @RequestParam(defaultValue = "10") int limit) {
        List<Payment> payment = this.paymentService.queryAllByLimit(offset, limit);

        return new CommonResult<>(200, "select success", payment);
    }


}
