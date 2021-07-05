package com.company.project.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.project.web.entity.SysLog;
import com.company.project.web.mapper.SysLogMapper;
import com.company.project.web.service.LogService;
import org.springframework.stereotype.Service;

/**
 * 系统日志
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@Service
public class LogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements LogService {
}
