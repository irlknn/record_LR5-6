package ItemsOfMenu.fileWork;

import HelperClasses.InputFromUser;
import menu.MenuItem;
import objectHierarchy.Record;
import objectHierarchy.RecordCollection;
import ItemsOfMenu.RecordCollectionManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LoadToFile implements MenuItem {
    RecordCollectionManager rcm = RecordCollectionManager.getRecordManager();

    @Override
    public void execute() {
        InputFromUser inputFromUser = new InputFromUser();
        System.out.println("Choose collection to save" + "\nEnter name of collection");

        String name = inputFromUser.getCollectionNameByIndex();
        StringBuilder text;

        try {
            text = buildText(name);
        }catch (NullPointerException e){
            System.out.println("There is no such collection");
            return;
        }

        Path filename = Path.of(createFile(name));

        try {
            Files.writeString(filename, text.toString());
        } catch (IOException e) {
            System.out.println("An error occurred.");
            throw new RuntimeException(e);
        }
    }

    private StringBuilder buildText (String collectionName){
        RecordCollection collection = rcm.getCollection(collectionName);
        List<Record> collectionList = collection.getCollectionList();

        StringBuilder text = new StringBuilder();
        for(Record r : collectionList){
            String name = r.getName();
            String style = r.getStyle();
            String duration = r.getDuration().toString();
            text.append(name).append(",").append(style).append(",").append(duration).append(",").append("\n");
        }
        return text;
    }

    private  String createFile(String  name) {
        String fileName = "D:\\file\\record application\\" + name + ".txt";
        System.out.println("File name: " + fileName);
        File file = new File(fileName);
        boolean isCreated;
        try {
            isCreated = file.createNewFile();
        } catch (IOException e) {
            System.out.println("File with this name already exist");
            return "";
        }
        System.out.println("Was file created -- " + isCreated);
        return fileName;
    }
}
