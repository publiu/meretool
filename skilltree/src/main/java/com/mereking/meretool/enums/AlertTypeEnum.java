package com.mereking.meretool.enums;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 提醒类型
 * @author Administrator
 *
 */
public enum AlertTypeEnum {
	MINUTE_5(1, "5", 1, -5),
	MINUTE_30(2,"30", 1, -30),
	HOURS_12(3,"12", 2, -12),
	DAY_1(4,"1", 3, -1),
	DAY_2(5,"2", 3, -2),
	DAY_4(5,"4", 3, -4),
	DAY_7(6,"7", 3, -7),
	DAY_15(7,"15", 3, -15),
	FINISH(99,"完成", 4, 0)
	;
	
	private Integer code;
    private String describe;
    private Integer type; // 时间类型 1.分钟 2.小时 3.天 4无格式
    private Integer time; // 时间差
    
    private AlertTypeEnum(Integer code, String describe, Integer type, Integer time) {
        this.code = code;
        this.describe = describe;
        this.type = type;
        this.time = time;
    }
    
    public static Map<Integer, String> getMap() {
        Map<Integer,String> map = new HashMap<Integer,String>();
        for (AlertTypeEnum item : AlertTypeEnum.values()) {
            map.put(item.getCode(), item.getDescribe());
        }
        return map;
    }

	public static List<AlertTypeEnum> getList() {
        List<AlertTypeEnum> stateList = new ArrayList<AlertTypeEnum>();
        for (AlertTypeEnum item : AlertTypeEnum.values()) {
            stateList.add(item);
        }
        return stateList;
    }
	
	public static AlertTypeEnum getContains(Integer code) {
        for (AlertTypeEnum item : AlertTypeEnum.values()) {
        	if(code.equals(item.getCode())){
        		return item;
        	}
        }
        return null;
    }
	
	public Date getAlertTime() {
		if (this.type == 1) {
			return addMinute(this.time);
		} else if (this.type == 2) {
			return addHours(this.time);
		} else if (this.type == 3) {
			return addDays(this.time);
		} else {
			return null;
		}
		
	}
	
	//日期加上天数后的新日期. 
	public Date addDays(Integer days) { 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, days);//可以设置增加一天，减少一天。Calendar.DATE更改为CalendarDAY_OF_MONTH设置增加一个月或者减少一个月。
		System.out.println("时间："+calendar.getTime());
		return calendar.getTime();
	}
	// 当前时分加上分钟数后的新时间
	public Date addMinute(Integer minutes) { 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, minutes);//可以设置增加一天，减少一天。Calendar.DATE更改为CalendarDAY_OF_MONTH设置增加一个月或者减少一个月。
		System.out.println("时间："+calendar.getTime());
		return calendar.getTime();
	}
	// 当前时分加上小时数后的新时间
	public Date addHours(Integer hours) { 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY, hours);//可以设置增加一天，减少一天。Calendar.DATE更改为CalendarDAY_OF_MONTH设置增加一个月或者减少一个月。
		System.out.println("时间："+calendar.getTime());
		return calendar.getTime();
	}


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}
}
