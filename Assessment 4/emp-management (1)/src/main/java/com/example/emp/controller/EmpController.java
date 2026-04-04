
package com.example.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

import com.example.emp.dto.EmpDto;
import com.example.emp.entity.Emp;
import com.example.emp.service.EmpService;

@Controller
public class EmpController {
	
    @Autowired
    private EmpService service;

    
    @RequestMapping("/view")
    public ModelAndView viewAll() {
        ModelAndView mv = new ModelAndView("view");
        mv.addObject("list", service.getAll());
        return mv;
    }

   
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Emp e = service.getById(id);

        EmpDto dto = new EmpDto();
        dto.setEmpId(e.getEmpId());
        dto.setEmpName(e.getEmpName());
        dto.setEmpSal(e.getEmpSal());
        dto.setEmpDoj(e.getEmpDoj());
        dto.setDeptName(e.getDeptName());

        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("emp", dto);
        return mv;
    }

    
    @PostMapping("/save")
    public ModelAndView save(@Valid @ModelAttribute("emp") EmpDto dto,
                             BindingResult result) {

        ModelAndView mv = new ModelAndView();

       
        if (result.hasErrors()) {
            mv.setViewName("edit");
            return mv;
        }

        Emp e = new Emp();
        e.setEmpId(dto.getEmpId());
        e.setEmpName(dto.getEmpName());
        e.setEmpSal(dto.getEmpSal());
        e.setEmpDoj(dto.getEmpDoj());
        e.setDeptName(dto.getDeptName());

        service.save(e);

        mv.setViewName("view");
        mv.addObject("msg", "Employee Edited");
        mv.addObject("list", service.getAll());
        return mv;
    }

    
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        service.delete(id);

        ModelAndView mv = new ModelAndView("view");
        mv.addObject("msg", "Employee Deleted");
        mv.addObject("list", service.getAll());
        return mv;
    }
}
		





