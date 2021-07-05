package com.company.project.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.project.web.entity.SysJobLogEntity;
import com.company.project.web.mapper.SysJobLogMapper;
import com.company.project.web.service.SysJobLogService;
import org.springframework.stereotype.Service;

/**
 * 定时任务 服务类
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@Service("sysJobLogService")
public class SysJobLogServiceImpl extends ServiceImpl<SysJobLogMapper, SysJobLogEntity> implements SysJobLogService {


}
