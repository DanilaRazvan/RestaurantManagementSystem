package data_layer;

import business_layer.OrderItem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class FileWriter {

    private String PATH = "/media/razvan/New Volume/java_workspace/PT2019_Assignment_4/pt2019_30424_danila_razvan_assignment_4/Assignment_4/";
    private File file;
    private ArrayList<OrderItem> items;
    private int table;

    public FileWriter(int table, ArrayList<OrderItem> items) {
        PATH = PATH.concat("bill" + table + ".txt");
        this.file = new File(PATH);
        createFile();

        this.table = table;
        this.items = items;
    }

    private void createFile() {
        //Create the file
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    public void write() {
        double sum = 0;
        StringBuilder sb = new StringBuilder();
        java.io.FileWriter writer;
        try {
            writer = new java.io.FileWriter(this.file);

            sb.append(new Date().toString() + "\n");
            sb.append("Bill Table " + this.table + "\n");
            sb.append("\nProducts:");
            for(OrderItem oi : this.items) {
                sb.append("\n" + oi.toString());
                sum += oi.getPrice() * oi.getQuantity();
            }

            sb.append("\n\nTotal sum = " + sum);

            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
