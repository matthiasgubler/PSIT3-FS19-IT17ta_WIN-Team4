package com.zhaw.ch.skill7.view.admin;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.interfaces.ICompany;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Observable;

public class AdminDevelopmentBatchController extends Observable {
    private final ICompany company;

    private AdminDevelopmentTableController AdminDevelopmentTableController;

    @FXML
    private TextField newDevelopmentSkillTextField;

    public AdminDevelopmentBatchController() {
        this.company = new CompanyData();
    }

    public AdminDevelopmentBatchController(ICompany company) {
        this.company = company;
    }

    private void setChangedAndNotify() {
        setChanged();
        notifyObservers();
    }

    public AdminDevelopmentTableController getAdminDevelopmentTableController() {
        return AdminDevelopmentTableController;
    }

    public void setAdminDevelopmentTableController(AdminDevelopmentTableController AdminDevelopmentTableController) {
        this.AdminDevelopmentTableController = AdminDevelopmentTableController;
    }
}
