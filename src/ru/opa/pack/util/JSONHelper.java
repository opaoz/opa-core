package ru.opa.pack.util;

import org.apache.jena.query.QuerySolution;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Vladimir_Levin on 05.12.2015.
 */

public final class JSONHelper {
    public static String generateJSONResponse(Map<String[], List<QuerySolution>> map) {
        Map.Entry<String[], List<QuerySolution>> item = map.entrySet().iterator().next();
        String[] vars = item.getKey();
        List<QuerySolution> values = item.getValue();

        JSONArray result = values.stream().map(qs -> generateJSONObject(vars, qs)).collect(Collectors.toCollection(() -> new JSONArray()));

        return result.toJSONString();
    }

    public static JSONObject generateJSONObject(String[] vars, QuerySolution qs) {
        JSONObject result = new JSONObject();
        for (String var : vars) {
            result.put(var, (qs.get(var) == null ? "null" : qs.get(var)).toString());
        }

        return result;
    }
}
