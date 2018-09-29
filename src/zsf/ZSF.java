/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zsf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author amir
 */
public class ZSF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream in=new FileInputStream("Sample.txt");
        BufferedInputStream bin=new BufferedInputStream(in);
        int sizeBefore=bin.available();
        //----------------------------------------------------
        FileOutputStream out=new FileOutputStream("Amir.zip");
        BufferedOutputStream bout=new BufferedOutputStream(out);
        ZipOutputStream zout=new ZipOutputStream(bout);
        ZipEntry ze=new ZipEntry("file.txt");
        zout.putNextEntry(ze);
        //---------------------------------------------------- 
        while (true){
            int b = bin.read();
            if (b == -1) break;
            zout.write(b);
        }
         zout.close();
        bin.close();
        in.close();
        in=new FileInputStream("Amir.zip");
        double sizeAfter=in.available();
        
        System.out.println(sizeBefore/1000+"KB"+"\n"+sizeAfter/1000+"KB");
        System.out.println("IMPROVEMENT= "+(int)(sizeBefore/sizeAfter) + "%");
    }
    
}
