import db.DBHelper;
import models.File;
import models.Folder;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Folder folder1 = new Folder("wee_folder");
        DBHelper.saveOrUpdate(folder1);

        File file1 = new File("new_file", "txt", 10, folder1);
        DBHelper.saveOrUpdate(file1);

        File toDelete = new File("to_delete", "txt", 20, folder1);
        DBHelper.saveOrUpdate(toDelete);
        DBHelper.delete(toDelete);
        List<File> files = DBHelper.getAll(File.class);

        File file2 = new File("another_new_file", "txt", 20, folder1);
        DBHelper.saveOrUpdate(file2);
        List<File> filesInFolder = DBHelper.getFilesFromFolder(folder1);
    }
}
