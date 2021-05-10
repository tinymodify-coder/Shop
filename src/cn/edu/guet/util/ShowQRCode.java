package cn.edu.guet.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShowQRCode {
    /**
     * Getting files from Folder(Time Sorting by Modify time)
     *
     * @param path
     * @return
     */
    public static List<File> getFileSort(String path) {
        List<File> list = getFiles(path, new ArrayList<File>());
        if (list != null && list.size() > 0) {
            Collections.sort(list, new Comparator<File>() {
                public int compare(File file, File newFile) {
                    if (file.lastModified() < newFile.lastModified()) {////按时间顺序显示D盘下的所有png的图片,拿取最新的二维码
                        return 0;
                    } else if (file.lastModified() > newFile.lastModified()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
        }
        return list;
    }

    /**
     * Get all the file from folders(img/{drivesid})
     *
     * @param realpath
     * @param files
     * @return
     */
    public static List<File> getFiles(String realpath, List<File> files) {

        File realFile = new File(realpath);
        if (realFile.isDirectory()) {
            File[] subfiles = realFile.listFiles();
            System.out.println("路径："+realpath);
            System.out.println("路径下的文件数组："+subfiles);
            for (File file : subfiles) {
                if(file.getName().endsWith(".png")){
                    files.add(file);
                }
            }
        }
        return files;
    }
}
