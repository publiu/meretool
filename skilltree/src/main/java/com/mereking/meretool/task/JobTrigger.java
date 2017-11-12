package com.mereking.meretool.task;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.mereking.meretool.entity.Skill;
import com.mereking.meretool.entity.User;
import com.mereking.meretool.enums.AlertTypeEnum;
import com.mereking.meretool.service.SkillService;
import com.mereking.meretool.service.UserService;
import com.mereking.meretool.util.EmailUtil;

public class JobTrigger {
	private static final Logger log = LoggerFactory.getLogger(JobTrigger.class);
	
	public void execute() {
		System.out.println("开始执行定时任务:" + new Date());
		// 遍历所有用户：目前用户较小，可以直接查询，
		List<User> users = userService.queryAllUser();
		for (User user : users) {
			List<Skill> skillAlertAll = skillService.querySkillsByCreateTimeAndAlertType(AlertTypeEnum.MINUTE_5.getAlertTime(), AlertTypeEnum.FINISH.getCode(), user.getId());
			List<AlertTypeEnum> alertTypeEnums = AlertTypeEnum.getList();
			for (AlertTypeEnum alertTypeEnum : alertTypeEnums) {
				if (!AlertTypeEnum.FINISH.getCode().equals(alertTypeEnum.getCode())) {
					for (Skill skill : skillAlertAll) {
						Long time = skill.getSkillCreate().getTime() - alertTypeEnum.getAlertTime().getTime();
						// 判断是否需要提醒
						if (time < 0 && skill.getAlertType() < alertTypeEnum.getCode()) {
							// 是否已提醒
							if (skill.getIsAlert().equals(0)) {
								if (!StringUtils.isEmpty(user.getEmail())) {
									// 符合要求，发送邮件
									try {
										EmailUtil.sendEmial(skill.getSkillName(), user.getEmail());
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								skill.setIsAlert(1);
								// 设置成已提醒
								skillService.updateSkillIsAlert(skill);
							}
						}
					}
				}
			}
		}
		
		System.out.println("结束执行定时任务:" + new Date());
	}
	
	@Autowired
	private SkillService skillService;
	@Autowired
	private UserService userService;
}
