package mz.ac.ucmins.Model;

import java.io.Serializable;

public class ItemResult implements Serializable {

    private String phone, name, lastname;
    private int img;
    private boolean isSelected;


    public ItemResult(String phone, String name, int img, boolean isSelected) {
        this.phone = phone;
        this.name = name;
        this.img = img;
        this.isSelected = isSelected;
    }

    public ItemResult() {

    }

    public ItemResult(AnalysisResquest aR, Patient patient) {
        phone = patient.getMobilePhone();
        name = patient.getFirstname();
        lastname = patient.getSurname();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public boolean isSelected() {
        return isSelected;
    }
}
