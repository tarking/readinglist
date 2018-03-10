package com.tarking.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by tuojinguo on 2018/3/10.
 */
@Component
@ConfigurationProperties(prefix = "amazon")
public class Advertiser {

    private String associateId;
    private String email;
    private String address;

    public String getAssociateId() {
        return associateId;
    }

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
