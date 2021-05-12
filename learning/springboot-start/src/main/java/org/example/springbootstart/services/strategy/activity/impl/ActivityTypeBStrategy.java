package org.example.springbootstart.services.strategy.activity.impl;

import org.example.springbootstart.dtos.param.activity.ActivityClassListDto;
import org.example.springbootstart.services.strategy.activity.IActivityStrategy;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * B类型活动策略
 */
@Component
public class ActivityTypeBStrategy implements IActivityStrategy {
    @Override
    public List<ActivityClassListDto> getActivityClassList(long number, int type) {
        System.out.println("ActivityTypeBStrategy: number=" + number +", type="+type);
        return Collections.emptyList();
    }
}
