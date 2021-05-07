package com.zrk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.Label;
import com.zrk.entity.ProblemLabel;
import com.zrk.mapper.LabelMapper;
import com.zrk.mapper.ProblemLabelMapper;
import com.zrk.service.LabelServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/16 12:18
 */
@Service
public class LabelServletImpl implements LabelServlet {
    @Autowired
    private LabelMapper labelMapper;
    @Autowired
    private ProblemLabelMapper problemLabelMapper;
    @Override
    public Integer add(Label label) {
        return labelMapper.insert(label);
    }

    @Override
    public Integer delete(Label label) {
        Integer label_id = problemLabelMapper.selectCount(new QueryWrapper<ProblemLabel>().eq("label_id", label.getLabelId()));
        if(label_id>1) return 2;
        return labelMapper.deleteById(label.getLabelId());
    }

    @Override
    public Integer update(Label label) {
        return labelMapper.update(label,new QueryWrapper<Label>().eq("label_id",label.getLabelId()));
    }

    @Override
    public IPage<Label> findAll(Page<Label> page) {
        return labelMapper.findAll(page);
    }
}
