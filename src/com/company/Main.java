package com.company;

import com.ibm.jvm.trace.format.api.ByteStream;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        File sourcefile = new File("sourcefile.txt");

        if(sourcefile.exists()){
            System.out.println("đã tồn tại source file");
        }else{
            System.out.println("chưa tồn tại source file");
           sourcefile.createNewFile();
        }
        FileWriter writersource = new FileWriter(sourcefile);
        writersource.write("hello");
        writersource.write("\n hello guys");
        writersource.flush();
//        writersource.close();
        File destfile = new File("destfile");

        if(destfile.exists()){
            System.out.println("đã tồn tại dest file");
        }else{
            System.out.println("chưa tồn tại dest file");
            destfile.createNewFile();
        }
        FileWriter writerdest = new FileWriter(destfile);
        FileReader fileReader = new FileReader(sourcefile);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = null;

        while((line = reader.readLine()) != null){
            writerdest.write(line);
            writerdest.flush();
        }
        writerdest.close();
    }
}
