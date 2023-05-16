package sg.nus.edu.visa.ssf.workshop12.model;

//This is done to populate image data (for all Pojo classes)
public class Image {
    
    private String name;
    private String path; 

//Just create constructor although you might not need it
public Image(String name, String path) {
    this.name = name;
    this.path = path;
}

//Getter and Setters 
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }


//Create toString as well
@Override
    public String toString() {
        return "Image [name=" + name + ", path=" + path + "]";
    }
    

}
