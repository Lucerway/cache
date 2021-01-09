# 怎么dump文档分析java内存

1、前置条件  
dump文件到本地前 需要调整下mac配置：系统偏好设置 => 共享 => 远程登录 勾选
 
2、jps命令 查看进程ID

3、dump命令
jmap -dump:format=b,file=<filename.hprof> <pid>  
例如 jmap -dump:format=b,file=ls.hprof 1

4、压缩文件
gzip ls.hprof

5、下载到本地
scp ls.hprof foolme@192.168.26.220:/Users/foolme

6、用MAT工具打开进行分析
 
 
     
