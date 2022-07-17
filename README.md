### BiliBiliMonitoringUtils
Monitoring the number of BiliBili Following and Follower

### springboot + httpClient + springboot scheduled

&nbsp;&nbsp;&nbsp;&nbsp;定时监控b站粉丝工具，使用springboot scheduled定时执行任务 + apache的
httpClient依赖完成对b站账号接口的请求，获取粉丝及关注数量。目前只有这一个功能，因为只是一个例子。

**使用方法**
>1.设置springboot配置文件中的邮件账号及密码。<br/>
>2.设置api包下枚举类中的用户id<br/>
>3.启动项目即可。<br/>

**文件描述**
>bFans<br/>
> |<br/>
> |api<br/>
> |<br/>
> |----apiManager(enum:设置监控用户id)<br/>
> |config<br/>
> |----Mail(该类包含发件人、收件人、抄送,还有最重要的javaMailSender-完成整个邮件的发送。)<br/>
> |entity<br/>
> |----Fans(实体类：请求的监控用户id的fans数据的载体)<br/>
> |mailTemplate<br/>
> |----mailTemplate(该类存放发送邮件的模板)<br/>
> |service<br/>
> |----MainService(定时执行任务类)<br/>
> |task<br/>
> |----BiliBiliMonitoring(BiliBili监控器)<br/>
> |utils(工具包，发送请求、数据转换实体等。)<br/>
> |<br/>

**邮件接收**
![测试截图](https://s1.328888.xyz/2022/07/17/Nqxzw.png)