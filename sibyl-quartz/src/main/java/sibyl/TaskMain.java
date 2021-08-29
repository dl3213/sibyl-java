package sibyl;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import sibyl.job.HelloJob;

/**
 * @Classname TaskMain
 * @Description TODO
 * @Date 2021/7/28 20:49
 * @Created by dyingleaf3213
 */
public class TaskMain {

    public static void main(String[] args) throws SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        int a = 0;
        JobDetail jobDetail = JobBuilder
                .newJob(HelloJob.class)
                .withIdentity("job1", "t30s")
                .usingJobData("job","jobName")
                .usingJobData("name","jobVVV")//
                .usingJobData("key","jobValue")//
                .usingJobData("a",a)
                .build();

        SimpleTrigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("tri1", "t30s")
                .usingJobData("tri","triName")
                .usingJobData("name","triVVV")
                .usingJobData("key","triValue")
                .startNow()
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(2).repeatForever())
                .build();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }
}
