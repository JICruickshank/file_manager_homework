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
    private Owner owner;

    public Folder() {
    }

    public Folder(String title, Owner owner) {
        this.title = title;
        this.owner = owner;
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

    @ManyToOne
    @JoinColumn(name="owner_id", nullable = false)
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
