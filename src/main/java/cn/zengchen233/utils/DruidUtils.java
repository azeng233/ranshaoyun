package cn.zengchen233.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

public class DruidUtils extends UnpooledDataSourceFactory {
    public DruidUtils() {
        this.dataSource = new DruidDataSource();
    }
}
