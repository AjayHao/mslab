package com.ajayhao.simpleboot.service.antxchecker;


import com.ajayhao.simpleboot.dto.antxchecker.AntxCheckDetail;

import java.util.List;

/**
 * Created by AjayHao on 2018/2/18.
 */
public interface AntxCheckerService {

    List<AntxCheckDetail> checkAntx(String inputPath, String antxContent);
}
