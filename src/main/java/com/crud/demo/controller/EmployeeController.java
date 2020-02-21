package com.crud.demo.controller;

import com.crud.demo.dao.DepartmentDao;
import com.crud.demo.dao.EmployeeDao;
import com.crud.demo.entities.Department;
import com.crud.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Collections;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表界面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employeeCollections = employeeDao.getAll();
        model.addAttribute("emps", employeeCollections);
        //thymeleaf默认就会拼串
        //classpath:/templates/
        return "emp/list";
    }

    @GetMapping("/add")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //返回添加页面
        return "emp/add";
    }

    //传入参数
    //SpringMvc自动将参数和表单里的属性进行一一绑定，要求请求参数的名字和javabean的属性名字一样
    @PostMapping("/addEmp")
    public String addEmp(Employee employee){
        System.out.println(employee);
        //redirect: 重定向
        //forward： 转发
        employeeDao.save(employee);
        return "redirect:/emps";
    }



}
