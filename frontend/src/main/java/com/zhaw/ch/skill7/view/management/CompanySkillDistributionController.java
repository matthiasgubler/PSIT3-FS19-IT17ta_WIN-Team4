package com.zhaw.ch.skill7.view.management;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.view.barchart.AbstractBarChartController;

import java.util.Map;

public class CompanySkillDistributionController extends AbstractBarChartController {

    private static final String TITLE = "Skillverteilung in der Unternehmung pro Mitarbeiter";

    private final ICompany company;

    public CompanySkillDistributionController() {
        this.company = new CompanyData();
    }

    public CompanySkillDistributionController(ICompany company) {
        this.company = company;
    }

    @Override
    protected String getTitle() {
        return TITLE;
    }

    @Override
    protected Map<String, Long> loadBarChartDataWithCount() {
        return company.getSkillDistribution();
    }

}
