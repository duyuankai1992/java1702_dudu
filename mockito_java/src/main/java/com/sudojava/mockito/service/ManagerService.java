package com.sudojava.mockito.service;

import com.sudojava.mockito.domain.Manager;

import java.util.List;

public class ManagerService {

    private List<Manager> managers;

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }

    public String findManagerNameByID(String id){
        if (!managers.isEmpty()){
            for (Manager manager:managers){
                if (manager.getId().equals(id)){
                    return manager.getName();
                }
            }
        }
        return null;
    }
}
