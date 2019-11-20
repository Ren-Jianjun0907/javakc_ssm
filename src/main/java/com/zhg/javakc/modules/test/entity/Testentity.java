package com.zhg.javakc.modules.test.entity;

import com.zhg.javakc.base.entity.BaseEntity;

import java.util.Date;

/**
 * @author :任建军
 * @date: 2019/11/19
 **/

public class Testentity extends BaseEntity<Testentity> {

    private String testId;
    private String testName;
    private String testSex;

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    private Date testDate;

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestSex() {
        return testSex;
    }

    public void setTestSex(String testSex) {
        this.testSex = testSex;
    }


}
