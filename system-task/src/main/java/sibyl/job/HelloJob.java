package sibyl.job;

import lombok.SneakyThrows;
import org.quartz.*;

import java.time.LocalDateTime;


/**
 * @Classname HelloJob
 * @Description TODO
 * @Date 2021/7/28 20:47
 * @Created by dyingleaf3213
 */
//@DisallowConcurrentExecution//禁止并发
@PersistJobDataAfterExecution//持久化，例如a，tri中的dataMap无效
public class HelloJob implements Job {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @SneakyThrows
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

//        final JobDataMap jobDetailMap = jobExecutionContext.getJobDetail().getJobDataMap();
//        final JobDataMap jobTriMap = jobExecutionContext.getTrigger().getJobDataMap();
//        final JobDataMap mergedMap = jobExecutionContext.getMergedJobDataMap();
//        System.err.println("job => " + jobDetailMap.get("job"));
//        System.err.println("job name => " + jobDetailMap.get("name"));
//        System.err.println("tri => " + jobTriMap.get("tri"));
//        System.err.println("merged => " + mergedMap.get("key"));
//
//        System.err.println("name in  => " + name);

//        System.err.println("job => " +
//                System.identityHashCode(jobExecutionContext.getJobDetail()));//每次不同
//        System.err.println("job => " +
//                System.identityHashCode(jobExecutionContext.getJobInstance()));//每次不同

        System.err.println("exc => " + LocalDateTime.now());
        int a = jobExecutionContext.getJobDetail().getJobDataMap().getInt("a");
        a ++;
        jobExecutionContext.getJobDetail().getJobDataMap().put("a",a);
        System.err.println(" a => " +
                jobExecutionContext.getJobDetail().getJobDataMap().getInt("a"));
//        Thread.sleep(3000);
    }
}
