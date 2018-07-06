
package com.supplychain.controller;

import com.supplychain.model.Ad;

import com.supplychain.service.AccountService;
import com.supplychain.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private RedisService redisService;


	@RequestMapping("/helloRedis")
	public String helloRedis() {
       String value = redisService.getStr("aaaa");
		return value;
	}

    @RequestMapping("/helloMybatis")
    public String helloMybatis() {
	    Ad ad = accountService.selectByPrimaryKey(37);
        return ad.getDetaillink();
    }




	@ResponseBody
	@RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
	public int addUser(Ad ad){

		return accountService.addUser(ad);
	}


}
