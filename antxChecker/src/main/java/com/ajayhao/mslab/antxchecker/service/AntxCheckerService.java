package com.ajayhao.mslab.antxchecker.service;


import com.ajayhao.mslab.antxchecker.dto.AntxCheckDetail;

import java.util.List;

/**
 * Created by AjayHao on 2018/2/18.
 */
public interface AntxCheckerService {

    List<AntxCheckDetail> checkAntx(String inputPath, String antxContent);
}
