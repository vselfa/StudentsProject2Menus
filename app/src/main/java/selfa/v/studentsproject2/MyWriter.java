package selfa.v.studentsproject2;

import android.graphics.drawable.Drawable;

public class MyWriter {

    String name;    // The name of the writer
    Integer photo;  // R.drawable.name_of_pictures
    Drawable picture;

    public MyWriter(String name, Integer photo) {
        this.name = name;
        this.photo = photo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPhoto() {
        return photo;
    }
    public void setPhoto(Integer photo) {
        this.photo = photo;
    }
}
