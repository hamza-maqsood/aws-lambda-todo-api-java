package todoapp.model;

public class Todo {
    private final String id;
    private String description;
    private Boolean done;
    public Todo(String id, String description, Boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }
    public String getId() {
        return this.id;
    }
    public String getDescription() {
        return this.description;
    }
    public Boolean isDone() {
        return this.done;
    }
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
    public void setIsDone(Boolean isDone) {
        this.done = isDone;
    }
}
