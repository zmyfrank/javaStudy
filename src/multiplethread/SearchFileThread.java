package multiplethread;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/**
 * @author: Frank
 * @Date: 2017/11/17 10:21
 */
public class SearchFileThread implements Runnable  {
    private File file;
    private String search;

    public SearchFileThread(File file, String search) {
        this.file = file;
        this.search = search;
    }



    public String readFilecontent(){
        try (FileReader fileReader = new FileReader(file)) {
            char[] all = new char[(int) file.length()];
            fileReader.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void run() {
        String result = readFilecontent();
        if (result.contains(search)) {
            System.out.printf("线程: %s 找到子目标字符串%s,在文件:%s%n", Thread.currentThread().getName(), search, file);
        }
    }
    /*
    *
    * 可分配
# Policy To Be Distributed
可分配状态
Distribution Status
分配方式
Distribution Method
规则配置
Policy Setup
人工分配
Mannual Distribution
数据全部分配至
All Data Distribute to
应续出险次数
Renewing Policy Last Year Claim Count
续保操作
Renew Action
应续保费
Renewing Policy Premium
应续保单报价
Renew Policy Premium
自核系数
UW Discount Factor
NCD系数
NCD Factor
续保操作
Is Renewed
用户电话
Customer Contact Number
业务类型
Business Type
报案电话
Claim Report Contact Number
道路救援联系电话
Road Assistant Contact Number
拖车联系电话
Toll Contact Number
代驾联系电话
Designated Driver Contact Number
年审联系电话
Annual Examination Contact Number
激活电话1
Policy Active Contact Number1
激活电话2
Policy Active Contact Number2
机场接送联系电话
Airport Pickup Contact Number
保单预留电话
Policy Contact Number1
保单预留手机
Policy Contact Number2
修改密码
Reset Password*/
}
