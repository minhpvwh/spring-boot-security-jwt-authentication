package com.bezkoder.springjwt.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationFailedResponse {

    //    private List<ResponseErrors> violations = new ArrayList<>();
    private ResponseErrors violations = new ResponseErrors("", "server.error", 5000);

//    public List<ResponseErrors> getViolations() {
//        return violations;
//    }

    public ResponseErrors getViolations() {
        return violations;
    }

//    public void setViolations(List<ResponseErrors> violations) {
//        this.violations = violations;
//    }

    public void setViolations(ResponseErrors violations) {
        this.violations = violations;
    }
}

