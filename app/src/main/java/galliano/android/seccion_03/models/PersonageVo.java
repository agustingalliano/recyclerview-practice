package galliano.android.seccion_03.models;

public class PersonageVo {

    private String name;
    private String info;
    private int photo;

    public PersonageVo(String name, String info, int photo) {
        this.name = name;
        this.info = info;
        this.photo = photo;
    }

    public PersonageVo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
