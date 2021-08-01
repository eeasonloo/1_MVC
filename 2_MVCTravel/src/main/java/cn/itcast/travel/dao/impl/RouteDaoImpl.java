package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import cn.itcast.travel.util.JedisUtil;
import com.alibaba.druid.util.JdbcUtils;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(int cid) {
        String sql = "select count(*) from tab_route where cid = ?";

        return template.queryForObject(sql,Integer.class,cid);
    }

    @Override
    public List<Route> findByPage(int cid, int pageSize, int start, String rname) {

        String sql = "select * from tab_route where 1=1";
        StringBuilder sb =new StringBuilder(sql);

        List params = new ArrayList();

        if(cid !=0){
            sb.append(" and cid = ?");
            params.add(cid);
        }

        if(rname!=null && !(rname.equals(""))){
            sb.append(" and rname like ? ");
            params.add("%"+rname+"%");
        }

        params.add(start);
        params.add(pageSize);
        sb.append(" limit ?,?");

        /*System.out.println(sb.toString());
        for (Object param : params) {
            System.out.println("1 :" + param);
        }*/


        return template.query(sb.toString(),new BeanPropertyRowMapper<Route>(Route.class),params.toArray());
    }
}
