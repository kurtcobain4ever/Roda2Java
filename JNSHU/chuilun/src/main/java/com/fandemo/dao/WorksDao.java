package com.fandemo.dao;

import com.fandemo.pojo.po.Works;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface WorksDao {
    List<Works> doGetAll();

    Works doGetById(int id);

    List<Works> doGetUploda();

    List<Works> doGetList(@Param("title_id") int title_id,
                          @Param("start") int start, @Param("size") int size);

    List<Works> doSearch(@Param("words") String words,
                         @Param("start") int start, @Param("size") int size);
    boolean doUpdate(Works works);

    boolean doCreate(Works works);

    boolean doDelete(int id);

    boolean doLoad(@Param("id") String id, @Param("status") int status);

    boolean doLoadByTitle(@Param("title_id") int title_id, @Param("status") int status);
}
