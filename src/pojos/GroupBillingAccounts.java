/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author Julio Lopez
 */
public class GroupBillingAccounts {
    private String id;
    private String GroupName;

    public GroupBillingAccounts() {
    }

    public GroupBillingAccounts(String id, String GroupName) {
        this.id = id;
        this.GroupName = GroupName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }
}
