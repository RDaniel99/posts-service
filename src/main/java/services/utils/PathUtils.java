package services.utils;

public final class PathUtils {

    public static Integer getEntityId(String path) {

        String[] urlData = path.split("/");
        return Integer.parseInt(urlData[1]);

    }
}

