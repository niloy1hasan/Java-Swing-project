package Backend_Java.DatabaseHelper;

import backend_java.Model.Quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Question_DAO {
    String path = "src/res/TxtDatabase/quiz_question.txt";

    public List<Quiz> getQuizList() {
        List<Quiz> quizList = new ArrayList<>();

        File file = new File(path);

        if (!file.exists()) {
            System.out.println("File not found\n");

            try {
                if (file.createNewFile()) {
                    System.out.println("created");
                    FileWriter writer = new FileWriter(file);
                    writer.write("");
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("can't create");
                return quizList;
            }
        }

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] qData = data.split(" ::: ");
                if (qData.length >= 6) {
                    quizList.add(new Quiz(
                            qData[0],
                            Arrays.asList(qData[1], qData[2], qData[3], qData[4]),
                            Integer.parseInt(qData[5])
                    ));
                } else {
                    System.out.println("invalid question");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

        return quizList;
    }
}
