package com.supplychain.service;


import com.supplychain.mapper.AdMapper;
import com.supplychain.model.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountService {


	@Autowired
	private AdMapper adMapper;


	public int addUser(Ad user) {
		return adMapper.insert(user);
	}

    public Ad selectByPrimaryKey(Integer id) {
        return adMapper.selectByPrimaryKey(id);
    }
}
