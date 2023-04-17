package br.com.santos.vinicius.util;

public class FileUtil {

    public static String getSrcFolder() {
        StringBuilder srcFolder = new StringBuilder(System.getProperty("user.dir"));
        srcFolder.append("\\src\\");

        return srcFolder.toString();
    }

    public static String getMainFolderWithPath(String path) {
        StringBuilder srcFolder = new StringBuilder(getSrcFolder());
        srcFolder.append("main\\");
        srcFolder.append(path);

        return srcFolder.toString();
    }

    public static String getRootFolderWithPath(String path) {
        StringBuilder rootFolder = new StringBuilder(System.getProperty("user.dir"));
        rootFolder.append("\\");
        rootFolder.append(path);

        return rootFolder.toString();
    }
}
