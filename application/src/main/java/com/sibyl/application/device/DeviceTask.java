package com.sibyl.application.device;

import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @Classname DeviceTask
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/17 11:29
 */
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class DeviceTask {
    private String deviceCode;
    private String taskName;
    private Object taskParameters;
    private long creatTime = System.currentTimeMillis();
    private long expiresTime = -1;
}
