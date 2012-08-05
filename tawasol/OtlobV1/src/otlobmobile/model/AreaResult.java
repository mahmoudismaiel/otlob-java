/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.model;

/**
 *
 * @author Mahmoud.Ismail
 */
public class AreaResult {
    
    private Area area;
    private BranchForMobile branch;
    private Provider provider;

    public AreaResult() {
    }

    public AreaResult(Area area, BranchForMobile branch, Provider provider) {
        this.area = area;
        this.branch = branch;
        this.provider = provider;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public BranchForMobile getBranch() {
        return branch;
    }

    public void setBranch(BranchForMobile branch) {
        this.branch = branch;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    } 
    
}
