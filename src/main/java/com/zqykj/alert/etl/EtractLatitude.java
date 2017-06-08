package com.zqykj.alert.etl;

import java.io.*;

/**
 * Created by zqykj on 2017/5/16.
 */
public class EtractLatitude {

    private String filePath;
    private String outputPath;
    private String separator;


    public EtractLatitude() {
    }

    public EtractLatitude(String filePath, String outputPath, String separator) {
        this.filePath = filePath;
        this.outputPath = outputPath;
        this.separator = separator;
    }

    public void loadFile() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(filePath);
            bufferedReader = new BufferedReader(new FileReader(file));
            bufferedWriter = new BufferedWriter(new FileWriter(outputPath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] dataArr = line.split(separator);
                bufferedWriter.write(dataArr[4] + separator + dataArr[5]);
                bufferedWriter.write("\n");
                System.out.println(dataArr[4] + separator + dataArr[5]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void extract() {

    }

}
