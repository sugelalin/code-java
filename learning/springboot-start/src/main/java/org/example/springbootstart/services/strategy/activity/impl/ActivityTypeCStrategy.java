package org.example.springbootstart.services.strategy.activity.impl;

import org.example.springbootstart.dtos.param.activity.ActivityClassListDto;
import org.example.springbootstart.services.strategy.activity.IActivityStrategy;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * C类型活动策略
 */
@Component
public class ActivityTypeCStrategy implements IActivityStrategy {
    @Override
    public List<ActivityClassListDto> getActivityClassList(long number, int type) {
        System.out.println("ActivityTypeCStrategy: number=" + number +", type="+type);
        return Collections.emptyList();
    }
}
