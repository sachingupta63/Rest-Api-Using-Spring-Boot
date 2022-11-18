package com.restapi.SpringRestApi.Service;

import com.restapi.SpringRestApi.Entity.Department;
import com.restapi.SpringRestApi.Error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentByid(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long depatmentId);

    Department updateDepartmentById(Long departmentId, Department department);

    Department getDepartmentByName(String departmentName) throws DepartmentNotFoundException;
}
