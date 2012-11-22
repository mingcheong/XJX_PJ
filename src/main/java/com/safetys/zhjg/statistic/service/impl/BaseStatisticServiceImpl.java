package com.safetys.zhjg.statistic.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.framework.exception.DaoException;
import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import com.safetys.framework.system.model.FkUserModel;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.Option;
import com.safetys.framework.utils.StaticMember;
import com.safetys.zhjg.statistic.dao.IBaseStatisticDao;
import com.safetys.zhjg.statistic.service.IBaseStatisticService;
import com.safetys.zhjg.statistic.util.QueryObject;

@SuppressWarnings("rawtypes")
@Service("baseStatisticService")
@Transactional(propagation = Propagation.REQUIRED)
public class BaseStatisticServiceImpl extends BaseServiceImpl implements IBaseStatisticService {
	// 为部分需要在持久层操作方法提供服务
	@Resource(name = "baseStatisticDao")
	protected IBaseStatisticDao baseStatisticDao;

	@Autowired
	@SuppressWarnings("unchecked")
	public BaseStatisticServiceImpl(@Qualifier("baseStatisticDao") IBaseStatisticDao baseStatisticDao) {
		super(baseStatisticDao);
	}

	public List<?> getAreaModelsByStatistic(FkUserModel user) throws ServicesException {
		List<?> datas = null;
		String areaCode = AppUtils.getUserLastArea(user).getValue();
		String SQL = "SELECT AREA.CODE, AREA.NAMES FROM( SELECT A5.c AS CODE, A5.n AS NAMES FROM A005 A5 WHERE (A5.F =( SELECT a51. ID FROM A005 a51 WHERE a51.c =" + areaCode + ") OR A5.C =" + areaCode + ") and A5.RD = 0) AREA order by CODE";
		try {
			datas = baseStatisticDao.getCollectionByNativeSql(SQL);
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
		return datas;
	}

	public List<?> getCompanyTrainStatistic(QueryObject object) throws ServicesException {
		String SQL = "select count(obj.id) from A006 obj where 1=1 ";
		try {
			if (object != null) if (!AppUtils.isNullOrEmptyString(object.getName())) {
				SQL += "and obj.n like '%" + object.getName() + "%'";
			}
			baseStatisticDao.getCollectionByNativeSql("SQL");
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
		return null;
	}

	public List<?> getCompanyIndustrialStatistic(FkUserModel object) throws ServicesException {
		List<?> datas = null;
		Option option = AppUtils.getUserLastArea(object);
		String columnName = AppUtils.getNativeColumnName(option.getKey());
		String SQL = "SELECT COUNT(INFO.ID), CODE, NAMES, enumCode, enumname FROM( SELECT A5.c AS CODE, A5.n AS NAMES, enumCode, enumName FROM A005 A5 FULL JOIN(SELECT A6.C enumCode, A6.N enumName FROM A006 A6 WHERE A6.F = (SELECT ID FROM A006 WHERE C = 'industrial')) enum ON 1 != 2 WHERE (A5.F =" +
				"(SELECT a51. ID FROM A005 a51 WHERE a51.c = "+option.getValue()+") OR A5.C="+option.getValue()+" ) AND a5.rd = 0) maps LEFT JOIN(SELECT C1.ID, C1."+columnName+" AREACODE, C1.CI FROM C001 C1 WHERE C1.RD = 0) INFO ON INFO.AREACODE = MAPS.CODE AND INFO.CI = MAPS.ENUMCODE GROUP BY CODE, NAMES, enumCode, enumname ORDER BY enumCode,code";
		try {
			datas = baseStatisticDao.getCollectionByNativeSql(SQL);
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
		return datas;
	}
	
	/**
	 * 企业陪训统计
	 * @param object   用户信息
	 * @param state	   培训状态 0:未培训    1:已培训
	 * @return
	 * @throws ServicesException
	 */
	public List<?> getCompanyTrainStatistic(FkUserModel object,int state) throws ServicesException {
		List<?> datas = null;
		Option option = AppUtils.getUserLastArea(object);
		String columnName = AppUtils.getNativeColumnName(option.getKey());
		
		String SQL = "SELECT COUNT(TRAIN.ID) as aid,  CODE, NAMES, enumCode, enumname ,TRAIN.STATE FROM (SELECT A5.c AS CODE, A5.n AS NAMES, enumCode, enumName FROM A005 A5 FULL JOIN (SELECT A6.C enumCode, A6.N enumName FROM A006 A6  WHERE A6.F =(SELECT ID FROM A006 WHERE C = 'trainType')) enum ON 1 != 2 WHERE (A5.F ="
				   + "(SELECT a51. ID FROM A005 a51 WHERE a51.c = "+option.getValue()+") OR A5.C ="+option.getValue()+" ) AND a5.rd = 0) maps LEFT JOIN (SELECT C8.ID, C8."+columnName
				   + " AREACODE, C8.TT,c8.PST STATE FROM C008 C8  WHERE C8.RD = 0 AND C8.PST = "+state+") TRAIN ON TRAIN.AREACODE = MAPS.CODE AND TRAIN.TT = MAPS.ENUMCODE GROUP BY CODE, NAMES, enumCode, enumname ,TRAIN.STATE  ORDER BY enumCode,code";
		  
		try {
			datas = baseStatisticDao.getCollectionByNativeSql(SQL);
			
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
		return datas;
		
	}

	public List<?> getCompanyAccidentByStatistic(FkUserModel object) throws ServicesException {
		List<?> datas = null;
		try {
			Option option = AppUtils.getUserLastArea(object);
			String columnName = AppUtils.getNativeColumnName(option.getKey());
			String SQL = "SELECT COUNT(qsnum) qsnum, NVL(SUM(swnum),'0') swnum, NVL(SUM(zsnum),'0') zsnum,NVL(SUM(jjsum),0) jjsum, CODE, NAMES, enumCode, enumname FROM( SELECT A5.c AS " +
					"CODE, A5.n AS NAMES, enumCode, enumName FROM A005 A5 FULL JOIN(SELECT A6.C enumCode, A6.N enumName FROM A006 A6 WHERE A6.F =(SELECT ID FROM A006 WHERE C = 'accidentBigType') " +
					"AND rd = 0) enum ON 1 != 2 WHERE(A5.F =(SELECT a51. ID FROM A005 a51 WHERE a51.c = "+option.getValue()+") OR A5.C = "+option.getValue()+") AND a5.rd = 0) maps LEFT JOIN(SELECT " +
					"c6. ID AS qsnum,(c6.dn + c6.mn) AS swnum, c6.swn AS zsnum, c6."+columnName+" AS areaCode, c6.CBT AS CBT , c6.CAL as jjsum FROM C006 c6 WHERE c6.RD = 0) info ON " +
					"info.areaCode = maps.CODE AND info.CBT = maps.ENUMCODE GROUP BY CODE, NAMES, enumCode, enumname ORDER BY maps.ENUMCODE, maps.code";
			datas = baseStatisticDao.getCollectionByNativeSql(SQL);
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
		return datas;
	}
	
	public List<?> getCompanyStatandsByStatistic(FkUserModel object) throws ServicesException {
		List<?> datas = null;
		try {
			Option option = AppUtils.getUserLastArea(object);
			String columnName = AppUtils.getNativeColumnName(option.getKey());
			String SQL = "SELECT COUNT(ID) AS NUM1, CODE, NAMES, enumCode, enumname, enumCode2, enumname2 FROM( SELECT A5.c AS CODE, A5.n AS NAMES, enumCode, enumName, enumCode2, enumname2" +
					" FROM A005 A5 FULL JOIN( SELECT A6.C enumCode, A6.N enumName FROM A006 A6 WHERE A6.F =(SELECT ID FROM A006 WHERE C = 'standardType') AND rd = 0) enum ON 1 != 2 FULL JOIN(" +
					" SELECT A61.C enumCode2, A61.N enumName2 FROM A006 A61 WHERE A61.F =(SELECT ID FROM A006 WHERE C = 'companyLeavel') AND rd = 0) enum ON 1 != 2 WHERE(A5.F =(SELECT a51. ID " +
					" FROM A005 a51 WHERE a51.c = "+option.getValue()+") OR A5.C = "+option.getValue()+") AND a5.rd = 0) maps LEFT JOIN( SELECT C04.ID AS ID, C01."+columnName+" AS areaCode, C04.ST" +
					" AS ST, C04.CL AS cl FROM C004 C04 INNER JOIN C001 C01 ON C04.CI = C01. ID AND C01.RD = 0 AND c04.RD = 0) INFO ON info.areaCode = maps.CODE AND INFO.ST = MAPS.ENUMCODE" +
					" AND info.CL = maps.ENUMCODE2 GROUP BY CODE, NAMES, enumCode, enumname, enumCode2, enumname2 ORDER BY maps.enumCode, maps.enumCode2, maps.code";
			datas = baseStatisticDao.getCollectionByNativeSql(SQL);
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
		return datas;
    }
	
	/**
	 * 行政许可统计
	 * @param object
	 * @return
	 * @throws ServicesException
	 */
	public List<?> getCompanyLicensingByStatistic(FkUserModel object) throws ServicesException {
		List<?> datas = null;
		try {
			Option option = AppUtils.getUserLastArea(object);
			String columnName = AppUtils.getNativeColumnName(option.getKey());
			
			String SQL ="SELECT COUNT(LICENS.ID), CODE, NAMES, enumCode, enumname FROM (SELECT A5.c AS CODE, A5.n AS NAMES, enumCode, enumName FROM A005 A5 FULL JOIN (SELECT A6.C enumCode, A6.N enumName FROM A006 A6 WHERE A6.F = (SELECT ID FROM A006 WHERE C = 'licensingType')) enum ON 1 != 2  WHERE (A5.F ="
					   +"(SELECT a51. ID FROM A005 a51 WHERE a51.c = "+option.getValue()+") OR A5.C = "+option.getValue()+") AND a5.rd = 0) maps LEFT JOIN (SELECT C2.ID, C2.ST LICENSINGTYPE,INFO.AREACODE FROM C002 C2 LEFT JOIN(SELECT ID,"
					   +columnName+" AREACODE FROM C001 )INFO  ON  C2.CI=INFO.ID AND C2.RD=0) LICENS ON LICENS.AREACODE = MAPS.CODE AND LICENS.LICENSINGTYPE = MAPS.ENUMCODE GROUP BY CODE, NAMES, enumCode, enumname ORDER BY enumCode,code";

			datas = baseStatisticDao.getCollectionByNativeSql(SQL);
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
		return datas;
	}

	
	@SuppressWarnings("unchecked")
	public List<?> getCompanyIndustrialStatisticByDate(FkUserModel fkUserModel,
			Date date,List<?> enums,HttpServletRequest request) throws ServicesException {
		List<String> list= new ArrayList<String>();
		List<Object[]> datas = null;
		try {
			int elen=StaticMember.INDUSTRIAL_CODE.length;
			StringBuilder categories = new StringBuilder();
			StringBuilder codes = new StringBuilder();
			categories.append("[");
			for(int i = 0;i<elen;i++){
				categories.append("'").append(StaticMember.INDUSTRIAL_NAME[i].toString()).append("',");
				codes.append("'"+StaticMember.INDUSTRIAL_CODE[i].toString()+"',");
			}
			request.setAttribute("categories", categories.substring(0, categories.length()-1)+"]");
			
			Option option = AppUtils.getUserLastArea(fkUserModel);
			String columnName = AppUtils.getNativeColumnName(option.getKey());
			String SQL = "select count(c.id) as cn,m.ac,m.an,m.ec,m.en from (select a5.c as ac ,a5.n as an,e.ec,e.en"
				     +" from a005 a5 "
				     +" full join (select a6.c as ec,a6.n as en from a006 a6 where a6.c in ("+codes.substring(0,codes.length()-1)+")) e on 1!=2"
				     +" where (a5.f=(select a52.id from a005 a52 where a52.c='"+option.getValue()+"') or a5.c='"+option.getValue()+"') and a5.rd=0 ) m "
					 + "left join (select c1.id ,c1."+columnName+" as ac ,c1.ci from c001 c1 where c1.rd=0) c on c.ac=m.ac and c.ci = m.ec "
					 + "group by m.ac,m.an,m.ec,m.en order by m.ac,m.ec";
			datas = baseStatisticDao.getCollectionByNativeSql(SQL);
			if(datas!=null&&datas.size()>0){
				for(int i = 0;i<datas.size();){
					StringBuilder data = new StringBuilder();
					data.append("{type:'column',name:'").append(datas.get(i)[2].toString()).append("',data:[");
					for(int j = 0 ;j<elen;j++,i++){
						data.append(datas.get(i)[0]+",");
					}
					list.add(data.substring(0, data.length()-1)+"],href:'#'}");
				}
			}
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
		return list;
	}
	
	public List<?> getEnumByFatherCode(String code) throws ServicesException {
		List<?> datas = null;
		String SQL = "select e.n from a006 e where e.f = (select id from a006 where c = '"+code+"') and e.rd = 0 order by e.c";
		try {
			datas = baseStatisticDao.getCollectionByNativeSql(SQL);
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
		return datas;
	}
	
	/**
	 * 重大危险源统计
	 * @param object
	 * @return
	 * @throws ServicesException
	 */
	public List<?> getCompanyDangerByStatistic(FkUserModel object) throws ServicesException {
		List<?> datas = null;
		try {
			Option option = AppUtils.getUserLastArea(object);
			String columnName = AppUtils.getNativeColumnName(option.getKey());
		
			String SQL = "SELECT COUNT(DANGER.ID), CODE, NAMES, enumCode, enumname FROM (SELECT A5.c AS CODE, A5.n AS NAMES, enumCode, enumName FROM A005 A5 FULL JOIN (SELECT A6.C enumCode, A6.N enumName FROM A006 A6 WHERE A6.F = (SELECT ID FROM A006 WHERE C = 'industrial')) enum ON 1 != 2 WHERE (A5.F ="
					  + "(SELECT a51.ID FROM A005 a51 WHERE a51.c = "+option.getValue()+") OR A5.C = "+option.getValue()+") AND a5.rd = 0) maps LEFT JOIN (SELECT C9.ID,C9."+columnName+" AREACODE,INFO.industrial FROM C009 C9 LEFT JOIN(SELECT C1.ID,"
					  + "C1.CI industrial FROM C001 C1)INFO ON  C9.CI=INFO.ID AND C9.RD=0) DANGER ON DANGER.AREACODE = MAPS.CODE AND DANGER.industrial = MAPS.ENUMCODE GROUP BY CODE, NAMES, enumCode, enumname ORDER BY enumCode,code";
			datas = baseStatisticDao.getCollectionByNativeSql(SQL);
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
		return datas;
	}

	public List<?> getCompanyGISStatistic(FkUserModel fkUserModel)
			throws ServicesException {
		List<?> datas = null;
		Option option = AppUtils.getUserLastArea(fkUserModel);
		String columnName = AppUtils.getNativeTrueColumnName(option.getKey());
		String SQL = "select e.n,e.c,'"+option.getValue()+"' as ac,count(c.id) as nb from c001 c right join (select a6.c ,a6.n  from a006 a6 where a6.f = (select id from a006 a62 where a62.c = 'industrial')) e on c.ci = e.c and c."+columnName+" = '"+option.getValue()+"' and c.rd = 0 "
					+" group by e.n,e.c,c.a1 order by e.c";
		try {
			datas = baseStatisticDao.getCollectionByNativeSql(SQL);
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
		return datas;
	}

	public List<?> getCompanyGISStatistic(String areaCode, String enumCode,
			FkUserModel fkUserModel) throws ServicesException {
		List<?> datas = null;
		Option option = AppUtils.getUserLastArea(fkUserModel);
		String columnName = AppUtils.getNativeTrueColumnName(option.getKey());
		String SQL = "select c.cn,c.cad , "
						+" (select a.n from a005 a where a.c=c.a1 and a.c <> 0) as a1, "
						+" (select a.n from a005 a where a.c=c.a2 and a.c <> 0) as a2, "
						+" (select a.n from a005 a where a.c=c.a3 and a.c <> 0) as a3, "
						+" (select e1.n from a006 e1 where e1.c=c.CH) as ch,e.n,c.LP,c.lc ,c.id" 
						+" from c001 c left join a006 e on c.ci=e.c where c."+columnName+" ='"+areaCode+"' and c.ci = '"+enumCode+"' and c.rd = 0";
		try {
			datas = baseStatisticDao.getCollectionByNativeSql(SQL);
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
		return datas;
	}

}
