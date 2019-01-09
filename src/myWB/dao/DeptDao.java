package myWB.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import myWB.common.HrmConstants;
import myWB.dao.provider.DeptDynaSqlProvider;
import myWB.domain.Dept;

/**   
 * @Description: DeptMapper接口
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @date 2016年7月11日 上午10:53:32 
 * @version V1.0   
 */
public interface DeptDao {

	// 动态查询
	@SelectProvider(type=DeptDynaSqlProvider.class,method="selectWhitParam")
	List<Dept> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=DeptDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	@Select("select * from "+HrmConstants.DEPTTABLE+" ")
	List<Dept> selectAllDept();
	
	@Select("select * from "+HrmConstants.DEPTTABLE+" where ID = #{id}")
	Dept selectById(int id);

	// 根据id删除部门
	@Delete(" delete from "+HrmConstants.DEPTTABLE+" where id = #{id} ")
	void deleteById(Integer id);
	
	// 动态插入部门
	@SelectProvider(type=DeptDynaSqlProvider.class,method="insertDept")
	void save(Dept dept);
	
	// 动态修改用户
	@SelectProvider(type=DeptDynaSqlProvider.class,method="updateDept")
	void update(Dept dept);
}
