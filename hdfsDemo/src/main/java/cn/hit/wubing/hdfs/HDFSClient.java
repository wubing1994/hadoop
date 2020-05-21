package cn.hit.wubing.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HDFSClient {

    private static Configuration conf;
    private static FileSystem fs;

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        conf = new Configuration();
        fs = FileSystem.get(new URI("hdfs://hadoop102:9000"), conf, "wubing");

        //创建目录
        //fs.mkdirs(new Path("/cn/hit/wubing/file"));

        //文件上传
        fs.copyFromLocalFile(new Path("D:/bigdata/input/word.txt"), new Path("/cn/hit/wubing/file/word.txt"));

        fs.close();

        System.out.println("over");
    }
}