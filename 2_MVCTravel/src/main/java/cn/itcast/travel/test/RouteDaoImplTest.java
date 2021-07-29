package cn.itcast.travel.test;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.domain.Route;
import org.junit.Test;

import java.util.List;

public class RouteDaoImplTest {

    private RouteDao routeDao = new RouteDaoImpl();

    @Test
    public void findTotalCount(){
       int count =  routeDao.findTotalCount(5);
        System.out.println(count);

    }

    @Test
    public void findByPage(){
        List<Route> routeList = routeDao.findByPage(5,10,0);
        for (Route route : routeList) {
            System.out.println(route);
        }

    }
}
