/*
 *author: camesha obi  
 *This program uses inheritance to display id,title and
 *year published of music items via GUI's 
 *
 */

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Manager
{
    //attributes 
    private List<Media> media;
    private int nextId;

    //constructor(s)
    public Manager(){
        media = new ArrayList<Media>();
        nextId = 123;
        loadData("media.txt");
    }

    //method(s)
    public void loadData(){
        loadData("media.txt");
    }

    public List<Media> findItems(String searchTitle){
        List<Media> selectedMedia = new ArrayList<Media>();
        for (Media item : media) {
            if (item.getTitle().equals(searchTitle))
                selectedMedia.add(item);
        }
        return selectedMedia;
    }
    
    public Media rentItem(int id){
        List<Media> selectedMedia = new ArrayList<Media>();
        for (Media item : media) {
            if (item.getId() == id && item.isAvailable()) {
                item.setRented();
                return item;
            }
        }
        return null;
    }
    

    public void loadData(String fname){
        File dataFile = new File(fname);
        try {//Catch errors
            Scanner fileScanner = new Scanner(dataFile);
            //String aLine = "";
            fileScanner.nextLine();     //ignore first line in file
            while(fileScanner.hasNextLine()) {
                String[] fields = fileScanner.nextLine().trim().split("\\|");
                switch(fields[0].charAt(0)){
                    case 'B':
                    media.add(new EBook(nextId++, fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3])));
                    break;
                    case 'C':
                    media.add(new MusicCD(nextId++, fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3])));
                    break;
                    case 'D':
                    media.add(new MovieDVD(nextId++, fields[1], Integer.parseInt(fields[2]), Double.parseDouble(fields[3])));
                    break;
                    default:
                    System.out.printf("Invalid media type: %s, %s, %s, %s\n", fields[0], fields[1], fields[2], fields[3]);
                }
            }
            fileScanner.close();//close scanner
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
