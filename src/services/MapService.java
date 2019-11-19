package services;

import enums.Subjects;
import resources.Constans;

import java.util.HashMap;
import java.util.Map;

public class MapService {

    public static String ShowEnumDoubleMap(Map<Subjects, Double> map) {
        StringBuilder stringResultOfMap = new StringBuilder();
        map.forEach((x, y) ->
                stringResultOfMap.append(x)
                        .append(Constans.DOUBLE_DOT_AND_SPACE)
                        .append(y)
                        .append(Constans.NEW_LINE));
        return stringResultOfMap.toString();
    }
}
