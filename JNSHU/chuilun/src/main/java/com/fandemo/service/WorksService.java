package com.fandemo.service;

import com.fandemo.pojo.po.Works;
import java.util.List;

public interface WorksService {
    List<Works> doGetAll();
    Works doGetById(int id);
    List<Works> doGetUploda();
    List<Works> doGetList(int title_id,int page,int size);
    List<Works> doSearch( String words,int start,int size);
    boolean doUpdate(Works works);
    boolean doCreate(Works works);
    boolean doDelete(int id);
    boolean doLoad(List<Integer> ids,int status);

}
