package com.company.project.web.service;

import com.company.project.web.vo.resp.HomeRespVO;

/**
 * 首页
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
public interface HomeService {

    /**
     * 获取首页信息
     *
     * @param userId userId
     * @return HomeRespVO
     */
    HomeRespVO getHomeInfo(String userId);
}
