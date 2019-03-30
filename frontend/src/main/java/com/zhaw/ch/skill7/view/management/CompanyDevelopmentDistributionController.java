package com.zhaw.ch.skill7.view.management;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.view.barchart.AbstractBarChartController;

import java.util.Map;

public class CompanyDevelopmentDistributionController extends AbstractBarChartController {

    private static final String TITLE = "Enticklungsbedarf in der Unternehmung pro Mitarbeiter";

    private final ICompany company;

    public CompanyDevelopmentDistributionController() {
        this.company = new CompanyData();
    }

    public CompanyDevelopmentDistributionController(ICompany company) {
        this.company = company;
    }

    @Override
    protected String getTitle() {
        return TITLE;
    }

    @Override
    protected Map<String, Long> loadBarChartDataWithCount() {
        return company.getDevelopmentDistribution();
    }
}
