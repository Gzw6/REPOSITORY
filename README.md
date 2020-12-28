# FWWB

## 一、答疑和资料

1)[答疑汇总](http://note.youdao.com/noteshare?id=d0ac87df151de147f2125cd773b8c3c4&sub=8AE1083ACA0B4127A42CC91729C98DA5)

## 二、[A12赛题要求](http://www.fwwb.org.cn/topic/show/2fcdcc6a-2d7a-41ee-ba40-acf5d3b68378)
1.以下为概括内容：

1)所有客户的位置距离固定

2)配送中心有最大装载重量为2吨和5吨的两种货车，车载重量可设定，并限制车辆一次运行路线距离不超过35公里

3)限制车辆一次运行路线距离不超过35公里

4)每个派送点只由一辆车服务一次

5)每辆车只能服务一条路线

6)车辆一律由配送中心出发，完成任务后返回配送中心，快递车辆配送过程中无装货，只考虑卸货

7)车辆每小时行驶距离为10千米(车速固定)

8)通过算法和程序计算需要的车辆数，最优路径及配送时间(三个目标函数)



## 三、建模工作（对照A12开发要求展开）

参数定义如下：

1)G =（V，A）是一个图形，A = {（vi，vj）：i≠j ˄ i，j∈V}是一个弧集

2)顶点集V={v0,...,vn+1} (其中，v1和vn+1都表示配送中心) 表示各个客户点。每个顶点都有对应的需求量qi和配送时间gi，顶点vi的需求量为qi（qi≥0），配送时间为gi（配送中心的需求量为q0=0）

3)车辆k所服务的客户点组成集合C = {v1，...，vn}，其中第i个服务点到第j个服务点的距离为dij

4)可用汽车集合为K={k1,k2,...kn},其中ki=(i,qmax),qmax为最大载重量且qmax∈{2，5}

5)`公式中有一个二进制决策变量，如约束条件中(7)所示。如果车辆k被分配从配送点i运行到到配送点j时，该决策变量取1，否则取0`

6)s为车速，且作为系统设置变量出现


1.目标函数


1)主要目标:配送车辆数最少
`（注解：该式中包含二进制决策变量，见图片中参数定义（5），它用来表示车辆是否在x点到y点之间运行。该式中变量的0表示配送中心，j∈C，因此j表示所有运行路线的第j条路线，C集合含义见图中参数定义。那么，该二进制决策变量在这里表示车辆k是否是在第j条配送路线上运行的，如果是则取1，否则取0。因此整个式子表示所有运行路线之和，即运行所需车辆数）`


2)次要目标:配送总路程最小
`（注解：该式中也包含决策变量，在这里决策变量表示车辆k的运行路线是否经过配送点i和配送点j之间的这段路程的，是则取1，否则取0。d的含义见参数定义。(i,j)属于A，A是所有配送点以及配送中心组成的集合，因此整个式子表示所有配送路线各段之和最小，即配送总路程最小）`
![image](https://images.gitee.com/uploads/images/2020/0202/115958_519a4538_5189209.jpeg)

***
2.约束条件
![image](https://images.gitee.com/uploads/images/2020/0202/120021_8c0d2dbb_5189209.jpeg)

1)任意路线货物总量不超过车辆容量                     (4)

2)一次行程为所有用户提供且仅提供一次服务             (5)

3)每辆车都进出一次配送中心                           (6)

4)决策变量的类型和域的指示                           (7)

5)车辆一次运行路线距离不超过35公里                   (8)

  

***
3.Jmetal求解


