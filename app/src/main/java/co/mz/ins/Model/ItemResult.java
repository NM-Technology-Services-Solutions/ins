package co.mz.ins.Model;

public class ItemResult {

    private String phone, name;
    private int img;

    public ItemResult(String phone, String name, int img) {
        this.phone = phone;
        this.name = name;
        this.img = img;
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
}
