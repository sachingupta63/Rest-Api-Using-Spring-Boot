package com.restapi.SpringRestApi.Service;

import com.restapi.SpringRestApi.Entity.Department;
import com.restapi.SpringRestApi.Error.DepartmentNotFoundException;
import com.restapi.SpringRestApi.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentByid(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> dep= departmentRepository.findById(departmentId) ;

        if(!dep.isPresent()){
            throw new DepartmentNotFoundException("Department Not Present By this Id");
        }
        return dep.get();
    }

    @Override
    public void deleteDepartmentById(Long depatmentId) {
        departmentRepository.deleteById(depatmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
         Department depDb=departmentRepository.findById(departmentId).get();

         if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
             depDb.setDepartmentName(department.getDepartmentName());
         }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDb.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDb);

    }

    @Override
    public Department getDepartmentByName(String departmentName) throws DepartmentNotFoundException {
        Department department=departmentRepository.getByDepartmentName(departmentName);
        if(department==null){
            throw new DepartmentNotFoundException("Department With This Name Not exist");
        }
        return department;
    }


}
