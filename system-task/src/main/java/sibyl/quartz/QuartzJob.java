package sibyl.quartz;

import lombok.SneakyThrows;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

/**
 * @Classname QuartzJob
 * @Description TODO
 * @Date 2021/7/28 21:34
 * @Created by dyingleaf3213
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class QuartzJob extends QuartzJobBean {
    @SneakyThrows
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        Thread.sleep(2000);
        System.err.println(context.getScheduler().getSchedulerInstanceId());
        System.err.println("taskName => " + context.getJobDetail().getKey().getName());
        System.err.println("time => " + LocalDateTime.now());
    }
}
