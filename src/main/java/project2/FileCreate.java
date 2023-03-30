package project2;

import java.io.*;
import java.util.ArrayList;

public class FileCreate{

    private String email;
    private String file_name;
    private int count;
    private String username;
    private String password;


    public void createFolder(){

    }
    public static ArrayList<String> readFile(String file_name) throws IOException {
        BufferedReader reader_file = new BufferedReader(new FileReader(file_name + ".txt"));
        String line;
        ArrayList<String> users = new ArrayList<>();
        while ((line = reader_file.readLine()) != null){
            users.add(line);
        }
        return users;
    }
    public static void addData(String username, String password, String email, String file_name){
        try {
            ArrayList<String> users = readFile(file_name);
            users.add(username);
            users.add(password);
            users.add(email);
            FileOutputStream fileOutputStream = new FileOutputStream(file_name + ".txt");
            for (int i = 0; i < users.size(); i++){
                fileOutputStream.write((users.get(i) + "\n").getBytes());
            }
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void upData(String file_name, ArrayList<String> users) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file_name + ".txt");
        for (int i = 0; i < users.size(); i++){
            fileOutputStream.write((users.get(i) + "\n").getBytes());
        }
        fileOutputStream.close();
    }
    public boolean checkData(String username, String password, int count){
        try {
            ArrayList<String> users = readFile("Users");
            switch (count) {
                case 1:
                    for (int i = 0; i < users.size(); i += 3) {
                        if (username.contains(users.get(i))) {
                            return true;
                        }
                    }
                case 2:
                    for (int i = 0; i < users.size(); i += 3) {
                        if (username.contains(users.get(i)) && password.contains(users.get(i + 1))) {
                            return true;
                        }
                    }
                break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static void resetPassword(String username, String password, String file_name) throws IOException{
        ArrayList<String> users = readFile("Users");
        for (int i = 0; i < users.size(); i += 3){
            if (username.contains(users.get(i))){
                users.set(i + 1, password);
                upData(file_name, users);
            }
        }
    }

    public void logic(){
        if(checkData(username, "", 1)){
            ResetPassword reset_password = new ResetPassword();
            reset_password.setLabel("username not exist");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public FileCreate(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public FileCreate(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public FileCreate(String username, String password, int count) {
        this.username = username;
        this.password = password;
    }

    public FileCreate(){}

}
