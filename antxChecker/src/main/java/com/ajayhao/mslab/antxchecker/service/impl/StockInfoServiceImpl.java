package com.ajayhao.mslab.antxchecker.service.impl;

import com.ajayhao.mslab.antxchecker.common.enums.RespCodeType;
import com.ajayhao.mslab.antxchecker.common.enums.YesNoEnum;
import com.ajayhao.mslab.antxchecker.common.exception.BusinessBizException;
import com.ajayhao.mslab.antxchecker.dal.dataobject.StockInfoDO;
import com.ajayhao.mslab.antxchecker.dto.StockInfoReq;
import com.ajayhao.mslab.antxchecker.dto.StockInfoResp;
import com.ajayhao.mslab.antxchecker.remote.StockRemoteService;
import com.ajayhao.mslab.antxchecker.remote.dto.JuHeStockBasicDto;
import com.ajayhao.mslab.antxchecker.remote.dto.JuHeStockDto;
import com.ajayhao.mslab.antxchecker.remote.dto.request.JuHeStockReq;
import com.ajayhao.mslab.antxchecker.remote.dto.response.JuHeRemoteResp;
import com.ajayhao.mslab.antxchecker.repository.StockRepository;
import com.ajayhao.mslab.antxchecker.service.StockInfoService;
import com.ajayhao.mslab.antxchecker.util.DateUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.ajayhao.mslab.antxchecker.common.LabConstant.SYSTEM_CREATOR;
import static com.ajayhao.mslab.antxchecker.common.LabConstant.SYSTEM_MODIFIER;

/**
 * Created by AjayHao on 2018/5/21.
 */
@Service
public class StockInfoServiceImpl implements StockInfoService{

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockRemoteService stockRemoteService;

    private String key = "dc585fdc8fc24cebbad73134920f9e73";

    private BeanCopier bc = BeanCopier.create(JuHeStockBasicDto.class, StockInfoDO.class, false);

    @Override
    public StockInfoResp recordLatestStockInfo(StockInfoReq req){
        StockInfoResp response = new StockInfoResp();
        String today = DateUtil.formatDateByYYYY_MM_DD(new Date());
        final StockInfoDO stockInfoDO = stockRepository.getStockInfoByGidDate(req.getGid(), today);
        if(stockInfoDO == null){
            JuHeStockReq remoteReq = new JuHeStockReq();
            remoteReq.setGid(req.getGid());
            remoteReq.setType(req.getType());
            remoteReq.setKey(key);
            JuHeRemoteResp<List<JuHeStockDto>> remoteResp = stockRemoteService.queryStockInfo(remoteReq);
            if(remoteResp.isSuccess()){
                StockInfoDO newStockInfoDO = resolveRemoteResp(remoteResp.getResult());
                if(newStockInfoDO == null){
                    throw new BusinessBizException(RespCodeType.REMOTE_INVOKE_ERROR);
                }

                if(newStockInfoDO.getWorkDate().equals(today)) {
                    stockRepository.newStockInfo(newStockInfoDO);
                }else{
                    final StockInfoDO latestStockInfoDO = stockRepository.getStockInfoByGidDate(req.getGid(), newStockInfoDO.getWorkDate());
                    if(latestStockInfoDO == null){
                        stockRepository.newStockInfo(newStockInfoDO);
                    }
                }
                BeanUtils.copyProperties(newStockInfoDO, response);
                response.buildSuccess();
            }else{
                response.buildFail();
            }
        }
        return response;
    }

    private StockInfoDO resolveRemoteResp(List<JuHeStockDto> stockList) {
        StockInfoDO stockInfoDO = null;
        if(CollectionUtils.isNotEmpty(stockList)){
            JuHeStockDto juheStockDto = stockList.get(0);
            JuHeStockBasicDto juheBaseDto =juheStockDto.getData();
            stockInfoDO = new StockInfoDO();
            bc.copy(juheBaseDto, stockInfoDO, null);
            stockInfoDO.setStockName(juheBaseDto.getName());
            stockInfoDO.setWorkDate(juheBaseDto.getDate());
            stockInfoDO.setCreator(SYSTEM_CREATOR);
            stockInfoDO.setModifier(SYSTEM_MODIFIER);
            stockInfoDO.setGmtCreated(new Date());
            stockInfoDO.setGmtModified(new Date());
            stockInfoDO.setIsDeleted(YesNoEnum.N.getCode());
        }
        return stockInfoDO;
    }

}
