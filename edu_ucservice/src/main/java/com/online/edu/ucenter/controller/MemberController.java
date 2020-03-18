package com.online.edu.ucenter.controller;


import com.online.edu.ucenter.entity.Member;
import com.online.edu.ucenter.service.MemberService;
import com.online.edu.ucenter.utils.JwtUtils;
import com.xueyuan.result.R;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author lucy
 * @since 2019-04-24
 */
@RestController
@RequestMapping("/ucenter/member")
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    //根据token信息jwt的令牌，获取用户信息返回
    @GetMapping("userInfo/{token}")
    public R getUserInfoToken(@PathVariable String token) {
        //调用工具类获取用户信息
        Claims claims = JwtUtils.checkJwt(token);
        String nickname = (String)claims.get("nickname");
        String avatar = (String)claims.get("avatar");
        String id = (String)claims.get("id");

        Member member = new Member();
        member.setId(id);
        member.setId(avatar);
        member.setNickname(nickname);

        return R.ok().data("member",member);
    }

    //统计某一天注册人数
    @GetMapping("countRegisterNum/{day}")
    public R countRegisterNum(@PathVariable String day) {
        Integer result = memberService.countRegisterNum(day);
        return R.ok().data("registerCount",result);
    }
}

