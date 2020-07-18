package com.stackroute.rabbitmq.model;

import lombok.Data;

import java.util.List;

@Data
public class CharityStatusList {
    private List<CharityStatus> charityStatusList;

    public CharityStatusList() {
    }

    public CharityStatusList(List<CharityStatus> charityStatusList) {
        this.charityStatusList = charityStatusList;
    }

    public List<CharityStatus> getCharityStatusList() {
        return charityStatusList;
    }

    public void setCharityStatusList(List<CharityStatus> charityStatusList) {
        this.charityStatusList = charityStatusList;
    }

}
