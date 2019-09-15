package com.ninova.mlc.po;

import java.sql.Timestamp;

public class verf_code_form {
    private String email;



    private String verf_code;

    private Timestamp time;

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getVerf_code() {
        return verf_code;
    }

    public void setVerf_code(String verf_code) {
        this.verf_code = verf_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
