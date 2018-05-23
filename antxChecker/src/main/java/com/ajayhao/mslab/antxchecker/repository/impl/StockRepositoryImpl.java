package com.ajayhao.mslab.antxchecker.repository.impl;

import com.ajayhao.mslab.antxchecker.dal.mapper.StockInfoMapper;
import com.ajayhao.mslab.antxchecker.dal.dataobject.StockInfoDO;
import com.ajayhao.mslab.antxchecker.dal.dataobject.StockInfoDOExample;
import com.ajayhao.mslab.antxchecker.repository.StockRepository;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AjayHao on 2018/5/20.
 */
@Repository("stockRepository")
public class StockRepositoryImpl implements StockRepository{

    @Autowired
    private StockInfoMapper stockInfoMapper;

    @Override
    public StockInfoDO getStockInfoByGidDate(String gid, String workDate){
        StockInfoDOExample example = new StockInfoDOExample();
        example.createCriteria().andGidEqualTo(gid).andWorkDateEqualTo(workDate);
        List<StockInfoDO> list = stockInfoMapper.selectByExample(example);
        if(CollectionUtils.isNotEmpty(list)){
            return list.get(0);
        }
        return null;
    }

    @Override
    public long newStockInfo(StockInfoDO stockInfoDO){
        stockInfoMapper.insert(stockInfoDO);
        return stockInfoDO.getId();
    }
}
