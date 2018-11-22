package com.example.springboot.Controller;
import com.example.springboot.SpringbootApplication;
import com.example.springboot.model.*;
import com.example.springboot.service.ContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@RestController
@RequestMapping("/Contact")
@Api(tags = "ContactController", description = "通讯录管理")
public class ContactController {

    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(SpringbootApplication.class);
    @Autowired
    private ContactService contactService;

    @ApiOperation(value = "获取联系人集合",notes = "根据url后面跟的参数来获取分页数据 页码：pageNum 行数：pageSize")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "pageSize", value = "行数", required = true, dataType = "Long")
    })
    @RequestMapping(value = "/all/{pageNum}/{pageSize}",produces={"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public List<Contact> getContactList(@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize)
    {
        logger.info("获取联系人集合：参数pageNum:{0},pageSize:{1}",pageNum,pageSize);
        List<Contact> list=contactService.getList(pageNum,pageSize);
        logger.info("获取联系人集合：结果-获取条数:{0}",list.size());
        return list;
    }
    @ApiOperation(value = "根据id获取联系人",notes = "根据url后面跟id获取联系人信息")
    @ApiImplicitParam(name = "id", value = "联系人id", required = true, dataType = "Long")
    @RequestMapping(value = "/get/{id}",produces={"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public Contact getContact(@PathVariable("id") int id)
    {
        logger.info("根据id获取联系人：id:{0}",id);
        Contact contact =contactService.selectByPrimaryKey(id);
        logger.info("根据id获取联系人：结果：{0}",contact == null ? false:true);
        return contact;
    }

    @ApiOperation(value = "修改联系人信息",notes = "根据Contact对象更新联系人信息")
    @ApiImplicitParam(name = "contact", value = "联系人实体", required = true, dataType = "Contact")
    @RequestMapping(value = "/put",produces={"application/json;charset=UTF-8"},method = RequestMethod.PUT)
    public int editContact(Contact contact)
    {
        logger.info("修改联系人信息：id:{0},name:{1}",contact.getId(),contact.getName());
        int result = contactService.updateByPrimaryKey(contact);
        logger.info("修改联系人信息：结果:{0}",result);
        return result;
    }
    @ApiOperation(value = "新增联系人信息",notes = "根据Contact对象添加联系人信息")
    @ApiImplicitParam(name = "contact", value = "联系人实体", required = true, dataType = "Contact")
    @RequestMapping(value = "/post",produces={"application/json;charset=UTF-8"},method = RequestMethod.POST)
    public int addContact(Contact contact)
    {
        logger.info("新增联系人信息：name:{0},phone:{1}",contact.getName(),contact.getPhone());
        int result = contactService.insert(contact);
        logger.info("新增联系人信息：结果:{0}",result);
        return result;
    }
    @ApiOperation(value = "删除联系人",notes = "根据url后面跟id删除联系人信息")
    @ApiImplicitParam(name = "id", value = "联系人id", required = true, dataType = "Long")
    @RequestMapping(value = "/delete/{id}",produces={"application/json;charset=UTF-8"},method = RequestMethod.DELETE)
    public int delContact(@PathVariable("id") int id)
    {
        logger.info("删除联系人信息：id:{0}",id);
        int result = contactService.deleteByPrimaryKey(id);
        logger.info("删除联系人信息：结果:{0}",result);
        return result;
    }
}
