package com.dilatoit.eagletest.validate.filetree;

import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Salt on 2017/9/24.
 */
public class FileTreeUtil {

    public FileTree translateToFileTree(@NotNull String filePath, String baseFilePath){
        //创建新node节点
        FileTree fileTree = new FileTree();

        //设置当前节点信息
        File file = new File(filePath);
        fileTree.setId(file.getAbsolutePath().replaceAll("\\\\", "/").replaceFirst(baseFilePath, ""));
        fileTree.setText(file.getName());
        fileTree.setIcon("wb-folder");

        File[] fileArr = file.listFiles();
        if(fileArr != null){
            List<File> files = Arrays.asList(fileArr);
            files = FileTreeUtil.orderByName(files);

            for (File item : files){
                String fileName = item.getName();
                if(item.isDirectory()) {
                    FileTree dirNode = translateToFileTree(item.getAbsolutePath(), baseFilePath);
                    fileTree.getChildren().add(dirNode);

                }else if(fileName.endsWith("txt")){
                    //String strFileName = files[i].getAbsolutePath();
                    FileTree textNode = new FileTree();
                    textNode.setId(item.getAbsolutePath().replaceAll("\\\\", "/").replaceFirst(baseFilePath, ""));
                    textNode.setText(fileName);
                    textNode.setIcon("wb-file");
                    fileTree.getChildren().add(textNode);
                    textNode.setChildren(FileTreeUtil.txtReader(item.getAbsolutePath().replaceAll("\\\\","/"), baseFilePath));
                }
            }
        }
        return fileTree;
    }

    public static List<FileTree> txtReader(String txtPath, String baseFilePath){
        List<FileTree> cases = new ArrayList<>();
        try{
            String str = "";
            boolean begin = false;
            FileReader fileReader = new FileReader(txtPath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((str = bufferedReader.readLine()) != null){
                if(str.equals("*** Test Cases ***")){
                    begin = true;
                    continue;
                }
                if(begin){
                    if(!str.startsWith("    ") && !str.equals("")){
                        FileTree fileTree = new FileTree(("$case:" + txtPath + "/" + str.trim()).replaceFirst(baseFilePath, ""), str.trim(), "wb-extension");
                        cases.add(fileTree);
                    }else if(str.trim().startsWith("[Tags]")) {
                        cases.get(cases.size() - 1).setTag(str.replaceAll("\\[Tags\\]", "").trim());
                    }
                }
            }
            bufferedReader.close();
            fileReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return cases;
    }

    private static List<File> orderByName(List<File> files){

        files.sort(new Comparator< File>() {
            @Override
            public int compare(File o1, File o2) {
                if (o1.isDirectory() && o2.isFile())
                    return -1;
                if (o1.isFile() && o2.isDirectory())
                    return 1;
                return o1.getName().compareTo(o2.getName());
            }
        });

        return files;
    }

}
