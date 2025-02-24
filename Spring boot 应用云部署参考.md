### Spring boot 应用云部署参考

#### 一、获得云服务器

目前项目的云服务器已经部署并配置完成，用的是阿里云提供的服务器，免费期七个月（从2024.7开始），ip 地址为 8.130.12.168。如果想要自己搞一台用于练手或者其他用途，可以参考这篇博客：[保姆级教程——将springboot项目部署到阿里云服务器(小白包会)](https://blog.csdn.net/Elon15/article/details/124516929)

注：项目服务器密码可以来找我要



#### 二、连接到云服务器

##### 2.1 网页版终端

阿里云为云服务器提供了网页版终端，根据参考博客中的连接方法即可打开网页版终端，效果如下：

![](https://pic.imgdb.cn/item/66a63775d9c307b7e9d968e7.png)

##### 2.2 通过终端 SSH 连接

以 Mac 的终端为例，在终端输入以下命令以访问远程主机：

```bash
ssh root@8.130.12.168
```

再输入密码，即可通过终端连接：

![](https://pic.imgdb.cn/item/66a63857d9c307b7e9dac932.png)

按 control + D 即可结束远程连接

Windows 下应该也能使用 SSH 连接，但是好像要打开相应服务，具体过程可以自行搜索。



#### 三、打包项目

在 IDEA 项目中的 `pom.xml` 文件中插入打包配置代码（以下面为例）：

```xml
<build>
      <plugins>
          <plugin>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-maven-plugin</artifactId>
              <version>2.6.0</version>
              <configuration>
                  <mainClass>com.heta.Application</mainClass>
                  <finalName>hetaRelease</finalName>
              </configuration>
              <executions>
                  <execution>
                      <goals>
                          <goal>repackage</goal>
                      </goals>
                  </execution>
              </executions>
          </plugin>
      </plugins>
  </build>
```

点击 IDEA 右侧的 maven 图标，在弹出来的窗口中选择 [项目名] -> [Lifecycle] -> package，等待完成打包。打包好的 jar 包在 target 目录下：

![](https://pic.imgdb.cn/item/66a63a88d9c307b7e9dd5cfe.png)

jar 包的名字就是上面代码里面标签 finalName 对应的名字。



#### 四、上传 jar 包到云服务器并执行

利用 scp 命令，将本地文件上传到服务器上:

```bash
scp /Users/busyforest/IdeaProjects/Heta_Application/target/hetaRelease.jar root@8.130.12.168:/root/ideaProject
```

![](https://pic.imgdb.cn/item/66a63c12d9c307b7e9e006f1.png)

可以发现 root/ideaProject/ 下已经有了上传的 jar 包，输入 java -jar 包名.jar 即可运行：

![](https://pic.imgdb.cn/item/66a63cc1d9c307b7e9e124c1.png)

这样就完成了云部署。