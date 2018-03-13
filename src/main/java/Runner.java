import db.DBHelper;
import models.File;
import models.Folder;
import models.Owner;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Owner owner1 = new Owner("J", "J1982");
        DBHelper.saveOrUpdate(owner1);
        Owner owner2 = new Owner("Rio", "Rio6");
        DBHelper.saveOrUpdate(owner2);

        Folder folder1 = new Folder("wee_folder", owner1);
        DBHelper.saveOrUpdate(folder1);
        Folder folder2 = new Folder("big_folder", owner2);
        DBHelper.saveOrUpdate(folder2);;
        Folder folder3 = new Folder("bigger_folder", owner1);
        DBHelper.saveOrUpdate(folder3);;

        File file1 = new File("new_file", "txt", 10, folder1);
        DBHelper.saveOrUpdate(file1);

        File toDelete = new File("to_delete", "txt", 20, folder1);
        DBHelper.saveOrUpdate(toDelete);
        DBHelper.delete(toDelete);
        List<File> files = DBHelper.getAll(File.class);

        File file2 = new File("another_new_file", "txt", 20, folder1);
        DBHelper.saveOrUpdate(file2);
        List<File> filesInFolder = DBHelper.getFilesFromFolder(folder1);

        List<Folder> foldersByOwner = DBHelper.ListOfFoldersForOwner(owner1);
    }
}
