package com.company.project.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.project.web.entity.SysContentEntity;
import com.company.project.web.mapper.SysContentMapper;
import com.company.project.web.service.SysContentService;
import org.springframework.stereotype.Service;

/**
 * 内容 服务类
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@Service("sysContentService")
public class SysContentServiceImpl extends ServiceImpl<SysContentMapper, SysContentEntity> implements SysContentService {


}
