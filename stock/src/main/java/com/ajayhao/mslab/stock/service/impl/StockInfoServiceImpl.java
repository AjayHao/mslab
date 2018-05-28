package com.ajayhao.mslab.stock.service.impl;

import com.ajayhao.mslab.core.common.enums.RespCodeType;
import com.ajayhao.mslab.core.common.enums.YesNoEnum;
import com.ajayhao.mslab.core.common.exception.BusinessBizException;
import com.ajayhao.mslab.core.util.DateUtil;
import com.ajayhao.mslab.stock.config.RemoteConfig;
import com.ajayhao.mslab.stock.dal.dataobject.StockInfoDO;
import com.ajayhao.mslab.stock.dto.StockInfoReq;
import com.ajayhao.mslab.stock.dto.StockInfoResp;
import com.ajayhao.mslab.stock.remote.StockRemoteService;
import com.ajayhao.mslab.stock.remote.dto.JuHeStockBasicDto;
import com.ajayhao.mslab.stock.remote.dto.JuHeStockDto;
import com.ajayhao.mslab.stock.remote.dto.request.JuHeStockReq;
import com.ajayhao.mslab.stock.remote.dto.response.JuHeRemoteResp;
import com.ajayhao.mslab.stock.repository.StockRepository;
import com.ajayhao.mslab.stock.service.StockInfoService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.ajayhao.mslab.core.common.LabConstant.SYSTEM_CREATOR;
import static com.ajayhao.mslab.core.common.LabConstant.SYSTEM_MODIFIER;

/**
 * Created by AjayHao on 2018/5/21.
 */
@Service
public class StockInfoServiceImpl implements StockInfoService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockRemoteService stockRemoteService;

    @Autowired
    private RemoteConfig remoteConfig;

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
            remoteReq.setKey(remoteConfig.getJuheKey());
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
