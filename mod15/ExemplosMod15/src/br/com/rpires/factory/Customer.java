package br.com.rpires.factory;

/**
 * @author rodrigo.pires
 */
public class Customer {

    private String gradeRequest;
    private boolean hasCompanyContract;

    public Customer(String gradeRequest, boolean hasCompanyContract) {
        this.gradeRequest= gradeRequest;
        this.hasCompanyContract = hasCompanyContract;
    }
    public boolean hasCompanyContract() {
        return hasCompanyContract;
    }
    public String getGradeRequest() {
        return gradeRequest;
    }
}
