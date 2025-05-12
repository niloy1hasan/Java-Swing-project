package Backend_Java.DatabaseHelper;

import Backend_Java.Model.Result;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leaderboard_DAO {
    String path = "src/res/TxtDatabase/leaderboard.txt";

    public List<Result> getLeaderboard() {
        List<Result> leaderboard_Data = new ArrayList<>();

            File leaderbaord = new File(path);

            if (!leaderbaord.exists()) {
                System.out.println("File not found\n");

                try {
                    if (leaderbaord.createNewFile()) {
                        System.out.println("leaderboard file created");
                    }
                } catch (Exception e) {
                    System.out.println("file can't create");
                    return new ArrayList<>();
                }
            }


            try {
                Scanner scanner = new Scanner(leaderbaord);
                String data;
                while (scanner.hasNextLine()) {
                    data = scanner.nextLine();
                    String[] lData = data.split(" ::: ");
                    leaderboard_Data.add(new Result(lData[0], LocalDateTime.parse(lData[1]), Double.parseDouble(lData[2])));
                }

                scanner.close();
                return leaderboard_Data;
            } catch (FileNotFoundException e) {
                System.out.println("File can't read");
            }

        return new ArrayList<>();
        }


    public void addOnLeaderboard(Result newResult){
        try {
            FileWriter writer = new FileWriter(path, true);
            String data = newResult.getPersonName() + " ::: " + newResult.getTime() + " ::: " + newResult.getMark() + "\n";
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            System.out.println("File is not found");
        }
    }

}
