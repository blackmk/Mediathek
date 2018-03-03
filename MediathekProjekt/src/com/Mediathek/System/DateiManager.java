package com.Mediathek.System;

import java.io.*;
import java.nio.file.Path;
import java.util.LinkedList;

public abstract class DateiManager implements Serializable
{
    public static void dateiSpeichern(String name, LinkedList list)
    {
        try
        {
            File file = new File("Data/"+name+".dat");
            File tmp = new File("Data");
            tmp.mkdir();
            if(file.exists()) {
                if(file.canWrite()) {
                    FileOutputStream fos = new FileOutputStream(file);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(list);
                    oos.close();
                }
            }


        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static LinkedList dateiLaden(String name)
    {
        File tmp = new File("Data");
        tmp.mkdir();
        try
        {
            File file = new File("Data/"+name+".dat");
            if(file.exists()) {
                if(file.canRead()) {
                    FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    LinkedList list = (LinkedList) ois.readObject();
                    if(list.size() == 0)
                        return new LinkedList();
                    return list;
                }
            }else
            {

                if(file.createNewFile())
                {
                    FileOutputStream fos = new FileOutputStream(file);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(new LinkedList<>());
                    oos.close();
                    return new LinkedList();
                }
            }
        }  catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }


}
