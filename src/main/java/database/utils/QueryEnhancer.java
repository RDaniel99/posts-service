package database.utils;

import static utils.SessionUtils.isProductionEnvironment;

public class QueryEnhancer {

    public static String enhanceQuery(String query) {

        if(isProductionEnvironment()) {

            return query.replace('\"', '\'');
        }

        return query;
    }
}
