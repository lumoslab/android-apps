package fsktm.um.edu.sqlite3;

public class Student {
    private String id;
    private String name;
    private String isBookmark;

    public Student(String id, String name, String isBookmark) {
        this.id = id;
        this.name = name;
        this.isBookmark = isBookmark;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsBookmark() {
        return isBookmark;
    }

    public void setIsBookmark(String isBookmark) {
        this.isBookmark = isBookmark;
    }
}
