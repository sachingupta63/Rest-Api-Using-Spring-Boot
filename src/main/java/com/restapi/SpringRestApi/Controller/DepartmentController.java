package com.restapi.SpringRestApi.Controller;

import com.restapi.SpringRestApi.Entity.Department;
import com.restapi.SpringRestApi.Error.DepartmentNotFoundException;
import com.restapi.SpringRestApi.Service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger logger= LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        logger.info("Post Method Called");
            return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetDepartmentList(){
        logger.info("Get Method Called");
        return departmentService.fetchDepartmentList();

    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentByid(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long depatmentId){
        departmentService.deleteDepartmentById(depatmentId);
        return "Department Deleted Successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId,@RequestBody Department department){
        return departmentService.updateDepartmentById(departmentId,department);
    }
    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName) throws DepartmentNotFoundException {
        return departmentService.getDepartmentByName(departmentName);
    }
}
