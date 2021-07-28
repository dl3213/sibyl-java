package sibyl.appLishener;

import lombok.SneakyThrows;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sibyl.quartz.QuartzJob;

/**
 * @Classname StartAppLishener
 * @Description TODO
 * @Date 2021/7/28 21:47
 * @Created by dyingleaf3213
 */
@Component
public class StartAppLishener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private Scheduler scheduler;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        TriggerKey triKey = TriggerKey.triggerKey("tg1","t30s");
        Trigger trigger = scheduler.getTrigger(triKey);
        if(trigger == null){
            trigger = TriggerBuilder.newTrigger()
                    .withIdentity(triKey)
                    .withSchedule(CronScheduleBuilder
                            .cronSchedule("0/5 * * * * ?"))
                    .startNow()
                    .build();
            JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
                    .withIdentity("j1","g1")
                    .build();
            scheduler.scheduleJob(jobDetail,trigger);
        }

        TriggerKey triKey2 = TriggerKey.triggerKey("tg2","t30s2");
        Trigger trigger2 = scheduler.getTrigger(triKey2);
        if(trigger2 == null){
            trigger2 = TriggerBuilder.newTrigger()
                    .withIdentity(triKey2)
                    .withSchedule(CronScheduleBuilder
                            .cronSchedule("0/5 * * * * ?"))
                    .startNow()
                    .build();
            JobDetail jobDetail2 = JobBuilder.newJob(QuartzJob.class)
                    .withIdentity("j2","g2")
                    .build();
            scheduler.scheduleJob(jobDetail2,trigger2);
        }

        scheduler.start();
    }
}
