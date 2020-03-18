package com.online.edu.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.online.edu.ucenter.entity.Member;
import com.online.edu.ucenter.mapper.MemberMapper;
import com.online.edu.ucenter.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author lucy
 * @since 2019-04-24
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Override
    public Integer countRegisterNum(String day) {
       return  baseMapper.countRegisterNum(day);
    }

    //根据微信id判断是否有用户信息
    @Override
    public Member existWxUser(String openid) {
        QueryWrapper<Member> wrapper = new QueryWrapper<>();
        wrapper.eq("openid",openid);
        Member member = baseMapper.selectOne(wrapper);
        return member;
    }

}
