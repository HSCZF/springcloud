package com.czf.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)  // 链式写法
public class Dept implements Serializable {

    /*主键*/
    private Long deptno;
    /*部门*/
    private String dname;
    /*来自哪个数据库：微服务，一个服务对应一个数据库，同一个信息可能存在不同的数据库*/
    private String db_source;

    public Dept(String dname){
        this.dname = dname;
    }

    /*
    * 链式写法
    * Dept dept = new Dept();
    * dept.setDeptNo(11).setDname('AAAA').setDb_source('开发部');
    * */

}
