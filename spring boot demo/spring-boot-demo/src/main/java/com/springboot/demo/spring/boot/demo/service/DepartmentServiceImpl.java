package com.springboot.demo.spring.boot.demo.service;

import com.springboot.demo.spring.boot.demo.Exceptions.DepartmentNotFoundException;
import com.springboot.demo.spring.boot.demo.entity.Department;
import com.springboot.demo.spring.boot.demo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.springboot.demo.spring.boot.demo.Util.UtilClass.notNullAndEmpty;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        //findById method will return optional
        // if there is no department found then throw custom exception
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("department not found for id " + departmentId);
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        // get the department based on id
        // update it with new values and save it
        // check if field is not null and blank and then update it with new value

        Department dpt = departmentRepository.findById(departmentId).get();
        // create a utility method for checking not null and blank parameters.
        if (notNullAndEmpty(department.getName())) {
            dpt.setName(department.getName());
        }
        if (notNullAndEmpty(department.getAddress())) {
            dpt.setAddress(department.getAddress());
        }
        if (notNullAndEmpty(department.getCode())) {
            dpt.setCode(department.getCode());
        }
        return departmentRepository.save(dpt);
    }
}
