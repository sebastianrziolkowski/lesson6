package models;

import enums.GroupSymbol;
import enums.Subjects;
import resources.Constans;
import services.MapService;
import services.ScannerHelper;
import services.StringHelper;

import java.util.*;

public class Student {
    private String name;
    private String surname;
    private GroupSymbol groupSymbol;
    private Map<Subjects, String> grades = new HashMap<>();


    public void readData() {
        System.out.println("Name: ");
        name = ScannerHelper.scanNextLine();
        System.out.println("Surname: ");
        surname = ScannerHelper.scanNextLine();
        System.out.println("Symbol of group: ");
        groupSymbol = ScannerHelper.scanGroupSymbolEnum();
        System.out.println("Grades for: ");
        grades = loadGrades();

    }

    private Map<Subjects, Double> calculateAvgGrade() {
        Map<Subjects, Double> mapOfGrades = new HashMap<>();
        List<Double> listOfGrades = new ArrayList<>();
        grades.forEach((x, y) ->
                mapOfGrades.put(x, StringHelper.convertStringOfDoubeToListOfDouble(y).stream().mapToDouble(f -> f).sum() / StringHelper.convertStringOfDoubeToListOfDouble(y).size()));

        return mapOfGrades;
    }

    private Map<Subjects, String> loadGrades() {
        Map<Subjects, String> gradesMap = new HashMap<>();
        for (Subjects subject : Subjects.values()) {
            System.out.println(subject + ": ");
            String tmp = ScannerHelper.scanNextLine();
            gradesMap.put(subject, tmp);
        }
        return gradesMap;
    }

    private String gradesToString() {
        StringBuilder gradesSBuilder = new StringBuilder();
        grades.forEach((x, y) ->
                gradesSBuilder.append(x)
                        .append(Constans.DOUBLE_DOT_AND_SPACE)
                        .append(y)
                        .append(Constans.NEW_LINE));
        return gradesSBuilder.toString();
    }


    public String writeData() {
        StringBuilder student = new StringBuilder();
        student.append(Constans.NAME).append(Constans.DOUBLE_DOT_AND_SPACE)
                .append(name)
                .append(Constans.NEW_LINE)
                .append(Constans.SURNAME).append(Constans.DOUBLE_DOT_AND_SPACE)
                .append(surname)
                .append(Constans.NEW_LINE)
                .append(Constans.SYMBOL_OF_GROUP).append(Constans.DOUBLE_DOT_AND_SPACE)
                .append(groupSymbol)
                .append(Constans.NEW_LINE)
                .append(gradesToString())
                .append(Constans.NEW_LINE)
                .append("Avg of grades: ")
                .append(MapService.ShowEnumDoubleMap(calculateAvgGrade()));

        return student.toString();
    }


}
