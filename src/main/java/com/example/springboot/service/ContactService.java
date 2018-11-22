package com.example.springboot.service;

import com.example.springboot.mapper.ContactMapper;
import com.example.springboot.model.Contact;

import java.util.List;

public interface ContactService{
    int deleteByPrimaryKey(Integer id);

    int insert(Contact record);

    int insertSelective(Contact record);

    Contact selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contact record);

    int updateByPrimaryKey(Contact record);

    List<Contact> getList(int pageNum, int pageSize);
}
