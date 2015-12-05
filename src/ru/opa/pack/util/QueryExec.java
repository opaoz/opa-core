package ru.opa.pack.util;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vladimir_Levin on 05.12.2015.
 */
public final class QueryExec {
    public static final Map<String[], List<QuerySolution>> exec(String queryString, Model model) {
        Query query = QueryFactory.create(queryString);

        try (QueryExecution qe = QueryExecutionFactory.create(query, model)) {
            ResultSet resultSet = qe.execSelect();
            List<QuerySolution> results = new ArrayList<>();
            Map<String[], List<QuerySolution>> result = new HashMap<>();
            List<String> resultVars = resultSet.getResultVars();

            while (resultSet.hasNext()) {
                results.add(resultSet.next());
            }

            result.put(resultVars.toArray(new String[resultVars.size()]), results);
            return result;
        }
    }
}

