package com.safetys.framework.utils;

public class StaticMember {

	// 举报投诉附件类型
	public static final String ANNEX_TYPE_COMPLAINTS = "complaints";

	public static final String ANNEX_TYPE_NOTICES = "notices";
	
	
	/*下面是附件相关-start*/
	
	//通知公告地址
	public static final String NOTICE_PATH_ANNEX = "/uploadFile/noticefile";
	public static final Long NOTICE_TYPE_ANNEX = 1L;
	
	//法律法规
	public static final String RULES_PATH_ANNEX = "/uploadFile/rulesfile";
	public static final Long RULES_TYPE_ANNEX = 2L;
	
	
	/*附件相关-end*/
	
	//首页图形统计，指定枚举类型
	public static final String[] INDUSTRIAL_CODE = {"industrial_01","industrial_03","industrial_08"};
	public static final String[] INDUSTRIAL_NAME = {"危险化学品","烟花爆竹","非煤矿山"};
	
	//组织机构类型
	public static final String ORGAN_PUBLIC = "public";
	//组织机构类型
	public static final String ORGAN_INNER = "inner";
}
