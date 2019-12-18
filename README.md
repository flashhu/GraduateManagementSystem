### 毕业生就业去向管理平台

Java控制台程序
***

#### 项目结构

```
GraduateManagementSystem
└─ src
       ├─ Main.java
       ├─ entity
       │    ├─ AdminInfo.java
       │    ├─ PersonInfo.java
       │    └─ StudentInfo.java
       ├─ service
       │    ├─ AdminService.java
       │    ├─ BaseService.java
       │    └─ StudentService.java
       ├─ ui
       │    ├─ AdminUI.java
       │    ├─ MainPageUI.java
       │    └─ StudentUI.java
       └─ util
              └─ Init.java
```
***
#### 主要功能
1）用户登录（管理端，学生端）
* 个人信息登录后可修改

2）就业登记（学生端）
* 登记就业去向
* 修改已登记信息

3）信息管理（管理员端）
* 对毕业生的基本信息增删改查
* 查看所有毕业生列表

4）信息汇总（管理员端）
* 根据四种去向分类显示毕业生记录
* 统计总的男女比例，就业率，就业登记完成情况





