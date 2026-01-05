package GESTORTAREASESTUDIANTE;

import java.util.StringJoiner;

public class Tarea {
    private String title;
    private String description;
    private boolean check;

    public Tarea(String title,String description){
        this.title=title;
        this.description=description;

    }
    public Tarea(){
        title=null;
        description=null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public String toString() {
        String estado = check ? "[X]" : "[ ]";
        return estado + " " + title.toUpperCase() + "\n      Descripcion: " + description;
    }
}
