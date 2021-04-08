package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException{
        // Creeaza un program care citeste numerele din cele 3 fisiere atasate.Dupa citire , aceste numere vor fi sortate in
        // ordine crescatoare si vor fi scrise intr-un fisier nou denumit "rezultat.txt". Pe prima linie se va scrie cel
        // mai mare numar dintre cele citite, urmat numarul total de elemente citite din cele 3 fisiere. (raspuns : 991 44)
        String filePath = "C:\\Cristiana\\curs\\PLATFORMA IT\\ProiecteJava\\exIO\\";
        String fileName = "rezultat.txt";
        File finalFile = new File(filePath + fileName);
        int numberOfNumbers = 0;
        //crearea fisierului rezultat.txt
        if (finalFile.createNewFile()) {
                System.out.println("Fisierul a fost creat: " + finalFile.getName());
            } else {
                System.out.println("Fisierul exista deja.");
            }
        System.out.println(finalFile.getAbsolutePath());

        //citire fisier 1
        FileReader file1 = new FileReader("fisier1.txt");
        BufferedReader reader = new BufferedReader(file1);
        ArrayList<Integer> dataFile = new ArrayList<Integer>();
        String line = " ";
        while ((line = reader.readLine()) != null) {
                dataFile.add(Integer.parseInt(line));
                numberOfNumbers++;
            }
        //citire fisier 2
        FileReader file2 = new FileReader("fisier2.txt");
        BufferedReader reader1 = new BufferedReader(file2);
        while ((line = reader1.readLine()) != null) {
                dataFile.add(Integer.parseInt(line));
                numberOfNumbers++;
            }
        //citire fisier 3
        FileReader file3 = new FileReader("fisier3.txt");
        BufferedReader reader2 = new BufferedReader(file3);
        while ((line = reader2.readLine()) != null) {
                dataFile.add(Integer.parseInt(line));
                numberOfNumbers++;
            }
        reader.close();
        //Sortarea datelor din ArrayList
        Collections.sort(dataFile);


        //Scrierea finala a rezultatului
        FileWriter fileWriter=new FileWriter("rezultat.txt");
        fileWriter.write(String.valueOf(numberOfNumbers));
        System.out.print(numberOfNumbers+" ");
        fileWriter.write(" ");
        fileWriter.write(Collections.max(dataFile).toString());
        System.out.println(Collections.max(dataFile));
        for(Integer s: dataFile){
                    fileWriter.write("\r\n");
                    fileWriter.write(s.toString());
                    System.out.println(s);
                }
        fileWriter.close();

        }
    }
