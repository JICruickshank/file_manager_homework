package models;

import models.File;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="folders")

public class Folder {

    private String title;
    private Set<File> files;
    private int id;

    public Folder() {
    }

    public Folder(String title) {
        this.title = title;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToMany(mappedBy="folder", fetch = FetchType.LAZY)
    public Set<File> getFiles() {
        return files;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
