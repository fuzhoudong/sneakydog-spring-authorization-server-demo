package dog.sneaky.demo.database.dao;


import com.github.pagehelper.Page;
import dog.sneaky.demo.database.dataobject.MyMenusDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyMenusDAO {

    List<MyMenusDO> loadMenusByUsername(String username);
    Page<MyMenusDO> listMenus(MyMenusDO myMenus);
    void insert(MyMenusDO myMenus);
    void update(MyMenusDO myMenus);
}