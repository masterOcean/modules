package com.fenlibao.model.pms.da.global.plan;

/**
 */
public enum UserPlanRepay_State {
    YH,
	TQH,
    WH,
    ;

    public static UserPlanRepay_State parse(String code){
    	for(UserPlanRepay_State item:UserPlanRepay_State.values()){
    		if(item.name().equals(code)){
    			return item;
    		}
    	}
    	return null;
    }
}
