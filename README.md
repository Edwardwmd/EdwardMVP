# 关于Android MVP 开发模式的说明
## **本项目以简单的Demo方式阐明MVP开发模式

###1、什么是MVP开发模式？
#####  *有四个要素 :
 + (1)View:负责绘制UI元素、与用户进行交互(在Android中体现为Activity);
  
 + (2)View interface:需要View实现的接口，View通过View interface与Presenter进行交互，降低耦合，方便进行单元测试;
  
 + (3)Model:负责存储、检索、操纵数据(有时也实现一个Model interface用来降低耦合);
  
 + (4)Presenter:作为View与Model交互的中间纽带，处理与用户交互的负责逻辑。

###2、和MVC的比较

 + 相信大家对MVC都是比较熟悉了：M-Model-模型、V-View-视图、C-Controller-控制器，MVP作为MVC的演化版本，
那么类似的MVP所对应的意义：M-Model-模型、V-View-视图、P-Presenter-表示器。 从MVC和MVP两者结合来看，
Controlller/Presenter在MVC/MVP中都起着逻辑控制处理的角色，起着控制各业务流程的作用。而 MVP与MVC最不
同的一点是M与V是不直接关联的也是就Model与View不存在直接关系，这两者之间间隔着的是Presenter层，其负责调
控 View与Model之间的间接交互。在 Android中很重要的一点就是对UI的操作基本上需要异步进行也就是在主线程中
才能操作UI，所以对View与Model的切断分离是 合理的。此外Presenter与View、Model的交互使用接口定义交互操
作可以进一步达到松耦合也可以通过接口更加方便地进行单元测试。
